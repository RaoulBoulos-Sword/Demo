package com.sword.oams.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "user_Id")
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
    @JoinTable(name = "user_Auth_Roles",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "auth_Role_Id"))
    private Set<AuthenticationRole> roles = new HashSet<>();

    @Column(name = "reset_password_token")
    private String resetPasswordToken;
}
