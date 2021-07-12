package com.microserivce.user.controller;

import com.microserivce.user.VO.ResponseTemplateVO;
import com.microserivce.user.entity.User;
import com.microserivce.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    private User saveUser(@RequestBody User user){
        log.info(("Inside saveUser of Usercontroller"));
        return  userService.saveUser(user);
    }

    @GetMapping("{id}")
    private ResponseTemplateVO getUserwithDepartcment(@PathVariable("id") long userId){
        return  userService.getUserwithDepartcment(userId);
    }
}
