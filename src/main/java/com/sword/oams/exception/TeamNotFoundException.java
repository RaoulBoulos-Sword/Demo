package com.sword.oams.exception;
public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(Long id) {
        super("Could not find team " + id);
    }
}