/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alloggio.villa;

/**
 *
 * @author Jhon
 */
public class alloggio {
    protected int codice;
    protected int numPersone;
    protected double metriQuadri;
    
    public alloggio(int codice,int numPersone,double metriQuadri){
        this.codice=codice;
        this.numPersone=numPersone;
        this.metriQuadri=metriQuadri;
    }
    public int getCodice(){
        return codice;
    }
    public int getNumPersone(){
        return numPersone;
    }
    public double getMetriQuadri(){
        return metriQuadri;
    }
    public double costoAcqua(double v){
        return v*numPersone;
    }
    public double valore(double v){
        return v*metriQuadri;
    }
    public double densita(){
        return numPersone/metriQuadri;
    }
}
