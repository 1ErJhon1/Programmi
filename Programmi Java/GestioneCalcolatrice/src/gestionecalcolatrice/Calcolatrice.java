/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionecalcolatrice;

import java.util.Scanner;

/**
 *
 * @author 4A
 */
public class Calcolatrice {
    private float num1,num2,ris;
    
    public void somm(){
        this.ris=num1+num2;
    }
    
    public void sott(){
        this.ris=num1-num2;
    }
    
    public void molt(){
        this.ris=num1*num2;
    }
    
    public int div(){
        int contr=1;
        if(num2==0){
            contr=0;
        }else{
            this.ris=num1/num2;
            contr=1;
        }
        return contr;
    }
    
    public int menu(){
        Scanner in=new Scanner(System.in);
        System.out.println("-----CALCOLATRICE-----\nInserisci il primo numero: ");
        float num=in.nextFloat();
        get_num1(num);
        System.out.println("Inserisci il secondo numero: ");
        num=in.nextFloat();
        get_num2(num);
        System.out.println("1) addizione\n2) sottrazione\n3)moltiplicazione\n4)divisione\n0)fine programma\nInserisci l'operazione da svoglere:");
        int op = in.nextInt();
        return op;
    }
    
    public void get_num1(float num1){
        this.num1=num1;
    }
    
    public void get_num2(float num2){
        this.num2=num2;
    }
    
    public void vis(int cont){
        if(cont==0){
            System.out.println("ERRORE: impossibile dividere per 0\n");
        }else{
            System.out.println("Il risultato e' "+ris+"\n");
        }
    }
}