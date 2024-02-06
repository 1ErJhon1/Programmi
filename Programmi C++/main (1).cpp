#include <iostream>

using namespace std;

int main() {
   int num1,num2,num3,max,sec,min;
    
    cout << "Inserisci un numero" << endl;
    cin >> num1;
    cout << "Inserisci un numero" << endl;
    cin >> num2;
    cout << "Inserisci un numero" << endl;
    cin >> num3;
    if (num1 > num2) {
        if (num1 > num3) {
            max = num1;
        } else {
            sec = num1;
        }
    } else {
        if (num1 > num3) {
            sec = num1;
        } else {
            min = num1;
        }
    }
    if (num2 > num1) {
        if (num2 > num3) {
            max = num2;
        } else {
            sec = num2;
        }
    } else {
        if (num2 > num3) {
            sec = num2;
        } else {
            min = num2;
        }
    }
    if (num3 > num2) {
        if (num3 > num1) {
            max = num3;
        } else {
            sec = num3;
        }
    } else {
        if (num3 > num1) {
            sec = num3;
        } else {
            min = num3;
        }
    }
    cout << "il numero maggiore e': ";
    cout << max << endl;
    cout << "il numero minore e': ";
    cout << min;
    return 0;
}
