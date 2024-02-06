package gestionecalcolatrice;
import java.util.Scanner;
/**
 *
 * @author Juan
 */
public class GestioneCalcolatrice {
    
    public static void main(String[] args) {
        Calcolatrice c=new Calcolatrice();
        int op, cont=0;
        do{
            op=c.menu();
            switch(op){
                case 1:
                    c.somm();
                    break;
                case 2:
                    c.sott();
                    break;
                case 3:
                    c.molt();
                    break;
                case 4:
                    cont=c.div();
                    break;
            }
            c.vis(cont);
        }while(op!=0);
    }
}