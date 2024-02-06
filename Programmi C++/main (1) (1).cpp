#include<iostream>
using namespace std;
float venditap();
float venditat();
float venditapitt();
float iva(float num1);
void incasso(float num1);

int main(){
	float pl,pn,inc;
	int op;
	cout<<"Azienda Edil2000";
	do{
	cout<<endl<<endl<<"Operazioni disponibili"<<endl<<"1-Vendere pavimento"<<endl<<"2-Vendere tegole"<<endl<<"3-Vendere pittura"<<endl<<"5-Stampa incasso"<<endl<<"4-Chudi programma"<<endl;
	cin>>op;
	switch(op){
   	case 1:
   		pl=venditap();
   		pn=iva(pl);
   		inc=pl+inc;
   		cout<<"Il prezzo lordo e' di: "<<pl<<" euro"<<endl<<"Il prezzo netto e' di: "<<pn<<" euro";
   		break;
   	case 2:
   		pl=venditat();
   		pn=iva(pl);
   		inc=pl+inc;
   		cout<<"Il prezzo lordo e' di: "<<pl<<" euro"<<endl<<"Il prezzo netto e' di: "<<pn<<" euro";
   		break;
   	case 3:
   		pl=venditapitt();
   		pn=iva(pl);
   		inc=pl+inc;
   		cout<<"Il prezzo lordo e' di: "<<pl<<" euro"<<endl<<"Il prezzo netto e' di: "<<pn<<" euro";
   		break;
   	case 5:
   		incasso(inc);
   }
}while(op!=4);
}



float venditap(){
	float num1,num2,num3;
    cout<<"Inserisci il prezzo del modello al mq: ";
    cin>>num1;
    cout<<"Inserisci i mq della stanza: ";
    cin>>num2;
    num3=num1*num2;
    return num3;
}


float venditat(){
	float num1,num2,num3;
    cout<<"Inserisci il prezzo del modello a tegola: ";
    cin>>num1;
    cout<<"Inserisci quante tegole vendere";
    cin>>num2;
    num3=num1*num2;
    return num3;
}


float venditapitt(){
    float num1,num2,num3;
    cout<<"Inserisci il prezzo del modello a kg: ";
    cin>>num1;
    cout<<"Inserisci quanti kg da vendere ";
    cin>>num2;
    num3=num1*num2;
    return num3;
}

float iva(float num1){
	float num2,num3;
    do{
        cout<<"inserisci l'aliquota dell'iva (10/22)";
        cin>>num3;
    }while(num3!=10&&num3!=22);
    num2=num1+(num1*num3)/100;
    return num2;
}

void incasso(float num1){
	cout<<"l'incasso totale e' di "<<num1<<" euro";
}
