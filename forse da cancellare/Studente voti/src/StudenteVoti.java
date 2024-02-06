/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author 4A
 */
public class StudenteVoti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int op=99;
        boolean ver=false;
        System.out.println("Inserisci cognome alunno:");
        String c=in.nextLine();
        System.out.println("Quanti voti vuoi inserire?:");
        int nv=in.nextInt();
        studente s=new studente(c,nv);
        for(int i=0;i<nv;i++){
            System.out.println("Inserisci voto");
            int v=in.nextInt();
            s.setVoti(v, i);
        }
        do{
            System.out.println("1) stampa media voti\n2) inserisci voto\n3) inserisci assenza\n4) eta'\n0)esci\nInserisci operazione da svolgere:");
            op=in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("La media dei voti e':"+s.media()+"\n");
                    break;                
                case 2:
                    System.out.println("Inserisci il voto:");
                    s.CVoti();
                    System.out.println("\n");
                    break;
                case 3:
                    s.InserisciA();
                    System.out.println("Assenza inserita\n");
                    break;
                case 4:
                    Studented sd=new Studented(c, nv);
                    System.out.println("Inserisci l'anno dello studente:");
                    int anno=in.nextInt();
                    System.out.println("L'eta' dello studente e': "+sd.eta(anno)+"anni\n");
            }
        }while(op!=0);
    }
    
}