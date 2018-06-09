package com.lgc.taskscheduler.manage;

import com.google.gson.reflect.TypeToken;
import com.lgc.taskscheduler.data.ResponseDto;
import com.lgc.taskscheduler.util.HttpClientUtil;
import com.lgc.taskscheduler.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.util.Date;

@Slf4j
@DisallowConcurrentExecution  //在job间隔期间内，保证上一个任务执行完后，再去调度下一个任务
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        String remoteUrl = map.getString("remoteUrl");
        String jobName = map.getString("jobName");

        long start = System.currentTimeMillis();
        log.info(new Date() + " >>>>> "+jobName+" | " + remoteUrl+" |begin");
        try {
            String returnJson = HttpClientUtil.doGet(remoteUrl,null);
            ResponseDto responseDto = JsonUtil.fromJson(returnJson, ResponseDto.class);
            if(responseDto!=null && "0".equals(responseDto.getCode()))
            {
                log.info(new Date() + " -- "+jobName+" |成功");
            }
        } catch (Exception e) {
            log.info(new Date() + " -- "+jobName+" |失败| "+e.getMessage());
            e.printStackTrace();
        }
        long usedTime = System.currentTimeMillis() - start;
        log.info(new Date() + " ========= "+jobName+" | " + remoteUrl+" |end|耗时:" + String.valueOf(usedTime) + "毫秒");
    }
}
