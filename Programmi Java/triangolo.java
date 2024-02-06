import java.util.Scanner;
public class triangolo {
    private float l1,l2,l3;
    
    public triangolo(float a){
        this.l1=a;
        this.l2=a;
        this.l3=a;
    }

    public triangolo(float a,float b){
        this.l1=a;
        this.l2=b;
        this.l3=b;
    }

    public triangolo(float a,float b,float c){
        this.l1=a;
        this.l2=b;
        this.l3=c;
    }

    public float perimetro(){
        return l1+l2+l3;
    }


    public static void main(String[] args){
        Scanner in =new Scanner (System.in);
        float a,b,c;
        System.out.println("INSERIMENTO DATI Triangolo");

        do{
            System.out.println("inserire base: ");
            a=in.nextInt();
            if(a<=0){
                System.out.println("ERRORE: inserire valore maggiore di 0");
            }
        }while(a<=0);

        do{
            System.out.println("inserire primo lato: ");
            b=in.nextInt();
            if(b<=0){
                System.out.println("ERRORE: inserire valore maggiore di 0");
            }
        }while(b<=0);

        do{
            System.out.println("inserire secondo lato: ");
            c=in.nextInt();
            if(c<=0){
                System.out.println("ERRORE: inserire valore maggiore di 0");
            }
        }while(c<=0);

        System.out.println("\n--------------------------------\n");

        if(b==c){
            if(b==a){
                triangolo t =new triangolo(a);
                System.out.println("Triangolo EQUILATERO\nPerimetro: "+t.perimetro());
            }else{
                triangolo t =new triangolo(a,b);
                System.out.println("Triangolo ISOSCELE\nPerimetro: "+t.perimetro());
            }
        }else{
                triangolo t =new triangolo(a,b,c);
                System.out.println("Triangolo SCALENO\nPerimetro: "+t.perimetro());
        }
    }
}