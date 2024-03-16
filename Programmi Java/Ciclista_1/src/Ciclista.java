
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class Ciclista {
    String nome;
    int numero;
    Date tempo;
    long diff;

    public Ciclista(String nome, Date tempo, int numero) {
        this.nome = nome;
        this.tempo = tempo;
        this.numero = numero;
    }
    
    public String getDiff(Date primo) {
        diff = tempo.getTime() - primo.getTime();
        long secondi = TimeUnit.MILLISECONDS.toSeconds(diff);
        long minuti = TimeUnit.MILLISECONDS.toMinutes(diff);
        long ore = TimeUnit.MILLISECONDS.toHours(diff);
        if(diff<0){
            return "00:00:00";
        }else
            return String.format("%02d:%02d:%02d", ore, minuti%60, secondi%60);
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
}
