#include <iostream>
#include <string>
using namespace std;

// Definizione del tipo record Dipendente
struct Dipendente {
  string nome;
  string cognome;
  string qualifica;
  string residenza;
  int stipendio;
  int figli;
};

// Prototipi delle funzioni
void caricaDipendenti(Dipendente[], int);
void stampaDipendenti(Dipendente[], int);
void stampaDipendentiCerignolaConStipendioMaggiore(Dipendente[], int, int);
int contaDipendentiConPiùDiDueFigli(Dipendente[], int);
int stipendioMaxProgrammatori(Dipendente[], int);

int main() {
  const int NUM_DIPENDENTI = 5;
  Dipendente dipendenti[NUM_DIPENDENTI];

  // Caricamento dei dipendenti
  caricaDipendenti(dipendenti, NUM_DIPENDENTI);

  // Stampa di tutti i dipendenti
  cout << "Elenco di tutti i dipendenti:" << endl;
  stampaDipendenti(dipendenti, NUM_DIPENDENTI);

  // Stampa dei dipendenti residenti a Cerignola con stipendio maggiore di un dato valore inserito in input
  int stipendioMinimo;
  cout << "Inserisci lo stipendio minimo desiderato: ";
  cin >> stipendioMinimo;
  cout << "Elenco dei dipendenti residenti a Cerignola con stipendio maggiore di " << stipendioMinimo << ":" << endl;
  stampaDipendentiCerignolaConStipendioMaggiore(dipendenti, NUM_DIPENDENTI, stipendioMinimo);

  // Conteggio dei dipendenti con più di due figli
  int numDipendentiConPiùDiDueFigli = contaDipendentiConPiùDiDueFigli(dipendenti, NUM_DIPENDENTI);
  cout << "Ci sono " << numDipendentiConPiùDiDueFigli << " dipendenti con più di due figli." << endl;

  // Stipendio massimo tra i programmatori
  int stipendioMaxProgrammatore = stipendioMaxProgrammatori(dipendenti, NUM_DIPENDENTI);
  cout << "Lo stipendio massimo tra i programmatori è " << stipendioMaxProgrammatore << "." << endl;

  return 0;
}

// Funzione per il caricamento dei dipendenti
void caricaDipendenti(Dipendente dipendenti[], int numDipendenti) {
  for (int i = 0; i < numDipendenti; i++) {
    cout << "Inserisci i dati del dipendente " << i+1 << ":" << endl;
    cout << "Nome: ";
    cin >> dipendenti[i].nome;
    cout << "Cognome: ";
    cin >> dipendenti[i].cognome;
    cout << "Qualifica: ";
    cin >> dipendenti[i].qualifica;
    cout << "Residenza: ";
    cin >> dipendenti[i].residenza;
    cout << "Stipendio: ";
    cin >> dipendenti[i].

