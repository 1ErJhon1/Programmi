#include<iostream>
#include<ctime>
#include <cstdlib>
using namespace std;

void visvett(int vett1[],int dim){
	int i;
	for(i=0;i<dim;i++){
	cout<<vett1[i]<<" ";
	}
	cout<<endl;
}

int main(){
	int vettp[30],vettd[30],i,num,ip,id;
	srand(time(NULL));
	for(i=0;i<30;i++){
		num=rand()%101;
		if(num%2==0){
			vettp[ip]=num;
			ip++;
		}else{
			vettd[id]=num;
			id++;
		}
	}
		cout<<"il vettore dispari e':"<<endl;
		visvett(vettp,ip);
		cout<<endl<<"il vettore pari e':"<<endl;
		visvett(vettd,id);
}
