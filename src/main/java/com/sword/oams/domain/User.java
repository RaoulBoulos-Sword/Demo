package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user") //uniqueConstraints = {@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")})
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "userId")
    private Long userId;

    @NotNull
    @NonNull
    private String username;

    @NotNull
    @NonNull
    @Email
    private String email;

    @NotNull
    @NonNull
    private String password;

    @NotNull
    @NonNull
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userAuthRoles",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "authRoleId"))
    private Set<AuthenticationRole> roles = new HashSet<>();
}
