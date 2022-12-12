package com.vhs.rental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @NotNull(message = "User cannot be null!")
    private User userRented;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vhsId")
    @NotNull(message = "Vhs cannot be null!")
    private Vhs vhsRented;

    @Column
    @NotNull(message = "Start date cannot be null!")
    private LocalDate startDate;

    @Column
    @NotNull(message = "End date cannot be null!")
    private LocalDate endDate;

    @Column
    private LocalDate dateReturned;

    @Column
    private Integer lateCost;

}
