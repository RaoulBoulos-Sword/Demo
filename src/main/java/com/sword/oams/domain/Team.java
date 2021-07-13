package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long teamId;

    @NotNull
    @NonNull
    private String name;
}
