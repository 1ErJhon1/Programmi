/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class Calciatore {
    String nome;
    int goalSegnati;
    int partiteGiocate;

    public Calciatore(String nome, int goalSegnati, int partiteGiocate) {
        this.nome = nome;
        this.goalSegnati = goalSegnati;
        this.partiteGiocate = partiteGiocate;
    }

    public String toString() {
        String s;
        s="Nome:"+nome;
        s+="\nGoal segnati:"+goalSegnati;
        s+="\nPartite giocate:"+partiteGiocate;
        return s;
    }

    public String getNome() {
        return nome;
    }

    public int getPartiteGiocate() {
        return partiteGiocate;
    }
    
    
    
    
}
