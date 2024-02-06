/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alloggio.villa;
import java.util.Scanner;
/**
 *
 * @author Jhon
 */
public class GestioneAlloggioVilla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int op,codice,numPersone;
        double metriQuadri,giardino;
        final double costoAcqua=15.5;
        final double v1=2000;
        final double v2=700;
        
        do{
            System.out.println("1) gestione alloggio\n2) gestione villa\n0) esci\nInserisci l'operazione da svolgere:");
            op=in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Inserisci codice, numero di persone e metri quadri dell'alloggio:");
                    codice=in.nextInt();
                    numPersone=in.nextInt();
                    metriQuadri=in.nextDouble();
                    alloggio a=new alloggio(codice, numPersone, metriQuadri);
                    System.out.println("----DATI ALLOGGIO----\nCODICE:"+a.getCodice()+"\nNUMERO PERSONE:"+a.getNumPersone()+"\nCOSTO TOTALE ACQUA:"+a.costoAcqua(costoAcqua)+" euro\nVALORE DELL'ALLOGGIO:"+a.valore(v1)+" euro\nDENSITA':"+a.densita());
                    break;
                    
                    case 2:
                    System.out.println("Inserisci codice, numero di persone, metri quadri dell'alloggio e metri quadri del giardino:");
                    codice=in.nextInt();
                    numPersone=in.nextInt();
                    metriQuadri=in.nextDouble();
                    giardino=in.nextDouble();
                    villa v=new villa(codice, numPersone, metriQuadri, giardino);
                    System.out.println("----DATI ALLOGGIO----\nCODICE:"+v.getCodice()+"\nNUMERO PERSONE:"+v.getNumPersone()+"\nCOSTO TOTALE ACQUA:"+v.costoAcqua(costoAcqua)+" euro\nVALORE DELL'ALLOGGIO TOTALE:"+v.valore(v1,v2)+" euro\nVALORE GIARDINO:"+v.getGiardino()+"\nDENSITA':"+v.densita());
                    break;
            }
        }while(op!=0);
    }
    
}
