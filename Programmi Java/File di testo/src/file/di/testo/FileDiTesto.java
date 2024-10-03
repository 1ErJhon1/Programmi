/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package file.di.testo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jhon
 */
public class FileDiTesto {

    /**
     * @param args the command line arguments
     */
    
    private int contaParole(String testo) {
        if (testo == null || testo.isEmpty()) {
            return 0;
        }
        String[] parole=testo.split("\\s+");
        return parole.length;
    }
    
    public static void main(String[] args) throws IOException {
        FileDiTesto fileDiTesto=new FileDiTesto();
        FileWriter writer=new FileWriter("prova.txt");
        System.out.println("cosa vuoi scrivere nel file?");
        Scanner in=new Scanner(System.in);
        String stringa=in.nextLine();
        writer.write(stringa);
        writer.close();
        int np=fileDiTesto.contaParole(stringa);
        System.out.println("Il numero di parole nel testo sono: "+np);
    }
    
}
