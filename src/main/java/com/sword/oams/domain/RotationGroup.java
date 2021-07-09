package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class RotationGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long rotation_id;

    @NonNull
    @NotNull
    @ElementCollection
    private Set<DayOfWeek> days;

    @NonNull
    @NotNull
    private String name;
}

