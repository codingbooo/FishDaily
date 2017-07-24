package codingbo.fishdaily.data.source;

import java.util.List;

import codingbo.fishdaily.data.entity.Tag;

/**
 * 标签数据访问入口
 */

public interface TagDataSource {

    interface LoadTagsCallback {
        void onTagsLoaded(List<Tag> tags);

        void onDataNotAvailable();
    }

    interface GetTagCallback {
        void onTagLoaded(Tag tag);

        void onDataNotAvailable();
    }

    void getTags(LoadTagsCallback callback);

    void getTag(String tagId, GetTagCallback callback);

    String saveTag(Tag tag);

    void deleteTag(String tagId);

    void update(Tag tag);

    void deleteAllTags();
}
