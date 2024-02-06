/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionecalciatore;

/**
 *
 * @author Jhon
 */
public class Gestionecalciatore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calciatore c=new Calciatore();
        int op;
        do{
            op=c.menu();
            switch(op){
                case 1:
                    c.ins();
                    break;
                case 2:
                    c.vis();
                    break;
            }
        }while(op!=0);
    }    
}