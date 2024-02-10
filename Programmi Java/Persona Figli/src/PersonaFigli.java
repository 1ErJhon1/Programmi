/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class PersonaFigli extends Persona {

    int nfigli;
    int[] etaFigli=new int[10];

    public PersonaFigli(int nfigli, String nome, String sesso, double redditoLordo, int aliquotaPagata) {
        super(nome, sesso, redditoLordo, aliquotaPagata);
        this.nfigli = nfigli;
    }
    
    public void inserisciFiglio(int eta){
        etaFigli[nfigli]=eta;
        nfigli++;
    }
    
    public double mediaEta(){
        int s=0;
        for(int i=0;i<10;i++){
            s+=etaFigli[i];
        }
        double media=s/nfigli-1;
        return media;
    }
    
    public int nMaggiorenni(){
        int n=0;
        for(int i=0;i<10;i++){
            if(etaFigli[i]>18)
                n++;
        }
        return n;
    }

    public String toString(){
        double media=mediaEta();
        int f18=nMaggiorenni();
        String s="NUMERO FIGLI:"+(nfigli-1)+"\nMEDIA ETA' FIGLI:"+media+"\nNUMERO FIGLI MAGGIORENNI:"+f18;
        return s;
    }
}