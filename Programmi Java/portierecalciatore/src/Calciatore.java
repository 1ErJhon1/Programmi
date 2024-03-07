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
    int[] goalSegnati;
    int partiteGiocate;

    public Calciatore(String nome, int[] goalSegnati, int partiteGiocate) {
        this.nome = nome;
        this.goalSegnati = goalSegnati;
        this.partiteGiocate = partiteGiocate;
    }

    public String toString() {
        String s;
        s="Nome:"+nome;
        for(int i=0;i<partiteGiocate;i++){
            s+="Partita "+i+":"+goalSegnati[i];
        }
        return s;
    }
    
    
}
