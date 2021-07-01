package com.herisand.submissionjp.datafile.source.remote.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.herisand.submissionjp.datafile.source.local.entity.*
import com.herisand.submissionjp.datafile.source.local.room.LocalDataSource
import com.herisand.submissionjp.datafile.source.remote.response.ApiResponse
import com.herisand.submissionjp.datafile.source.remote.response.movie.MovieRemote
import com.herisand.submissionjp.datafile.source.remote.response.movie.MoviesDetailResponse
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowRemote
import com.herisand.submissionjp.datafile.source.remote.response.tvshow.TVShowsDetailResponse
import com.herisand.submissionjp.datafile.source.remote.source.ListDataSource
import com.herisand.submissionjp.datafile.source.remote.source.RemoteDataSource
import com.herisand.submissionjp.resources.Resource
import com.herisand.submissionjp.utils.AppExecutors
import com.herisand.submissionjp.utils.NetworkBoundResource

class ListRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
    ) : ListDataSource{

    companion object{
        @Volatile
        private var instance: ListRepository? = null

        fun getInstance(
            remote: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): ListRepository =
            instance ?: synchronized(this) {
                ListRepository(remote, localDataSource, appExecutors).apply {
                    instance = this }
            }
    }
    override fun loadMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieRemote>>(appExecutors) {

            override fun saveCallResult(data: List<MovieRemote>) {
                val listMovie = ArrayList<MovieEntity>()
                for (dataMovie in data) {
                    dataMovie.apply {
                        val movie = MovieEntity(
                            id, title, image, description, scores, date, background, false
                        )
                        listMovie.add(movie)
                    }
                    localDataSource.insertMovie(listMovie)
                }
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieRemote>>> =
                remoteDataSource.getListMovies()


            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val conf  = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), conf).build()
            }

        }.asLiveData()
    }

    override fun loadDetailMovies(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MoviesDetailResponse>(appExecutors){

            override fun saveCallResult(data: MoviesDetailResponse) {
                with(data) {
                    val dataDetailMovie = MovieEntity(
                        id = id,
                        title = title,
                        image = image,
                        description = description,
                        scores = scores,
                        date = date,
                        background = background,
                        favorite = false
                    )
                    localDataSource.updateMovieFavorite(dataDetailMovie, false )
                }
            }

            override fun createCall(): LiveData<ApiResponse<MoviesDetailResponse>> =
                remoteDataSource.getDetailMovies(movieId.toString())


            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun loadFromDb(): LiveData<MovieEntity> =
                localDataSource.getMovieById(movieId)

        }.asLiveData()

    }

    override fun loadTVShows(): LiveData<Resource<PagedList<TvEntity>>> {
        return object :
        NetworkBoundResource<PagedList<TvEntity>, List<TVShowRemote>>(appExecutors) {
            override fun saveCallResult(data: List<TVShowRemote>) {
                val lisTVShow = ArrayList<TvEntity>()
                for (dataTVShow in data) {
                    with(dataTVShow) {
                        val tvShow = TvEntity(
                            id, title, image, description, scores, date, background, false
                        )
                        lisTVShow.add(tvShow)
                    }
                }
                localDataSource.insertTv(lisTVShow)
            }

            override fun createCall(): LiveData<ApiResponse<List<TVShowRemote>>> =
                remoteDataSource.getListTVShows()

            override fun shouldFetch(data: PagedList<TvEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<TvEntity>> {
                val conf = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTv(), conf).build()
            }

        }.asLiveData()
    }

    override fun loadDetailTVShows(tvShowID: Int): LiveData<Resource<TvEntity>>{
        return object : NetworkBoundResource<TvEntity, TVShowsDetailResponse>(appExecutors) {
            override fun saveCallResult(data: TVShowsDetailResponse) {
                with(data) {
                    val dataDetailTVShow = TvEntity(
                        id = id,
                        title = title,
                        image = image,
                        description = description,
                        scores = scores,
                        date = date,
                        background = background,
                        favorite = false
                    )
                    localDataSource.updateTvShowFavorite(dataDetailTVShow, false)
                }
            }

            override fun createCall(): LiveData<ApiResponse<TVShowsDetailResponse>> =
                remoteDataSource.getDetailTVShows(tvShowID.toString())

            override fun loadFromDb(): LiveData<TvEntity> =
                localDataSource.getTVShowById(tvShowID)

            override fun shouldFetch(data: TvEntity?): Boolean =
                data == null

        }.asLiveData()
    }

    override fun getMoviesFav(): LiveData<PagedList<MovieEntity>> {
        val conf = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), conf).build()
    }

    override fun getTVShowsFav(): LiveData<PagedList<TvEntity>> {
        val conf = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), conf).build()
    }

    override fun setMovieFav(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute {
            localDataSource.updateMovieFavorite(movie, state)
        }

    override fun setTVShowsFav(tvShow: TvEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.updateTvShowFavorite(tvShow, state)
        }
    }

}