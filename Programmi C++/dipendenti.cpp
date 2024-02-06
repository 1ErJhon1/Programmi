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
void visdati(dipendente vett[],int dim);
int aggpers(fstream &file,int dim);

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
				visdati(vett1,nd);
				break;
			case 5:
				nd=aggpers(file1,nd);
				break;
		}
	}while(op!=0);
}

int carica(fstream &file,dipendente vett[]){
	int i=0;
	file.open("dipendenti.txt",ios::in);
	if(!file){
	    cout<<"----ATTENZIONE IL FILE NON E' STATO APERTO CORRETTAMENTE----"<<endl;
	}else{
	file>>vett[i].cognome>>vett[i].stip>>vett[i].lvl;
	while(!file.eof()){
		i++;
		file>>vett[i].cognome>>vett[i].stip>>vett[i].lvl;
	}
	file.close();
	return i;
	}
}


void ordina(dipendente vett[],int dim){
	int i,j;
	dipendente temp;
	for(i=0;i<dim-1;i++){
		for(j=i+1;j<dim;j++){
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

void visdati(dipendente vett[],int dim){
    fstream file2;
	int i;
	file2.open("dipendenti2.0.txt", ios::out);
	for(i=0;i<dim;i++){
		file2<<"cognome dipendente n."<<i+1<<": "<<vett[i].cognome<<endl;
		file2<<"stipendio dipendente n."<<i+1<<": "<<vett[i].stip<<endl;
		file2<<"livello dipendente n."<<i+1<<": "<<vett[i].lvl<<endl<<endl;
	}
	file2.close();

}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica dipendenti"<<endl<<"2) ordina i dipendenti in ordine alfabetico"<<endl<<"3) aumenta stipendio dipendenti livello 4"<<endl<<"4) salva i dati aggiornati nel file di testo"<<endl<<"aggiungi dipendente"<<endl<<"0) fine programma"<<endl<<"aggiungi dipendente"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}

int aggpers(fstream &file,int dim){
	dipendente agg;
	file.open("dipendenti.txt",ios::app);
	cout<<"inserisci il cognome della persona da inserire: ";
	cin>>agg.cognome;
	cout<<"inserisci lo stipendio della persona da inserire: ";
	cin>>agg.stip;
	cout<<"inserisci il livello della persona da inserire: ";
	cin>>agg.lvl;
	file<<agg.cognome<<endl<<agg.stip<<endl<<agg.lvl<<endl;
	file.close();
	dim++;
	return dim;
}
