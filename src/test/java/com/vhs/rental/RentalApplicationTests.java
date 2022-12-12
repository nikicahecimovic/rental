package com.vhs.rental;

import com.vhs.rental.exception.RentalNotFoundException;
import com.vhs.rental.exception.VhsNotAvailableForRentException;
import com.vhs.rental.exception.VhsNotFoundException;
import com.vhs.rental.model.Rental;
import com.vhs.rental.model.User;
import com.vhs.rental.model.Vhs;
import com.vhs.rental.repository.RentalRepository;
import com.vhs.rental.repository.UserRepository;
import com.vhs.rental.repository.VhsRepository;
import com.vhs.rental.service.RentalService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RentalApplicationTests {

	@Autowired
	RentalRepository rentalRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	VhsRepository vhsRepository;

	@Autowired
	RentalService rentalService;

	@Test
	@Order(1)
	void testRentVhs() throws VhsNotAvailableForRentException, VhsNotFoundException, RentalNotFoundException {

		User user = new User();
		user.setActive(true);
		user.setUsername("username");
		user.setPassword("password");
		user.setRole("ROLE_ADMIN");
		userRepository.save(user);

		Vhs vhs = new Vhs();
		vhs.setAvailableForRent(true);
		vhs.setName("Jumanji");
		vhsRepository.save(vhs);

		//Although this is not optimal as userId is hard-coded, this is 3L because there are two users already pre-existing in the database
		Rental rented = rentalService.rentVhs(3L, 5L);
		Rental rentalCheck = rentalService.getRentalById(2L);

		Assertions.assertEquals(rented.getVhsRented().getName(), rentalCheck.getVhsRented().getName());
		Assertions.assertEquals(rented.getUserRented().getUsername(), rentalCheck.getUserRented().getUsername());
		Assertions.assertEquals(rented.getStartDate(), LocalDate.now());
	}

	@Test
	@Order(2)
	void testReturnRental() throws RentalNotFoundException, VhsNotAvailableForRentException, VhsNotFoundException {
		User user = new User();
		user.setActive(true);
		user.setUsername("username");
		user.setPassword("password");
		user.setRole("ROLE_ADMIN");
		userRepository.save(user);

		Vhs vhs = new Vhs();
		vhs.setAvailableForRent(true);
		vhs.setName("Pulp Fiction");
		vhsRepository.save(vhs);

		Rental rented = rentalService.rentVhs(3L, 5L);

		Rental rentalReturned = rentalService.returnVhs(2L);

		Rental rentalCheck = rentalService.getRentalById(2L);

		Assertions.assertEquals(rentalReturned.getVhsRented().getName(), rentalCheck.getVhsRented().getName());
		Assertions.assertEquals(rentalReturned.getVhsRented().isAvailableForRent(), rentalCheck.getVhsRented().isAvailableForRent());
	}

	@Test
	@Order(3)
	void testSaveVhs() {
		Vhs vhs = new Vhs();
		vhs.setAvailableForRent(true);
		vhs.setName("Shawshank Redemption");
		Vhs savedVhs = vhsRepository.save(vhs);
		Vhs retrievedVhs = vhsRepository.findByName("Shawshank Redemption");
		Assertions.assertEquals(retrievedVhs.getVhsId(), savedVhs.getVhsId());
	}
}
