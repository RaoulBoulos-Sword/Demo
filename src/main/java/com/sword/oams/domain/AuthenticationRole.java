package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "auth_Roles")
public class AuthenticationRole {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_Role_Id")
    private Long authRoleId;

    @Enumerated(EnumType.STRING)
    @NonNull
    private ERole name;
}
