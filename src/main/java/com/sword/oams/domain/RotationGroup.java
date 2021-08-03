package com.sword.oams.domain;

import lombok.*;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rotation_Group")
public class RotationGroup {
    @PlanningId
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "rotation_Id")
    private Long rotationId;

    @NotNull
    @NonNull
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rotation_Days",
            joinColumns = @JoinColumn(name = "rotation_Id"),
            inverseJoinColumns = @JoinColumn(name = "week_Day_Id"))
    private Set<Weekdays> weekdays = new HashSet<>();

    //Rotations to be ignored from employees solving
    @Column(name = "Availability")
    private boolean status = false;
}

