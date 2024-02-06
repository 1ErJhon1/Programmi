#include <iostream>
using namespace std;
int main() {
    
    double var1,var2,ptot,psg;
    int peso,pcons;
    string dest,cg;
    
    cout << "scrivi il peso del pacco in kg" << endl;
    cin >> peso;
    pcons = 10;
    if (10 < peso && peso <= 20) {
        var1 = peso - 10;
        var2 = var1 * 0.5;
        pcons = (int) (pcons + var2);
    } else {
        if (peso > 20) {
            pcons = peso * 2;
        }
    }
    cout << "Qual'e' la destinazione?" << endl;
    cin >> dest;
    if (dest == "milano" || dest == "Milano" || dest == "MILANO") {
        pcons = pcons + 5;
    } else {
        if (dest == "roma" || dest == "Roma" || dest == "ROMA") {
            pcons = pcons + 10;
        } else {
            if (dest == "torino" || dest == "Torino" || dest == "TORINO") {
                pcons = pcons + 7;
            }
        }
    }
    cout << "se vuoi la consegna di 1 giorno scrivi si altrimenti scrivi no" << endl;
    cin >> cg;
    if (cg == "si" || cg == "Si" || cg == "SI") {
        psg = (double) (pcons * 12) / 100;
        ptot = pcons + psg;
    } else {
        ptot = pcons;
    }
    cout << "Il prezzo totale e' di ";
    cout << ptot;
    cout << " euro";
    return 0;
}