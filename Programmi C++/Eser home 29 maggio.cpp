#include<iostream>
#include<string>
using namespace std;

struct alunno{
	string cognome;
	string nome;
	string scuola;
	string classe;
	float media;
	int diploma;
	int bonus;
};

int main(){
	int op,n,i;
	alunno v1[10000];
	string appsc,appcl;
	cout<<"Inserisci il numero di ragazzi nell'elenco: ";
	cin>>n;
	do{
		cout<<"inserisci l'operazione da compiere"<<endl<<"1-crea un elenco di alunni"<<endl<<"2-mostra l'intero elenco di alunni"<<endl<<"3-mostra alunni di una data classe di una data scuola"<<endl<<"4-Mostra alunni meritevoli"<<endl<<"5-Assegna bonus"<<endl<<"0-termina programma";
		cin>>op;
		cout<<endl;
		switch(op){
			case 1:
				for(i=0;i<n;i++){
					cin.ignore();
					cout<<"compila i campi dell'alunno n."<<i<<endl;
					cout<<"cognome: ";
					cin>>v1[i].cognome;
					cout<<"nome: ";
					cin>>v1[i].nome;
					cout<<"scuola: ";
					getline(cin,v1[i].scuola);
					cout<<"classe: ";
					cin>>v1[i].classe;
					cout<<"media dei voti: ";
					cin>>v1[i].media;
					cout<<"voto diploma (se ha preso 100 e lode scrivi'101'): ";
					cin>>v1[i].diploma;
					v1[i].bonus=0;
				}
			break;
			case 2:
				for(int i=0;i<n;i++){
					cout<<"alunno n."<<i<<endl;
					cout<<"cognome: "<<v1[i].cognome<<endl;
					cout<<"nome: "<<v1[i].nome<<endl;
					cout<<"scuola: "<<v1[i].scuola<<endl;
					cout<<"classe: "<<v1[i].classe<<endl;
					cout<<"bonus: "<<v1[i].bonus;
					cout<<endl<<endl;
				}
			break;
			case 3:
				cout<<"inserisci il nome della scuola: ";
				getline(cin,appsc);
				cout<<"inserisci la classe: ";
				cin>>appcl;
					cout<<"gli alunni della scuola "<<appsc<<" della classe "<<appcl<<" trovati sono:"<<endl;
				for(i=0;i<n;i++){
					if(appsc==v1[i].scuola&&appcl==v1[i].classe)
					cout<<v1[i].cognome<<" "<<v1[i].nome<<endl;
				}
				cout<<endl;
			break;
			case 4:
				cout<<"gli alunni meritevoli sono: "<<endl;
				for(i=0;i<n;i++){
					if(v1[i].diploma==101)
					cout<<v1[i].cognome<<" "<<v1[i].nome<<endl;
				}
			break;
			case 5:
				cout<<"sto assegnano i bonus..."<<endl;
				for(i=0;i<n;i++){
					if(v1[i].media>8)
						v1[i].bonus+=100;
					if(v1[i].diploma>85)
						v1[i].bonus+=150;
				}
				cout<<"bonus assegnati"<<endl<<endl;
		}
	}while(op!=0);
}
