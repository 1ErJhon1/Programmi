#include <iostream>
using namespace std;
int main() {
    string nm;
    string cgm;
    int cap;
    double abb;
    int dist;
    string mezzo;
    double rimb;
    
    cout << "Inserire il nome dello studente" << endl;
    cin >> nm;
    cout << "Inserire il cognome dello studente" << endl;
    cin >> cgm;
    cout << "Inserire il prezzo dell'abbonamento" << endl;
    cin >> abb;
    cout << "Inserirre il CAP del tuo paese/citta'" << endl;
    cin >> cap;
    if (cap != 71122 || cap != 71121) {
        cout << "Quanti chilometri e' lontana la scuola?" << endl;
        cin >> dist;
        if (dist >= 20) {
            cout << "Che mezzo usi per andare a scuola, autobus o treno?" << endl;
            cin >> mezzo;
            if (mezzo == "autobus" || mezzo == "Autobus" || mezzo == "AUTOBUS") {
                rimb = abb * 15 / 100;
            } else {
                if (mezzo == "treno" || mezzo == "Treno" || mezzo == "TRENO") {
                    rimb = abb * 10 / 100;
                }
            }
        }
        cout << "Nome: ";
        cout << nm;
        cout << "  Cognome: ";
        cout << cgm << endl;
        cout << "Il rimborso e' di euro: ";
        cout << rimb << endl;
    }
    return 0;
}