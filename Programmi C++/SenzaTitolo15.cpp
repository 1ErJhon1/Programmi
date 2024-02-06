#include<iostream>
using namespace std;

struct persona{
	string nome;
	string cognome;
	int eta;
	string num_t;
};

int main(){
	persona a[50];
	int i;
	for(i=0;i<50;i++){
	cout<<"Inserisci il nome della persona: ";
	cin>>a[i].nome;
	cout<<"inserisci il cognome della persona: ";
	cin>>a[i].cognome;
	cout<<"inserisci l'eta' della persona: ";
	cin>>a[i].eta;
	cout<<"inserisci il numero di telefono della persona: ";
	cin>>a[i].num_t;
	cout<<"nome: "<<a[i].nome<<endl;
	cout<<"cognome: "<<a[i].cognome<<endl;
	cout<<"eta': "<<a[i].eta<<endl;
	cout<<"numero di telefono: "<<a[i].num_t<<endl;
	}
}
