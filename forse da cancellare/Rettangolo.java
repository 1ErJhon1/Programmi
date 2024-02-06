import java.util.Scanner;
public class Rettangolo{
	private double base;
	private double altezza;
	private double perimetro;
	private double area;
	
	//metodi
	public Rettangolo(){
		   base=0;
		   altezza=0;
	}
    
	public Rettangolo(double x1, double x2){
		   base=x1;
		   altezza=x2;
	}
    	
		
	public void setBase(double x){
		
	   base=x;
	}
	
	public void setAltezza(double x){
		
	   altezza=x;
	}
	
	public void calcolaPerimetro(){
		
	   perimetro=2*(base+altezza);
	}
	
	public void calcolaArea(){
		
	   area=base*altezza;
	}
	
	public double getPerimetro()
	{
		return perimetro;
	}
		
	public double getArea(){
		return area;
	}	
		
	


public static void main (String[] args) throws Exception {
	
	Scanner in =new Scanner (System.in);
	double numero;
	
	Rettangolo tavolo =new Rettangolo();
	
	System.out.print("Inserisci la base del tavolo: ");
	numero=in.nextDouble();
	tavolo.setBase(numero);
	
	System.out.print("Inserisci l'altezza del tavolo: ");
	numero=in.nextDouble();
	tavolo.setAltezza(numero);
	tavolo.calcolaPerimetro();
	tavolo.calcolaArea();
	System.out.println("Il perimetro del tavolo: "+tavolo.getPerimetro());
	System.out.println("L'area del tavolo: "+tavolo.getArea());
	
}	
	
}	