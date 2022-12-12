package com.vhs.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Vhs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vhsId;

    @Column
    @NotNull(message = "Vhs name cannot be null!")
    private String name;

    @Column
    @NotNull(message = "Vhs availability cannot be null!")
    private boolean availableForRent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vhs vhs = (Vhs) o;
        return Objects.equals(name, vhs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, availableForRent);
    }

}
