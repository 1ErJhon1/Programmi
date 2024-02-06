#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int menu();
int scelta();
void visdati(int nr);

int main(){
	int op,nriga;
	do{
		op=menu();
		switch(op){
			case 1:
				nriga=scelta();
				break;
			case 2:
				visdati(nriga);
				break;
		}
	}while(op!=0);
}


int scelta(){
	int nriga;
	cout<<"inserisci il numero della riga da scrivere sull'altro file di testo: ";
	cin>>nriga;
	nriga-=1;
	return nriga;
}

void visdati(int nr){
    fstream file1,file2;
	int i;
	string riga;
	file1.open("brano.txt",ios::in);
	if(!file1){
	    cout<<"----ATTENZIONE IL FILE NON E' STATO APERTO CORRETTAMENTE----"<<endl;
	}else{
		for(i=0;i++;i<nr){
			riga=getline(file1);
		}
	file2.open("rigabrano.txt", ios::out);		
	file2<<riga;
	file1.close();
	file2.close();
	}
}

int menu(){
	int num;
	cout<<"-------INTERFACCIA MENU'-------"<<endl<<"1) scegli riga"<<endl<<"2) scrivi riga"<<endl<<"0) fine programma"<<endl<<"inserisci l'operazione da svolgere: ";
	cin>>num;
	cout<<endl;
	return num;
}
