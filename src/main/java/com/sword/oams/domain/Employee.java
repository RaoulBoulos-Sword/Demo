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
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long employee_id;

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @NotNull
    @NonNull
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    private Room room;
}
