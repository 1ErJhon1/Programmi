#include<iostream>
using namespace std;

struct s_giocatore{
	int num;
	int soldi;
	int carta;
	int punt;
};

int cgiocatori(int &getti,int &cartei){
	int ng;
	do{
		cout<<"Quanti giocatori siete?(max 50): ";
		cin>>ng;
	}while(ng<=0||ng>=50);
	do{
		cout<<"con quanti gettoni volete iniziare?: ";
		cin>>getti;
	}while(getti<=0);
	do{
		cout<<"con quante carte volete iniziare?: ";
		cin>>cartei;
	}while(cartei<=0||cartei<ng);
	return ng;
}

void caricavett(s_giocatore vett1[],int numerog,int soldiIniziali){
	int i;
	s_giocatore g;
	for(i=0;i<50;i++){
		g.num=i;
		g.soldi=soldiIniziali;
	}
}

void visgett(s_giocatore vett1[],int numerog){
	int i;
	cout<<endl;
	for(i=0;i<numerog;i++){
		cout<<"il giocatore numero "<<vett1[i].num<<" ha: "<<vett1[i].soldi<<"gettoni"<<endl;
	}
}

int puntata(int numerogiocatore){
	int p;
	cout<<"giocatore numero: "<<numerogiocatore<<", quanto vuoi puntare?: ";
	cin>>p;
	return p;
}

int main(){
	int ng,gett,carte,i,p,banco;
	s_giocatore vett1[ng],g;
	ng=cgiocatori(gett,carte);
	for(i=0;i<ng;i++){
		g.num=i;
		g.soldi=gett;
	}
	for(i=0;i<ng;i++){
		g.punt=puntata(ng);
		banco+=g.punt;
	}
	visgett(vett1,ng);
	
}
//Ho provato a farlo ma user e' piu' forte di me
