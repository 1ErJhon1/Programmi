#include<iostream>
using namespace std;

struct prod{
	string cod;
	string des;
	string cat;
	float prz;
};

int carvett(prod vett[],int num);
void cercael(prod vett[],int num);
void przmax(prod vett[],int num);
void przmedf(prod vett[],int num);
int menu();

int main(){
	prod v1[100];
	int ne,op;
	ne=0;
	do{
		op=menu();
		switch(op){
			case 1:
				ne=carvett(v1,ne);
				break;
			case 2:
				cercael(v1,ne);
				break;
			case 3:
				przmax(v1,ne);
				break;
			case 4:
				przmedf(v1,ne);
		}
	}while(op!=0);
}

int carvett(prod vett[],int num){
	cout<<"inserisci il codice dell'elettrodomestico: ";
	cin>>vett[num].cod;
	cout<<"inserisci la descrizione dell'elettrodomestico: ";
	cin>>vett[num].des;
	cout<<"inserisci la categoria dell'elettrodomestico: ";
	cin>>vett[num].cat;
	cout<<"inserisci il prezzo dell'elettrodomestico: ";
	cin>>vett[num].prz;
	num++;
	return num;
}

void cercael(prod vett[],int num){
    int i;
    string cercac;
    cout<<"Inserisci il codice dell'elettrodomestico da cercare: ";
    cin>>cercac;
    for(i=0;i<num;i++){
        if((cercac==vett[i].cod)){
            cout<<"CODICE: "<<vett[i].cod<<endl<<"DESCRIZIONE: "<<vett[i].des<<endl<<"CATEGORIA: "<<vett[i].cat<<endl<<"PREZZO: "<<vett[i].prz<<endl<<endl<<endl;;
        }
    }
}

void przmax(prod vett[],int num){
	string cerca;
	int i,pos;
	float przmax;
	przmax=0;
	cout<<"inserisci la categoria da cercare: ";
	cin>>cerca;
	for(i=0;i<num;i++){
		if((vett[i].cat==cerca)&&(vett[i].prz>przmax)){
			pos=i;
			}
		}
		cout<<"-----RISULTATO-----"<<endl<<"CODICE: "<<vett[pos].cod<<endl<<"DESCRIZIONE: "<<vett[pos].des<<endl<<"CATEGORIA: "<<vett[pos].cat<<endl<<"PREZZO: "<<vett[pos].prz<<endl<<endl<<endl;
	}

void przmedf(prod vett[],int num){
	int i,nf;
	float s,m;
	s=0;
	m=0;
	nf=0;
	for(i=0;i<num;i++){
		if(vett[i].cat=="frigorifero"){
			nf++;
			s=s+vett[i].prz;
		}
		m=s/nf;
	}
	cout<<"il prezzo medio dei frigoriferi e' di euro "<<m<<endl<<endl<<endl;
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica elettrodomestici"<<endl<<"2) cerca elettrodomestico"<<endl<<"3) elettrodomestico prezzo massimo in una categoria"<<endl<<"4) prezzo medio frigoriferi"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}