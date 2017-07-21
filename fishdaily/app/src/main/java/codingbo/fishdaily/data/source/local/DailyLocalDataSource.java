package codingbo.fishdaily.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;

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
            daily.setTaskList(findTasks(String.valueOf(daily.getId())));
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
        List<Daily> dailies = mDailyDao.queryBuilder()
                .limit(length)
                .offset(startIndex)
                .list();
        for (Daily daily : dailies) {
            daily.setTaskList(findTasks(String.valueOf(daily.getId())));
        }
        if (/*dailies != null &&*/ dailies.size() > 0) {
            callback.onDailiesLoaded(dailies);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void getDaily(String dailyId, GetDailyCallback callback) {
        checkCallback(callback);
        Daily daily = mDailyDao.load(Long.parseLong(dailyId));
        List<Task> taskList = findTasks(dailyId);
        daily.setTaskList(taskList);
        if (callback != null) {
            callback.onDailyLoaded(daily);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @NonNull
    private List<Task> findTasks(String dailyId) {
        List<Task> taskList = mTaskDao.queryBuilder()
                .where(TaskDao.Properties.DailyId.eq(dailyId))
                .orderAsc(TaskDao.Properties.TagId)
                .list();
        for (Task task : taskList) {
            findTag(task);
        }
        return taskList;
    }

    private void findTag(Task task) {
        Tag tag = mTagDao.load(task.getTagId());
        task.setTag(tag);
    }

    private void checkCallback(Object callback) {
        if (callback == null) {
            throw new RuntimeException("callback can not be null!");
        }
    }

    @Override
    public Long saveDaily(Daily daily) {
        long dailyId = mDailyDao.insert(daily);
        List<Task> list = daily.getTaskList();
        for (Task task : list) {
            task.setDailyId(dailyId);
            mTaskDao.insert(task);
        }
        return dailyId;
    }

    @Override
    public void deleteDaily(String dailyId) {
        List<Task> tasks = findTasks(dailyId);
        mTaskDao.deleteInTx(tasks);
        mDailyDao.deleteByKey(Long.parseLong(dailyId));
    }

    @Override
    public void updateDaily(Daily daily) {
        //删除数据库老数据
        List<Task> tasks = findTasks(String.valueOf(daily.getId()));
        mTaskDao.deleteInTx(tasks);
        //重新插入数据
        List<Task> list = daily.getTaskList();
        for (Task task : list) {
            task.setDailyId(daily.getId());
            mTaskDao.insert(task);
        }
        mDailyDao.update(daily);
    }

    @Override
    public void refreshDailies() {

    }

    @Override
    public void deleteAllDailies() {
        mDailyDao.deleteAll();
        mTaskDao.deleteAll();
    }
}
