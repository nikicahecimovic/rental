package com.vhs.rental.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VhsForm {

    @NotNull
    String name;

    boolean AvailableForRent;

}
