package com.herisand.submissionjp.utils


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.herisand.submissionjp.datafile.source.remote.response.ApiResponse
import com.herisand.submissionjp.datafile.source.remote.response.StatusResponse
import com.herisand.submissionjp.resources.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val appExecutors: AppExecutors) {
   private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val databaseSource = loadFromDb()

        result.addSource(databaseSource) { data ->
            result.removeSource(databaseSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(databaseSource)
            } else {
                result.addSource(databaseSource) { newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    appExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        appExecutors.mainThread().execute {
                            result.addSource(loadFromDb()) { newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    }
                StatusResponse.EMPTY -> appExecutors.mainThread().execute {
                    result.addSource(loadFromDb()) { newData ->
                        result.value = Resource.success(newData)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    private fun onFetchFailed() {}

    protected abstract fun saveCallResult(data: RequestType)

    abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun loadFromDb(): LiveData<ResultType>

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}