import java.util.Scanner;
public class cc{
    private String correntista;
    private String nc;
    private float saldo;

    public String get_correntista(){
        return correntista;
    }

    public String get_nc(){
        return nc;
    }

    public float get_saldo(){
        return saldo;
    }

    public int prelievo(float s){
        int eseguito=0;
        if(saldo>=s){
            saldo-=s;
        }else{
            eseguito=1;
        }
        return eseguito;
    }

    public void versamento(float s){
        saldo+=s;
    }

    public int menu(){
        int op;
        Scanner in =new Scanner (System.in);
        System.out.println("--------Conto Corrente--------\n1) Prelievo\n2) Versamento\n3) Visualizza tutte le informazioni\n0) Esci dal programma\nInserisci operazione da svolgere:");
        op=in.nextInt();
        return op;
    }
    
    public static void main(String[] args) {
        Scanner in =new Scanner (System.in);
        int op;
        String correntista, nc;
        System.out.print("Inserisci nome contista: ");
        correntista=in.nextLine();
        System.out.print("Inserisci numero del conto: ");
        nc=in.nextLine();
        do{
            op=c.menu();
            switch (op) {
                case 1:
                    System.out.println("Inserisci la quantita' di denaro da prelevare: ");
                    float s=in.nextFloat();
                    int contr=c.prelievo(s);
                    if(contr==1){
                        System.out.println("Non hai abbastanza soldi");
                    }else{
                        System.out.println("Prelievo eseguito");
                    }
                    break;
                
                case 2:
                    System.out.print("Inserisci la quantita' di denaro da versare: ");
                    s=in.nextFloat();
                    c.versamento(s);
                    break;
            }
        }while(op!=0);
    }

    void versamento(float saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void versamento(float saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}