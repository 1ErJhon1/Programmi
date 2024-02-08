import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    public void set_saldo(float saldo){
        this.saldo=saldo;
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
    
    public String orario(){
        LocalDateTime data=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String dataform=data.format(dtf);
        return dataform;
    }
}