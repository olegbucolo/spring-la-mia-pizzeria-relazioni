package org.exercises.java.spring_la_mia_pizzeria_crud.controllers;

import org.exercises.java.spring_la_mia_pizzeria_crud.models.Pizza;
import org.exercises.java.spring_la_mia_pizzeria_crud.repositories.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    
    private final PizzaRepository pr;

    public PizzaController(PizzaRepository pr){
        this.pr = pr;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("pizzas", pr.findAll());
        return "pizzas";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model){
        Pizza pizza = pr.findById(id)
        .orElseThrow(() -> new RuntimeException("Pizza no found"));
        model.addAttribute("pizza", pizza);
        return "pizza-detail";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("pizza", new Pizza());
        return "pizza-create";
    }

    @PostMapping
    public String store(@ModelAttribute Pizza pizza){
        pr.save(pizza);
        return "redirect:/pizzas";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        pr.deleteById(id);
        return "redirect:/pizzas";
    }

    @GetMapping("/edit/{id}")
    public String editAtId(@PathVariable int id, Model model) {
        Pizza pizza = pr.findById(id).orElseThrow();
        model.addAttribute("pizza", pizza);
        return "pizza-edit";
    }

    @PutMapping("/{id}")
    public String editAtId(@PathVariable int id, @ModelAttribute Pizza pizza){
        pizza.setId(id);
        pr.save(pizza);
        return "redirect:/pizzas";
    }
    
}
