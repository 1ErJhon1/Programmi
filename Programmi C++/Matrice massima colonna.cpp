#include<iostream>
using namespace std;
const int rmax=50;
const int cmax=50;

void caricamat(int mat[][cmax],int &r,int &c);
void vismat(int mat[][cmax],int &r,int &c);
void vissmax(int mat[][cmax],int &r,int &c);
int menu();
	
int main(){
	int op,mat[rmax][cmax],r,c;
	do{
		op=menu();
		switch(op){
			case 1:
				caricamat(mat,r,c);
				break;
			case 2:
				vismat(mat,r,c);
				break;
			case 3:
				vissmax(mat,r,c);
				break;
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

void vissmax(int mat[][cmax],int &r,int &c){
	int i,j,s1,s2,nc1;
	s1=-1;
	s2=0;
	for(j=0;j<c;j++){
		for(i=0;i<r;i++){
			s2=s2+mat[i][r];
			if(s2>s1){
				s1=s2;
				nc1=j;
			}
		}
	}
	cout<<"la colonna con la somma massima e' la numero "<<nc1;
}

int menu(){
	int num;
	cout<<endl<<endl<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica matrice"<<endl<<"2) visualizza matrice"<<endl<<"3) visualizza la colonna la cui somma degli elementi e' massima"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}

