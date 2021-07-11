package com.sword.oams.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "weekdays")
public class weekdays {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long weekday_id;

    @NotNull
    private String dayName;
}
