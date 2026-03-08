// Peamine Spring Boot rakenduse klass, mis käivitab kogu backendi teenuse.

package com.example.backend_tableReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendTableReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTableReservationApplication.class, args);
	}

}
