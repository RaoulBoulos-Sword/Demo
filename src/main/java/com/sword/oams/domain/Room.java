package com.sword.oams.domain;

import lombok.*;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @PlanningId
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "roomId")
    private Long roomId;

    @NotNull
    @NonNull
    private String block;

    @NotNull
    @NonNull
    private int deskNumber;
}
