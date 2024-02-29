/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class reparto {
    String nome;
    int piano;
    caporeparto caporeparto;

    public reparto(String nome, int piano) {
        this.nome = nome;
        this.piano = piano;
    }

    public caporeparto getCaporeparto() {
        return caporeparto;
    }

    public String getNome() {
        return nome;
    }

    public int getPiano() {
        return piano;
    }

    public void setCaporeparto(caporeparto caporeparto) {
        this.caporeparto = caporeparto;
    }
}
