/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestione.temperature;

import java.util.Scanner;

/**
 *
 * @author 4A
 */
public class GestioneTemperature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci il numero del giorno:");
        int num = in.nextInt();

        System.out.println("Inserisci la temperatura massima registrata:");
        double tmax = in.nextDouble();

        System.out.println("Inserisci la temperatura minima registrata:");
        double tmin = in.nextDouble();

        g1 giorno = new g1(num, tmax, tmin);
        System.out.println(giorno);
        
        System.out.println("Scostamento termico: " + giorno.scostamento());
        System.out.println("Temperatura media: " + giorno.mediaG());

        System.out.println("Inserisci una temperatura da confrontare:");
        double temperaturaConfronto = in.nextDouble();
        System.out.println(giorno.stampaMaggiore(temperaturaConfronto));
    }
}
