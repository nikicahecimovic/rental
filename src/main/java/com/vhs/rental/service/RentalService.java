package com.vhs.rental.service;

import com.vhs.rental.model.Rental;
import com.vhs.rental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }
}
