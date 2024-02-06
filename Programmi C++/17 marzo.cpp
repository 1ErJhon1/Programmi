#include<iostream>
using namespace std;
int menu();
float scelta_prezzi();
string inf(string &p2, string &p3, string &p4);
void fine(float num1,float num2,float num3,float num4,float num5,float num6,float num7,float num8,float num9,float num10);

int main(){
	int op,ma,mo,an;
	string t;
	cout<<"Benvenuto nell'officina Coluccelli"<<endl;
	t=inf(ma, mo, an)
	do{
		op=menu();
		switch(op){
			case 1:
				cout<<"cambio olio"<<endl;
				p1=scelta_prezzi();
				cout<<"filtro olio"<<endl;
				p2=scelta_prezzi();
				cout<<"filtro aria"<<endl;
				p3=scelta_prezzi();
				cout<<"filtro abitacolo"<<endl;
				p4=scelta_prezzi();
				cout<<"filtro gasolio"<<endl;
				p5=scelta_prezzi();
				break;
			case 2:
				cout<<"inserisci il prezzo di una ruota";
				cin>>pg;
				cout<<"inserisci quante gomme vuoi cambiare";
				cin>>ng;
				ptg=pg*ng;
			case 3:
				void fine(t,ma,mo,an,p1,p2,p3,p4,p5,ptg);
				}
		}while(op!=4);
}

int menu(){
	int num1;
	cout<<"scegli l'operazione da svolgere "<<endl<<endl<<"1-Registrazione tagliando"<<endl<<"2-Cambio gomme"<<endl<<"3-Stampa fattura"<<"4-Chiudi il programma"<<endl;
	cin>>num1;
	return num1;
}

float scelta_prezzi(){
	float num1,num2,num3;
	cout<<"inserisci il prezzo del componente"<<endl;
	cin>>num1;
	cout<<"inserisci il prezzo della manodopera"<<endl;
	cin>>num2;
	num3=num1+num3;
	return num3;
}

string inf(string &p2,string &p3,string &p4){
	string p1;
	cout<<"inserisci la targa della macchina";
	cin>>p1;
	cout<<"inserisci la marca";
	cin>>p2;
	cout<<"inserisci il modello";
	cin>>p3;
	cout<<"inserisci l'anno di immatricolazione";
	cin>>p4;
	return p1;
}

void fine(float num1,float num2,float num3,float num4,float num5,float num6,float num7,float num8,float num9,float num10){
	cout<<"TARGA	MARCA	MODELLO		ANNO IMM."<<endl;
	cout<<num1<<"	"<<num2<<"	"<<num3<<"	"<<num4<<endl;
	cout<<"Costo delle operazioni:"<<endl<<"cambio olio: "<<num5<<endl<<"cambio filtro olio: "<<num6<<endl<<"cambio filtro aria: "<<num7<<endl<<"cambio filtro abitacolo: "<<num8<<endl<<"cambio filtro gasolio: "<<num9<<endl<<"cambio gomme: "<<num10;
}
