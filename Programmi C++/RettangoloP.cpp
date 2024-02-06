#include <iostream>
using namespace std;

class rettangolo{
    int vmq;
    float prett;

    public:
    void vernice(int pmq){
        int mq;
        cout<<"Inserisci la superficie in mq del rettangolo da verniciare"<<endl;
        cin>>mq;
        prett=pmq*mq;
    }

    void ins(){
        cout<<"Inserisci il prezzo della vernice al mq"<<endl;
        cin>>vmq;
    }

    int get_vmq(){
        return vmq;
    }

    int menu(){
        int op;
        cout<<"-----MENU-----\n1) Calcola costo superficie rettangolo\n2) Calcola costo superficie parallelepipedo\n0) Esci dal programma:\n";
        cin>>op;
        return op;
    }

    void vis(){
        cout<<"----RETTANGOLO----\nPrezzo tot="<<prett<<"\n\n"<<endl;
    }
};

class parallelepipedo
{
private:
    int vmq1,vmq2,ppar;
public:
    int get_vmq1(){
        return vmq1;
    }

    int get_vmq2(){
        return vmq2;
    }

    void ins(){
        cout<<"Inserisci il prezzo della vernice al mq"<<endl;
        cin>>vmq1;
        cout<<"Inserisci il prezzo dell'altra vernice al mq"<<endl;
        cin>>vmq2;
    }

    void vernice(int pmq,int pmq2){
        int mq,mq2;
        cout<<"Inserisci la superficie in mq del parallelepipedo da verniciare:"<<endl;
        cin>>mq;
        ppar=pmq*mq;
        cout<<"Inserisci dell'altra superficie in mq del parallelepipedo da verniciare:"<<endl;
        cin>>mq2;
        ppar+=pmq2*mq2;
    }

    void vis(){
        cout<<"----PARALLELEPIPEDO----\nPrezzo tot="<<ppar<<"\n\n";
    }
};

int main(){
    int op;
    rettangolo r;
    parallelepipedo p;
    do{
        op=r.menu();
        switch(op){
            case 1:
                r.ins();
                r.vernice(r.get_vmq());
                r.vis();
                break;
            case 2:
                p.ins();
                p.vernice(p.get_vmq1(),p.get_vmq2());
                p.vis();
                break;
        }
    }while(op!=0);
}