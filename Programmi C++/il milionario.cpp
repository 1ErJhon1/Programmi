#include<iostream>
#include<string>
using namespace std;
struct persona{
	string nome;
	int soldi;
	int record;
};
int main(){
	int op;
	char op2;
	cout<<"Benvenuto ad 'il milionario'"<<endl<<endl<<"inserisci l'operazione da svolgere"<<endl<<"1-inizia la partita"<<endl<<"2-mostra record"<<endl<<"0-chiudi il gioco"<<endl<<": ";
	cin>>op;
	switch(op){
		case 1:
			cout<<"vuoi che ti mostri il tutorial?(Y/N): "<<;
			cin>>op2;
				if(op2=='y'||op2=='Y')
				op2=1;
				if(op2=='n'||op2=='N')
				op2=0;
				switch(op2){
					case 1:
						cout<<"rispondi alle domande in modo corretto"<<endl<<"se rispondi alla domanda vinci la somma scritta"<<endl<<"se sbagli perdi tutto"<<endl<<"hai a disposizione:"<<endl<<"1-'50:50': lascio solamente la risposta esatta e una sbagliata"<<endl<<"2-'Switch': permette di cambiare la domanda"<<endl<<"3-'Aiuto dell'esperto': permette di chiamare ad un amico esperto"<<endl<<"4-'Chiedilo a Gerry': Gerry esprime il suo parere domanda"<<endl<<endl;
						break;
						}
	}
}
