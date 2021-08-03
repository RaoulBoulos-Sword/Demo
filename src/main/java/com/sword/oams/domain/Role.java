package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "role_Id")
    private Long roleId;

    @NotNull
    @NonNull
    private String roleName;
}
