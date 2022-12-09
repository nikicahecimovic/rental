package com.vhs.rental.form;

import com.vhs.rental.model.User;
import com.vhs.rental.model.Vhs;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class RentalForm {

    @NotNull
    private User user;

    @NotNull
    private Vhs vhs;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private LocalDate dateReturned;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vhs getVhs() {
        return vhs;
    }

    public void setVhs(Vhs vhs) {
        this.vhs = vhs;
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
}

