package com.learnSpringMVC.controller;

import com.learnSpringMVC.pojo.User;
import org.springframework.web.bind.annotation.*;

//@Controller("usersRESTController")
//@ResponseBody
@RestController("usersRESTController")  // @Controller + @ResponseBody
@RequestMapping("/users")
public class usersRESTController {
    @GetMapping
    public String getUsers(){
        System.out.println("getUsers...");
        return "{" +
                "'message':'getUsers'" +
                "}";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id){
        System.out.println("getUserById... id:" + id);
        return "{" +
                "'message':'getUserById'" +
                "}";
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        System.out.println("addUser... user:" + user);
        return "{" +
                "'message':'addUser'" +
                "}";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        System.out.println("updateUser... id:" + id);
        System.out.println("updateUser... user:" + user);
        return "{" +
                "'message':'updateUser'" +
                "}";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        System.out.println("deleteUser... id:" + id);
        return "{" +
                "'message':'deleteUser'" +
                "}";
    }
}
