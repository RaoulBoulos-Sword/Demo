package com.sword.oams.service;

import com.sword.oams.domain.User;
import com.sword.oams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);
        return UserDetailsImpl.build(user);
    }

    public void updateResetPasswordToken(String token, String email)  throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email);
        if(user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        }
    }

    public User getResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String password) {
        user.setPassword(encoder.encode(password));
        user.setResetPasswordToken(null);
        userRepository.save(user);
    }

}