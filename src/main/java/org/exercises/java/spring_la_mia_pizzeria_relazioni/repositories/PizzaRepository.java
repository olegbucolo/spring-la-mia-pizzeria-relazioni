package org.exercises.java.spring_la_mia_pizzeria_relazioni.repositories;

import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    
}
