#include<iostream>
using namespace std;
const int rmax=100;
const int cmax=100;

void caricamat(int mat[][cmax],int &r,int &c);
void vismat(int mat[][cmax],int r,int c);
void maxr(int mat[][cmax],int r, int c);
void mintab(int mat[][cmax],int r, int c);
void medcol(int mat[][cmax],int r, int c);

int main(){
	int i,mat[rmax][cmax],r,c,max;
	caricamat(mat,r,c);
	vismat(mat,r,c);
	maxr(mat,r,c);
	mintab(mat,r,c);
	medcol(mat,r,c);
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

void vismat(int mat[][cmax],int r,int c){
	int i,j;
	for(i=0;i<r;i++){
		for(j=0;j<c;j++){
			cout<<"Il numero posizionato in: "<<i+1<<" "<<j+1<<"= "<<mat[i][j];}}
}

void maxr(int mat[][cmax],int r, int c){
	int i,j,max;
	for(i=0;i<r;i++){
		max=mat[i][0];
		for(j=1;j<c;j++){
		if(mat[i][j]>max)
		max=mat[i][j];}
		cout<<"il numero maggiore della riga: "<<i+1<<" = "<<mat[i][j];}
}

void mintab(int mat[][cmax],int r, int c){
	int i,j,min;
	min=mat[0][0];
	for(i=0;i<r;i++){
		for(j=0;i<c;j++){
		if(mat[i][j]<min)
		min=mat[i][j];}}
		cout<<"Il numero minimo della tabella e': "<<min;
}

void medcol(int mat[][cmax],int r, int c){
	int i,j,som,med;
	for(j=0;i<c;j++){
	som=0;
		for(i=0;i<r;i++){
		som=mat[i][j]+som;
		med=som/r;}
		cout<<"la media della colonna: "<<j+1<<" e'= "<<med;}
}