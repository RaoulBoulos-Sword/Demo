package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weekDays")
public class Weekdays {
    @Id
    @NonNull
    @Column(name = "weekDayId")
    private Long weekDayId;

    @Enumerated(EnumType.STRING)
    @NonNull
    private WDay weekDay;
}
