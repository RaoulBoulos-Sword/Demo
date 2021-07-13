package com.sword.oams.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RoleRequest {

    @NotBlank
    private String roleName;

}
