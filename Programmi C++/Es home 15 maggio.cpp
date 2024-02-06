#include<iostream>
using namespace std;
struct s_tel{
	string marca1;
	string marca2;
	string marca3;
	string mod1;
	string mod2;
	string mod3;
	int adp1;
	int adp2;
	int adp3;
	int p1;
	int p2;
	int p3;
};

struct s_pers{
	string n1;
	string n2;
	string n3;
	string c1;
	string c2;
	string c3;
	int ricc1;
	int ricc2;
	int ricc3;
};

struct s_vend{
	string n1;
	string n2;
	string n3;
	string pos1;
	string pos2;
	string pos3;
	string ada1;
	string ada2;
	string ada3;
	string prov1;
	string prov2;
	string prov3;
};



string inmarca(int i){
	string m;
	cout<<"inserisci la marca del "<<i<<" telefono: ";
	cin>>m;
	return m;
}

string inmod(int i){
	string m;
	cout<<"inserisci il modello del "<<i<<" telefono: ";
	cin>>m;
	return m;
}

int inadp(int i){
	int a;
	cout<<"inserisci l'anno di produzione del "<<i<<" telefono: ";
	cin>>a;
	return a;
}

int inp(int i){
	int p;
	cout<<"inserisci il prezzo del "<<i<<" telefono: ";
	cin>>p;
	return p;
}

void vistel(s_tel tma,s_tel tmod,s_tel tadp,s_tel tp){
	cout<<"il telefono piu' costoso e' il: ";
	cout<<tma;
	cout<<tmod<<endl;
	cout<<"anno di produzione: "<<tadp<<endl<<"costo: "<<tp<<" euro"<<endl<<endl;
}

string innome(int i){
	string n;
	cout<<"inserisci il nome della "<<i<<" persona: ";
	cin>>n;
	return n;
}

string inc(int i){
	string c;
	cout<<"inserisci il cognome della "<<i<<" persona: ";
	cin>>c;
	return c;
}

int inricc(int i){
	int ricc;
	cout<<"inserisci i soldi della "<<i<<" persona: ";
	cin>>ricc;
	return ricc;
}

void vispers(struct pn,struct pc,struct pricc){
	cout<<"la persona meno ricca si chiama "<<pn<<" "<<pc<<" ed ha "<<pricc<<" euro"<<endl<<endl;
}

string innv(int i){
	string nv;
	cout<<"inserisci il nome del "<<i<<" venditore: ";
	cin>>nv;
	return nv;
}

string inpos(int i){
	string pos;
	cout<<"inserisci la via del "<<i<<" venditore: ";
	cin>>pos;
	return pos;
}

int inada(int i){
	int ada;
	cout>>"inserisci l'anno di apertura del "<<i<<" venditore: ";
	cin>>ada;
	return ada;
}

string prov(int i){
	string prov;
	cout<<"inserisci la provincia del "<<i<<" venditore: ";
	cin>>prov;
	return prov;
}

void visven(struct vn,struct vpos,struct vada,struct vprov){
	cout<<"nome del venditore della provincia di foggia: "<<vn<<endl<<"si trova in: "<<vpos<<endl<<"anno di apertura: "<<vada<<endl<<prov<<endl<<endl;
}

int main(){
	int i;
	struct tel,pers,vend;
	i=1;
	tel.marca1=inmarca(i);
	tel.mod1=inmod(i);
	tel.adp1=inadp(i);
	tel.p1=inp(i);
	i++;
	tel.marca2=inmarca(i);
	tel.mod2=inmod(i);
	tel.adp2=inadp(i);
	tel.p2=inp(i);
	i++;
	tel.marca3=inmarca(i);
	tel.mod3=inmod(i);
	tel.adp3=inadp(i);
	tel.p3=inp(i);
	if(tel.p1>tel.p2&&tel.p1>tel.p3)
	vistel(tel.marca1,tel.mod1,tel.adp1,tel.p1);
	if(tel.p2>tel.p1&&tel.p2>tel.p3)
	vistel(tel.marca2,tel.mod2,tel.adp2,tel.p2);
	if(tel.p3>tel.p1&&tel.p3>tel.p2)
	vistel(tel.marca3,tel.mod3,tel.adp3,tel.p3);
	i=1;
	pers.n1=innome(i);
	pers.c1=inc(i);
	pers.ricc1=inricc(i);
	i++;
	pers.n2=innome(i);
	pers.c2=inc(i);
	pers.ricc2=inricc(i);
	i++;
	pers.n3=innome(i);
	pers.c3=inc(i);
	pers.ricc3=inricc(i);
	if(pers.ricc1<pers.ricc2&&pers.ricc1<pers.ricc3);
	vispers(pers.n1,pers.c1,pers.ricc1);
	if(pers.ricc2<pers.ricc1&&pers.ricc2<pers.ricc3);
	vispers(pers.n2,pers.c2,pers.ricc2);
	if(pers.ricc3<pers.ricc1&&pers.ricc3<pers.ricc2);
	vispers(pers.n3,pers.c3,pers.ricc3);
	i=1;
	vend.n1=innv(i);
	vend.pos1=inpos(i);
	vend.ada1=inada(i);
	vend.prov1=prov(i);
	i++;
	vend.n2=innv(i);
	vend.pos2=inpos(i);
	vend.ada2=inada(i);
	vend.prov2=prov(i);
	i++;
	vend.n3=innv(i);
	vend.pos3=inpos(i);
	vend.ada3=inada(i);
	vend.prov3=prov(i);
	if(vend.prov1=="fg"||vend.prov1=="Fg"||vend.prov1=="Foggia"||vend.prov1=="FOGGIA"||vend.prov1=="foggia");
	visven(vend.n1,vend.pos1,vend.ada1,vend.prov1);
	if(vend.prov2=="fg"||vend.prov2=="Fg"||vend.prov2=="Foggia"||vend.prov2=="FOGGIA"||vend.prov2=="foggia");
	visven(vend.n2,vend.pos2,vend.ada2,vend.prov2);
	if(vend.prov3=="fg"||vend.prov3=="Fg"||vend.prov3=="Foggia"||vend.prov3=="FOGGIA"||vend.prov3=="foggia");
	visven(vend.n3,vend.pos3,vend.ada3,vend.prov3);
}
