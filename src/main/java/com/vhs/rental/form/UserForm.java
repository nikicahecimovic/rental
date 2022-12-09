package com.vhs.rental.form;

import javax.validation.constraints.NotNull;

public class UserForm {
    @NotNull
    String username;

    @NotNull
    String password;

    @NotNull
    String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
