#include<iostream>
using namespace std;

struct cliente{
	string c;
	string n;
};

struct data{
	string g;
	string m;
	string a;
};

struct dvd{
	int cod;
	int nc;
	string tit;
};

struct prestito{
	cliente cl;
	int cod;
	int op;
	data d;
};
int cardvd(dvd vett[]);
int regpres(prestito vett[]);
void cercacod(dvd vett1[],prestito vett2[],int num1,int num2);
void infdvd(prestito vett[],int num);
int menu();

int main(){
	int nv1,nv2,op;
	dvd v1;
	prestito v2;
	
	do{
		op=menu();
		switch(op){
			case 1: 
				nv1=cardvd(v1);
				break;
			case 2:
				nv2=regpres(v2)
				break;
			case 3:
				cercacod(v1,v2,nv1,nv2);
				break;
			case 4:
				infdvd(v2,nv2);
				break;
		}
	}while(op!=0);
}

int cardvd(dvd vett[]){
	int i,num;
	cout<<"Quanti DVD vuoi inserire?: ";
	cin>>num;
	for(i=0;i<num;i++){
		cout<<"Inserisci il codice del DVD: ";
		cin>>vett[i].cod;
		cout<<"Inserisci il numero copie del DVD: ";
		cin>>vett[i].nc;
		cout<<"Inserisci il titolo del DVD: ";
		cin>>vett[i].tit;
		cout<<endl;
	}
	return num;
}

int regpres(prestito vett[]){
	int i,num;
	cout<<"Quanti DVD vuoi inserire?: ";
	cin>>num;
	for(i=0;i<num;i++){
		cout<<"Inserisci cognome e nome del cliente: ";
		cin>>vett[i].cl.c>>vett[i].cl.n;
		cout<<"Inserisci il codice del DVD: ";
		cin>>vett[i].cod;
		cout<<"Inserisci 0 se e' stato prestato, 1 se e' stato restituito: (0/1):";
		cin>>vett[i].op;
		cout<<"Inserisci la data dell'operazione (gg/mm/aaaa): ";
		cin>>vett[i].d.g>>vett[i].d.m>>vett[i].d.a;
		cout<<endl;
	}
	return num;
}

void cercacod(dvd vett1[],prestito vett2[],int num1,int num2){
	int i,cerca;
	bool vc;
	vc=false;
	cout<<"Inserisci il codice da cercare";
	for(i=0;i<num1;i++){
		if(cerca==vett1[i].cod){
			cout<<"codice: "<<vett1[i].cod<<endl<<"numero copie: "<<vett1[i].nc<<endl<<"titolo: "<<vett1[i].tit;
			vc=true;
		}
	}
	for(i=0;i<num2;i++){
		if(cerca==vett2[i].cod){
				vc=true;
				cout<<"codice: "<<vett2[i].cod<<endl<<"cliente: \t\tdata: \toperazione"<<endl<<vett2[i].cl.c<<" "<<vett2[i].cl.n<<"\t"<<vett2[i].d.g<<vett2[i].d.m<<vett2[i].d.a<<"\t";
				if(vett2[i].op==1){
					cout<<"restituito"<<endl;
				}else{
					cout<<"prestato";
			}
		}
	}
	if(vc==false){
		cout<<"IL DVD NON E' STATO TROVATO";
	}
}

void infdvd(prestito vett[],int num){
	int i,j;
	prestito tmp;

    for (i=0;i<num-1;i++){
        for (j=i+1;j<num;j++){
            if (vett[i]>vett[j]){
                tmp=vett[i];
                vett[i]=vett[j];
                vett[j]=tmp;
            }
        }
    }
	for(i=0;i<num;i++){
		cout<<"codice: "<<vett[i].cod<<endl<<"cliente: \t\tdata: \toperazione"<<endl<<vett[i].cl.c<<" "<<vett[i].cl.n<<"\t"<<vett[i].d.g<<vett[i].d.m<<vett[i].d.a<<"\t";
			if(vett[i].op==1){
				cout<<"restituito"<<endl;
			}else{
				cout<<"prestato"<<endl;
			}
	}
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica DVD"<<endl<<"2) registra DVD prestato o restituito"<<endl<<"3) cerca codice DVD"<<endl<<"4) informazioni su tutte le operazioni"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
