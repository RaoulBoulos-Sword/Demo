package com.sword.oams.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type="Bearer";
    private String username;
    private String email;
    private String address;
    private List<String> roles;
    private Long id;

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JwtResponse(String token, String username, String email, List<String> roles, Long id, String address) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.id = id;
        this.address = address;
    }
}
