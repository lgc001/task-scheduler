package com.lgc.taskscheduler.controller;

import com.lgc.taskscheduler.configuration.TaskListConfig;
import com.lgc.taskscheduler.data.TaskDto;
import com.lgc.taskscheduler.manage.MyJob;
import com.lgc.taskscheduler.manage.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/manage")
@RestController
public class ManageController {

    @Autowired
    private TaskListConfig jobListConfig;

    @RequestMapping("/addJob")
    public String addJob(@RequestBody TaskDto taskDto) {
        String jobName = taskDto.getName() + "_job";
        String triggerName = taskDto.getName() + "_trigger";
        String jobGroupName = taskDto.getName() + "_jobGroup";
        String triggerGroupName = taskDto.getName() + "_triggerGroup";

        try {
            QuartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, MyJob.class, taskDto.getCron(), taskDto.getRemoteUrl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "ok";
    }

    @RequestMapping("/removeJob")
    public String removeJob(@RequestBody TaskDto taskDto) {
        String jobName = taskDto.getName() + "_job";
        String triggerName = taskDto.getName() + "_trigger";
        String jobGroupName = taskDto.getName() + "_jobGroup";
        String triggerGroupName = taskDto.getName() + "_triggerGroup";

        try {
            QuartzManager.removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "ok";
    }

    @RequestMapping("/jobList")
    public List<TaskDto> jobList() {
        try {
            return jobListConfig.getList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<>();
    }
}
