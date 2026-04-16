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

	@Bean
	CommandLineRunner run(PizzaRepository repo) {
		return args -> {
			Pizza pizza = new Pizza();
			pizza.setDescription("lol");
			pizza.setName("pizzaProva");
			pizza.setPrice(new BigDecimal(55));

			SpecialOffer offer = new SpecialOffer();
			offer.setStartDate(LocalDate.of(2026,4,15));
			offer.setTitle("10%");
			offer.setEndDate(LocalDate.of(2026,4, 20));
			offer.setDiscount(BigDecimal.valueOf(10));

			pizza.addSpecialOffer(offer);
			repo.save(pizza);
		};
	}

}
