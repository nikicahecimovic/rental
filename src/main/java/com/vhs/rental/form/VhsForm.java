package com.vhs.rental.form;

import javax.validation.constraints.NotNull;

public class VhsForm {

    @NotNull
    String name;

    @NotNull
    boolean isAvailableForRent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailableForRent() {
        return isAvailableForRent;
    }

    public void setAvailableForRent(boolean availableForRent) {
        isAvailableForRent = availableForRent;
    }
}
