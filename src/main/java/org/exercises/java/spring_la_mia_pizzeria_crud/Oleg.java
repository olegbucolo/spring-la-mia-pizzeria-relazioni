package org.exercises.java.spring_la_mia_pizzeria_crud;

import java.util.HashMap;
import java.util.Map;

public class Oleg extends Studenti {

    @Override
    public void uscireDallaClasse() {
        System.out.println("Ciao ciao");
    }

    public static void main(String[] args) {
        Oleg oleg = new Oleg();
        // oleg.uscireDallaClasse();
        System.out.println(oleg.toString());

        Map<Integer, String> oggetto = new HashMap<>();

        // map        {nome: "valore"}
    }

}
