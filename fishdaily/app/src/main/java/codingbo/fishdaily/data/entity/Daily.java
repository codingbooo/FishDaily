package codingbo.fishdaily.data.entity;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.greenrobot.greendao.annotation.Generated;

/**
 * 日常实体类
 */
@Entity
public class Daily implements Comparable<Daily> {
    @Id(autoincrement = true)
    private Long id;
    private String content;
    @Transient
//    @ToMany()
    private List<Task> taskList;
    private Long date;

    @Generated(hash = 890305013)
    public Daily(Long id, String content, Long date) {
        this.id = id;
        this.content = content;
        this.date = date;
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

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public int compareTo(@NonNull Daily o) {
//        List<Task> list = o.getTaskList();
        int result = o.getContent().equals(this.content)
                && Objects.equals(o.getDate(), this.date)
//                && o.getTaskList().size() == this.taskList.size()
                ? 0 : 1;
//        if (result == 0 && taskList.size() > 0) {
//            int len = taskList.size();
//            for (int i = 0; i < len; i++) {
//                Task sTask = list.get(0);
//                Task task = taskList.get(0);
//                if (sTask.compareTo(task) != 0) {
//                    result = sTask.compareTo(task);
//                    break;
//                }
//            }
//        }
        return result;
    }
}
