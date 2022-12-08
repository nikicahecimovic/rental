package com.vhs.rental.repository;

import com.vhs.rental.model.Rental;
import com.vhs.rental.model.Vhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Rental findByRentalId(Long rentalId);
}
