#include<iostream>
using namespace std;

int carica(int vett1[]){
	int dim,i;
	cout<<"Inserisci la dimensione del vettore (max 50): ";
	cin>>dim;
	for(i=0;i<dim;i++){
	cout<<"inserisci un numero (pos."<<i<<")";
	cin>>vett1[i];
	}
	cout<<endl;
	return dim;
}

int main(){
	int vett[50],dim,i;
	dim=carica(vett);
	for(i=0;i<dim;i++){
		cout<<"posizione:"<<i<<" ";
		for(i=0;i<vett[i];i++){
			cout<<"*";
		}
		cout<<endl;
	}
}
