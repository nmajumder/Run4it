package hu.ait.android.run4it;

import android.app.Application;

import com.backendless.Backendless;

/**
 * Created by Jwatto01 on 5/18/16.
 */
public class Run4itApp extends Application{

        @Override
        public void onCreate() {
            super.onCreate();

            Backendless.initApp(this,
                    "A94E262B-238C-C591-FFC2-7311BC2CEC00",
                    "5A91BE01 - A040-9159-FFB7-FF93974F9000",
                    "v1");
        }
}
