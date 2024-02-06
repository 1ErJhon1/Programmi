/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestione.temperature;

import java.util.Scanner;

/**
 *
 * @author 4A
 */
public class g1 {
    private int num;
    private double tmax;
    private double tmin;

    public g1(int num,double tmax,double tmin) {
        num = 0;
        tmax = 100;
        tmin = -100;
    }

    public int getNum() {
        return num;
    }

    public double getTmax() {
        return tmax;
    }

    public double getTmin() {
        return tmin;
    }

    public double scostamento() {
        return tmax - tmin;
    }

    public double mediaG() {
        return (tmax + tmin) / 2;
    }

    public String stampaMaggiore(double t) {
        double tmed = mediaG();
        if (tmed > t) {
            return "La temperatura media registrata (" + tmed + ") è maggiore della temperatura data (" + t + ")";
        } else if (tmed < t) {
            return "La temperatura media registrata (" + tmed + ") è minore della temperatura data (" + t + ")";
        } else {
            return "La temperatura media registrata (" + tmed + ") è uguale alla temperatura data (" + t + ")";
        }
    }

    public String toString() {
        return "Giorno " + num + ": Temperatura massima " + tmax + ", Temperatura minima " + tmin;
    }
}
