
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class Regione {
    String nome;
    int abitanti;
    ArrayList<Provincia> prov=new ArrayList<>();

    public Regione(String nome, int abitanti) {
        this.nome = nome;
        this.abitanti = abitanti;
    }

    public String getNome() {
        return nome;
    }

    public int getAbitanti() {
        return abitanti;
    }

    public void addProv(Provincia provincia){
        prov.add(provincia);
    }
    
    
}
