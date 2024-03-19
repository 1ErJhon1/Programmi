
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ITALO
 */
public class Nuotatore extends Atleta {
    String stile;
    int tempo100;
    int tempo200;

    public Nuotatore(String stile, int tempo100, int tempo200, String nome, String nazionalita, int num, int annoNascita) {
        super(nome, nazionalita, num, annoNascita);
        this.stile = stile;
        this.tempo100 = tempo100;
        this.tempo200 = tempo200;
    }
    
    public String tostring(){
        return "Stile preferito: "+stile+"\nTempo record sui 100 metri: "+tempo100+" secondi\nTempo record sui 200 metri: "+tempo200+" secondi";
    }
}
