package com.lgc.taskscheduler.manage;

import com.lgc.taskscheduler.data.TaskDto;

import java.util.ArrayList;
import java.util.List;

public class TaskConfig {
    public List<TaskDto> getTaskList() {
        List<TaskDto> taskList = new ArrayList<>();

        TaskDto task = new TaskDto();
        task.setName("test1");
        task.setIsRun(1);
        task.setRemoteUrl("http://www.baidu.com");
        task.setCron("0/10 * * * * ?");
        taskList.add(task);

        task = new TaskDto();
        task.setName("test2");
        task.setIsRun(1);
        task.setRemoteUrl("http://www.shangpin.com");
        task.setCron("0/15 * * * * ?");
        taskList.add(task);

        return taskList;
    }
}
