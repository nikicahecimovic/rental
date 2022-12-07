package com.vhs.rental.repository;

import com.vhs.rental.model.Vhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VhsRepository extends JpaRepository<Vhs, Long> {

}
