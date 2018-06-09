package com.lgc.taskscheduler.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private String name;
    private Integer isRun;
    private String remoteUrl;
    private String cron;
}
