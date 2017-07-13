package codingbo.fishdaily.entity;

import java.util.Calendar;
import java.util.List;

/**
 * 日常实体类
 */

public class Daily {
    private Long id;
    private String content;
    private List<Task> taskList;
    private Calendar date;
    private int spendTime;
    private int level;
    private float progress;
}
