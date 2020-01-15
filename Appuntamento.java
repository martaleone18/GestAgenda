/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda01;

import java.time.LocalDateTime;

/**
 * appuntamento non modificabile
 *
 *
 * @author tss
 */
public class Appuntamento implements Comparable <Appuntamento> {

    private static int counter = 1;
    private final int id; //obbligatorio
    private final LocalDateTime quando; //obbligatorio
    private final String motivo;
    private final String persona;
    private final String luogo;

    
    /*costruttore con i due parametri obbligatori, non necessario ma più comodo */
    public Appuntamento(LocalDateTime quando) {
        this(quando, null, null, null);
    }

    
    public Appuntamento(LocalDateTime quando, String motivo, String persona, String luogo) {
        this.id = counter++;
        this.quando = quando;
        this.motivo = motivo;
        this.persona = persona;
        this.luogo = luogo;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getQuando() {
        return quando;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getPersona() {
        return persona;
    }

    public String getLuogo() {
        return luogo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Appuntamento other = (Appuntamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

  
    public boolean findMotivo(String ricerca) {
        return this.motivo != null && this.motivo.contains(motivo);
    }

    public boolean findPersona(String ricerca) {
        return this.persona != null && this.persona.contains(persona);
    }

    public boolean findLuogo(String ricerca) {
        return this.luogo != null && this.luogo.contains(luogo);
    }

    @Override
    public int compareTo(Appuntamento a) {
      return this.quando.compareTo(a.getQuando());
    }

    @Override
    public String toString() {
        return "Appuntamento{" + "id=" + id + ", quando=" + quando + ", motivo=" + motivo + ", persona=" + persona + ", luogo=" + luogo + '}';
    }

}
