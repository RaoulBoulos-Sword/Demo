package com.sword.oams.service;

import com.sword.oams.domain.AuthenticationRole;
import com.sword.oams.domain.ERole;
import com.sword.oams.domain.User;
import com.sword.oams.payload.request.UserRequest;
import com.sword.oams.repository.AuthRolesRepository;
import com.sword.oams.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthRolesRepository authRolesRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, UserRequest request) {
        Set<String> requestRoles = request.getRoles();
        Set<AuthenticationRole> roleSet = new HashSet<>();

        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(request.getUsername());
                    user.setAddress(request.getAddress());
                    user.setEmail(request.getEmail());

                    if(requestRoles== null) {
                        AuthenticationRole userRole = authRolesRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roleSet.add(userRole);
                    } else {
                        requestRoles.forEach(role -> {
                            switch (role) {
                                case "admin":
                                    AuthenticationRole adminRole = authRolesRepository.findByName(ERole.ROLE_ADMIN)
                                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                                    roleSet.add(adminRole);
                                    break;
                                case "mod":
                                    AuthenticationRole modRole = authRolesRepository.findByName(ERole.ROLE_MODERATOR)
                                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                                    roleSet.add(modRole);
                                    break;
                                default:
                                    AuthenticationRole userRole = authRolesRepository.findByName(ERole.ROLE_USER)
                                            .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                                    roleSet.add(userRole);
                            }
                        });
                    }
                    user.setRoles(roleSet);

                    return userRepository.save(user);
                })
                .orElse(null);
    }
}
