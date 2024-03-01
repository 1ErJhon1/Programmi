/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giann
 */
public class Libro {
    String nome;
    String aut;
    String casaed;
    float prz;
    int nscaff;
    int disp;
    int quant;
    Biblioteca biblioteca;
    
    public void sconto(int sconto){
        float przs=prz*sconto/100;
        prz-=przs;
    }
    
    public void presta(){
        disp--;
    }
    
    public void restituisci(){
        disp++;
    }
    
    
}
