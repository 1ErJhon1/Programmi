#include<iostream>
using namespace std;

struct przstanze{
	float economy;
	float standard;
	float suite;
};

struct famiglia{
	string c;
	int np;
	int ns;
	float prezzo;
};

struct stanza{
	bool libera;
};

void impostazioni(int &num1,przstanze a);
int menu();
void insfam(int nums,famiglia vett[],stanza vett2[],przstanze a,int &numf);
void elimfam(int numf,famiglia vett[],stanza vett2[]);
void visstanze(int nums,stanza vett[]);

int main(){
	int ns,nf,op;
	famiglia vett1[900];
	stanza vett2[900];
	przstanze var;
	impostazioni(ns,var);
	op=menu();
	do{
		switch(op){
			case 1:
				insfam(ns,vett1,vett2,var,nf);
				break;
			case 2:
				elimfam(nf,vett1,vett2);
				break;
			case 3:
				visstanze(ns,vett2);
				break;
		}
	}while(op!=0);
}

void impostazioni(int &num1,przstanze a){
	cout<<"--------IMPOSTAZIONI--------"<<endl;
	cout<<"quante stanze ci sono per ogni piano?: ";
	cin>>num1;
	num1=num1*5;
	cout<<"inserisci il prezzo a persona per la stanza economy: ";
	cin>>a.economy;
	cout<<"inserisci il prezzo a persona per la stanza standard: ";
	cin>>a.standard;
	cout<<"inserisci il prezzo a persona per la suite: ";
	cin>>a.suite;
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) impostazioni"<<endl<<"2) occupa stanza"<<endl<<"3) libera stanza"<<endl<<"4) prezzo medio frigoriferi"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}

void insfam(int nums,famiglia vett[],stanza vett2[],przstanze a,int &numf){
	int i,temp,num2;
	numf++;
	cout<<"Inserisci il Cognome della prenotazione e il numero di componenti della famiglia:"<<endl;
	cin>>vett[numf].c>>vett[numf].np;
	for(i=0;i<nums;i++){
		if(vett2[i].libera==true)
		num2=i;
	}
	cout<<"inserisci la tipologia della camera"<<endl<<"##\ttipologia\tprezzo totale"<<endl<<"1)\teconomy\t"<<a.economy*vett[numf].np<<endl<<"2)\tstandard\t"<<a.standard*vett[numf].np<<endl<<"3)\tsuite\t"<<a.suite*vett[numf].np;
	cin>>temp;
	switch(temp){
		case 1:
			vett[numf].prezzo=a.economy*vett[numf].np;
			break;
		case 2:
			vett[numf].prezzo=a.standard*vett[numf].np;
			break;
		case 3:
			vett[numf].prezzo=a.suite*vett[numf].np;
			break;
	}
	vett[numf].ns=num2;
	stanza[num2].libera=false;
	cout<<"la tua stanza e' la numero "<<vett[numf].ns<<endl<<"il prezzo totale da pagare e' di "<<vett[numf].prezzo;
}

void elimfam(int numf,famiglia vett[],stanza vett2[]){
	int i;
	string temp;
	cout<<"inserisci il cognome della famiglia da eliminare: ";
	cin>>temp;
	for(i=0;i<numf;i++){
		if(vett[i].c==temp){
			stanza[vett[i].ns].libera=true;
		}
	}
}

void visstanze(int nums,stanza vett[]){
	int i;
	for(i=0;i<nums;i++){
		cout<<i+1<<"\t";
		if(vett[i].libera==true){
			cout<<"LIBERA";
		}else{
			cout<<"OCCUPATA";
		}
		cout<<endl;
	}
}
