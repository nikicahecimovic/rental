package com.vhs.rental.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

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
    private Date startDate;

    @Column
    @NotNull(message = "End date cannot be null!")
    private Date endDate;

    @Column
    @NotNull(message = "Date returned cannot be null!")
    private Date dateReturned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }
}
