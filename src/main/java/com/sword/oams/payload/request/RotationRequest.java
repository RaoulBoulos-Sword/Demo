package com.sword.oams.payload.request;

import com.sword.oams.domain.WDay;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class RotationRequest {
    @NotBlank
    private String name;

    private Set<WDay> weekDay;
}
