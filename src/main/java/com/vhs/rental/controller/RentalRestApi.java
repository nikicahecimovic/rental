package com.vhs.rental.controller;

import com.vhs.rental.exception.RentalNotFoundException;
import com.vhs.rental.exception.VhsNotAvailableForRentException;
import com.vhs.rental.model.Rental;
import com.vhs.rental.model.User;
import com.vhs.rental.model.Vhs;
import com.vhs.rental.service.RentalService;
import com.vhs.rental.service.VhsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/rental")
public class RentalRestApi {

    @Autowired
    RentalService rentalService;

    @GetMapping(value = "/all")
    public List<Rental> getAll(){
        log.info("GET All Vhs'");
        return rentalService.getAllRentals();
    }

    @PostMapping(value = "/rent/{userId}/{vhsId}")
    public Rental rentVhs(@PathVariable Long userId, @PathVariable Long vhsId) throws VhsNotAvailableForRentException {
        log.info("POST Rent Vhs");
        return rentalService.rentVhs(userId, vhsId);
    }

    @PutMapping(value = "/return/{rentalId}")
    public Rental returnVhs(@PathVariable Long rentalId) throws RentalNotFoundException {
        log.info("PUT Return Vhs");
        return rentalService.returnVhs(rentalId);
    }
}
