package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "employeeId")
    private Long employeeId;

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @NotNull
    @NonNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "teamId")
    private Team team;

    @NotNull
    @NonNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "roomId")
    private Room room;
}
