package com.example.demo.controller;

import com.example.demo.Cache;
import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MyController {
    Cache cache = new Cache(new HashMap<Integer,String>());

    @GetMapping("/get-user-data")
    @ResponseBody
    public String userData(@RequestParam Integer id) throws InterruptedException {
        if (!cache.has(id)) {
            User user = new User(id);
            String value = user.getDataSlow();

            cache.set(id, value);
            cache.setTTL(id,30);
        }
        return cache.get(id);

    }
}
