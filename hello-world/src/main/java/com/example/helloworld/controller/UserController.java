package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author lwz
 */
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public ArrayList<User> getUsers() {
        return new ArrayList<User>() {{
            add(new User(11111L, "Guide哥", "koushuangbwcx@163.com", "123456"));
            add(new User(22222L, "李真", "koushuangbwcx@163.com", "123456"));
            add(new User(33333L, "帅", "koushuangbwcx@163.com", "123456"));
        }};
    }
}
