#include<iostream>
using namespace std;

struct accett{
	string ga;
	string ma;
	string aa;
};

struct dim{
	string gd;
	string md;
	string ad;
};

struct paziente{
	string cognome;
	string nome;
	accett a;
	dim d;
};

int caricav(paziente vett[]);
void visv(paziente vett[],int num);
void cercadim(paziente vett[],int num);
void regdim(paziente vett[],int num);
void cercapaz(paziente vett[],int num);
int menu();

int main(){
	paziente v1[100];
	int op,np,i;
	for(i=0;i<100;i++){
		v1[i].a.ga="00";
		v1[i].a.ma="00";
		v1[i].a.aa="0000";
		v1[i].d.gd="00";
		v1[i].d.md="00";
		v1[i].d.ad="0000";
	}
	do{
		op=menu();
		switch(op){
			case 1:
				np=caricav(v1);
				break;
			case 2:
				visv(v1,np);
				break;
			case 3:
				cercadim(v1,np);
				break;
			case 4:
				regdim(v1,np);
				break;
			case 5:
			    cercapaz(v1,np);
			    break;
			case 6:
			    system("cls");
			    break;
		}
	}while(op!=0);
}

int caricav(paziente vett[]){
	int i,num;
	cout<<"Quanti pazienti vuoi inserire?: ";
	cin>>num;
	for(i=0;i<num;i++){
		cout<<"Inserisci il cognome del paziente: ";
		cin>>vett[i].cognome;
		cout<<"Inserisci il nome del paziente: ";
		cin>>vett[i].nome;
		cout<<"Inserisci la data dell'ammissione (gg mm aaaa): ";
		cin>>vett[i].a.ga>>vett[i].a.ma>>vett[i].a.aa;
		cout<<endl;
	}
	return num;
}

void visv(paziente vett[],int num){
	int i;
	cout<<"-----ELENCO PAZIENTI------"<<endl;
	for(i=0;i<num;i++){
		cout<<"COGNOME: "<<vett[i].cognome<<endl<<"NOME: "<<vett[i].nome<<endl<<"DATA ACCETTAZIONE: "<<vett[i].a.ga<<"/"<<vett[i].a.ma<<"/"<<vett[i].a.aa<<endl<<"DATA DIMISSIONE: "<<vett[i].d.gd<<"/"<<vett[i].d.md<<"/"<<vett[i].d.ad<<endl<<"------------------------------"<<endl;
	}
}

void cercadim(paziente vett[],int num){
	int i;
	dim cerca;
	cout<<"inserisci il giorno, il mese e l'anno della dimissione"<<endl;
	cin>>cerca.gd>>cerca.md>>cerca.ad;
			cout<<"i pazienti dimessi in questa data sono:"<<endl;
	for(i=0;i<num;i++){
		if((cerca.gd==vett[i].d.gd)&&(cerca.md==vett[i].d.md)&&(cerca.ad==vett[i].d.ad)){
			cout<<"-"<<vett[i].cognome<<" "<<vett[i].nome<<endl;
		}
	}
}

void regdim(paziente vett[],int num){
	int i;
	string cerca;
	paziente data;
	cout<<"Inserisci il cognome del paziente a cui registrare la dimissione: ";
	cin>>cerca;
	cout<<"Inserisci la data della dimissione (gg mm aaaa): ";
	cin>>data.d.gd>>data.d.md>>data.d.ad;
	for(i=0;i<num;i++){
		if(cerca==vett[i].cognome){
			vett[i].d.gd=data.d.gd;
			vett[i].d.md=data.d.md;
			vett[i].d.ad=data.d.ad;
		}
	}
}

void cercapaz(paziente vett[],int num){
    int i;
    string cercan,cercac;
    cout<<"Inserisci il cognome del paziente da cercare: ";
    cin>>cercac;
    cout<<"Inserisci il nome del paziente da cercare: ";
    cin>>cercan;
    for(i=0;i<num;i++){
        if((cercac==vett[i].cognome)&&(cercan==vett[i].nome)){
            cout<<"COGNOME: "<<vett[i].cognome<<endl<<"NOME: "<<vett[i].nome<<endl<<"DATA ACCETTAZIONE: "<<vett[i].a.ga<<"/"<<vett[i].a.ma<<"/"<<vett[i].a.aa<<endl<<"DATA DIMISSIONE: "<<vett[i].d.gd<<"/"<<vett[i].d.md<<"/"<<vett[i].d.ad<<endl;
        }
    }
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica dipendenti"<<endl<<"2) aumenta stipendio dipendenti livello 4"<<endl<<"3) visualizza i dati"<<endl<<"4) salva i dati aggiornati nel file di testo"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
