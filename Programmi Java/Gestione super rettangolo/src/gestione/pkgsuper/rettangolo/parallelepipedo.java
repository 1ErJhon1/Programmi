/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestione.pkgsuper.rettangolo;

import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class parallelepipedo {
    
    private int vmq1;
    private int vmq2;
    private float ppar;
    
    public int get_vmq1(){
        return vmq1;
    }
    public int get_vmq2(){
        return vmq2;
    }
    public void ins(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci il prezzo della vernice al mq");
        vmq1=in.nextInt();
        System.out.println("Inserisci il prezzo dell'altra vernice al mq");
        vmq2=in.nextInt();
    }    
    
    public void vernice(int pmq,int pmq2){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci la superficie in mq del parallelepipedo da verniciare: ");
        int mq=in.nextInt();
        ppar=pmq*mq;
        System.out.println("Inserisci dell'altra superficie in mq del parallelepipedo da verniciare: ");
        int mq2=in.nextInt();
        ppar=ppar+pmq2*mq2;
    }
    
    public void vis(){
        System.out.print("----PARALLELEPIPEDO----\nPrezzo tot="+ppar+"\n\n");
    }
}
