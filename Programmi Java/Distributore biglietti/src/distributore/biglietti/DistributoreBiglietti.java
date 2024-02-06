/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distributore.biglietti;

import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class DistributoreBiglietti {
    
    private int codice;
    private String nomeF;
    private int nBiglietti;
    private int stato;
    private float costo;

    public DistributoreBiglietti(int codice,String nomeF,float costo,int nb,int stato){
        this.codice=codice;
        this.nomeF=nomeF;
        this.nBiglietti=nb;
        this.stato=stato;
        this.costo=costo;
    };

    public void ricarica(float num){
        nBiglietti+=num;
        stato=1;
    }

    public float vendi(int num){
        float prz=0;
        if(num<=nBiglietti){
            nBiglietti-=num;
            prz=num*costo;
            if(nBiglietti==0){
                stato=0;
            }
        }else{
            stato=0;
            prz=nBiglietti*costo;
            System.out.println("Stai acquistando solamente "+nBiglietti);
            nBiglietti=0;
        }
        return prz;
    }

    public int get_nbiglietti(){
        return nBiglietti;
    }

    public void ripara(){
        stato=0;
    }

    public int get_stato(){
        return stato;
    }

    public void vis(){
        System.out.print("----DETTAGLI DISTRIBUTORE----\nCODICE: "+codice+"\nNOME FERMATA: "+nomeF+"\nNUMERO BIGLIETTI: "+nBiglietti+"\nSTATO:");
        if (stato==0) {
            System.out.print("IN MANUTENZIONE\n");
        }else{
            System.out.print("FUNZIONANTE\n");
        }
    }
}
