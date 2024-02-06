//data la matrice la matrice A con M righe e M colonne copiala per riga nel vettore
//VR[M*N] e per colonna VC[M*N]
#include<iostream>
using namespace std;
const int rmax=50;
const int cmax=50;

int menu();
void caricamat(int mat[][cmax],int &r,int &c);
void vismat(int mat[][cmax],int &r,int &c);
int vettr(int mat[][cmax],int &r,int &c,int vett[]);
int vettc(int mat[][cmax],int &r,int &c,int vett[]);
void cerca(int mat[][cmax],int &r,int &c);

int main(){
	int op,mat[rmax][cmax],vr[rmax*cmax],vc[rmax*cmax],r,c;
	do{
		op=menu();
		switch(op){
			case 1:
				caricamat(mat,r,c);
				break;
			case 2:
				vismat(mat,r,c);
				break;
			case 3:vettr(mat,r,c,vr);
				break;
			case 4:vettc(mat,r,c,vc);
				break;
			case 5:cerca(mat,r,c);
		}
	}while(op!=0);
}

void caricamat(int mat[][cmax],int &r,int &c){
	int i,j;
	cout<<"quante righe vuoi inserire?: ";
	cin>>r;
	cout<<"quante colonne vuoi inserire?: ";
	cin>>c;
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			cout<<"Inserisci un numero da posizionare in: "<<i+1<<" "<<j+1<<"= ";
			cin>>mat[i][j];}
		}
}

void vismat(int mat[][cmax],int &r,int &c){
	int i,j;
	cout<<"------------MATRICE------------"<<endl;
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			cout<<mat[i][j];
		cout<<"\t";
		}
		cout<<endl;
	}
}

int menu(){
	int num;
	cout<<endl<<endl<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica matrice"<<endl<<"2) visualizza matrice"<<endl<<"3) visualizza matrice in vettore per riga"<<endl<<"4) visualizza matrice in vettore per colonna"<<endl<<"5) ricerca valore nella matrice"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}

int vettr(int mat[][cmax],int &r,int &c,int vett[]){
	int i,j,k;
	k=0;
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			vett[k]=mat[i][j];
			k++;
		}}
	cout<<"-----VETTORE MATRICE PER RIGA-----"<<endl;
	for(k=0;k<(r*c);k++){
		cout<<vett[k]<<"   ";
	}
}

int vettc(int mat[][cmax],int &r,int &c,int vett[]){
	int i,j,k;
	k=0;
	for(j=0;j<c;j++){
		for(i=0;i<r;i++){
			vett[k]=mat[i][j];
			k++;
		}
	}
	cout<<"---VETTORE MATRICE PER COLONNA---"<<endl;
	for(k=0;k<(r*c);k++){
		cout<<vett[k]<<"   ";
	}
}

void cerca(int mat[][cmax],int &r,int &c){
	int i,j,num;
	cout<<"inserisci il valore da ricercare: ";
	cin>>num;
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			if(num==mat[i][j]){
				cout<<num<<" si trova in: "<<i+1<<" "<<j+1<<endl;
			}}}
}
