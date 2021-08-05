package com.sword.oams.rest;

import com.sword.oams.config.EmailConfig;
import com.sword.oams.domain.User;
import com.sword.oams.payload.request.ForgotPasswordRequest;
import com.sword.oams.service.UserDetailsServiceImpl;
import com.sword.oams.utils.Utility;
import io.swagger.annotations.Api;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Api(tags = "Forgot Password")
@RestController
public class ForgotPasswordController {

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    PasswordEncoder encoder;

    private EmailConfig emailConfig;

    public ForgotPasswordController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public void sendEmail(String recipientEmail, String link) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("raoul.v.boulos@gmail.com");
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject("Password Change");
        mailMessage.setText("Send a post request to this link to change your password:\n"+link);

        mailSender.send(mailMessage);
    }


    @PostMapping("/forgot_password")
    public void processForgotPassword(ForgotPasswordRequest resetRequest,HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String email = resetRequest.getEmail();
        String token = RandomString.make(30);

        userService.updateResetPasswordToken(token, email);
        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
        sendEmail(email, resetPasswordLink);
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
