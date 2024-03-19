
import java.time.LocalDate;
import java.time.Period;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITALO
 */
public class Atleta {
    String nome;
    String nazionalita;
    int numeroGare;
    int annoNascita;

    public Atleta(String nome, String nazionalita, int numeroGare, int annoNascita) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.numeroGare = numeroGare;
        this.annoNascita = annoNascita;
    }
    
    public int eta(int anno){
        return LocalDate.now().getYear()-anno;
    }
    
    public String toString(){
        return "NOME: "+nome+"\nNAZIONALITA': "+nazionalita+"\nNumero Gare: "+numeroGare+"\nAnno di Nascita: "+annoNascita;
    }
}
