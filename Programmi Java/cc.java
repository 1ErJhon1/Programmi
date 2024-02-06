import java.util.Scanner;
public class cc{
    private String correntista;
    private String nc;
    private float saldo;

    public cc(String correntista, String nc){
        this.correntista=correntista;
        this.nc=nc;
        this.saldo=0;
    }

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

    public void Visualizza(){
        System.out.println("Nome del Correntista: "+get_correntista());
        System.out.println("Numero del Conto: "+get_nc());
        System.out.println("Saldo del Conto: "+get_saldo()+" euro\n");
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
        cc c =new cc(correntista, nc);
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
                case 3:
                    c.Visualizza();
            }
        }while(op!=0);
    }
}