package com.sword.oams.domain;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "roomId")
    private Long roomId;

    @NotNull
    private String block;

    @NotNull
    private int deskNumber;
}
