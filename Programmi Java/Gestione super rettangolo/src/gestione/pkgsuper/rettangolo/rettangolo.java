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
    public class rettangolo {
        
    private int vmq;
    private float prett;
        
    public void vernice(int pmq){
        Scanner in=new Scanner(System.in);
        System.out.print("Inserisci la superficie in mq del rettangolo da verniciare: ");
        int mq=in.nextInt();
        prett=pmq*mq;
    }
    
    public void ins(){
        Scanner in=new Scanner(System.in);
        System.out.println("Inserisci il prezzo della vernice al mq");
        vmq=in.nextInt();
    }
    
    public int get_vmq(){
        return vmq;
    }
    
    public int menu(){
        Scanner in=new Scanner(System.in);
        System.out.println("-----MENU-----\n1) Calcola costo superficie rettangolo\n2) Calcola costo superficie parallelepipedo\n0) Esci dal programma:");
        int op = in.nextInt();
        return op;
    }
    
        public void vis(){
        System.out.print("----RETTANGOLO----\nPrezzo tot="+prett+"\n\n");
    }
}
