#include<iostream>
using namespace std;
void listalib(int dim,string vett[],int vett1[]){
	int i;
	for(i=0;i<=dim;i++){
		cout<<i<<")"<<vett1[i]<<" copie disponibili: "<<vett1[i];
	}
}

void cerca(string vett[],string vett1[],int vett2,int dim){
	int i,nom;
	cout<<"inserisci il nome dell'autore da cercare: ";
	cin>>nom;
	for(i=0;i<dim;i++){
		if(vett1[i]==nom){
			cout<<vett[i]<<" posizione n."<<vett2[i]<<endl;
		}
	}
}

int main(){
	string tit[50],aut[50];
	int op,i,n[2000];
	i=0;
	do{
		cout<<"inserisci l'operazione da svolgere:"<<endl<<"1)inserire un nuovo libero"<<endl<<"2)effettuare un prestito di un libro"<<endl<<"3)visualizza tutti i libri di un autore";
		cin>>op;
		switch(op){
			case 1:
				cout<<"inserisci il titolo: ";
				cin>>tit[i];
				cout<<"inserisci l'autore del libro: ";
				cin>>aut[i];
				cout<<"inserisci il numero di copie che sono disponibili: ";
				cin>>n[i];
				i++;
				break;
			case 2:
				listalib(i,tit,n);
				cout<<"scrivi il numero del libro da prestare: ";
				cin>>op;
				n[op]--;
				break;
			case 3:
				cerca(tit,aut,n,i);
		}
	}while(op!=0);
}


