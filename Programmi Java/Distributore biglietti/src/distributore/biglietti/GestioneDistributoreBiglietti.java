/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package distributore.biglietti;
import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class GestioneDistributoreBiglietti {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int nb,op=99,codice,biglietti,stato;
        String nomeF;
        float costo;
        System.out.print("Inserisci il codice identificativo del distributore: ");
        codice=in.nextInt();
        System.out.print("Inserisci il nome della fermata: ");
        nomeF=in.nextLine();
        System.out.print("Inserisci il costo dei biglietti: ");
        costo=in.nextInt();
        System.out.print("Inserisci il numero dei biglietti: ");
        nb=in.nextInt();
        System.out.print("Inserisci lo stato del distributore: ");
        stato=in.nextInt();
        System.out.print("\n\n");
        DistributoreBiglietti d=new DistributoreBiglietti(codice,nomeF,costo,nb,stato);
        do{
                System.out.println("----DISTRIBUTORE BIGLIETTI----\n1) ricarica\n2) vendi\n3) cambia stato\n4) visualizza dettagli distributore\nInserisci operazione da svolgere: ");
                op=in.nextInt();
                switch (op) {
                    case 1:
                        System.out.print("Inserisci quanti biglietti ricaricare: ");
                        int num=in.nextInt();
                        d.ricarica(num);
                        System.out.println("Biglietti caricati\n");
                        break;
                    case 2:
                        if(d.get_stato()==1){
                            nb=d.get_nbiglietti();
                            System.out.print("Inserisci quanti biglietti acquistare: ");
                            num=in.nextInt();
                            float ct=d.vendi(num);
                            System.out.println("Il costo e' "+ct+" euro");
                        }else{
                            System.out.println("Biglietti esauriti contattare l'assistenza");
                        }
                        break;
                    case 3:
                        System.out.println("--GESTIONE STATO DISTRIBUTORE--\n");
                        d.ripara();
                        System.out.println("Lo stato della distribuzione e': ");
                        if(d.get_stato()==1){
                            System.out.println("In funzione\n");
                        }else{
                            System.out.println("In manutenzione\n");
                        }
                        break;
                    case 4:
                        d.vis();
                        break;
                }
        }while(op!=0);
    }
}