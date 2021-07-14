package com.sword.oams.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TeamRequest {

    @NotBlank
    private String name;

}
