#include<iostream>
using namespace std;
void inv(float vett1[]){
	float num;
	int i;
	for(i=0;i<=9;i++){
		cout<<"inserisci un numero nella posizione "<<i;
		cin>>num;
		vett1[i]=num;
	}
}

void maxv(float vett1[]){
	int i;
	float num,max;
	max=0;
	for(i=0;i<=9;i++){
		num=vett1[i];
		if(max<num){
			max=vett1[i];
		}
	}
	cout<<"il numero maggiore e' "<<vett1[i]<<" ed e' in posizione: "<<i;
}

float sppari(float vett1[]){
	int i;
	float s;
	s=0;
	for(i=0;i<=9;i+2){
		s=vett1[i]+s;
	}
	return s;
}

float svpari(float vett1[]){
	int i;
	float s;
	s=0;
	for(i=0;i<=9;i++){
		if(vett1[i]%2==0){
			s=vett1[i]+s;
		}
	}
}


int main(){
	float v[10],num1,num2;
	inv(v[]);
	maxv(v[]);
	num1=sppari(v[]);
	cout<<"la somma dei numeri in posizione pari e': "<<max;
	num2=svpari(v[]);
	cout<<"la somma dei numeri di valore pari e': "<<s;
}
