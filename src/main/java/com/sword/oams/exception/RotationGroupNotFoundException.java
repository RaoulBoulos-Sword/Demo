package com.sword.oams.exception;

public class RotationGroupNotFoundException extends RuntimeException {
    public RotationGroupNotFoundException(Long id) {
        super("Could not find rotation group with id "+id);
    }
}
