package co.sebasdeveloper.pruebac360.remote;

import co.sebasdeveloper.pruebac360.model.MovieListModel;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {


    //https://api.themoviedb.org
    // /3/movie/popular?
    // api_key=09963e300150f9831c46a1828a82a984 &
    // language=en-US

    @GET("/3/movie/popular")
    Single<MovieListModel> getPopularMovie(@Query("api_key") String api_key,
                                           @Query("language") String language);

}
