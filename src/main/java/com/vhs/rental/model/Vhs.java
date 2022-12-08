package com.vhs.rental.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Vhs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vhsId;

    @Column
    @NotNull(message = "Vhs name cannot be null!")
    private String name;

    @Column
    @NotNull(message = "Vhs availability cannot be null!")
    private boolean isAvailableForRent;

    public Long getId() {
        return vhsId;
    }

    public void setId(Long vhsId) {
        this.vhsId = vhsId;
    }

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
