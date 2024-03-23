package com.fluxmongo.testing.controller;

import com.fluxmongo.testing.Service.UserService;
import com.fluxmongo.testing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUser(@PathVariable(value = "id") final String userId){
        return userService.findById(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getAllUsers(@RequestParam(value = "name") final String name){
        return userService.fetchUser(name);
    }


}
