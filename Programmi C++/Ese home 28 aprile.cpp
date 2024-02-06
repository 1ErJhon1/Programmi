#include<iostream>
using namespace std;

int numvett(){
	int conta;
	cout<<"quanti alunni sono? (max 50): ";
	cin>>conta;
	return conta;
}

string caricarevett(int conta,string &vett2[]){
	string vett[],vett2[];
	cout<<"inserisci il cognome dell'alunno numero "<<conta;
	cin>>vett2[conta];
	cout<<"inserisci il nome dell'alunno numero "<<conta;
	cin>>vett[conta]
	return vett[]
	}
	
void cerca(string &vett[],string &vett2[],int numf){
	string vett[],vett2[];
	int scerca,num
	cout<<"inserisci il cognome dell'alunno da cercare: ";
	cin>>ccerca;
	for(conta=0;conta<numf;conta++){
		if(vett2[conta]==scerca){
			num=conta
		cout<<"il nome dell'alunno e' "<<vett[conta]
		}
	}
}
	
int main(){
	string nome[50],cognome[50];
	int i,fi;
	fi=numvett();
	for(i=0;i<fi;i++){
		nome[]=caricavett(i,cognome[]);
	}
	cerca(nome[],cognome[],fi);
}
