#include<iostream>
#include<fstream>
using namespace std;

const int nmax=500;

struct film{
	string tit;
	string att;
	int dur;
};

int menu();
int carica(fstream &file,film vett[]);
void cercaatt(fstream &file,film vett[],int dim);
void durmagg(fstream &file,film vett[],int dim);
void datifa(fstream &file,film vett[],int dim);

int main(){
	int op,nf;
	fstream file1;
	film vett[nmax];
	do{
		op=menu();
		switch(op){
			case 1:
				nf=carica(file1,vett);
				break;
			case 2:
				cercaatt(file1,vett,nf);
				break;
			case 3:
				durmagg(file1,vett,nf);
				break;
			case 4:
				datifa(file1,vett,nf);
				break;
		}
	}while(op!=0);
}

int carica(fstream &file,film vett[]){
	int i=0;
	file.open("Film.txt",ios::in);
	if(!file){
	    cout<<"----ATTENZIONE IL FILE NON E' STATO APERTO CORRETTAMENTE----"<<endl;
	}else{
	file>>vett[i].tit>>vett[i].att>>vett[i].dur;
	while(!file.eof()){
		i++;
		file>>vett[i].tit>>vett[i].att>>vett[i].dur;
		}
	file.close();
	}
		return i;
}

void cercaatt(fstream &file,film vett[],int dim){
	int i,i2;
	string tit;
	bool ver;
	film temp;
	file.open("Film.txt",ios::in);
	cout<<"Inserisci il nome del film: ";
	cin>>tit;
	for(i=0;i<dim;i++){
		if(tit==vett[i].tit){
			ver=true;
			i2=i;
			}
		}
	if(ver==true){
		for(i=0;i<i2;i++){
			file<<temp.tit<<temp.att<<temp.dur;
		}
		cout<<"titolo: "<<temp.tit<<endl<<"attore: "<<temp.att<<endl<<"durata: "<<temp.dur<<endl;
	}else{
		cout<<"Non e' stato possibile trovare alcun attore";
	}
	file.close();
}

void durmagg(fstream &file,film vett[],int dim){
	int i,max;
	film temp;
	file.open("Film.txt",ios::in);
	max=0;
	for(i=0;i<dim;i++){
		if(vett[max].dur>vett[i].dur){
			max=i;
		}
	}
	for(i=0;i<max;i++){
		file<<temp.tit<<temp.att<<temp.dur;
	}
	cout<<"il titolo del film con durata maggiore e': "<<temp.tit;
	file.close();
}

void datifa(fstream &file,film vett[],int dim){
	int i,i2;
	string att;
	fstream file2;
	file.open("Film.txt",ios::in);
	file2.open("Stampa.txt",ios::out);
	cout<<"Inserisci il nome dell'attore: ";
	cin>>att;
	cout<<"ELENCO FILM DI: "<<att<<endl<<"TITOLO\tDURATA"<<endl;
	for(i=0;i<dim;i++){
		if(vett[i].att==att){
			file2<<vett[i].tit<<"\t"<<vett[i].dur;
		i2++;
		}
	}
	cout<<"numero di film: "<<i2;
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) visualizza nome dell'attore"<<endl<<"2) visualizza titolo durata maggiore"<<endl<<"3) crea file con dati film di un attore"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
