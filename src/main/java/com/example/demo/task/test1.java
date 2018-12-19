package com.example.demo.task;

public class test1 {

   /* private static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    private static DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
    private long initialDelay = 20l;

    private static ScheduledExecutorService excutor = Executors.newSingleThreadScheduledExecutor();

    *//**
     * 按指定频率周期执行某个任务 <br>
     * 初始化延迟0ms开始执行，每隔5ms重新执行一次任务。
     *//*
    public void fixedRate(){
        excutor.scheduleAtFixedRate((Runnable) new EchoServer(), //执行线程
                1,  //初始化延迟
                5000, //两次开始的执行的最小时间间隔
                TimeUnit.MILLISECONDS //计时单位
        );
    }

    *//**
     *
     *//*
    public void fixDelay(){
        excutor.scheduleWithFixedDelay((Runnable) new EchoServer(),//执行线程
                1, //初始化延迟
                5000, //前一次执行结束到下一次执行开始的间隔时间
                TimeUnit.MILLISECONDS);
    }

    *//**
     * 每天晚上8点执行一次
     *//*
    public void dayOfDelay(String time){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis(time) - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(
                (Runnable) new EchoServer(),
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);


    }


    *//**
     * 获取给定时间对应的毫秒数
     * @param string "HH:mm:ss"
     * @return
     *//*
    private static long getTimeMillis(String time) {
        try {
            Date currentDate = dateFormat.parse(dayFormat.format(new Date()) + " " +time);
            return currentDate.getTime() ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args){

        test1 schedule = new test1();
        schedule.fixedRate();
        schedule.fixDelay();

    }*/

}

