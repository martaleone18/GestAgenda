/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Agenda {

    private List<Appuntamento> appuntamenti = new ArrayList<>();

    public void add(Appuntamento a) {
        appuntamenti.add(a);
    }

    public List<Appuntamento> search(String ricerca) {
        List<Appuntamento> ris = new ArrayList<>();
        for (Appuntamento a : appuntamenti) {
            if (a.findMotivo(ricerca) || a.findPersona(ricerca) || a.findLuogo(ricerca)) {
                ris.add(a);
            }
        }
        return ris;
    }

    public Optional<Appuntamento> find(int id) {
        Optional<Appuntamento> result = Optional.empty();
        for (Appuntamento a : appuntamenti) {
            if (a.getId() == id) {
                result = Optional.of(a);
            }
        }
        return result;
    }

    public void remove(int id) {
        Optional<Appuntamento> finded = find(id);
        if (finded.isPresent()) {
            appuntamenti.remove(finded.get());
        }
    }

    /*public void remove1(int id) {
        Optional<Appuntamento> finded = find(id);
        if (finded.isPresent()) {
            appuntamenti.remove(finded.get());
        } else {
            throw new IllegalArgumentException("appuntamento inesistente");
        }
    }

      public boolean remove2(int id) {
        boolean result = false;
        Optional<Appuntamento> finded = find(id);
        if (finded.isPresent()) {
            appuntamenti.remove(finded.get());
            result = true;
        }
        return result;
    }*/

    public void update(int id, Appuntamento a) {
        remove(id);
        add(a);
    }

    public void stampa() {
        for (Appuntamento a : appuntamenti) {
            System.out.println(a);
        }
    }
    
    
    public List <Appuntamento> all(){
        return new ArrayList <> (appuntamenti);
    }
}
