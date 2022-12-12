package com.vhs.rental.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserForm {
    @NotNull
    String username;

    @NotNull
    String password;

    @NotNull
    String role;
}
