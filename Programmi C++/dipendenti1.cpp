#include<iostream>
#include<fstream>
using namespace std;

const int nmax=100;
struct dipendente{
	string cognome;
	int stip;
	int lvl;
};

int menu();
int carica(fstream &file,dipendente vett[]);
void ordina(dipendente vett[],int dim);
void scambio(dipendente &a,dipendente &b);
void aumstip(dipendente vett[],int dim);
void visdati(fstream &file,dipendente vett[],int dim);

int main(){
	fstream file1;
	dipendente vett1[nmax];
	int nd,op;
	do{
		op=menu();
		switch(op){
			case 1:
				nd=carica(file1,vett1);
				break;
			case 2:
				ordina(vett1,nd);
				break;
			case 3:
				aumstip(vett1,nd);
				break;
			case 4:
				visdati(file1,vett1,nd);
				break;
		}
	}while(op!=0);
}

int carica(fstream &file,dipendente vett[]){
	int i=0;
	file.open("dipendenti.txt",ios::in);
	file>>vett[i].cognome>>vett[i].stip>>vett[i].lvl;
	while(!file.eof()){
		i++;
		file>>vett[i].cognome>>vett[i].stip>>vett[i].lvl;
	}
	file.close();
	cout<<i;
	return i;
}


void ordina(dipendente vett[],int dim){
	int i,j;
	dipendente temp;
	for(i=0;i<dim-1;i++){
		for(j=1;j<dim;j++){
			if(vett[j].cognome<vett[i].cognome){
				scambio(vett[i],vett[j]);
			}
		}
	}
}

void scambio(dipendente &a,dipendente &b){
	dipendente temp;
	temp=a;
	a=b;
	b=temp;
}

void aumstip(dipendente vett[],int dim){
	int i;
	float s;
	for(i=0;i<dim;i++){
		if(vett[i].lvl==4){
			s=(vett[i].stip*2)/100;
			vett[i].stip=vett[i].stip+s;
		}
	}
}

void visdati(fstream &file,dipendente vett[],int dim){
	int i;
	cout<<dim;
	file.open("dipendenti.txt", ios::out);
	for(i=0;i<dim;i++){
		cout<<"cognome dipendente n."<<i+1<<": "<<vett[i].cognome<<endl;
		cout<<"stipendio dipendente n."<<i+1<<": "<<vett[i].stip<<endl;
		cout<<"livello dipendente n."<<i+1<<": "<<vett[i].lvl<<endl<<endl;
		file<<"cognome dipendente n."<<i+1<<": "<<vett[i].cognome<<endl;
		file<<"stipendio dipendente n."<<i+1<<": "<<vett[i].stip<<endl;
		file<<"livello dipendente n."<<i+1<<": "<<vett[i].lvl<<endl<<endl;
	}
	file.close();

}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica dipendenti"<<endl<<"2) ordina i dipendenti in ordine alfabetico"<<endl<<"3) aumenta stipendio dipendenti livello 4"<<endl<<"4) salva i dati aggiornati nel file di testo"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
