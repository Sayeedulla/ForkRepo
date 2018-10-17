package com.example.ThreadExample;

import java.util.Map;
import java.util.Random;

public class WriterThread extends Thread {
    private Map<Integer, String> map;
    private Random random;
    private String name;

    public WriterThread(Map<Integer, String> map,
                        String threadName, long randomSeed) {
        this.map = map;
        this.random = new Random(randomSeed);
        this.name = threadName;
    }

    public void run() {
        while (true) {
            Integer key = random.nextInt(10);
            String value = name;
            map.put(key, value);
            String output = String.format("%s has put [%d => %s]",
                    name, key, value);
            System.out.println(output);
            System.out.println(map);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}