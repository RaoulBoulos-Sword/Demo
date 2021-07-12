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
@Table(name = "employee")
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
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @NotNull
    @NonNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;
}
