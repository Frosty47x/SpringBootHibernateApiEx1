package com.app.api.controller;

import com.app.api.entity.Book;
import com.app.api.entity.User;
import com.app.api.entity.request.RequestUser;
import com.app.api.entity.response.ResponseEntity;
import com.app.api.service.Service;
import com.app.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private Service service;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody RequestUser user) {
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public ResponseEntity editUser(@RequestBody RequestUser user) {
        return userService.editUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public String deleteUser(@PathVariable long id) {
        if (service.deleteUser(id)) {
            return "SUCCESS";
        } else {
            return "SOMETHING WENT WRONG";
        }
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUserByUsernameAndPassword(@RequestBody User user) {
        return userService.getUser(user);
    }

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public String getAllUsers() {
//        return service.getAllUsers();
//    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getBooksForUser(@PathVariable long id) {
        return service.getBooksForUser(id);
    }
}
