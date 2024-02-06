#include<iostream>
#include<fstream>
using namespace std;

struct prodotto{
	int codice;
	string descrizione;
	float prezzo;
};

int menu();
void carica(fstream &file1,int &d);
void cerca(fstream &file1,int d);
void prezzomin(fstream &file1,int d);

int main(){
	fstream file;
	int nprod,op;
	prodotto p;
	file.open("prodotti.txt",ios::in);
	file>>p.codice>>p.descrizione>>p.prezzo;
	while(!file.eof()){
		nprod++;
		file>>p.codice>>p.descrizione>>p.prezzo;
	}
	do{
		op=menu();
		switch(op){
			case 1:
				cerca(file,nprod);
				break;
			case 2:
				prezzomin(file,nprod);
				break;
			case 3:
				carica(file,nprod);
				break;
		}
	}while(op!=0);
	file.close();
}

void carica(fstream &file1,int &d){
	char risp;
	prodotto p;
	file1.open("prodotti.txt",ios::app);
	do{
		cout<<endl<<"Inserisci il codice: "<<endl;
		cin>>p.codice;
		cout<<"Inserisci descrizione: "<<endl;
		cin>>p.descrizione;
		cout<<"Inserisci prezzo: "<<endl;
		cin>>p.prezzo;
		file1<<p.codice<<endl<<p.descrizione<<endl<<p.prezzo<<endl;
		cout<<"Altri dati?\n";
		cin>>risp;
		d++;
	}while(risp=='s');
	file1.close();
}

void cerca(fstream &file1,int d){
	int i,cod;
	bool verifica=false;
	prodotto p;
	file1.open("prodotti.txt",ios::in);
	cout<<"inserisci il codice da cercare"<<endl;
	cin>>cod;
	cout<<"CODICE: "<<cod<<endl;
	for(i=0;(i<d)&&(verifica==false);i++){
		file1>>p.codice>>p.descrizione>>p.prezzo;
		if(cod==p.codice){
			cout<<"DESCRIZIONE: "<<p.descrizione<<endl;
			cout<<"PREZZO: "<<p.prezzo<<endl<<endl;
			verifica=true;
		}
	}
	if(verifica==false){
		cout<<"ERRORE IMPOSSIBILE TROVARE CODICE"<<endl;
	}
	file1.close();
}

void prezzomin(fstream &file1,int d){
	int i,codicemin;
	string descrizionemin;
	float prezzomin;
	prodotto p;
	file1.open("prodotti.txt",ios::in);
	file1>>codicemin>>descrizionemin>>prezzomin;
	for(i=0;i<d;i++){
		file1>>p.codice>>p.descrizione>>p.prezzo;
		if(p.prezzo<prezzomin){
			codicemin=p.codice;
			descrizionemin=p.descrizione;
			prezzomin=p.prezzo;
		}
	}
	cout<<"prodotto con il prezzo minimo:"<<endl;
	cout<<"CODICE: "<<codicemin<<endl;
	cout<<"DESCRIZIONE: "<<descrizionemin<<endl;
	cout<<"PREZZO: "<<prezzomin;
	file1.close();
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) cerca codice"<<endl<<"2) visualizza nome del prodotto che ha prezzo minore"<<endl<<"3) aggiungi nuovi prodotti"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
