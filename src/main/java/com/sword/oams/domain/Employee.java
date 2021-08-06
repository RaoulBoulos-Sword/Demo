package com.sword.oams.domain;

import lombok.*;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Hashtable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@PlanningEntity
@Entity
@Table(name = "employee")
public class Employee {
    @PlanningId
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "employee_Id", nullable = false)
    private Long employeeId;

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @OneToOne(optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id", unique=true, nullable=false, updatable=false)
    private User user;

    @NotNull
    @NonNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "team_Id")
    private Team team;

    @PlanningVariable(valueRangeProviderRefs = {"roomRange"})
    @ManyToOne
    private Room room;

    @PlanningVariable(valueRangeProviderRefs = {"rotationRange"})
    @ManyToOne
    private RotationGroup rotationGroup;

    @Column(name = "Availability")
    private boolean status;
}
