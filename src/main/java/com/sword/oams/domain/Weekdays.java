package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weekDays")
public class Weekdays {
    @Id
    @Column(name = "weekDayId")
    private Long weekDayId;

    @Enumerated(EnumType.STRING)
    private WDay weekDay;
}
