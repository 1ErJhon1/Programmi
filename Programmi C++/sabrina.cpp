#include<iostream>
using namespace std;
int main(){
	float x,p,y,importo_p,importo_tot,d;
	cout<<"inserisci x: ";
	cin>>x;
	cout<<"inserisci y: ";
	cin>>y;
	cout<<"inserisci p: ";
	cin>>p;
	cout<<"inserisci dimensioni dell'appartamento: ";
	cin>>d;
	importo_tot=d*x;
	importo_tot=d+y;
	importo_p=(importo_tot*p)/100;
	importo_tot=importo_tot+importo_p;
	cout<<"l'importo totale e': "<<importo_tot<<" euro";
}
