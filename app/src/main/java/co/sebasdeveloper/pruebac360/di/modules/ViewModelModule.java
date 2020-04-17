package co.sebasdeveloper.pruebac360.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.sebasdeveloper.pruebac360.di.ViewModelKey;
import co.sebasdeveloper.pruebac360.viewmodel.MovieViewModel;
import co.sebasdeveloper.pruebac360.viewmodel.ViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel.class)
    abstract ViewModel vMovieModel(MovieViewModel movieViewModel);

    @Binds
    abstract ViewModelProvider.Factory binFactory(ViewModelFactory factory);

}
