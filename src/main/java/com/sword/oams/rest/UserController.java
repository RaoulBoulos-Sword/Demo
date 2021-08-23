package com.sword.oams.rest;

import com.sword.oams.domain.User;
import com.sword.oams.payload.request.UserRequest;
import com.sword.oams.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Users")
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/oams/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all users.")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get a user by its ID.")
    public User getSpecificUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "This method is used to delete a user by its ID.")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "This method is used to update a user by its ID.")
    public User updateUser(@PathVariable Long id, UserRequest request) {
        return userService.updateUserById(id, request);
    }
}
