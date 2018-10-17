package com.example.schedulerexample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {


    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(10);
        Map<Integer, Temperature> map = new HashMap<Integer, Temperature>();
        System.out.println("Current Time = " + new Date());
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            Temperature temperature = new Temperature();
            temperature.setTemperature(new Random().nextInt(50) + "^C");
            scheduledThreadPool.schedule(new WorkerThread(map, temperature), 10, TimeUnit.SECONDS);
        }
        Thread.sleep(30000);

        scheduledThreadPool.shutdown();

        map.forEach((k, v) -> {
            System.out.println(k + " " + v.getTemperature());
        });
        System.out.println("Finished all threads");
    }
}
