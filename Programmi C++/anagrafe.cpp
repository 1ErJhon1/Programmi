#include<iostream>
using namespace std;

class classe{
	int codice;
	string cognome;
	string nome;
	bool registrato;
		public:
		void registra();
		void mostra();
		classe();
};

classe{
	codice=0;
	cognome=" ";
	nome=" ";
	registrato=false;
};

void classe::registra(){
	registra=true;
}

int setcodice(){
	int valore;
	do{
		cout<<"Inserisci il codice: ";
		cin>>valore
	}while(valore<0)
}

void setcognome(){
	cognome=valore;
}

void setnome(string valore){
	nome=valore;
}

void classe::inserisci(){
	classe c1;
	int cod
	string c,n
	do{
		cout<<"Inserisci il codice: ";
		cin>>cod;
	}while(cod<0);
	c1::
	cout<<"Inserisci il cognome: ";
	cin>>c;
	cout<<"Inserisci il nome: ";
	cin>>n;
	reg=false;
}

void classe::mostra(){
	if(registrato==true){
		cout<<"-----DATI-----"<<endl;
		cout<<"Codice: "<<codice<<endl;
		cout<<"Cognome: "<<cognome<<endl;
		cout<<"Nome: "<<nome<<endl;
		cout<<"Registrato: SI";
	}else{
		cout<<"persona non registrata"<<endl<<endl;
	}
}


