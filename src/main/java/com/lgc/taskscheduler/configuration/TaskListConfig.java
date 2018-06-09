package com.lgc.taskscheduler.configuration;

import com.lgc.taskscheduler.data.TaskDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "task.config")
public class TaskListConfig {
//    private TaskDto[] list;
    private List<TaskDto> list;
}
