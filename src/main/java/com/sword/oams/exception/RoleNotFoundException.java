package com.sword.oams.exception;

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(Long id) {
        super("Could not find role " + id);
    }
}