package com.app.api.controller;

import com.app.api.entity.User;
import com.app.api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private Service service;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String addUser(@RequestBody User user) {
        if (service.addUser(user)){
            return "SUCCESS";
        }else {
            return "SOMETHING WENT WRONG";
        }
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public String editUser(@RequestBody User user) {
        if (service.editUser(user)){
            return "SUCCESS";
        }else {
            return "SOMETHING WENT WRONG";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public String deleteUser(@PathVariable long id) {
        if (service.deleteUser(id)){
            return "SUCCESS";
        }else {
            return "SOMETHING WENT WRONG";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUserById(@PathVariable long id) {
        User user = service.getUserById(id);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getBooksForUser(@PathVariable long id){
        return service.getBooksForUser(id);
    }
}
