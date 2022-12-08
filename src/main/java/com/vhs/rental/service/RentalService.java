package com.vhs.rental.service;

import com.vhs.rental.exception.RentalNotFoundException;
import com.vhs.rental.exception.VhsNotAvailableForRentException;
import com.vhs.rental.model.Rental;
import com.vhs.rental.model.User;
import com.vhs.rental.model.Vhs;
import com.vhs.rental.repository.RentalRepository;
import com.vhs.rental.repository.UserRepository;
import com.vhs.rental.repository.VhsRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    VhsRepository vhsRepository;

    @Autowired
    UserRepository userRepository;

    @Value("${rental.rentalDays}")
    public Integer rentalDays;

    @Value("${rental.lateCost}")
    public Integer lateCost;

    public List<Rental> getAllRentals(){
        return rentalRepository.findAll();
    }

    public Rental rentVhs(Long userId, Long vhsId) throws VhsNotAvailableForRentException {
        Rental rental = new Rental();
        Vhs vhs = vhsRepository.findByVhsId(vhsId);
        if (vhs.isAvailableForRent()) {
            vhs.setAvailableForRent(false);
            User user = userRepository.findByUserId(userId);
            rental.setUserRented(user);
            rental.setStartDate(LocalDate.now());
            rental.setEndDate(LocalDate.now().plusDays(rentalDays));
            rental.setVhsRented(vhs);
            rentalRepository.save(rental);
        } else {
            throw new VhsNotAvailableForRentException("This VHS is not available for rent");
        }
        return rental;
    }

    public Rental returnVhs(Long rentalId) throws RentalNotFoundException {
        Rental rental = rentalRepository.findByRentalId(rentalId);
        if (rental == null) {
            throw new RentalNotFoundException("Rental with id " + rentalId + " not found");
        }
        if (rental.getDateReturned() == null) {
            LocalDate rentEndDate = rental.getEndDate();
            LocalDate returnDate = LocalDate.now();
            rental.setDateReturned(returnDate);
            Vhs vhs = rental.getVhsRented();
            vhs.setAvailableForRent(true);
            rental.setVhsRented(vhs);
            int daysDifference = (int) (rentEndDate.toEpochDay() - returnDate.toEpochDay());
            if (daysDifference < 0) {
                rental.setLateCost(lateCost * Math.abs(daysDifference));
            }
            rentalRepository.save(rental);
        } else {
            throw new IllegalStateException("This VHS has not been rented yet, therefore it cannot be returned");
        }
        return rental;
    }
}
