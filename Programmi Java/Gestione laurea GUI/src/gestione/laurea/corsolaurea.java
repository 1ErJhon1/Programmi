/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestione.laurea;

import java.util.ArrayList;

/**
 *
 * @author giann
 */
public class corsolaurea {
    private ArrayList<studente> studenti=new ArrayList<studente>();
    String denominazione;
    studente studente;
    String get_denominazione;

    public corsolaurea(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public studente getStudente() {
        return studente;
    }
    
    public void addstudente(studente s){
        studenti.add(s);
    }
}
