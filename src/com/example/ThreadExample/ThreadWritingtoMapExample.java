package com.example.ThreadExample;

import java.util.HashMap;
import java.util.Map;

public class ThreadWritingtoMapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            new WriterThread(map, "Writer" + "" + i, 1).start();
        }

    }
}
