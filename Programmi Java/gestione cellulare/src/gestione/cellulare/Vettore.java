/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestione.cellulare;

/**
 *
 * @author Jhon
 */
public class Vettore {
    int[] v;
    int n;
    public Vettore(){
        v=new int [100];
        this.n=0;
    }
    public void inserisci(int elm){
        v[n]=elm;
        n++;
    }
    public int maxpos() {
        int max=0;
        if (n > 0) {
            max = v[0];
            for (int i = 1; i < n; i++) {
                if (v[i] > max) {
                    max = v[i];
                }
            }
        }
        return max;
    }
    public float media(){
        float s=0,m=0;
        for(int i=0;i<maxpos();i++){
            s=v[i]+s;
        }
        m=s/maxpos();
        return m;
    }
    public int elimina(int pos) {
        if (pos >= 0 && pos < this.n) {
            int eliminato = this.v[pos];
            for (int i = pos; i < this.n - 1; i++) {
                this.v[i] = this.v[i + 1];
            }
            this.n--;
            return eliminato;
        } else {
            System.out.println("Posizione non valida.");
            return -1;
        }
    }
    public int getvett(int i){
        return v[i];
    }
}
