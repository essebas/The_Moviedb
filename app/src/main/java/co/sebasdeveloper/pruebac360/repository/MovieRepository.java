package co.sebasdeveloper.pruebac360.repository;


import javax.inject.Inject;

import co.sebasdeveloper.pruebac360.BuildConfig;
import co.sebasdeveloper.pruebac360.model.MovieListModel;
import co.sebasdeveloper.pruebac360.remote.MovieService;
import io.reactivex.Single;

public class MovieRepository {

    private MovieService movieService;

    @Inject
    public MovieRepository(MovieService movieService) {
        this.movieService = movieService;
    }

    public Single<MovieListModel> modelSinglePopularMovie(String language){
        return movieService.getPopularMovie(BuildConfig.TheMoviedb_API_KEY, language);
    }

}
