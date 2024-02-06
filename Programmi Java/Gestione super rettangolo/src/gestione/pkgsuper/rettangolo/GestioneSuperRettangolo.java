/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.pkgsuper.rettangolo;
import java.util.Scanner;
/**
 *
 * @author Jhon
 */
public class GestioneSuperRettangolo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op;
        rettangolo r=new rettangolo();
        parallelepipedo p=new parallelepipedo();
        Scanner in=new Scanner(System.in);
        do{
            op=r.menu();
            switch(op){
                case 1:
                    r.ins();
                    r.vernice(r.get_vmq());
                    r.vis();
                    break;
                case 2:
                    p.ins();
                    p.vernice(p.get_vmq1(), p.get_vmq2());
                    p.vis();
                    break;
            }
        }while(op!=0);
    }
    
}
