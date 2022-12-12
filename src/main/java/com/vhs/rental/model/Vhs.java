package com.vhs.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private boolean isAvailableForRent;

}
