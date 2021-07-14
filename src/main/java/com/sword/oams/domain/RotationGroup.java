package com.sword.oams.domain;

import lombok.*;

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
@Table(name = "rotationGroup")
public class RotationGroup {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "rotationId")
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

