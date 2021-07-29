package com.sword.oams.domain;

import lombok.*;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@PlanningSolution
public class EmployeeRotation {

    @NonNull
    @PlanningEntityCollectionProperty
    private List<Employee> employees;

    @NonNull
    @ValueRangeProvider(id = "rotationRange")
    @ProblemFactCollectionProperty
    private List<RotationGroup> rotationGroups;

    @NonNull
    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    private List<Room> rooms;

    @PlanningScore
    private HardSoftScore score;

    private SolverStatus solverStatus;
}
