/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Scanner;

/**
 *
 * @author 4A
 */
public class studente {
    protected String cognome;
    protected int numeroAssenze;
    protected int numeroVoti;
    protected int[] voti;
    public studente(String c,int nv){
        this.cognome=c;
        this.numeroVoti=nv;
        this.numeroAssenze=0;
        int[] voti=new int[30];
        for(int i=0;i<30;i++){
            voti[i]=0;
        }
    }
    public void setVoti(int v,int i){
        voti[i]=v;
    }
    public int InserisciA(){
        numeroAssenze++;
        return numeroAssenze;
    }
    public double media(){
        float s=0;
        for(int i=0;i<numeroVoti;i++){
            s+=voti[i];
        }
        return s/numeroVoti;
    }
    public String toString(){
        String s="----STUDENTE----\nCOGNOME:"+cognome+"NUMERO ASSENZE:";
        s=numeroAssenze+"MEDIA:"+media();
        return s;
    }
    public void CVoti(){
        Scanner in=new Scanner(System.in);
        boolean ver=false;
        for(int i=0;i<30;i++){
            if(voti[i]==0&&ver==false){
                voti[i]=in.nextInt();
                ver=true;
            }
        }
    }
    public int[] getVoti() {
        return voti;
    }
}
