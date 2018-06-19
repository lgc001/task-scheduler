package com.lgc.taskscheduler.controller;

import com.lgc.taskscheduler.data.ResponseDto;
import com.lgc.taskscheduler.data.TaskDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping("/delay")
    public ResponseDto delay() {
        int second=10;
        if (second <= 0) {
            second = 10;
        }

        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ResponseDto responseDto = new ResponseDto();
        return responseDto;
    }
}
