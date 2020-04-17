package co.sebasdeveloper.pruebac360.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.sebasdeveloper.pruebac360.R;
import co.sebasdeveloper.pruebac360.adapter.MovieAdapter;
import co.sebasdeveloper.pruebac360.model.MovieListModel;
import co.sebasdeveloper.pruebac360.viewmodel.MovieViewModel;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewFactory;

    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;
    private MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_popularmovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        movieAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(movieAdapter);
        movieViewModel = new ViewModelProvider(this, viewFactory).get(MovieViewModel.class);
        movieViewModel.getMovieListModelMutableLiveData("en-US").observe(this, new Observer<MovieListModel>() {
            @Override
            public void onChanged(MovieListModel movieListModel) {
                movieAdapter.setList(movieListModel.getResults());
            }
        });
    }
}
