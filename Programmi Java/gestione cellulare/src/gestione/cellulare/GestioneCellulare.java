/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.cellulare;
import java.util.Scanner;
/**
 *
 * @author Jhon
 */
public class GestioneCellulare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        Scanner in=new Scanner(System.in);
        Vettore vcod=new Vettore();
        Vettore vprz=new Vettore();
        Vettore vore=new Vettore();
        System.out.println("quanti telefoni vuoi inserire?");
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Inserisci codice:");
            int cod=in.nextInt();
            vcod.inserisci(cod);

            System.out.println("Inserisci prezzo:");
            int prz=in.nextInt();
            vprz.inserisci(prz);

            System.out.println("Inserisci ore autonomia:");
            int ore=in.nextInt();
            vore.inserisci(ore);
        }
        do {
            System.out.println("\nScegli un'operazione:");
            System.out.println("1) aggiungi cellulare");
            System.out.println("2) stampa media dei prezzi");
            System.out.println("3) stampa media ore di autonomia");
            System.out.println("4) stampa posizione del cellulare di prezzo massimo");
            System.out.println("5) elimina cellulare");
            System.out.println("6) stampa tutti i cellulari");
            System.out.println("0) esci");
            op=in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("inserisci codice:");
                    int cod=in.nextInt();
                    vcod.inserisci(cod);
                    System.out.println("inserisci prezzo:");
                    int prz=in.nextInt();
                    vprz.inserisci(prz);
                    System.out.println("inserisci ore autonomia:");
                    int ore=in.nextInt();
                    vore.inserisci(ore);
                    break;
                
                case 2:
                    System.out.println("media prezzi:"+vprz.media());
                    break;

                case 3:
                    System.out.println("media ore autonomia"+vore.media());
                    break;
                
                case 4:
                    int pos=vprz.maxpos();
                    System.out.println("posizione prezzo massimo: "+pos);
                    break;
                case 5:
                    System.out.println("inserisci la posizione del cellulare da eliminare:");
                    pos=in.nextInt();
                    int nume=vprz.elimina(pos);
                    int nume2=vore.elimina(pos);
                    int nume3=vcod.elimina(pos);
                    System.out.println("Cellulare eliminato\nprezzo: "+nume);
                    System.out.println("ore: "+nume2+"\ncodice: "+nume3);
                    break;
                case 6:
                    for(int i=0;i<vcod.maxpos();i++){
                        System.out.println(vcod.maxpos()+"----Cellulari----\n--N."+vcod.maxpos()+"--\ncodice:"+vcod.getvett(i)+"\nprezzo:"+vprz.getvett(i)+"\nore di autonomia:"+vore.getvett(i));
                    }
            }
        }while(op!=0);
    }
}
