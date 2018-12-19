package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class test {

    public static ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();

    public static AtomicInteger flag = new AtomicInteger(0);

    private static long initialDelay = 20l;

    public static void main(String[] args) {
        execService.scheduleAtFixedRate(()->{
            startTest();
        },initialDelay,10, TimeUnit.SECONDS);
    }

    public static void startTest(){

        if(flag.get()>0){
            log.info("----------------正在执行-------------------");
            return;
        }
        try{
            flag.incrementAndGet();//启动
            log.info("开始");
        }catch (Exception e){
            log.error("----------------错误-----------");
        }finally {
            flag.decrementAndGet();//结束
            log.info("-----------------结束----------");
        }
    }
}
