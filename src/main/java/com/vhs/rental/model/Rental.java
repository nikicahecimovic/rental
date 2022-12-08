package com.vhs.rental.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
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

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public User getUserRented() {
        return userRented;
    }

    public void setUserRented(User userRented) {
        this.userRented = userRented;
    }

    public Vhs getVhsRented() {
        return vhsRented;
    }

    public void setVhsRented(Vhs vhsRented) {
        this.vhsRented = vhsRented;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Integer getLateCost() {
        return lateCost;
    }

    public void setLateCost(Integer lateCost) {
        this.lateCost = lateCost;
    }
}
