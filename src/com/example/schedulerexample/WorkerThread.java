package com.example.schedulerexample;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class WorkerThread implements Runnable {

    private String command;
    Temperature temperature;
    Map<Integer, Temperature> map;

    public WorkerThread(Map<Integer, Temperature> map, Temperature temperature) {
        this.temperature = temperature;
        this.map = map;
    }

    @Override
    public void run() {

        map.put(new Random().nextInt(100), temperature);
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + LocalDateTime.now());

        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + LocalDateTime.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }


}
