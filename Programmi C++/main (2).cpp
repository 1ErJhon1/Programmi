#include <iostream>

using namespace std;

int main() {
    string pizza,bev,dolce;
    int npiz,nbev,pbev,ndolce,pdolce;
    float ppiz,ptot,bi,resto;
    
    cout << "Salve benvenuti nella nuova pizzeria foggiana" << endl;
    cout << "Abbiamo pizza marinara, margherita, diavola, capricciosa scrivi quale vuoi" << endl;
    cin >> pizza;
    if (pizza == "marinara") {
        cout << "il prezzo di ogni marinara e' di 3.50 euro" << endl;
        cout << "quante ne vuoi?" << endl;
        cin >> npiz;
        ppiz = 3.50 * npiz;
    } else {
        if (pizza == "margherita") {
            cout << "il prezzo di ogni margherita e' di 4 euro" << endl;
            cout << "quante ne vuoi?" << endl;
            cin >> npiz;
            ppiz = 4 * npiz;
        } else {
            if (pizza == "diavola") {
                cout << "il prezzo di ogni diavola e' di 6 euro" << endl;
                cout << "quante ne vuoi?" << endl;
                cin >> npiz;
                ppiz = 6 * npiz;
            } else {
                cout << "il prezzo di ogni capricciosa e' di 7 euro" << endl;
                cout << "quante ne vuoi?" << endl;
                cin >> npiz;
                ppiz = 7 * npiz;
            }
        }
    }
    cout << "da bere abbiamo acqua e Coca Cola" << endl;
    cout << "scrivi cosa vuoi" << endl;
    cin >> bev;
    if (bev == "acqua") {
        cout << "il prezzo di ogni bottiglia e' di 1 euro" << endl;
        cout << "quante bottiglie vuoi?" << endl;
        cin >> nbev;
        pbev = 1 * nbev;
    } else {
        cout << "Il prezzo di ogni lattina di Coca Cola e' di 2 euro" << endl;
        cout << "quante lattine vuoi?" << endl;
        cin >> nbev;
        pbev = 2 * nbev;
    }
    cout << "come dolci abbiamo la pizza con la nutella e il tiramisu'" << endl;
    cout << "scrivi cosa vuoi" << endl;
    cin >> dolce;
    if (dolce == "tiramisu'") {
        cout << "una porzione di tiramisu' costa 3 euro" << endl;
        cout << "quante porzioni vuoi?" << endl;
        cin >> ndolce;
        pdolce = 3 * ndolce;
    } else {
        cout << "una pizza con la nutella costa 5 euro" << endl;
        cout << "quante pizze vuoi?" << endl;
        cin >> ndolce;
        pdolce = 5 * ndolce;
    }
    ptot = ppiz + pbev + pdolce;
    cout << "il prezzo totale e' di ";
    cout << ptot;
    cout << " euro" << endl;
    cout << "digitare l'importo della banconota inserita" << endl;
    cin >> bi;
    if (bi == ptot) {
        cout << "ritirare lo scontrino e grazie per averci scelto" << endl;
    } else {
        resto = ptot - bi;
        cout << "Il resto e' di ";
        cout << resto;
        cout << " euro";
    }
    return 0;
}