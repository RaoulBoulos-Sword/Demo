package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NonNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rotation_days",
            joinColumns = @JoinColumn(name = "rotation_id"),
            inverseJoinColumns = @JoinColumn(name = "weekday_id"))
    private Set<Weekdays> weekdays = new HashSet<>();
}

