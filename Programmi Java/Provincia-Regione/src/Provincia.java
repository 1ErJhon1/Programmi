/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class Provincia {
    String nome;
    int abit;
    Regione regione;

    public Provincia(String nome, int abit, Regione regione) {
        this.nome = nome;
        this.abit = abit;
        this.regione = regione;
    }

    public String getNome() {
        return nome;
    }
    

    public int getAbit() {
        return abit;
    }

    public Regione getRegione() {
        return regione;
    }
    
    
}
