
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class caporeparto {
    String nome;
    int eta;
    reparto reparto;

    public caporeparto(String nome, int eta, reparto reparto) {
        this.nome = nome;
        this.eta = eta;
        this.reparto = reparto;
    }

    public int getEta() {
        return eta;
    }

    public String getNome() {
        return nome;
    }
    
     
}
