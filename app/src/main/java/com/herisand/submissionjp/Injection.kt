package com.herisand.submissionjp

import android.content.Context
import com.herisand.submissionjp.datafile.source.local.room.LocalDataSource
import com.herisand.submissionjp.datafile.source.local.room.database.ContentDatabase
import com.herisand.submissionjp.datafile.source.remote.repository.ListRepository
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource
import com.herisand.submissionjp.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context): ListRepository {

        val remoteDataSource = RemoteDataSource.getInstance()
        val db = ContentDatabase.getInstance(context)
        val localDataSource= LocalDataSource.getInstance(db.contentDao())
        val appExecutors = AppExecutors()

        return ListRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}