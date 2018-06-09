package com.lgc.taskscheduler.manage;

import com.lgc.taskscheduler.configuration.TaskListConfig;
import com.lgc.taskscheduler.data.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Portal {

    @Autowired
    private TaskListConfig taskListConfig;

    public void start() {
        try {
            TaskConfig taskConfig = new TaskConfig();
            List<TaskDto> taskList = taskConfig.getTaskList();
            startJob(taskList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(List<TaskDto> taskList) {
        try {
            startJob(taskList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startJob(List<TaskDto> taskList){
        for (TaskDto item :
                taskList) {
            if(item.getIsRun()==1) {
                System.out.println("【系统启动】..." + item.getName());

                String jobName = item.getName() + "_job";
                String triggerName = item.getName() + "_trigger";
                String jobGroupName = item.getName() + "_jobGroup";
                String triggerGroupName = item.getName() + "_triggerGroup";

                QuartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, MyJob.class, item.getCron(),item.getRemoteUrl());
            }
        }
    }
}
