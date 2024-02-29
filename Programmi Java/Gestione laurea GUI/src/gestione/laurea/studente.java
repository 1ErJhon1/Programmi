/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestione.laurea;

/**
 *
 * @author giann
 */
public class studente {
    String matricola;
    corsolaurea corsolaurea;

    public studente(String matricola, corsolaurea corsolaurea) {
        this.matricola = matricola;
        this.corsolaurea = corsolaurea;
    }

    public String getMatricola() {
        return matricola;
    }

    public corsolaurea getCorsolaurea() {
        return corsolaurea;
    }
}
