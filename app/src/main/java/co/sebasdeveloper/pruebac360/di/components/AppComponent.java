package co.sebasdeveloper.pruebac360.di.components;


import javax.inject.Singleton;

import co.sebasdeveloper.pruebac360.di.modules.ContextModule;
import co.sebasdeveloper.pruebac360.di.modules.NetworkModule;
import co.sebasdeveloper.pruebac360.ui.activity.MainActivity;
import co.sebasdeveloper.pruebac360.ui.activity.SplashScreen;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
