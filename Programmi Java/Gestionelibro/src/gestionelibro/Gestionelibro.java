/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionelibro;

/**
 *
 * @author Jhon
 */
public class Gestionelibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro l =new Libro();
        int op;
        do{
            op=l.menu();
            switch(op){
                case 1:
                    l.ins();
                    break;
                case 2:
                    l.vis();
                    break;
                case 3:
                    l.sconto();
                    break;
            }
        }while(op!=0);
    }
    
}
