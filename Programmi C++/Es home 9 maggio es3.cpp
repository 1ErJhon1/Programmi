#include<iostream>
#include<ctime>
#include <cstdlib>
using namespace std;

void carica(int vett1[]){
	int num,dim,i;
	srand(time(NULL));
	for(i=0;i<10;i++){
		vett1[i]=rand()%101;
	}
	cout<<endl;
}

void visvett(int vett[]){
	int i;
	for(i=0;i<10;i++){
	cout<<"il numero in posizione: "<<i<<" ha valore: "<<vett[i]<<endl;
	}
	cout<<endl;
}

void scambio(int vett[]){
	int i,app,max,min;
	max=0;
	min=150;
	for(i=0;i<10;i++){
		if(vett[i]>max){
			max=vett[i];
		}
		if(vett[i]<min){
			min=vett[i];
		}
	}
	app=min;
	min=max;
	max=min;
	for(i=0;i<10;i++){
		if(vett[i]==max){
		vett[i]=min;
		}
		if(vett[i]==min){
			vett[i]=max;
		}
	}
}

int main(){
	int vett1[10];
	carica(vett1);
	visvett(vett1);
	scambio(vett1);
	cout<<"lo scambio e' stato effettuato, ecco il nuovo vettore:"<<endl;
	visvett(vett1);
}

