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
@Table(name = "rotationGroup")
public class RotationGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long rotationId;

    @NotNull
    @NonNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rotationDays",
            joinColumns = @JoinColumn(name = "rotationId"),
            inverseJoinColumns = @JoinColumn(name = "weekDayId"))
    private Set<Weekdays> weekdays = new HashSet<>();
}

