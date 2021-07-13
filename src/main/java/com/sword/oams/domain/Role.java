package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long roleId;

    @NotNull
    private String roleName;
}
