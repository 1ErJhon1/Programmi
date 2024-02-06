#include<iostream>
#include<fstream>
using namespace std;

const int nmax=100;

struct num{
	float n;
	float s;
};

int carica(fstream &file,num vett[],float &med);
float media(float num1,int num2);
void scostamento(num vett[],int dim,float num);
void visdati(num vett[],int dim,float num);
int menu();

int main(){
	fstream file1;
	int op,nn;
	num vett1[nmax];
	float med;
	do{
		op=menu();
		switch(op){
			case 1:
				nn=carica(file1,vett1,med);
				break;
			case 2:
				visdati(vett1,nn,med);
				break;
		}
	}while(op!=0);
}

int carica(fstream &file,num vett[],float &med){
	int i=0,j;
	float s;
	file.open("numeri.txt",ios::in);
	if(!file){
	    cout<<"----ATTENZIONE IL FILE NON E' STATO APERTO CORRETTAMENTE----"<<endl;
	}else{
	file>>vett[i].n;
	while(!file.eof()){
		i++;
		file>>vett[i].n;
		s+=vett[i].n;
		}
	file.close();
	med=media(s,i);
	for(j=0;j<i;i++){
		scostamento(vett,i,med);
	}
	}
		return i;

}

float media(float num1,int num2){
	float med;
	med=num1/num2;
	return med;
}

void scostamento(num vett[],int i,float num){
	int s;
	vett[i].s=num-vett[i].n;
	if(vett[i].s<0){
		vett[i].s=-vett[i].s;
	}
}

void visdati(num vett[],int dim,float num){
    fstream file2;
	int i;
	file2.open("numeri2.0.txt", ios::out);
	file2<<"Media: "<<num;
	for(i=0;i<=dim;i++){
		file2<<"numero in posizione "<<i+1<<": "<<vett[i].n<<endl;
		file2<<"scostamento: "<<vett[i].s<<endl<<endl;
	}
	file2.close();
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) carica numeri"<<endl<<"2) visualizza risultato"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}