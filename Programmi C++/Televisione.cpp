#include<iostream>
using namespace std;

class Televisione{
	bool stato;
	int volume;
	int canale;
	bool silenzioso;
	public:
		Televisione(){
			stato=false;
			volume=0;
			canale=0;
			silenzioso=false;
		}
		void visualizza();
		void accendi(){
			stato=true;
		}
		void spegni(){
			stato=false;
		}
		void set_volume(){
			int valore;
			do{
				cout<<"inserisci il volume(da 0 a 10): ";
				cin>>valore;
			}while((valore<0)&&(valore>10));
			volume=valore;
			cout<<endl<<endl;
		}
		void set_canale(){
			int valore;
			do{
				cout<<"inserisci il canale(da 0 a 99): ";
				cin>>valore;
			}while((valore<0)&&(valore>99));
			canale=valore;
			cout<<endl<<endl;
		}
		void attivas(){
			silenzioso=true;
		}
		void disattivas(){
			silenzioso=false;
		}
		
};

void Televisione::visualizza()
{
	cout<<"-----TELEVISIONE STATI-----"<<endl;
	cout<<"stato: ";
	if(stato==true){
		cout<<"accesa"<<endl;
	}else{
		cout<<"spenta"<<endl;
	}
	cout<<"volume: "<<volume<<endl;
	cout<<"canale: "<<canale<<endl;
	cout<<"silenzioso:";
	if(silenzioso==true){
		cout<<"attivato"<<endl<<endl;
	}else{
		cout<<"disattivato"<<endl<<endl;
	}
}

int menu(){
	int num;
	cout<<"1) accendi televisione"<<endl;
	cout<<"2) cambia canale"<<endl;
	cout<<"3) cambia volume"<<endl;
	cout<<"4) attiva silenzioso"<<endl;
	cout<<"5) disattiva silenzioso"<<endl;
	cout<<"6) spegni televisione"<<endl;
	cout<<"0) fine programma"<<endl;
	cout<<"Inserisci operazione: ";
	cin>>num;
	cout<<endl<<endl;
	return num;
}

int main(){
	Televisione t1;
	int op;
	t1.visualizza();
	do{
		op=menu();
		switch(op){
			case 1:
				t1.accendi();
				t1.visualizza();
				break;
			case 2:
				t1.set_canale();
				t1.visualizza();
				break;
			case 3:
				t1.set_volume();
				t1.visualizza();
				break;
			case 4:
				t1.attivas();
				t1.visualizza();
				break;
			case 5:
				t1.disattivas();
				t1.visualizza();
				break;
			case 6:
				t1.spegni();
				t1.visualizza();
				break;
		}
	}while(op!=0);
}
