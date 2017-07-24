package codingbo.fishdaily.data.source;

import java.util.List;

import codingbo.fishdaily.data.entity.Daily;

/**
 * 日常数据入口
 */

public interface DailyDataSource {

    interface LoadDailiesCallback {

        void onDailiesLoaded(List<Daily> dailies);

        void onDataNotAvailable();
    }

    interface GetDailyCallback {

        void onDailyLoaded(Daily daily);

        void onDataNotAvailable();
    }

    void getDailies(LoadDailiesCallback callback);

    void getDailies(int startIndex, int length, LoadDailiesCallback callback);

    void getDaily(String dailyId, GetDailyCallback callback);

    String saveDaily(Daily daily);

    void deleteDaily(String dailyId);

    void updateDaily(Daily daily);

    void refreshDailies();

    void deleteAllDailies();

}
