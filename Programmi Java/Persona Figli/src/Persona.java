/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class Persona {
    String nome;
    String sesso;
    double redditoLordo;
    int aliquotaPagata;
    
    public Persona(String nome,String sesso,double redditoLordo,int aliquotaPagata){
        this.nome=nome;
        this.sesso=sesso;
        this.redditoLordo=redditoLordo;
        this.aliquotaPagata=aliquotaPagata;
    }
    
    public double redditoNetto(){
        return redditoLordo-aliquotaPagata;
    }
    
    public String toString(){
        double redd=redditoNetto();
        String s="NOME:"+nome+"\nSESSO:"+sesso+"\nREDDITO LORDO:"+redd+"\n";
        return s;
    }
    
    public String get_nome(){
        return nome;
    }
}
