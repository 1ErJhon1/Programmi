#include<iostream>
using namespace std;

class studente{
	string cognome;
	float voto[50];
	int nvoti;
	float med;
	public:
		void visualizza();
		void inserisci();
		float media();
		void setnvoti(float nvoti);
		void setvoto(float voto,int i);
		float getmedia();
		void setmedia(float media);
		void setcognome(string cognome);
};

void studente::visualizza()
{
	cout<<"-----STUDENTE-----"<<endl;
	cout<<"COGNOME: "<<cognome<<endl;
	cout<<"VOTI: ";
	for(int i=0;i<nvoti;i++){
		cout<<voto[i]<<" ";
	}
	cout<<"MEDIA: "<<med;
}

void studente::setcognome(string cognome){
	this->cognome=cognome;
}

void studente::setnvoti(float nvoti){
	this->nvoti=nvoti;
}

void studente::setvoto(float voto,int i){
	this->voto[i]=voto;
}
void studente::setmedia(float med){
	this->med=med;
}
float studente::getmedia(){
	return med;
}

void studente::inserisci(){
	float voto;
	int i;
	cout<<"inserisci il cognome: ";
	cin>>cognome;
	cout<<"quanti voti vuoi inserire?: ";
	cin>>nvoti;
	for(i=0;i<nvoti;i++){
		cout<<"Inserisci il "<<i+1<<"^ voto: ";
		cin>>voto;
		setvoto(voto,i);
	}
	cout<<endl;
}

float studente::media(){
	float s=0,m=0;
	for(int i=0;i<nvoti;i++){
		 s+=voto[i];
	}
	m=s/nvoti;
	setmedia(m);
}

int main(){
	studente s;
	s.inserisci();
	s.media();
	s.visualizza();
}
