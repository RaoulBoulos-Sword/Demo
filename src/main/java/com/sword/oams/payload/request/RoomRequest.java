package com.sword.oams.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoomRequest {

    @NotBlank
    private char block;

    @NotBlank
    private int deskNumber;
}
