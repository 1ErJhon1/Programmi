/*Definire una classe triangolo che preveda la possibilità di calcolare 
il perimetro di qualunque tipo di triangolo.
Definire poi un programma che, facendo uso della classe triangolo, 
istanzi un oggetto opportuno della classe e ne visualizzi il perimetro*/

#include<iostream>
using namespace std;

class Triangolo{
	//attributi
	private:		
		float l1, l2, l3;
		
	public:
		//costruttori per tipologia di triangolo
		Triangolo(float);
		Triangolo(float, float);
		Triangolo(float, float, float);
		
		//metodo x valore perimetro
		float Perimetro(){
			return l1+l2+l3;
		}
};

int main(){
	float a, b, c;
	
	cout<<"INSERIMENTO DATI TRIANGOLO"<<endl;
	
	do{cout<<"inserire base: ";
		cin>>a;
			if(a<=0){
				cerr<<"errore, inserire valore maggiore di 0"<<endl;
			}
	}while(a<=0);
	
	do{cout<<"inserire primo lato: ";
		cin>>b;
		if(b<=0){
				cerr<<"errore, inserire valore maggiore di 0"<<endl;
			}
	}while(b<=0);
	
	do{cout<<"inserire secondo lato: ";
		cin>>c;
		if(c<=0){
				cerr<<"errore, inserire valore maggiore di 0"<<endl;
			}
	}while(c<=0);
	
	cout<<"\n--------------------------------\n"<<endl;
	
	if(b==c){		//controllo lati uguali
		if(b==a){	//contrllo base uguale al lato
			Triangolo t(a);
			cout<<"Triangolo EQUILATERO"<<endl;
			cout<<"Perimetro: "<<t.Perimetro()<<endl;
		}
		else{
			Triangolo t(a, b);
			cout<<"Triangolo ISOSCELE"<<endl;
			cout<<"Perimetro: "<<t.Perimetro()<<endl;
		}
	}
	else{
		Triangolo t(a, b, c);
		cout<<"Triangolo SCALENO"<<endl;
		cout<<"Perimetro: "<<t.Perimetro()<<endl;
	}
}

//costruttore triangolo EQUILATERO
Triangolo::Triangolo(float a){
	this->l1=a;
	this->l2=a;
	this->l3=a;
}

//costruttore triangolo ISOSCELE
Triangolo::Triangolo(float a, float b){
	this->l1=a;
	this->l2=b;
	this->l3=b;
}

//costruttore triangolo SCALENO
Triangolo::Triangolo(float a, float b, float c){
	this->l1=a;
	this->l2=b;
	this->l3=c;
}
