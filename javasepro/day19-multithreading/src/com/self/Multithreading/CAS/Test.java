package com.self.Multithreading.CAS;


import com.sun.source.tree.SynchronizedTree;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        map.put("a", "a");

        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
    }
}
