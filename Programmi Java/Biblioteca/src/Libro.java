/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class Libro {
    String nome;
    int codice;
    String aut;
    String casaed;
    float prz;
    int nscaff;
    int disponibili;
    int quantita;
    Biblioteca biblioteca;

    public Libro(String nome, int codice, String aut, String casaed, float prz, int nscaff, int quantita, Biblioteca biblioteca) {
        this.nome = nome;
        this.codice = codice;
        this.aut = aut;
        this.casaed = casaed;
        this.prz = prz;
        this.nscaff = nscaff;
        this.quantita = quantita;
        this.biblioteca = biblioteca;
        this.disponibili = this.quantita;
    }
    
    public void sconto(int sconto){
        float przs=prz*sconto/100;
        prz-=przs;
    }
    
    public void presta(){
        disponibili--;
    }
    
    public void restituisci(){
        disponibili++;
    }
    
    
}
