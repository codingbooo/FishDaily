package codingbo.fishdaily.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 完成任务实体类
 */
@Entity
public class Task {
    @Id(autoincrement = true)
    private Long id;
    private String content;
    @Transient
    private Tag tag;
    private Long tagId;
    private Long dailyId;
    @Generated(hash = 1458708264)
    public Task(Long id, String content, Long tagId, Long dailyId) {
        this.id = id;
        this.content = content;
        this.tagId = tagId;
        this.dailyId = dailyId;
    }
    @Generated(hash = 733837707)
    public Task() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getTagId() {
        return this.tagId;
    }
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
    public Long getDailyId() {
        return this.dailyId;
    }
    public void setDailyId(Long dailyId) {
        this.dailyId = dailyId;
    }
}

