package com.sword.oams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(String email, String link) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("raoul.v.boulos@gmail.com");
        mail.setSubject("Forgot Password");
        mail.setTo(email);
        mail.setText("Click on this link to change your password: \n"+link);

        javaMailSender.send(mail);
    }
}
