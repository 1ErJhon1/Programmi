import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 4A
 */
public class Finestra extends javax.swing.JFrame {
    String filecredenziali="FileCredenziali";
    String nomefile="NuovoFile.txt";
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    Object[] nomicolonne=new Object[]{
        "n. treno","compagnia t.","data partenza","citta' partenza","citta' arrivo","p. orario","tempo percorso","a. orario","n. b. economy disp.","prezzo b. economy","n. b. classe 2 disp.","prezzo b. classe 2","n. b. classe 1 disp.","prezzo b. classe 1"
    };
    DefaultTableModel dtm1=new DefaultTableModel(nomicolonne, 0);
    DefaultTableModel dtm2=new DefaultTableModel(nomicolonne, 0);
    Date datasistema=new Date();
    /**
     * Creates new form Finestra
     */
    
    public void logineff(){
        jTabbedPane1.setEnabledAt(2, true);
    }
    
    private void aggiornaQuantitaBiglietti(int rigaSelezionata, int quantitaPrenotata) {
    String numeroTreno = dtm2.getValueAt(rigaSelezionata, 0).toString();
    int indiceTipoBiglietto = switch (jComboBox1.getSelectedIndex()) {
        case 0 -> 8; 
        case 1 -> 10; 
        case 2 -> 12; 
        default -> -1; 
    };

    // Verifica se l'indice della colonna è valido
    if (indiceTipoBiglietto < 0 || indiceTipoBiglietto >= dtm1.getColumnCount()) {
        System.err.println("Indice della colonna non valido: " + indiceTipoBiglietto);
        return;
    }

    // Ottieni il valore della quantità disponibile dalla tabella
    Object quantitaDisponibileObj = dtm1.getValueAt(rigaSelezionata, indiceTipoBiglietto);

    // Controlla se il valore è null
    if (quantitaDisponibileObj == null) {
        System.err.println("Valore della quantità disponibile null alla riga: " + rigaSelezionata + ", colonna: " + indiceTipoBiglietto);
        return;
    }

    // Converte il valore della quantità disponibile in un intero
    int quantitaDisponibile;
    try {
        quantitaDisponibile = Integer.parseInt(quantitaDisponibileObj.toString());
    } catch (NumberFormatException e) {
        System.err.println("Impossibile convertire il valore della quantità disponibile in un intero alla riga: " + rigaSelezionata + ", colonna: " + indiceTipoBiglietto);
        return;
    }

    // Calcola la nuova quantità disponibile
    int nuovaQuantita = quantitaDisponibile - quantitaPrenotata;

    System.out.println("Numero treno: " + numeroTreno);
    System.out.println("Indice tipo biglietto: " + indiceTipoBiglietto);
    System.out.println("Quantità disponibile prima: " + quantitaDisponibile);
    System.out.println("Quantità prenotata: " + quantitaPrenotata);
    System.out.println("Nuova quantità: " + nuovaQuantita);

    // Aggiorna la tabella con la nuova quantità
    dtm1.setValueAt(nuovaQuantita, rigaSelezionata, indiceTipoBiglietto);

    // Aggiorna il file con la nuova quantità
    try {
        List<String> lines = Files.readAllLines(Paths.get(nomefile));
        int indiceRigaFile = rigaSelezionata * 14 + indiceTipoBiglietto - 1;
        lines.set(indiceRigaFile, Integer.toString(nuovaQuantita));
        Files.write(Paths.get(nomefile), lines);
        System.out.println("Quantità disponibile dopo: " + nuovaQuantita);
    } catch (IOException ex) {
        Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    private void aggiornatab() {
        Object[][] dati = leggiDatiDaFile(nomefile);
        dtm1.setRowCount(0);
        for (Object[] row : dati) {
            dtm1.addRow(row);
        }
    }

    private Object[][] leggiDatiDaFile(String nomefile) {
        List<Object[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomefile))) {
            String line;
            List<Object> rowData = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    rowData.add(line);
                } else {
                    data.add(rowData.toArray());
                    rowData.clear();
                }
            }
            if (!rowData.isEmpty()) {
                data.add(rowData.toArray());
            }
        } catch (IOException ex) {
            Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data.toArray(new Object[0][]);
    }

        private String calcolaDifferenzaOrari(String ora1String, String ora2String) {
        LocalTime ora1 = LocalTime.parse(ora1String);
        LocalTime ora2 = LocalTime.parse(ora2String);
        long differenzaInMinuti = ChronoUnit.MINUTES.between(ora1, ora2);
        long ore = Math.abs(differenzaInMinuti) / 60;
        long minuti = Math.abs(differenzaInMinuti) % 60;
        return String.format("%02d:%02d", ore, minuti);
    }

    public Finestra() {
        initComponents();
        jDateChooser2.setMinSelectableDate(datasistema);
        dateinspart.setMinSelectableDate(datasistema);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        jTabbedPane1.setEnabledAt(4, false);
        try {
            Files.createFile(Paths.get(filecredenziali));
        } catch (IOException ex) {
            Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Files.createFile(Paths.get(nomefile));
                    } catch (IOException ex) {
            Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
            for(int i=0;i<24;i++){
                cbxhhins.addItem(String.format("%02d", i));
            }
            for(int i=0;i<60;i++){
                cbxmmins.addItem(String.format("%02d", i));
            }
            for(int i=0;i<24;i++){
                cbxhharrins.addItem(String.format("%02d", i));
            }
            for(int i=0;i<60;i++){
                cbxmmarrins.addItem(String.format("%02d", i));
            }
        }
        Tabellone.setModel(dtm1);
        Tabellonericerca.setModel(dtm2);
        aggiornatab();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabellone = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtpart = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtarrivo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spinadulti = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spinragazzi = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtntrenoins = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcomptins = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtinspartt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtarrivotins = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        spinbeconomy = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        spinb2cl = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        spinb1cl = new javax.swing.JSpinner();
        dateinspart = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxhhins = new javax.swing.JComboBox<>();
        cbxmmins = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbxhharrins = new javax.swing.JComboBox<>();
        cbxmmarrins = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        spinprzecins = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        spinprz2clins = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        spinprz1clins = new javax.swing.JSpinner();
        btninst = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabellonericerca = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        lblerrore = new javax.swing.JLabel();
        btnerrore = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblprezzo = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trenitalia_logo.png"))); // NOI18N

        jScrollPane1.setViewportView(Tabellone);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabellone", jPanel2);

        jLabel2.setText("Da dove parti?");

        jLabel3.setText("Dove vuoi arrivare?");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trasferire-le-frecce-sinistra-e-.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Quando vuoi partire?");

        jLabel5.setText("Quanti adulti?");

        jLabel6.setText("Quanti ragazzi?");

        jButton3.setText("Cerca treni");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "2 classe", "1 classe" }));

        jLabel23.setText("Servizio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtpart, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(spinadulti, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23)
                                .addGap(67, 67, 67)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinragazzi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtarrivo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jButton3)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtpart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtarrivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinadulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spinragazzi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("accatt u bigliett", jPanel1);

        jLabel7.setText("Numero treno");

        txtntrenoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtntrenoinsActionPerformed(evt);
            }
        });

        jLabel8.setText("Compagnia Treno");

        txtcomptins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcomptinsActionPerformed(evt);
            }
        });

        jLabel9.setText("Quando parte?");

        jLabel11.setText("Dove parte?");

        jLabel13.setText("Dove arriva?");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trasferire-le-frecce-sinistra-e-.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("n. biglietti economy?");

        jLabel12.setText("n. biglietti 2° classe?");

        jLabel14.setText("n. biglietti 1° classe?");

        jLabel15.setText("hh");

        jLabel16.setText("mm");

        jLabel17.setText("hh");

        jLabel18.setText("mm");

        jLabel19.setText("Arrivo");

        jLabel20.setText("Prezzo");

        jLabel21.setText("Prezzo");

        jLabel22.setText("Prezzo");

        btninst.setText("Inserisci");
        btninst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtntrenoins, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(dateinspart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtinspartt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(spinbeconomy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(32, 32, 32))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(jLabel20)
                                    .addGap(49, 49, 49)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel22)
                                .addGap(49, 49, 49)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinprz1clins)
                            .addComponent(spinb1cl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(spinprzecins, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(93, 93, 93)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtarrivotins, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txtcomptins))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxhhins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxmmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxhharrins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxmmarrins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(164, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btninst)
                                    .addComponent(jLabel21))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinprz2clins)
                            .addComponent(spinb2cl, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(txtcomptins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel13)
                                .addComponent(txtarrivotins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtntrenoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtinspartt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(spinbeconomy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dateinspart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(cbxhhins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxmmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(cbxhharrins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxmmarrins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(spinb2cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(spinprzecins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(spinb1cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(spinprz1clins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btninst))))
                    .addComponent(spinprz2clins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserimento Treno", jPanel3);

        Tabellonericerca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Tabellonericerca);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("Seleziona il treno da prenotare:");

        lblerrore.setForeground(new java.awt.Color(255, 51, 51));
        lblerrore.setText("Non ci sono treni con queste impostazioni torna alla schermata di ricerca");

        btnerrore.setText("torna alla ricerca");
        btnerrore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnerroreActionPerformed(evt);
            }
        });

        jButton5.setText("Acquista biglietti");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnerrore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(120, 120, 120))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblerrore)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblerrore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnerrore)
                    .addComponent(jButton5))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tabellone ricerca", jPanel4);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Numero treno");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Compagnia treno");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Data partenza");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("jLabel28");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("jLabel29");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("jLabel30");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Citta' partenza");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Citta' destinazione");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Orario arrivo");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("quantita' biglietti adulti");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("jLabel35");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("quantita' biglietti ragazzi");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("jLabel37");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("jLabel38");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("jLabel39");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("jLabel40");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel41.setText("Controlla ordine");

        lblprezzo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblprezzo.setText("Prezzo totale 00.00$");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Tempo percorso");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Servizio");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("jLabel44");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("jLabel45");

        jButton4.setText("Acquista");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel46.setText("Orario partenza");

        jLabel47.setText("jLabel47");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel43))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30)))
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel44))
                                .addGap(44, 44, 44)))
                        .addGap(177, 177, 177)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprezzo)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jButton4)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel41)
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28)
                    .addComponent(jLabel31)
                    .addComponent(jLabel40))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29)
                    .addComponent(jLabel32)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel30)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jLabel38))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel35)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(jLabel37))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel44)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(lblprezzo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(152, 152, 152))
        );

        jTabbedPane1.addTab("Acquisto", jPanel5);

        jLabel48.setText("Sei un operatore ferroviario?");

        jButton6.setText("Effettua il login");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jLabel48))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String app;
        app=txtarrivo.getText();
        txtarrivo.setText(txtpart.getText());
        txtpart.setText(app);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtntrenoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtntrenoinsActionPerformed
       
    }//GEN-LAST:event_txtntrenoinsActionPerformed

    private void txtcomptinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcomptinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcomptinsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String app;
        app=txtinspartt.getText();
        txtinspartt.setText(txtarrivotins.getText());
        txtarrivotins.setText(app);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btninstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninstActionPerformed
        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomefile, true))) {
                bw.newLine();
                bw.write(txtntrenoins.getText());
                bw.newLine();
                bw.write(txtcomptins.getText().substring(0, 1).toUpperCase()+txtcomptins.getText().substring(0));
                bw.newLine();
                bw.write(sdf.format(dateinspart.getDate()));
                bw.newLine();
                bw.write(txtinspartt.getText().substring(0, 1).toUpperCase()+txtinspartt.getText().substring(0));
                bw.newLine();
                bw.write(txtarrivotins.getText().substring(0, 1).toUpperCase()+txtarrivotins.getText().substring(0));
                bw.newLine();
                bw.write((cbxhhins.getSelectedItem().toString())+":"+(cbxmmins.getSelectedItem().toString()));
                bw.newLine();
                bw.write(calcolaDifferenzaOrari((cbxhharrins.getSelectedItem().toString())+":"+(cbxmmarrins.getSelectedItem().toString()), (cbxhhins.getSelectedItem().toString())+":"+(cbxmmins.getSelectedItem().toString())));
                bw.newLine();
                bw.write((cbxhharrins.getSelectedItem().toString())+":"+(cbxmmarrins.getSelectedItem().toString()));
                bw.newLine();
                bw.write(spinbeconomy.getValue().toString());
                bw.newLine();
                bw.write(spinprzecins.getValue().toString());
                bw.newLine();
                bw.write(spinb2cl.getValue().toString());
                bw.newLine();
                bw.write(spinprz2clins.getValue().toString());
                bw.newLine();
                bw.write(spinb1cl.getValue().toString());
                bw.newLine();
                bw.write(spinprz1clins.getValue().toString());
                bw.newLine();
            }
            aggiornatab();
        } catch (IOException ex) {
            Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtcomptins.setText("");
        txtntrenoins.setText("");
        txtinspartt.setText("");
        txtarrivotins.setText("");
        dateinspart.setDate(null);
        cbxhhins.setSelectedIndex(0);
        cbxmmins.setSelectedIndex(0);
        cbxhharrins.setSelectedIndex(0);
        cbxmmarrins.setSelectedIndex(0);
        spinbeconomy.setValue(0);
        spinprzecins.setValue(0);
        spinprz2clins.setValue(0);
        spinprz1clins.setValue(0);
        spinb2cl.setValue(0);
        spinb1cl.setValue(0);
    }//GEN-LAST:event_btninstActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dtm2.setRowCount(0);
        int nbigl = Integer.valueOf(spinadulti.getValue().toString()) + Integer.valueOf(spinragazzi.getValue().toString());
        int colonnaserv = switch (jComboBox1.getSelectedIndex()) {
            case 0 -> 8;
            case 1 -> 10;
            case 2 -> 12;
            default -> 2;
        };

        for (int i = 0; i < dtm1.getRowCount(); i++) {
            try {
                Object partenza = dtm1.getValueAt(i, 3);
                Object arrivo = dtm1.getValueAt(i, 4);
                Object data = dtm1.getValueAt(i, 2);
                Object servizio = dtm1.getValueAt(i, colonnaserv);

                if (partenza != null && arrivo != null && data != null && servizio != null &&
                    txtpart.getText().equalsIgnoreCase(partenza.toString()) &&
                    txtarrivo.getText().equalsIgnoreCase(arrivo.toString())) {

                    Date dataParsed = sdf.parse(data.toString());
                    if (!jDateChooser2.getDate().after(dataParsed) && nbigl <= Integer.parseInt(servizio.toString())) {
                        Object[] rowData = new Object[dtm1.getColumnCount()];
                        for (int j = 0; j < dtm1.getColumnCount(); j++) {
                            rowData[j] = dtm1.getValueAt(i, j);
                        }
                        dtm2.addRow(rowData);
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                Logger.getLogger(Finestra.class.getName()).log(Level.SEVERE, "Errore di conversione del numero di biglietti", ex);
            }
        }
        jTabbedPane1.setSelectedIndex(3);
        
        if(dtm2.getRowCount()==0){
            lblerrore.setVisible(true);
            btnerrore.setVisible(true);
        }else{
            lblerrore.setVisible(false);
            btnerrore.setVisible(false);
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnerroreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnerroreActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnerroreActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int scelta=JOptionPane.showConfirmDialog(null, "Vuoi confermare l'acquisto?\noppure verrai reindirizzato al tabellone di ricerca");
    if(scelta==JOptionPane.YES_OPTION){
        // Ottieni la riga selezionata nella tabella dtm2
        int rigaSelezionata = Tabellonericerca.getSelectedRow();
        // Ottieni la quantità di biglietti prenotata
        int quantitaPrenotata = Integer.parseInt(spinadulti.getValue().toString()) + Integer.parseInt(spinragazzi.getValue().toString());
        // Aggiorna la quantità dei biglietti disponibili
        aggiornaQuantitaBiglietti(rigaSelezionata, quantitaPrenotata);
        // Uscita dall'applicazione
        System.exit(0);
    } else {
        jTabbedPane1.setSelectedIndex(3);
    }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        int riga=Tabellonericerca.getSelectedRow();
        jLabel28.setText(dtm2.getValueAt(riga, 0).toString());
        jLabel29.setText(dtm2.getValueAt(riga, 1).toString());
        jLabel30.setText(dtm2.getValueAt(riga, 2).toString());
        jLabel40.setText(dtm2.getValueAt(riga, 3).toString());
        jLabel39.setText(dtm2.getValueAt(riga, 4).toString());
        jLabel47.setText(dtm2.getValueAt(riga, 5).toString());
        jLabel38.setText(dtm2.getValueAt(riga, 7).toString());
        jLabel44.setText(dtm2.getValueAt(riga, 6).toString());
        jLabel45.setText(jComboBox1.getSelectedItem().toString());
        jLabel35.setText(spinadulti.getValue().toString());
        jLabel37.setText(spinragazzi.getValue().toString());
        float pb=0;
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                pb=Float.valueOf(dtm2.getValueAt(riga, 9).toString());
                break;
            case 1:
                pb=Float.valueOf(dtm2.getValueAt(riga, 11).toString());
                break;
            case 2:
                pb=Float.valueOf(dtm2.getValueAt(riga, 13).toString());
                break;
        }
        Float prz=(Float.valueOf(spinadulti.getValue().toString())+Float.valueOf(spinragazzi.getValue().toString()))*pb;
        lblprezzo.setText("Prezzo totale "+prz+"€");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        Login log=new Login();
//        log.setVisible(true);
        jTabbedPane1.setEnabledAt(2, true);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finestra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabellone;
    private javax.swing.JTable Tabellonericerca;
    private javax.swing.JButton btnerrore;
    private javax.swing.JButton btninst;
    private javax.swing.JComboBox<String> cbxhharrins;
    private javax.swing.JComboBox<String> cbxhhins;
    private javax.swing.JComboBox<String> cbxmmarrins;
    private javax.swing.JComboBox<String> cbxmmins;
    private com.toedter.calendar.JDateChooser dateinspart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblerrore;
    private javax.swing.JLabel lblprezzo;
    private javax.swing.JSpinner spinadulti;
    private javax.swing.JSpinner spinb1cl;
    private javax.swing.JSpinner spinb2cl;
    private javax.swing.JSpinner spinbeconomy;
    private javax.swing.JSpinner spinprz1clins;
    private javax.swing.JSpinner spinprz2clins;
    private javax.swing.JSpinner spinprzecins;
    private javax.swing.JSpinner spinragazzi;
    private javax.swing.JTextField txtarrivo;
    private javax.swing.JTextField txtarrivotins;
    private javax.swing.JTextField txtcomptins;
    private javax.swing.JTextField txtinspartt;
    private javax.swing.JTextField txtntrenoins;
    private javax.swing.JTextField txtpart;
    // End of variables declaration//GEN-END:variables
}
