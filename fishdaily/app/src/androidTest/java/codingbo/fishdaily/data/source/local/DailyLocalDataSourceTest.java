package codingbo.fishdaily.data.source.local;

import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import codingbo.fishdaily.data.entity.Daily;
import codingbo.fishdaily.data.entity.Task;
import codingbo.fishdaily.data.source.DailyDataSource;

import static org.junit.Assert.*;

/**
 * Created by bob
 * on 17.7.20.
 */
public class DailyLocalDataSourceTest {

    private DailyLocalDataSource mDailyLocalDataSource;

    @Before
    public void setUp() throws Exception {
        mDailyLocalDataSource = DailyLocalDataSource.getInstance(InstrumentationRegistry.getTargetContext());
    }

    @After
    public void cleanUp() {
        mDailyLocalDataSource.deleteAllDailies();
    }

//    @Test
//    public void getDailies() throws Exception {
//        mDailyLocalDataSource.getDailies(new DailyDataSource.LoadDailiesCallback() {
//            @Override
//            public void onDailiesLoaded(List<Daily> dailies) {
//                assertEquals(3, dailies.size());
////                assertEquals(4, dailies.size());
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//
//            }
//        });
//    }
//
//    @Test
//    public void saveDaily() throws Exception {
//        final Daily d = new Daily();
//        d.setContent("今天有点虚度啊,改天再好好学习吧!");
//        d.setDate(System.currentTimeMillis());
//
//        Long dailyId = mDailyLocalDataSource.saveDaily(d);
//
//        mDailyLocalDataSource.getDaily(String.valueOf(dailyId), new DailyDataSource.GetDailyCallback() {
//            @Override
//            public void onDailyLoaded(Daily daily) {
//                assertEquals(d.getContent(), daily.getContent());
//                assertEquals(d.getDate(), daily.getContent());
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//
//            }
//        });
//
//
//    }

    @Test
    public void save_retrieveDaily() throws Exception {
        Task task1 = new Task("跑了个不", 1L, 20, 1);
        Task task2 = new Task("吃了个饭", 1L, 10, 2);
        Task task3 = new Task("玩了个球", 1L, 50, 3);
        Task task4 = new Task("喝了口水", 1L, 90, 1);

        final List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        final Daily oldDaily = new Daily();
        oldDaily.setDate(1498842061L);
        oldDaily.setContent("这是一个日常的描述");
        oldDaily.setTaskList(tasks);

        String dailyId = mDailyLocalDataSource.saveDaily(oldDaily);

        mDailyLocalDataSource.getDaily(dailyId, new DailyDataSource.GetDailyCallback() {
            @Override
            public void onDailyLoaded(Daily daily) {
                assertEquals(0, daily.compareTo(oldDaily));
                assertEquals(tasks.size(), daily.getTaskList().size());
            }

            @Override
            public void onDataNotAvailable() {
                fail("callback error");
            }
        });


    }

    @Test
    public void delete_retrieveDaily() throws Exception {

    }

    @Test
    public void update_retrieveDaily() throws Exception {

    }

    @Test
    public void deleteAll_emptyListOfRetrieveDaily() {

    }

    @Test
    public void getDailies_retrieveSaveDailies() {


    }

}