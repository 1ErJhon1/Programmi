#include<iostream>
using namespace std;
float quintali();
float prezzoq();
float ricavo(float num1,float num2);
float mediap(float num1, float num2);


int main(){
	int op,ig,io,iu;
	float q,pq,r,aqg,aqo,aqu,aqpg,aqpo,aqpu,rtot,arg,aro,aru,mpqg,mpqo,mpqu;
	do{
		cout<<"Azienda 3C COOP"<<endl<<endl<<"1-grano"<<endl<<"2-olio/olive"<<endl<<"3-uva/vino"<<endl<<"0-FINE PROGRAMMA"<<endl<<endl<<"scegli l'operazione da svolgere: ";
		cin>>op;
		switch(op){
			case 1:
				q=quintali();								//quintali grano
				pq=prezzoq();								//prezzo un quitale grano
				r=ricavo(q,pq);								//ricavo grano
				aqg=q+aqg;									//accumulatore quintali grano
				aqpg=pq+aqpg;								//accumulatore quintale prezzo grano
				arg=arg+r;									//accumulatore ricavo uva
				ig++;										//contatore caso 1
				rtot=rtot+r;								//ricavo totale
				break;
			case 2:
				q=quintali();								//quintali olive
				pq=prezzoq();								//prezzo un quitale olive
				r=ricavo(q,pq);								//ricavo olive
				aqo=q+aqo;									//accumulatore quintali olive
				aqpo=pq+aqpo;								//accumulatore quintale prezzo olive
				aro=aro+r;									//accumulatore ricavo olive
				io++;										//contatore caso 2
				rtot=rtot+r;								//ricavo totale
				break;
			case 3:
				q=quintali();								//quintali uva
				pq=prezzoq();								//prezzo un quitale uva
				r=ricavo(q,pq);								//ricavo uva
				aqu=q+aqu;									//accumulatore quintali uva
				aqpu=pq+aqpu;								//accumulatore quintale prezzo uva
				aru=aru+r;									//accumulatore ricavo uva
				iu++;										//contatore caso 3
				rtot=rtot+r;								//ricavo totale
				break;
		}
	}while(op!=0);
				mpqg=mediap(aqpg,ig);						//media prezzo al quintale grano
				mpqo=mediap(aqpo,io);						//media prezzo al quintale olive
				mpqu=mediap(aqpu,iu);						//media prezzo al quintale uva
				if(ig==0){
					mpqg=0;
					aqg=0;
				}
				if(io==0){
					mpqo=0;
					aqo=0;
				}
				if(iu==0){
					mpqu=0;
					aqu=0;
				}
	cout<<endl<<endl<<endl<<"RIEPILOGO VENDITE"<<endl<<endl<<endl<<"GRANO"<<endl<<endl<<"quintali grano: "<<aqg<<endl<<"ricavo: "<<arg<<endl<<"media prezzo al quintale: "<<mpqg<<endl<<endl<<endl<<"OLIVE"<<endl<<endl<<"quintali olive: "<<aqo<<endl<<"media prezzo al quintale: "<<mpqo<<endl<<endl<<endl<<"UVA"<<endl<<endl<<"quintali uva: "<<aqu<<endl<<"media prezzo al quintale: "<<mpqu;
}


float quintali(){
	float num1;
	cout<<endl<<"quanti quintali vuoi vendere?: ";
	cin>>num1;
	return num1;
}

float prezzoq(){
	float num1;
	cout<<"quanto e' il prezzo a quintale?: ";
	cin>>num1;
	cout<<endl;
	return num1;
}

float ricavo(float num1,float num2){
	float num3;
	num3=num1*num2;
	return num1;
}


float mediap(float num1, float num2){
	float num3;
	num3=num1/num2;
	return num3;
}
