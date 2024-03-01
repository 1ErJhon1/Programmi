
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class Biblioteca {
    String nome;
    String citta;
    String indirizzo;
    ArrayList<Libro> libri=new ArrayList<>();

    public Biblioteca(String nome, String citta, String indirizzo) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;
    }
    
    public void addlib(Libro libro){
        libri.add(libro);
    }
    
    public void removelib(Libro libro){
        libri.remove(libro);
    }
}
