package codingbo.fishdaily.data.source.local;

import android.content.Context;

import java.util.List;

import codingbo.fishdaily.App;
import codingbo.fishdaily.data.dao.DailyDao;
import codingbo.fishdaily.data.dao.TagDao;
import codingbo.fishdaily.data.dao.TaskDao;
import codingbo.fishdaily.data.entity.Daily;
import codingbo.fishdaily.data.entity.Tag;
import codingbo.fishdaily.data.entity.Task;
import codingbo.fishdaily.data.source.DailyDataSource;

/**
 * 本地存储仓库
 */

public class DailyLocalDataSource implements DailyDataSource {

    private static DailyLocalDataSource INSTANCE;
    private final TagDao mTagDao;
    private final TaskDao mTaskDao;
    private final DailyDao mDailyDao;

    private DailyLocalDataSource(Context context) {
        mDailyDao = ((App) context.getApplicationContext()).getDaoSession().getDailyDao();
        mTagDao = ((App) context.getApplicationContext()).getDaoSession().getTagDao();
        mTaskDao = ((App) context.getApplicationContext()).getDaoSession().getTaskDao();
    }

    public static DailyLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DailyLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getDailies(DailiesCallback callback) {
        checkCallback(callback);

        List<Daily> dailies = mDailyDao.loadAll();
        for (Daily daily : dailies) {
            List<Task> taskList = mTaskDao.queryBuilder()
                    .where(TaskDao.Properties.DailyId.eq(daily.getId()))
                    .list();
            for (Task task : taskList) {
                Tag tag = mTagDao.load(task.getTagId());
                task.setTag(tag);
            }
            daily.setTaskList(taskList);
        }
        if (/*dailies != null &&*/ dailies.size() > 0) {
            callback.onDailiesLoaded(dailies);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void getDailies(int startIndex, int length, DailiesCallback callback) {
        checkCallback(callback);

//        List<Daily> dailies = mDailyDao.loadAll();

//        mDailyDao.

//        if (dailies != null && dailies.size() > 0) {
//            callback.onDailiesLoaded(dailies);
//        } else {
//            callback.onDataNotAvailable();
//        }
    }

    @Override
    public void getDaily(String dailyId, GetDailyCallback callback) {
        checkCallback(callback);
        Daily daily = mDailyDao.load(Long.parseLong(dailyId));
        //// TODO: 17.7.19 需要关联task tag数据
        if (daily != null) {
            callback.onDailyLoaded(daily);
        } else {
            callback.onDataNotAvailable();
        }
    }

    private void checkCallback(Object callback) {
        if (callback == null) {
            throw new RuntimeException("callback can not be null!");
        }
    }

    @Override
    public Long saveDaily(Daily daily) {
        return mDailyDao.insert(daily);
        //// TODO: 17.7.19 需要关联task数据
    }

    @Override
    public void deleteDaily(String dailyId) {
        mDailyDao.deleteByKey(Long.parseLong(dailyId));
        //// TODO: 17.7.19 需要关联task数据
    }

    @Override
    public void updateDaily(Daily daily) {
        mDailyDao.update(daily);
        //// TODO: 17.7.19 需要关联task数据
    }

    @Override
    public void refreshDailies() {

    }

    @Override
    public void deleteAllDailies() {
        mDailyDao.deleteAll();
    }
}
