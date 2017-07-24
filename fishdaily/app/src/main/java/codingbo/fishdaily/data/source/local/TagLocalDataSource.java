package codingbo.fishdaily.data.source.local;

import android.content.Context;
import android.provider.CalendarContract;

import java.util.List;

import codingbo.fishdaily.App;
import codingbo.fishdaily.data.dao.TagDao;
import codingbo.fishdaily.data.entity.Tag;
import codingbo.fishdaily.data.source.TagDataSource;

/**
 * 标签数据数据库实现类
 */

public class TagLocalDataSource implements TagDataSource {

    private static TagLocalDataSource INSTANCE;
    private final TagDao mTagDao;

    private TagLocalDataSource(Context context) {
        mTagDao = ((App) context.getApplicationContext()).getDaoSession().getTagDao();
    }

    public synchronized static TagLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TagLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getTags(LoadTagsCallback callback) {
        checkCallback(callback);
        List<Tag> tags = mTagDao.loadAll();
        if (tags.size() > 0) {
            callback.onTagsLoaded(tags);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void getTag(String tagId, GetTagCallback callback) {
        checkCallback(callback);
        Tag tag = mTagDao.load(Long.valueOf(tagId));
        if (tag != null) {
            callback.onTagLoaded(tag);
        } else {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public String saveTag(Tag tag) {
        return String.valueOf(mTagDao.insert(tag));
    }

    @Override
    public void deleteTag(String tagId) {
        mTagDao.deleteByKey(Long.valueOf(tagId));
    }

    @Override
    public void update(Tag tag) {
        mTagDao.update(tag);
    }

    @Override
    public void deleteAllTags() {
        mTagDao.deleteAll();
    }

    private void checkCallback(Object callback) {
        if (callback == null) {
            throw new RuntimeException("callback can not be null!");
        }
    }
}
