package com.herisand.submissionjp.utils.network

import com.herisand.submissionjp.BuildConfig

object ApiConfig {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = BuildConfig.GITHUB_TOKEN
    const val IMG_URL = "https://image.tmdb.org/t/p/w500"
}