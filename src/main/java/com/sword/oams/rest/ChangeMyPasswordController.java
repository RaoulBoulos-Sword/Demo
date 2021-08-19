package com.sword.oams.rest;

import com.sword.oams.domain.User;
import com.sword.oams.payload.request.ChangePasswordRequest;
import com.sword.oams.payload.response.MessageResponse;
import com.sword.oams.repository.UserRepository;
import com.sword.oams.service.UserDetailsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "Change Password")
@RequestMapping("/oams/changePass")
public class ChangeMyPasswordController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<?> changeMyPassword(HttpServletRequest request, @RequestBody ChangePasswordRequest changePasswordRequest) {
        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username);
        String newInputPassword = changePasswordRequest.getNewPassword();
        userDetailsService.updatePassword(user, newInputPassword);
        return ResponseEntity.ok(new MessageResponse("Success: Password changed for user: "+user.getUsername()));
    }
}
