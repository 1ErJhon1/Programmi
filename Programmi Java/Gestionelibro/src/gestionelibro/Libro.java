/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionelibro;

import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class Libro {
    private String noml;
    private float prezzo;
    private int ns;
    private int np;
    private String ce;
    
    public Libro(){
        noml="";
        prezzo=0;
        ns=0;
        np=0;
        ce="";
    }
    
    public void ins(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci il nome del libro: ");
        noml=in.nextLine();
        System.out.println("Inserisci il prezzo: ");
        prezzo=in.nextInt();
        System.out.println("Inserisci il numero dello scaffale: ");
        ns=in.nextInt();
        System.out.println("Inserisci il numero di pagine: ");
        np=in.nextInt();
        System.out.println("Inserisci casa editrice: ");
        ce=in.nextLine();
    }
    
    public void vis(){
        System.out.println("-----LIBRO-----\n-nome del libro: "+noml+"\n-prezzo: "+prezzo+" euro\n-N. scaffale: "+ns+"\n-N. pagine: "+np+"\n-casa editrice: "+ce+"\n");
    }
    
    public void sconto(){
        float prezzos=prezzo*10/100;
        prezzo-=prezzos;
    }
    
    public int menu(){
        Scanner in=new Scanner(System.in);
        System.out.println("-----MENU-----\n1) Inserisci dati\n2) Visualizza\n3) Applica sconto 10%\n0)Fine programma\nInserisci l'operazione da svoglere:");
        int op = in.nextInt();
        return op;
    }
}


