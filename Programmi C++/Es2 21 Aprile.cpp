#include<iostream>
using namespace std;

void saldo(){
	int num1;
	cout<<"inserisci il saldo disponibile"<<endl;
	cin>>num1;
}

float prod(){
	int num1;
	float num2;
	cout<<"inserisci il numero dei prodotti: ";
	cin>>num1;
	cout<<"inserisci il prezzo al prodotto: ";
	cin>>num2;
	num2=num2*num1;
	return num2;
}

float paga(){
	string string1;
	int num1,num2;
	cout<<"inserisci la qualifica del lavoratore: ";
	cin>>string1;
	cout<<"inserisci le ore di lavoro: ";
	cin>>num1;
	cout<<"inserisci il prezzo all'ora: ";
	cin>>num2;
	num2=num2*num1;
	cout<<"lo stipendio e' di "<<num2<<" euro";
}

float visld(float num1){
	cout<<"il tuo saldo disponibile e' di: "<<num1<<" euro";
}

float ammo(float num1){
	cout<<"il totale ammonta a: "<<num1<<" euro";
}

float tasse(float num1, float num2){
	num1=num2-num1;
	if(num1>num2){
		num2=num1/25*100;
		num1=num1-num2;
	}else{
		cout<<"non devi pagare tasse";
	}
	return num1;
}

int main(){
	int op;
	float pa,s,pta,pv,ptv,pso,si;
	saldo();
	si=s;
	do{
	cout<<endl<<endl<<"scegli l'operazione da svolgere"<<endl<<"1-acquistare una certa quantita' di prodotto"<<endl<<"2-vendere una certa quantita' di prodotto"<<endl<<"3-pagare lo stipedio di un operaio"<<endl<<"4-visualizza il saldo disponibile"<<endl<<"5-visualizza l'ammontare delle vendite"<<endl<<"6-visualizza l'ammontare degli acquisti"<<endl<<"7-pagare le tasse"<<endl<<"0-chiudi programma"<<endl<<endl;
	cin>>op;
	switch(op){
		case 1:
			pa=prod();
			s=s-pa;
			pta=pa+pta;
			break;
		case 2:
			pv=prod();
			s=s+pv;
			ptv=pv+ptv;
			break;
		case 3:
			pso=paga();
			s=s-pso;
			break;
		case 4:
			visld(s);
			break;
		case 5:
			ammo(ptv);
			break;
		case 6:
			ammo(pta);
			break;
		case 7:
			tasse(si,s);
			break;
			}
	}while(op!=0);
}

