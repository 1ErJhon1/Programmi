#include <iostream>
#include <vector>

using namespace std;

// Funzione per caricare una matrice da input utente
void caricaMatrice(vector<vector<int>>& matrix, int numRows, int numCols) {
    cout << "Inserisci gli elementi della matrice:" << endl;
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            cin >> matrix[i][j];
        }
    }
}

// Funzione per visualizzare la matrice
void visualizzaMatrice(const vector<vector<int>>& matrix, int numRows, int numCols) {
    cout << "Matrice inserita:" << endl;
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}

// Funzione per calcolare il massimo per riga
void massimoPerRiga(const vector<vector<int>>& matrix, int numRows, int numCols) {
    cout << "Massimo per riga:" << endl;
    for (int i = 0; i < numRows; i++) {
        int maxVal = matrix[i][0];
        for (int j = 1; j < numCols; j++) {
            if (matrix[i][j] > maxVal) {
                maxVal = matrix[i][j];
            }
        }
        cout << "Riga " << i << ": " << maxVal << endl;
    }
}

// Funzione per calcolare il massimo per colonna
void massimoPerColonna(const vector<vector<int>>& matrix, int numRows, int numCols) {
    cout << "Massimo per colonna:" << endl;
    for (int j = 0; j < numCols; j++) {
        int maxVal = matrix[0][j];
        for (int i = 1; i < numRows; i++) {
            if (matrix[i][j] > maxVal) {
                maxVal = matrix[i][j];
            }
        }
        cout << "Colonna " << j << ": " << maxVal << endl;
    }
}

// Funzione per trovare il minimo degli elementi della matrice
int minimoMatrice(const vector<vector<int>>& matrix, int numRows, int numCols) {
    int minVal = matrix[0][0];
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            if (matrix[i][j] < minVal) {
                minVal = matrix[i][j];
            }
        }
    }
    return minVal;
}

// Funzione per calcolare la media per colonna
void mediaPerColonna(const vector<vector<int>>& matrix, int numRows, int numCols) {
    cout << "Medie delle colonne:" << endl;
    for (int j = 0; j < numCols; j++) {
        double columnSum = 0.0;
        for (int i = 0; i < numRows; i++) {
            columnSum += matrix[i][j];
        }
        double columnAverage = columnSum / numRows;
        cout << "Colonna " << j << ": " << columnAverage << endl;
    }
}

int main() {
    int numRows, numCols;

    cout << "Inserisci il numero di righe della matrice: ";
    cin >> numRows;

    cout << "Inserisci il numero di colonne della matrice: ";
    cin >> numCols;

    // Dichiarazione e allocazione della matrice
    vector<vector<int>> matrix(numRows, vector<int>(numCols));

    // Carica la matrice da input utente
    caricaMatrice(matrix, numRows, numCols);

    // Visualizza la matrice
    visualizzaMatrice(matrix, numRows, numCols);

    // Calcola e visualizza il massimo per riga
    massimoPerRiga(matrix, numRows, numCols);

    // Calcola e visualizza il massimo per colonna
    massimoPerColonna(matrix, numRows, numCols);

    // Trova e visualizza il minimo degli elementi della matrice
    int minVal = minimoMatrice(matrix, numRows, numCols);
    cout << "Il valore minimo nella matrice è: " << minVal << endl;

    // Calcola e visualizza la media per colonna
    mediaPerColonna(matrix, numRows, numCols);

    return 0;
}
