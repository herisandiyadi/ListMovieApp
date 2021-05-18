package com.herisand.submissionjp

import android.content.Context
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource

object Injection {

    fun provideRepository(context: Context): ListRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return ListRepository.getInstance(remoteDataSource)
    }
}