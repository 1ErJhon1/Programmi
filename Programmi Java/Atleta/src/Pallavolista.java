/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ITALO
 */
public class Pallavolista extends Atleta {
    int falli;
    int vinte;
    int perse;

    public Pallavolista(int falli, int vinte, int perse, String nome, String nazionalita, int numeroGare, int annoNascita) {
        super(nome, nazionalita, numeroGare, annoNascita);
        this.falli = falli;
        this.vinte = vinte;
        this.perse = perse;
    }
    
    public String toString(){
        return "Falli: "+falli+"\nPartite vinte: "+vinte+"\nPartite perse: "+perse;
    }
}
