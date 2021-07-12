package com.sword.oams.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeRequest {
	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private Long teamId;

	@NotBlank
	private Long roomId;
}
