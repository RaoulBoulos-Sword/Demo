package com.sword.oams.payload.request;

import com.sword.oams.domain.WDay;
import com.sword.oams.domain.Weekdays;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
public class RotationRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Set<Weekdays> weekDay;

    @NotBlank
    private boolean status;
}
