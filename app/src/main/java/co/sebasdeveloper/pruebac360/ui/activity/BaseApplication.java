package co.sebasdeveloper.pruebac360.ui.activity;

import android.app.Application;

import co.sebasdeveloper.pruebac360.di.components.AppComponent;
import co.sebasdeveloper.pruebac360.di.components.DaggerAppComponent;

public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
