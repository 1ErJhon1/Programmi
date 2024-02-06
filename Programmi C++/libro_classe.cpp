/*1. Definisci una classe Libro contenente i seguenti attributi:
- nome del libro;
- prezzo;
numero di scaffale;
numero di pagine;
 casa editrice.      
Inoltre definisci i metodi con i seguenti compiti:      
–  inizializzare i campi dati dell’oggetto classe;      
–  stampare tutti i dati dell’oggetto;      
–  diminuire del 10% il prezzo del libro in oggetto.*/
#include <iostream>
using namespace std;
class Libro{
	public:
		string nome_libro;
		float prezzo;
		int n_scaffale;
		int n_pagine;
		string casa_editrice;
		void visualizza();
		void sconto();
		Libro()
		{
			nome_libro="Pizzarelli";
			prezzo=0;
			n_scaffale=1;
			n_pagine=69;
			casa_editrice="La solitudine rende forte";
		}
};
void Libro::visualizza()
{
	cout<<"I dati del libro inserito sono:"<<endl;
	cout<<"Nome libro:"<<nome_libro<<endl;
	cout<<"Prezzo:"<<prezzo<<endl;
	cout<<"Numero scaffale:"<<n_scaffale<<endl;
	cout<<"Numero pagine:"<<n_pagine<<endl;
	cout<<"Casa editrice:"<<casa_editrice<<endl;
}
void Libro::sconto()
{
	float sconto=prezzo*10/100;
	prezzo=prezzo-sconto;
	cout<<"Prezzo Scontato="<<prezzo<<endl;
	cout<<"sconto="<<sconto<<endl;
}
int main()
{
	Libro l;//oggetto della classe Libro
	cout<<"I dati iniziali del libro sono:"<<endl;
	l.visualizza();
	cout<<"Inserisci il nome del libro:"<<endl;
	cin>>l.nome_libro;
	cout<<"Inserisci il prezzo del libro:"<<endl;
	cin>>l.prezzo;
	cout<<"Inserisci il numero dello scaffale:"<<endl;
	cin>>l.n_scaffale;
	cout<<"Inserisci il numero di pagine:"<<endl;
	cin>>l.n_pagine;
	cout<<"Inserisci la casa editrice del libro:"<<endl;
	cin>>l.casa_editrice;
	l.sconto();
	l.visualizza();
}

