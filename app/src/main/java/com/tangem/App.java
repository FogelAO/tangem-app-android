package com.tangem;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.tangem.di.DaggerNavigatorComponent;
import com.tangem.di.DaggerNetworkComponent;
import com.tangem.di.NavigatorComponent;
import com.tangem.di.NetworkComponent;
import com.tangem.tangemcard.data.Issuer;
import com.tangem.tangemcard.data.local.Firmwares;
import com.tangem.tangemcard.data.local.PINStorage;

public class App extends Application {

    /**
     * A singleton instance of the application class for easy access in other places
     */
    private static App sInstance;

    public App() {
        super();
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private static NetworkComponent networkComponent;
    private static NavigatorComponent navigatorComponent;

    public static NavigatorComponent getNavigatorComponent() {
        return navigatorComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the singleton
        sInstance = this;

        networkComponent = DaggerNetworkComponent.create();
        navigatorComponent = buildNavigatorComponent();

        // common init
        if (PINStorage.needInit())
            PINStorage.init(getApplicationContext());

        if (Issuer.needInit())
            Issuer.init(getApplicationContext());

        if (Firmwares.needInit())
            Firmwares.init(getApplicationContext());
    }

    /**
     * @return singleton instance
     */
    public static synchronized App getInstance() {
        return sInstance;
    }

    public static NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    protected NavigatorComponent buildNavigatorComponent() {
        return DaggerNavigatorComponent.builder()
                .build();
    }

}