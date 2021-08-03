package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "week_Days")
public class Weekdays {
    @Id
    @Column(name = "week_Day_Id")
    private Long weekDayId;

    @Enumerated(EnumType.STRING)
    private WDay weekDay;
}
