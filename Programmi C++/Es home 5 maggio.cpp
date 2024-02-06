#include<iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
int carica(int vett1[],int n){
	int num1,dim,i;
	cout<<"Per caricare il vettore numero "<<n<<" quanti numeri vuoi generare? (max 50): "<<endl;
	cin>>dim;
	for(i=0;i<dim;i++){
	srand(time(NULL));
	vett1[i]=rand()%301;
	}
	return dim;
}

void visvett(int vett1[],int dim){
	int i;
	cout<<"Il vettore ha come dimensione: "<<dim<<endl;
	for(i=0;i<dim;i++){
		cout<<"Il numero in posizione: "<<i<<" e': "<<vett1[i]<<endl;
	}
}

int valmax(int vett1[],int dim){
	int i,numm;
	numm=0;
	for(i=0;i<dim;i++){
		if(vett1[i]>numm){
			numm=vett1[i];
		}
	}
	return numm;
}

void somvett(int vett1[],int vett2[],int vett3[],int dim){
	int s,i;
	for(i=0;i<dim;i++){
		vett3[i]=vett1[i]+vett2[i];
	}
}

int main(){
	int vett1[50],vett2[50],vett3[50],d1,d2,n,max1,max2;
	n=1;
	d1=carica(vett1,n);
	visvett(vett1,d1);
	n++;
	d2=carica(vett2,n);
	visvett(vett2,d2);
	max1=valmax(vett1,d1);
	max2=valmax(vett2,d2);
	if(max2<max1)
	max1=max2;
	cout<<"il valore piu' grande tra i due vettori e': "<<max1<<endl;
	if(d1<d2)
	d1=d2;
	somvett(vett1,vett2,vett3,d1);
	visvett(vett1,d1);
}


