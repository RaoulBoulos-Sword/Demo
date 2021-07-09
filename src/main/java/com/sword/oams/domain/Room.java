package com.sword.oams.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
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
