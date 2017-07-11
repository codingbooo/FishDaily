package codingbo.fishdaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bob
 * on 17.7.10.
 */

public class App extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean logDebug = BuildConfig.LOG_DEBUG;
        String serverHost = BuildConfig.SERVER_HOST;

    }
}
