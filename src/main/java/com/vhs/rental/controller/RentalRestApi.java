package com.vhs.rental.controller;

import com.vhs.rental.model.Rental;
import com.vhs.rental.model.Vhs;
import com.vhs.rental.service.RentalService;
import com.vhs.rental.service.VhsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
