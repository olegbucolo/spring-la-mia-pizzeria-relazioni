package org.exercises.java.spring_la_mia_pizzeria_relazioni.repositories;

import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Integer> {
    
}
