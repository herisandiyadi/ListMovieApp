package com.herisand.submissionjp.utils

import android.os.Looper
import androidx.annotation.MainThread
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.logging.Handler

class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor
) {
    companion object {
        private const val THEAD_COUNT = 3
    }

    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(THEAD_COUNT),
        MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    fun networkIO(): Executor = networkIO

    fun mainThread(): Executor = mainThread

    private class MainThreadExecutor() : Executor {
        private val mainThreadHandler = android.os.Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }

    }
}


