package com.sword.oams.payload.request;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class UserRequest {
    @NotBlank
    private String address;

    @NotBlank
    @Email
    private String username;

    //@NotBlank
    //@Email
    //private String email;

    private Set<String> roles;
}
