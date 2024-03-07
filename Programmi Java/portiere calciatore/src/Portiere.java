/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author giann
 */
public class Portiere extends Calciatore {
    
    int goalSubiti;
    int rigoriSubiti;
    int rigoriParati;

    public Portiere(int goalSubiti, int rigoriSubiti, int rigoriParati, String nome, int goalSegnati, int partiteGiocate) {
        super(nome, goalSegnati, partiteGiocate);
        this.goalSubiti = goalSubiti;
        this.rigoriSubiti = rigoriSubiti;
        this.rigoriParati = rigoriParati;
    }
    
    public String toString() {
        String s;
        s="Nome:"+nome+"\nGoal segnati:"+goalSegnati+"\nPartite giocate"+partiteGiocate+"\nGoal subiti:"+goalSubiti+"\nRigori subiti:"+rigoriSubiti+"\nRigori parati:"+rigoriParati;
        if(rigoriParati>goalSubiti)
            s+="Bravo giocatore";
        return s;
    }

    public String getNome() {
        return nome;
    }
    
    public int getPartiteGiocate() {
        return super.getPartiteGiocate(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
