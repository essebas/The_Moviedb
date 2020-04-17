package co.sebasdeveloper.pruebac360.viewmodel;

import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import co.sebasdeveloper.pruebac360.R;
import co.sebasdeveloper.pruebac360.model.MovieListModel;
import co.sebasdeveloper.pruebac360.repository.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<MovieListModel> movieListModelMutableLiveData;
    private static final String TAG = "MovieViewModel";
    private static final String BASE_PATH = "https://image.tmdb.org/t/p/w300_and_h450_bestv2";

    @Inject
    public MovieViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MutableLiveData<MovieListModel> getMovieListModelMutableLiveData(String language) {
        if(movieListModelMutableLiveData == null){
            movieListModelMutableLiveData = new MutableLiveData<>();
            loadData(language);
        }
        return movieListModelMutableLiveData;
    }

    public void loadData(String language){
        disposable.add(movieRepository.modelSinglePopularMovie(language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<MovieListModel>(){
                    @Override
                    public void onSuccess(MovieListModel movieListModel) {
                        getMovieListModelMutableLiveData(language).setValue(movieListModel);
                        Log.d(TAG,"Average: " + movieListModel.getResults().get(0).getVote_average());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "Error caused by:" + e.getMessage());
                    }
                })
        );
    }

    @BindingAdapter({"imageURL"})
    public static void loadImage(ImageView imageView, String imageURL){
        String url = BASE_PATH + imageURL;
        Log.d(TAG, "URL image: " + url);
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }

}
