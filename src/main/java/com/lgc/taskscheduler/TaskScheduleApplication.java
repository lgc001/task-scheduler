package com.lgc.taskscheduler;

import com.lgc.taskscheduler.configuration.TaskListConfig;
import com.lgc.taskscheduler.data.TaskDto;
import com.lgc.taskscheduler.manage.Portal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class TaskScheduleApplication {

    @Autowired
    private TaskListConfig taskListConfig;

    private static TaskListConfig staticTaskListConfig;

    @PostConstruct
    public void init() {
        staticTaskListConfig = taskListConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskScheduleApplication.class, args);

        Portal portal = new Portal();
        portal.start(staticTaskListConfig.getList());
    }
}
