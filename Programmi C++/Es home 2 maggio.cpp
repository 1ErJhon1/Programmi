#include<iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int nevett(){
	int num;
	cout<<"Ciao user, quanti elementi vuoi caricare? (max 20): ";
	cin>>num;
	return num;
}

void visvett(int vett[],int dim){
	int i;
	for(i=0;i<dim;i++){
		cout<<vett[i]<<" ";
	}
}

void vispari(int vett[],int dim){
	int i;
	cout<<"le posizioni in cui si trovano gli elementi pari sono: ";
	for(i=0;i<dim;i++){
		if(vett[i]%2==0){
			cout<<i<<" ";
		}
	}
	cout<<endl;
}

int sdisp(int vett[],int dim){
	int i,s;
	s=0;
	for(i=0;i<dim;i++){
		if(vett[i]%2!=0){
			s=vett[i]+s;
		}
	}
	return s;
}




void nrandom(int vett[],int dim){
	int i,num;
	for(i=0;i<dim;i++){
		srand(time(NULL));
		num=rand()%51+1;
		vett[i]=num;
	}
}

int main(){
	int vett[20],max,somma;
	max=nevett();
	nrandom(vett,max);
	visvett(vett,max);
	vispari(vett,max);
	somma=sdisp(vett,max);
	cout<<"la somma dei numeri dispari sono: "<<somma;
}
