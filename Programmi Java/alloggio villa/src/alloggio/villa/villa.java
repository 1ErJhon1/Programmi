/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alloggio.villa;

/**
 *
 * @author Jhon
 */
class villa extends alloggio{
    private double giardino;

    public villa(int codice,int numPersone,double metriQuadri,double giardino){
        super(codice, numPersone, metriQuadri);
        this.codice=codice;
        this.numPersone=numPersone;
        this.metriQuadri=metriQuadri;
        this.giardino=giardino;
    }
    public double getGiardino(){
        return giardino;
    }
    public double valore(double v1,double v2){
        return metriQuadri*v1+giardino*v2;
    }
    public double densita(){
    return numPersone/(metriQuadri+giardino);
    }
}
