package codingbo.fishdaily.data.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Calendar;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 日常实体类
 */
@Entity
public class Daily {
    @Id(autoincrement = true)
    private Long id;
    private String content;
    @Transient
    private List<Task> taskList;
    private Long date;
    private int spendTime;
    private int level;
    private float progress;
    @Generated(hash = 195098520)
    public Daily(Long id, String content, Long date, int spendTime, int level,
            float progress) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.spendTime = spendTime;
        this.level = level;
        this.progress = progress;
    }
    @Generated(hash = 2135515054)
    public Daily() {
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
    public Long getDate() {
        return this.date;
    }
    public void setDate(Long date) {
        this.date = date;
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
    public float getProgress() {
        return this.progress;
    }
    public void setProgress(float progress) {
        this.progress = progress;
    }
}
