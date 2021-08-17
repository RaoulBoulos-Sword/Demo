package com.sword.oams.rest;

import com.sword.oams.domain.User;
import com.sword.oams.payload.request.ForgotPasswordRequest;
import com.sword.oams.service.NotificationService;
import com.sword.oams.service.UserDetailsServiceImpl;
import com.sword.oams.utils.Utility;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Slf4j
@Api(tags = "Forgot Password")
@RestController
public class ForgotPasswordController {

    private Logger logger = LoggerFactory.getLogger(ForgotPasswordController.class);

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/forgot_password")
    public void processForgotPassword(ForgotPasswordRequest resetRequest,HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String email = resetRequest.getEmail();
        String token = RandomString.make(30);

        userService.updateResetPasswordToken(token, email);
        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password/" + token;
        try {
            notificationService.sendNotification(email,resetPasswordLink);
        } catch (MailException e) {
            logger.info(e.getMessage());
        }
    }

    @GetMapping("/reset_password/{token}")
    public String clickedLink(@PathVariable String token) {
        User user = userService.getResetPasswordToken(token);
        return "Changing password for user: "+user.getUsername();
    }

    @PostMapping("/reset_password/{token}")
    public String processResetPassword(@PathVariable String token, @RequestBody String password) {
        User user = userService.getResetPasswordToken(token);
        if(user==null) {
            return "User with reset token: "+token+" was not found";
        }
        userService.updatePassword(user,password);
        return "Password Changed Successfully";
    }
}
