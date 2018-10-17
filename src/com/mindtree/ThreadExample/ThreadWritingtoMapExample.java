package com.mindtree.ThreadExample;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadWritingtoMapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            new WriterThread(map, "Writer" + "" + i, 1).start();
        }

    }
}
