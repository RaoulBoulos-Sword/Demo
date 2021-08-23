package com.sword.oams.rest;

import com.sword.oams.domain.User;
import com.sword.oams.payload.response.MessageResponse;
import com.sword.oams.repository.UserRepository;
import com.sword.oams.service.UserDetailsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@Api(tags = "Change Password")
@RequestMapping("/oams/changePass")
public class ChangeMyPasswordController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<?> changeMyPassword(HttpServletRequest request, @RequestBody @NotBlank String password) {
        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username);
        userDetailsService.updatePassword(user, password);
        return ResponseEntity.ok(new MessageResponse("Success: Password changed for user: "+user.getUsername()));
    }
}
