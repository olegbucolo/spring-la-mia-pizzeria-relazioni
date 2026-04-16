package org.exercises.java.spring_la_mia_pizzeria_relazioni;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.Pizza;
import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.SpecialOffer;
import org.exercises.java.spring_la_mia_pizzeria_relazioni.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

}
