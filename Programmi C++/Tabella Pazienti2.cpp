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

int caricav(paziente vett[],int num);
void visv(paziente vett[],int num);
void cercadim(paziente vett[],int num);
int regdim(paziente vett[],int num,paziente storico[],int nmaxs);
void regacc(paziente vett[],int num);
int menu();

int main(){
	paziente v1[100],s[1000];
	int op,np,i,nmaxs;
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
				caricav(v1,np);
				break;
			case 2:
				visv(s,nmaxs);
				break;
			case 3:
				cercadim(v1,np);
				break;
			case 4:
				nmaxs=regdim(v1,np,s,nmaxs);
				break;
			case 5:
				regacc(v1,np);
		}
	}while(op!=0);
}

int caricav(paziente vett[],int num){
	int i;
	for(i=0;(i<num)&&(i<1000);i++)
		if((vett[i].d.gd=="00")&&(vett[i].d.md=="00")&&(vett[i].d.md=="00")){
			cout<<"Inserisci il cognome del paziente: ";
			cin>>vett[i].cognome;
			cout<<"Inserisci il nome del paziente: ";
			cin>>vett[i].nome;
			num++;
			i=1001;
		}
		if((vett[i].d.gd=="00")&&(vett[i].d.md=="00")&&(vett[i].d.md=="00")){
			cout<<"Inserisci il cognome del paziente: ";
			cin>>vett[i].cognome;
			cout<<"Inserisci il nome del paziente: ";
			cin>>vett[i].nome;
			i<1001;
		}
		cout<<endl;
	return num;
}

void visv(paziente vett[],int num){
	int i;
	cout<<"-----ELENCO PAZIENTI DIMESSI------"<<endl;
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
			cout<<vett[i].cognome<<" "<<vett[i].nome<<endl;
		}
	}
}

int regdim(paziente vett[],int num,paziente storico[],int nmaxs){
	int i,j;
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
			for(j=0;j<nmaxs;j++){
				if((storico[j].a.ga=="00")&&(storico[j].d.gd=="00")){
					storico[nmaxs].nome=vett[i].nome;
			storico[nmaxs].cognome=vett[i].cognome;
			storico[nmaxs].a.ga=vett[i].a.ga;
			storico[nmaxs].a.ma=vett[i].a.ma;
			storico[nmaxs].a.aa=vett[i].a.aa;
			storico[nmaxs].d.gd=vett[i].d.gd;
			storico[nmaxs].d.md=vett[i].d.md;
			storico[nmaxs].d.ad=vett[i].d.ad;
			nmaxs++;
			vett[i].d.gd="11";
			vett[i].d.md="11";
			vett[i].d.ad="1111";
			vett[i].a.ga="00";
			vett[i].a.ma="00";
			vett[i].a.aa="0000";
				}
			}
		}
	}
	return nmaxs;
}

void regacc(paziente vett[],int num){
	int i;
	paziente cerca;
	for(i=0;i<num;i++){
		if((vett[i].a.ga=="00")&&(vett[i].a.ma=="00")&&(vett[i].a.aa=="0000")){
			cout<<"Inserisci la data di accettazione del paziente "<<vett[i].cognome<<" "<<vett[i].nome<<" (gg mm aaaa):"<<endl;
			cin>>vett[i].a.ga>>vett[i].a.ma>>vett[i].a.aa;
			i=num;
		}
	}
}

int menu(){
	int num;
	cout<<endl<<endl<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica pazienti"<<endl<<"2) visualizza pazienti dimessi"<<endl<<"3) stampa elenco di tutti i pazienti dimessi in una data"<<endl<<"4) registra dimissione"<<endl<<"5) registra accettazione"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
