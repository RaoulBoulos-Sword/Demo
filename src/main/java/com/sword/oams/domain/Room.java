package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long room_id;

    @NotNull
    @NonNull
    private String block;

    @NotNull
    @NonNull
    private int deskNumber;
}
