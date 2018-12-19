package com.example.demo.task;

public class MyScheduledExecutor implements Runnable {

    private String jobName;

    MyScheduledExecutor() {

    }

    MyScheduledExecutor(String jobName) {
        this.jobName = jobName;
    }
static{
    System.out.println("任务开始");
}
    @Override
    public void run() {
        System.out.println("任务：【"+jobName+"】执行");
        System.out.println(jobName + " is running");
        System.out.println("任务结束");
    }
}