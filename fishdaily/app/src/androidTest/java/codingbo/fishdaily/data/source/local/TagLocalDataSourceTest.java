package codingbo.fishdaily.data.source.local;

import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import codingbo.fishdaily.data.entity.Tag;
import codingbo.fishdaily.data.source.TagDataSource;

import static org.junit.Assert.*;

/**
 * Created by bob
 * on 17.7.24.
 */
public class TagLocalDataSourceTest {

    private TagLocalDataSource mTagLocalDataSource;

    @Before
    public void setUp() {
        mTagLocalDataSource = TagLocalDataSource.getInstance(
                InstrumentationRegistry.getTargetContext());

    }

    @After
    public void cleanUp() {
        mTagLocalDataSource.deleteAllTags();
    }

    @Test
    public void save_retrieve() throws Exception {
        Tag tag = new Tag();
        tag.setDescription("学习的描述");
        tag.setName("学习");
        tag.setProgress(30);

        String tagId = mTagLocalDataSource.saveTag(tag);

        mTagLocalDataSource.getTag(tagId, new TagDataSource.GetTagCallback() {
            @Override
            public void onTagLoaded(Tag tag) {
                checkNull(tag);
                assertEquals(0, tag.compareTo(tag));
//                assertEquals(1, tag.compareTo(tag));
            }

            @Override
            public void onDataNotAvailable() {
                fail("callback error");
            }
        });

    }

    @Test
    public void delete_retrieve() throws Exception {
        final Tag tag1 = new Tag();
        tag1.setDescription("学习的描述");
        tag1.setName("学习");
        tag1.setProgress(10);

        final Tag tag2 = new Tag();
        tag2.setDescription("生活的描述");
        tag2.setName("生活");
        tag2.setProgress(30);

        String tagId1 = mTagLocalDataSource.saveTag(tag1);
        String tagId2 = mTagLocalDataSource.saveTag(tag2);
        tag1.setId(Long.valueOf(tagId1));
        tag2.setId(Long.valueOf(tagId2));

        mTagLocalDataSource.deleteTag(tagId1);

        mTagLocalDataSource.getTags(new TagDataSource.LoadTagsCallback() {
            @Override
            public void onTagsLoaded(List<Tag> tags) {
                checkNull(tags);
                assertTrue(tags.size() == 1);
                Tag tag = tags.get(0);
                assertEquals(0, tag.compareTo(tag2));
            }

            @Override
            public void onDataNotAvailable() {

            }
        });


    }

    @Test
    public void getTags_retrieveSaveTags() throws Exception {
        final Tag tag1 = new Tag();
        tag1.setDescription("学习的描述");
        tag1.setName("学习");
        tag1.setProgress(10);

        final Tag tag2 = new Tag();
        tag2.setDescription("生活的描述");
        tag2.setName("生活");
        tag2.setProgress(30);

        final Tag tag3 = new Tag();
        tag3.setDescription("工作的描述");
        tag3.setName("工作");
        tag3.setProgress(90);

        final String tagId1 = mTagLocalDataSource.saveTag(tag1);
        final String tagId2 = mTagLocalDataSource.saveTag(tag2);
        final String tagId3 = mTagLocalDataSource.saveTag(tag3);

        tag1.setId(Long.valueOf(tagId1));
        tag2.setId(Long.valueOf(tagId2));
        tag3.setId(Long.valueOf(tagId3));

        mTagLocalDataSource.getTags(new TagDataSource.LoadTagsCallback() {
            @Override
            public void onTagsLoaded(List<Tag> tags) {
                checkNull(tags);
                assertTrue(tags.size() >= 3);

                boolean newTag1Compare = false;
                boolean newTag2Compare = false;
                boolean newTag3Compare = false;
                for (Tag tag : tags) {
                    if (tagId1.equals(String.valueOf(tag.getId()))) {
                        newTag1Compare = tag.compareTo(tag1) == 0;
                    }
                    if (tagId2.equals(String.valueOf(tag.getId()))) {
                        newTag2Compare = tag.compareTo(tag2) == 0;
                    }
                    if (tagId3.equals(String.valueOf(tag.getId()))) {
                        newTag3Compare = tag.compareTo(tag3) == 0;
                    }
                }

                assertTrue(newTag1Compare);
                assertTrue(newTag2Compare);
                assertTrue(newTag3Compare);
            }

            @Override
            public void onDataNotAvailable() {
                fail("callback error");
            }
        });
    }

    private void checkNull(Object o) {
        if (o == null) {
            throw new RuntimeException("Object can not null");
        }
    }

    @Test
    public void update_retrieve() throws Exception {
        Tag tag = new Tag();
        tag.setDescription("生活的描述");
        tag.setName("生活");
        tag.setProgress(20);

        String tagId = mTagLocalDataSource.saveTag(tag);
        tag.setId(Long.valueOf(tagId));

        final String description = "生活的描述222";
        tag.setDescription(description);

        mTagLocalDataSource.update(tag);

        mTagLocalDataSource.getTag(tagId, new TagDataSource.GetTagCallback() {
            @Override
            public void onTagLoaded(Tag tag) {
                checkNull(tag);
                assertEquals(description, tag.getDescription());
            }

            @Override
            public void onDataNotAvailable() {
                fail("callback error");
            }
        });
    }


}