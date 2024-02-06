/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionecalciatore;

import java.util.Scanner;
/**
 *
 * @author Jhon
 */
public class Calciatore {
    private String nome;
    private String sq;
    private int gol;
    private int min;
    
    public void ins(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci nome del giocatore:");
        nome=in.nextLine();
        System.out.println("Inserisci nome della squadra:");
        sq=in.nextLine();
        System.out.println("Inserisci il numero dei gol segnati:");
        gol=in.nextInt();
        System.out.println("Inserisci il numero di minuti segnati:");
        min=in.nextInt();
    }
    
    public void vis(){
        System.out.println("----CALCIATORE----\n-nome: "+nome+"\n-squadra: "+sq+"\n-N. gol: "+gol+"\n-minuti giocati: "+min+"'\n");
    }
    
    public int menu(){
        Scanner in=new Scanner(System.in);
        System.out.println("-----MENU-----\n1) Inserisci dati\n2) Visualizza\n0)Fine programma\nInserisci l'operazione da svoglere:");
        int op = in.nextInt();
        return op;
    }
}
