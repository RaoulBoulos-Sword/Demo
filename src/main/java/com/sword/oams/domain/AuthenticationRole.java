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
@Table(name = "authRoles")
public class AuthenticationRole {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authRoleId")
    private Long authRoleId;

    @Enumerated(EnumType.STRING)
    @NonNull
    private ERole name;
}
