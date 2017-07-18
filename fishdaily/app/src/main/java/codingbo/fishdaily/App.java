package codingbo.fishdaily;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.facebook.stetho.Stetho;

import codingbo.fishdaily.data.dao.DaoMaster;
import codingbo.fishdaily.data.dao.DaoSession;

/**
 * Created by bob
 * on 17.7.10.
 */

public class App extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        boolean logDebug = BuildConfig.LOG_DEBUG;
        String serverHost = BuildConfig.SERVER_HOST;

        initDB();
        if (BuildConfig.LOG_DEBUG) {
            intStetho();
        }
    }


    private void intStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }

    private void initDB() {
        String dbName = BuildConfig.APP_NAME + ".db";
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, dbName, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
