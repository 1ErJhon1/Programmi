#include<iostream>
using namespace std;
int main(){
	int num,i,r;
	string es,ris;
	cout<<"Scrivi un numero"<<endl;
	cin>>num;
	if(16777215>=num&&num>=0){
	for(i=1;i<=5;i++){
		r=num%16;
		num=num/16;
		switch(r){
			case 0:
				es="0";
				break;
			case 1:
				es="1";
				break;
			case 2:
				es="2";
				break;
			case 3:
				es="3";
				break;			
			case 4:
				es="4";
				break;
			case 5:
				es="5";
				break;
			case 6:
				es="6";
				break;
			case 7:
				es="7";
				break;
			case 8:
				es="8";
				break;
			case 9:
				es="9";
				break;
			case 10:
				es="A";
				break;
			case 11:
				es="B";
				break;
			case 12:
				es="C";
				break;
			case 13:
				es="D";
				break;
			case 14:
				es="E";
				break;
			case 15:
				es="F";
				break;
				}
		ris=es+ris;
	}
	cout<<"Il risultato e' "<<ris;
	}else{
		cout<<"Impossibile calcolare"
	}
}
