package codingbo.fishdaily.data.source;

import java.util.List;

import codingbo.fishdaily.data.entity.Daily;

/**
 * Created by bob
 * on 17.7.18.
 */

public interface DailyDataSource {

    interface DailiesCallback {

        void onDailiesLoaded(List<Daily> dailies);

        void onDataNotAvailable();
    }

    interface GetDailyCallback {

        void onDailyLoaded(Daily daily);

        void onDataNotAvailable();
    }

    void getDailies(DailiesCallback callback);

    void getDailies(int startIndex, int length, DailiesCallback callback);

    void getDaily(String dailyId, GetDailyCallback callback);

    Long saveDaily(Daily daily);

    void deleteDaily(String dailyId);

    void updateDaily(Daily daily);

    void refreshDailies();

    void deleteAllDailies();

}
