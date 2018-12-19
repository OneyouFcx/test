package com.example.demo.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class main {
    private static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    private static DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");

    private static ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();



    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        long initialDelay = 3;
        long period = 3;  //执行的频率
        String time="09:41:00";   // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        service.scheduleAtFixedRate(new MyScheduledExecutor("job1"), 1, period, TimeUnit.SECONDS);
        // 从现在开始2秒钟之后，每隔2秒钟执行一次job2
        service.scheduleWithFixedDelay(new MyScheduledExecutor("job2"), initialDelay, period, TimeUnit.SECONDS);
    }
}

