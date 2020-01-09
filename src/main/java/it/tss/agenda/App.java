/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        Agenda ag = new Agenda();
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.MARCH, 20, 10, 10), "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.JUNE, 5, 15, 30), "tennis", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.MARCH, 22, 10, 0), "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.SEPTEMBER, 18, 9, 0), "scuola", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.MARCH, 25, 5, 0), "agenzia immobiliare", "agente", null));

        ag.stampa();

        System.out.println("----------------- ricerca ----------------");
        List<Appuntamento> appuntamentiTrovati = ag.search("lavoro");

        stampa(appuntamentiTrovati);

        System.out.println("-------------- find --------------");

        Optional<Appuntamento> found = ag.find(5);
        if (found.isPresent()) {
            Appuntamento a = found.get();
            System.out.println(a);
        } else {
            System.out.println("appuntamento non trovato");
        }

        System.out.println("-------------- elimina--------------");
        ag.remove(2);
        ag.stampa();

        System.out.println("-------------- update--------------");
        ag.update(1, new Appuntamento(LocalDateTime.now(), "cena calcio", "Mario", "Ivrea"));
        ag.stampa();

        System.out.println("-------------- ordinamento --------------");
        List<Appuntamento> all = ag.all();
        Collections.sort(all);
        stampa(all);

    }

    private static void stampa(List<Appuntamento> appuntamentiTrovati) {
        for (Appuntamento a : appuntamentiTrovati) {
            System.out.println(a);
        }

    }

}
