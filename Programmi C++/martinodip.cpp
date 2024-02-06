#include<iostream>
#include<string>
#include<fstream>
using namespace std;


const int nmax=30;


struct dipendenti{
	string nome;
	int stipendio;
	int livello;
};

//prototipi
void carica(dipendenti d[], int n);
void ordina(dipendenti d[], int n);
void percentuale(dipendenti d[], int n);
void view(dipendenti d[], int n);
void scambio(dipendenti &a,dipendenti &b);
void aggiungi( int n);


int main(){
	int num;
	dipendenti dip[nmax];
	int scelta;
	cout<<"1) carica dipendenti"<<endl<<"2) ordina i dipendenti in ordine alfabetico"<<endl<<"3) aumenta stipendio per i dipendenti livello 4"<<endl<<"4) visualizza "<<endl<<"5) inserire un nuovo dipendente"<<endl<<"0) ESCI"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>scelta;
	do{
		switch(scelta){
			case 1:
				carica(dip, num);
				break;
			case 2:
				ordina(dip, num);
				break;
			case 3:
				percentuale(dip, num);
				break;
			case 4:
				view(dip, num);
				break;
			case 5:
			    aggiungi(num);
			    break;
		}
	}while(scelta!=0);
}

void carica(dipendenti d[], int n){
	fstream file;
	file.open("dipendenti.txt"),ios::out;
	if(!file)cout<<"non esiste nessun file\n";
	file>>d[n].nome>>d[n].stipendio>>d[n].livello;
	while(!file.eof()){
		n++;
		file>>d[n].nome>>d[n].stipendio>>d[n].livello;
	}
	
	
	file.close();
	cout<<n;
}


void ordina(dipendenti d[], int n){
	fstream file;
	
	file.open("dipendenti.txt"),ios::out;
	for(int i=0; i<n-1; i++){
		for(int j=i+1; j<n; j++){
		    if(d[j].nome<d[i].nome){
		        scambio(d[i],d[j]);
		  }
		
	   }
	}

	
}

void scambio(dipendenti &a,dipendenti &b){
	dipendenti temp;
	temp=a;
	a=b;
	b=temp;
}



void percentuale(dipendenti d[], int n){
	int perc=0;
	
	for(int i=0; i<n; i++){
		if(d[i].livello==4)
		perc=(d[i].stipendio*2)/100;
    
     d[i].stipendio=d[i].stipendio+perc; //stipendio aggiornato
    

	}

}

void view(dipendenti d[], int n){
	fstream file1;
	
	file1.open("new_dipendenti.txt",ios::out);
	for(int i=0; i<n; i++){
		file1<<d[i].nome<<endl;
		file1<<d[i].stipendio<<endl;
		file1<<d[i].livello<<endl;
	}
		
	file1.close();
}

void aggiungi( int n)
{
    dipendenti a;
    fstream file;
    file.open("dipendenti.txt",ios::app);
    cout<<"NOME:";
    cin>>a.nome;
    cout<<"SIPENDIO:";
    cin>>a.stipendio;
    cout<<"LIVELLO:";
    cin>>a.livello;
    file<<a.nome<<endl<<a.stipendio<<endl<<a.livello;
    file.close();
}
