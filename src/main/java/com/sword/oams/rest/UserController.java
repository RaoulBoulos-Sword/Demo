package com.sword.oams.rest;

import com.sword.oams.domain.User;
import com.sword.oams.payload.request.UserRequest;
import com.sword.oams.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Users")
@RequestMapping("/oams/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getSpecificUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, UserRequest request) {
        return userService.updateUserById(id, request);
    }
}
