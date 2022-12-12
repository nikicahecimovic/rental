package com.vhs.rental.controller;

import com.vhs.rental.exception.RentalNotFoundException;
import com.vhs.rental.exception.VhsNotAvailableForRentException;
import com.vhs.rental.exception.VhsNotFoundException;
import com.vhs.rental.form.RentalForm;
import com.vhs.rental.model.Rental;
import com.vhs.rental.repository.RentalRepository;
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

    @Autowired
    RentalRepository rentalRepository;

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Rental> getAll(){
        log.info("GET All Rentals'");
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental getRentalById(@PathVariable Long id) throws RentalNotFoundException {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found with ID: " + id));
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental addRental(@RequestBody RentalForm rentalForm) {
        return rentalService.addRental(rentalForm);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }

    @PostMapping(value = "/rent/{userId}/{vhsId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental rentVhs(@PathVariable Long userId, @PathVariable Long vhsId) throws VhsNotAvailableForRentException, VhsNotFoundException {
        log.info("POST Rent Vhs");
        return rentalService.rentVhs(userId, vhsId);
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental editRental(@PathVariable Long id, @RequestBody RentalForm rentalForm) throws VhsNotAvailableForRentException, RentalNotFoundException, VhsNotFoundException {
        return rentalService.editRental(id, rentalForm);
    }

    @PutMapping(value = "/return/{rentalId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Rental returnVhs(@PathVariable Long rentalId) throws RentalNotFoundException {
        log.info("PUT Return Vhs");
        return rentalService.returnVhs(rentalId);
    }
}
