#include<string>
#include<iostream>
#include<fstream>
using namespace std;

string nome,cognome,ntel;

void carica();
void stampa();

int main(){
	carica();
	stampa();
}

void carica(){
	fstream file1;
	char risp;
	file1.open("Agenda.txt",ios::out);
	do{
		cout<<"Inserisci il nome"<<endl;
		cin>>nome;
		cout<<"Inserisci il cognome"<<endl;
		cin>>cognome;
		cout<<"Inserisci numero di telefono"<<endl;
		cin>>ntel;
		file1<<nome<<" "<<cognome<<" "<<ntel<<endl;
		cout<<"Altri dati?\n";
		cin>>risp;
	}while(risp=='s');
	file1.close();
}

void stampa(){
	fstream file1;
	file1.open("Agenda.txt",ios::in);
	while(!file1.eof()){
		cout<<"nome= "<<nome<<" cognome= "<<cognome<<" tel= "<<ntel<<endl;
		file1>>nome>>cognome>>ntel;
	}
	file1.close();
}
