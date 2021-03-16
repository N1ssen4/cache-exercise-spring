package com.example.demo;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Cache {
    HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

    public Cache(HashMap<Integer, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String get(Integer key) {
        return hashMap.get(key);
    }

    public void set(Integer key, String value) {
        hashMap.put(key, value);
    }

    public boolean has(Integer key) {
        return hashMap.containsKey(key);
    }

    public void delete(Integer key) {
        hashMap.remove(key);
    }

    public void setTTL(Integer userId,int sec) {
        TimerTask task = new TimerTask() {
            public void run() {
                delete(userId);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,(sec*1000));
    }
}