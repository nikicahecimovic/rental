package com.vhs.rental.controller;

import com.vhs.rental.exception.RentalNotFoundException;
import com.vhs.rental.exception.VhsNotAvailableForRentException;
import com.vhs.rental.exception.VhsNotFoundException;
import com.vhs.rental.form.RentalForm;
import com.vhs.rental.model.Rental;
import com.vhs.rental.service.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/rental")
public class RentalController {

    @Autowired
    RentalService rentalService;

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Rental> getAll(){
        log.info("GET All Rentals'");
        return rentalService.getAllRentals();
    }

    @PostMapping(value = "/rent/{userId}/{vhsId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Rental rentVhs(@PathVariable Long userId, @PathVariable Long vhsId) throws VhsNotAvailableForRentException, VhsNotFoundException {
        log.info("POST Rent Vhs");
        return rentalService.rentVhs(userId, vhsId);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental editRental(@PathVariable Long id, @RequestBody RentalForm rentalForm) throws VhsNotAvailableForRentException, RentalNotFoundException {
        return rentalService.editRental(id, rentalForm);
    }

    @PutMapping(value = "/return/{rentalId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Rental returnVhs(@PathVariable Long rentalId) throws RentalNotFoundException {
        log.info("PUT Return Vhs");
        return rentalService.returnVhs(rentalId);
    }
}
