package com.sword.oams.domain;

import lombok.*;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "employeeId", nullable = false)
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

    @PlanningVariable(valueRangeProviderRefs = {"roomRange"})
    //@NotNull
    //@NonNull
    @ManyToOne//(cascade=CascadeType.ALL)
    //@JoinColumn(name = "roomId")
    private Room room;

    @PlanningVariable(valueRangeProviderRefs = {"rotationRange"})
    @ManyToOne
    private RotationGroup rotationGroup;
}
