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
    private Long id;//主键
    private String content;//内容
    @Transient
    private Tag tag;
    private Long tagId;//标签Id
    private Long dailyId;//日常ID
    private int spendTime;//花费时间
    private int level;//难度等级


    @Generated(hash = 1886002782)
    public Task(Long id, String content, Long tagId, Long dailyId, int spendTime,
                int level) {
        this.id = id;
        this.content = content;
        this.tagId = tagId;
        this.dailyId = dailyId;
        this.spendTime = spendTime;
        this.level = level;
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

    public int getSpendTime() {
        return this.spendTime;
    }

    public void setSpendTime(int spendTime) {
        this.spendTime = spendTime;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

