package codingbo.fishdaily.data.source.local;

import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import codingbo.fishdaily.data.entity.Daily;
import codingbo.fishdaily.data.source.DailyDataSource;

import static org.junit.Assert.*;

/**
 * Created by bob
 * on 17.7.20.
 */
public class DailyLocalDataSourceTest {

    private DailyLocalDataSource mLocalDataSource;

    @Before
    public void setUp() throws Exception {
        mLocalDataSource = DailyLocalDataSource.getInstance(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void getDailies() throws Exception {
        mLocalDataSource.getDailies(new DailyDataSource.DailiesCallback() {
            @Override
            public void onDailiesLoaded(List<Daily> dailies) {
                assertEquals(3, dailies.size());
//                assertEquals(4, dailies.size());
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Test
    public void getDailies1() throws Exception {

    }

    @Test
    public void getDaily() throws Exception {

    }

    @Test
    public void saveDaily() throws Exception {
        final Daily d = new Daily();
        d.setContent("今天有点虚度啊,改天再好好学习吧!");
        d.setDate(System.currentTimeMillis());

        Long dailyId = mLocalDataSource.saveDaily(d);

        mLocalDataSource.getDaily(String.valueOf(dailyId), new DailyDataSource.GetDailyCallback() {
            @Override
            public void onDailyLoaded(Daily daily) {
                assertEquals(d.getContent(), daily.getContent());
                assertEquals(d.getDate(), daily.getContent());
            }

            @Override
            public void onDataNotAvailable() {

            }
        });


    }

    @Test
    public void deleteDaily() throws Exception {

    }

    @Test
    public void updateDaily() throws Exception {

    }

    @Test
    public void refreshDailies() throws Exception {

    }

    @Test
    public void deleteAllDailies() throws Exception {

    }

}