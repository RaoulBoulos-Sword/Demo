package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "weekdays")
public class Weekdays {
    @Id
    private Long weekday_id;

    @Enumerated(EnumType.STRING)
    @NonNull
    private WDay weekDay;
}
