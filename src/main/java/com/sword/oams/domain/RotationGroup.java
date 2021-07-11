package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class RotationGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long rotation_id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rotation_days",
            joinColumns = @JoinColumn(name = "rotation_id"),
            inverseJoinColumns = @JoinColumn(name = "weekday_id"))
    private Set<Role> weekdays = new HashSet<>();

    @NonNull
    @NotNull
    private String name;
}

