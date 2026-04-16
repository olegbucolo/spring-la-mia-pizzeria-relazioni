package org.exercises.java.spring_la_mia_pizzeria_relazioni.controllers;

import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.Pizza;
import org.exercises.java.spring_la_mia_pizzeria_relazioni.models.SpecialOffer;
import org.exercises.java.spring_la_mia_pizzeria_relazioni.repositories.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/offers")
public class SpecialOfferController {

    private final PizzaRepository pizzaRepo;

    public SpecialOfferController(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @GetMapping("/create")
    public String create(@RequestParam Integer pizzaId, Model model) {
        model.addAttribute("offer", new SpecialOffer());
        model.addAttribute("pizzaId", pizzaId);
        return "offers/create-offer";
    }

    @PostMapping
    public String store(
            @RequestParam Integer pizzaId,
            @Valid @ModelAttribute("offer") SpecialOffer offer,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pizzaId", pizzaId);
            return "offers/create-offer";
        }

        Pizza pizza = pizzaRepo.findById(pizzaId).orElseThrow(() -> new RuntimeException("Pizza not found"));
        pizza.addSpecialOffer(offer);
        pizzaRepo.save(pizza);

        return "redirect:/pizzas/" + pizzaId;
    }
}
