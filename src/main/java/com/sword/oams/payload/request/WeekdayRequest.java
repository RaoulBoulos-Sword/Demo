package com.sword.oams.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WeekdayRequest {

    @NotBlank
    private Long id;

    @NotBlank
    private String weekDay;
}
