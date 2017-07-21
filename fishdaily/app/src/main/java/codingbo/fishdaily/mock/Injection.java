package codingbo.fishdaily.mock;

import android.content.Context;

import codingbo.fishdaily.data.source.DailyDataSource;
import codingbo.fishdaily.data.source.local.DailyLocalDataSource;

/**
 * Created by bob
 * on 17.7.19.
 */

public class Injection {

    public static DailyDataSource provideDailyDataRepository(Context context) {
        return DailyLocalDataSource.getInstance(context);
    }
}
