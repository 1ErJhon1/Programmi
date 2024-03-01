
import javax.swing.DefaultComboBoxModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Jhon
 */
public class NewJFrame extends javax.swing.JFrame {

    DefaultComboBoxModel<String> dcbm=new DefaultComboBoxModel<>();

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
    
    private void initializeData() {
        Regione[] regioni = {
            new Regione("Abruzzo", 1311580),
            new Regione("Basilicata", 562869),
            new Regione("Calabria", 1947131),
            new Regione("Campania", 5801692),
            new Regione("Emilia-Romagna", 4467118),
            new Regione("Friuli-Venezia Giulia", 1215220),
            new Regione("Lazio", 5879082),
            new Regione("Liguria", 1550640),
            new Regione("Lombardia", 10060574),
            new Regione("Marche", 1525271),
            new Regione("Molise", 305617),
            new Regione("Piemonte", 4356406),
            new Regione("Puglia", 4029053),
            new Regione("Sardegna", 1653135),
            new Regione("Sicilia", 4999891),
            new Regione("Toscana", 4999487),
            new Regione("Trentino-Alto Adige", 1067689),
            new Regione("Umbria", 882015),
            new Regione("Valle d'Aosta", 125666),
            new Regione("Veneto", 4907704)
        };

        String[][] province = {
            {"L'Aquila", "Teramo", "Pescara", "Chieti"}, // Abruzzo
            {"Potenza", "Matera"}, // Basilicata
            {"Catanzaro", "Cosenza", "Reggio Calabria", "Crotone", "Vibo Valentia"}, // Calabria
            {"Napoli", "Avellino", "Benevento", "Caserta", "Salerno"}, // Campania
            {"Bologna", "Modena", "Ferrara", "Parma", "Reggio Emilia", "Ravenna", "Forlì-Cesena", "Piacenza", "Rimini"}, // Emilia-Romagna
            {"Trieste", "Gorizia", "Udine", "Pordenone"}, // Friuli-Venezia Giulia
            {"Roma", "Viterbo", "Latina", "Frosinone", "Rieti"}, // Lazio
            {"Genova", "Imperia", "La Spezia", "Savona"}, // Liguria
            {"Milano", "Bergamo", "Brescia", "Como", "Cremona", "Lecco", "Lodi", "Mantova", "Monza e Brianza", "Pavia", "Sondrio", "Varese"}, // Lombardia
            {"Ancona", "Pesaro e Urbino", "Macerata", "Fermo", "Ascoli Piceno"}, // Marche
            {"Campobasso", "Isernia"}, // Molise
            {"Torino", "Cuneo", "Asti", "Alessandria", "Novara", "Biella", "Verbano-Cusio-Ossola", "Vercelli"}, // Piemonte
            {"Bari", "Taranto", "Foggia", "Brindisi", "Lecce", "Barletta-Andria-Trani"}, // Puglia
            {"Cagliari", "Sassari", "Nuoro", "Oristano", "Olbia-Tempio", "Medio Campidano", "Carbonia-Iglesias", "Ogliastra"}, // Sardegna
            {"Palermo", "Catania", "Messina", "Siracusa", "Ragusa", "Trapani"}, // Sicilia
            {"Firenze", "Prato", "Pistoia", "Livorno", "Lucca", "Pisa", "Arezzo", "Siena", "Grosseto"}, // Toscana
            {"Trento", "Bolzano"}, // Trentino-Alto Adige
            {"Perugia", "Terni"}, // Umbria
            {"Aosta"}, // Valle d'Aosta
            {"Verona", "Vicenza", "Belluno", "Padova", "Treviso", "Venezia", "Rovigo"} // Veneto
        };

        for (int i = 0; i < regioni.length; i++) {
            dcbm.addElement(regioni[i].getNome());
            String[] provinceRegione = getProvince(regioni[i].getNome(), province);
            for (int j = 0; j < provinceRegione.length; j++) {
                dcbm.addElement("  " + provinceRegione[j]);
            }
        }
        cbxreg.setModel(dcbm);
    }

    private String[] getProvince(String regione, String[][] province) {
        switch (regione) {
            case "Abruzzo":
                return province[0];
            case "Basilicata":
                return province[1];
            case "Calabria":
                return province[2];
            case "Campania":
                return province[3];
            case "Emilia-Romagna":
                return province[4];
            case "Friuli-Venezia Giulia":
                return province[5];
            case "Lazio":
                return province[6];
            case "Liguria":
                return province[7];
            case "Lombardia":
                return province[8];
            case "Marche":
                return province[9];
            case "Molise":
                return province[10];
            case "Piemonte":
                return province[11];
            case "Puglia":
                return province[12];
            case "Sardegna":
                return province[13];
            case "Sicilia":
                return province[14];
            case "Toscana":
                return province[15];
            case "Trentino-Alto Adige":
                return province[16];
            case "Umbria":
                return province[17];
            case "Valle d'Aosta":
                return province[18];
            case "Veneto":
                return province[19];
            default:
                return new String[0];
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxprov = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxreg = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxprov.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L'Aquila", "Teramo", "Pescara", "Chieti", "Potenza", "Matera", "Catanzaro", "Cosenza", "Reggio Calabria", "Crotone", "Vibo Valentia", "Napoli", "Avellino", "Benevento", "Caserta", "Salerno", "Bologna", "Ferrara", "Forlì-Cesena", "Modena", "Parma", "Piacenza", "Ravenna", "Reggio Emilia", "Rimini", "Udine", "Gorizia", "Trieste", "Pordenone", "Roma", "Frosinone", "Latina", "Rieti", "Viterbo", "Genova", "Imperia", "La Spezia", "Savona", "Milano", "Bergamo", "Brescia", "Como", "Cremona", "Lecco", "Lodi", "Mantova", "Monza e Brianza", "Pavia", "Sondrio", "Varese", "Ancona", "Ascoli Piceno", "Fermo", "Macerata", "Pesaro e Urbino", "Campobasso", "Isernia", "Torino", "Alessandria", "Asti", "Biella", "Cuneo", "Novara", "Verbano-Cusio-Ossola", "Vercelli", "Bari", "Barletta-Andria-Trani", "Brindisi", "Foggia", "Lecce", "Taranto", "Cagliari", "Nuoro", "Oristano", "Sassari", "Sud Sardegna", "Agrigento", "Caltanissetta", "Catania", "Enna", "Messina", "Palermo", "Ragusa", "Siracusa", "Trapani", "Arezzo", "Firenze", "Grosseto", "Livorno", "Lucca", "Massa-Carrara", "Pisa", "Pistoia", "Prato", "Siena", "Trento", "Bolzano", "Perugia", "Terni", "Aosta", "Belluno", "Padova", "Rovigo", "Treviso", "Venezia", "Verona", "Vicenza" }));
        cbxprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxprovActionPerformed(evt);
            }
        });

        jLabel1.setText("Scegli la provincia");

        jLabel2.setText("Scegli la regione");

        cbxreg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abruzzo", "Basilicata", "Calabria", "Campania", "Emilia-Romagna", "Friuli-Venezia Giulia", "Lazio", "Liguria", "Lombardia", "Marche", "Molise", "Piemonte", "Puglia", "Sardegna", "Sicilia", "Toscana", "Trentino-Alto Adige", "Umbria", "Valle d'Aosta", "Veneto" }));
        cbxreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxregActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Regione");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Stampa dati");

        jButton2.setText("Provincia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1)
                                .addGap(33, 33, 33)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel2))
                                    .addComponent(cbxreg, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxprov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(cbxreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxprovActionPerformed
        
    }//GEN-LAST:event_cbxprovActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Regione selectedRegion = (Regione) cbxreg.getSelectedItem();
    jTextArea1.setText("Nome Regione: " + selectedRegion.getNome() + "\n"
    + "Numero Abitanti: " + selectedRegion.getAbitanti() + "\n"
    + "Province: ");
    for (int i = 0; i < selectedRegion.prov.size(); i++) {
        jTextArea1.append(selectedRegion.prov.get(i).getNome() + "\n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxregActionPerformed
        switch(cbxreg.getSelectedItem().toString()) {
        case "Abruzzo":
            dcbm.addElement("L'Aquila");
            dcbm.addElement("Teramo");
            dcbm.addElement("Pescara");
            dcbm.addElement("Chieti");
            break;
        case "Basilicata":
            dcbm.addElement("Potenza");
            dcbm.addElement("Matera");
            break;
        case "Calabria":
            dcbm.addElement("Catanzaro");
            dcbm.addElement("Cosenza");
            dcbm.addElement("Crotone");
            dcbm.addElement("Reggio Calabria");
            dcbm.addElement("Vibo Valentia");
            break;
        case "Campania":
            dcbm.addElement("Napoli");
            dcbm.addElement("Avellino");
            dcbm.addElement("Benevento");
            dcbm.addElement("Caserta");
            dcbm.addElement("Salerno");
            break;
        case "Emilia-Romagna":
            dcbm.addElement("Bologna");
            dcbm.addElement("Modena");
            dcbm.addElement("Ferrara");
            dcbm.addElement("Parma");
            dcbm.addElement("Reggio Emilia");
            dcbm.addElement("Ravenna");
            dcbm.addElement("Forlì-Cesena");
            dcbm.addElement("Piacenza");
            dcbm.addElement("Rimini");
            break;
        case "Friuli-Venezia Giulia":
            dcbm.addElement("Trieste");
            dcbm.addElement("Gorizia");
            dcbm.addElement("Udine");
            dcbm.addElement("Pordenone");
            break;
        case "Lazio":
            dcbm.addElement("Roma");
            dcbm.addElement("Viterbo");
            dcbm.addElement("Latina");
            dcbm.addElement("Frosinone");
            dcbm.addElement("Rieti");
            break;
        case "Liguria":
            dcbm.addElement("Genova");
            dcbm.addElement("Imperia");
            dcbm.addElement("La Spezia");
            dcbm.addElement("Savona");
            break;
        case "Lombardia":
            dcbm.addElement("Milano");
            dcbm.addElement("Bergamo");
            dcbm.addElement("Brescia");
            dcbm.addElement("Como");
            dcbm.addElement("Cremona");
            dcbm.addElement("Lecco");
            dcbm.addElement("Lodi");
            dcbm.addElement("Mantova");
            dcbm.addElement("Monza e Brianza");
            dcbm.addElement("Pavia");
            dcbm.addElement("Sondrio");
            dcbm.addElement("Varese");
            break;
        case "Marche":
            dcbm.addElement("Ancona");
            dcbm.addElement("Pesaro e Urbino");
            dcbm.addElement("Macerata");
            dcbm.addElement("Fermo");
            dcbm.addElement("Ascoli Piceno");
            break;
        case "Molise":
            dcbm.addElement("Campobasso");
            dcbm.addElement("Isernia");
            break;
        case "Piemonte":
            dcbm.addElement("Torino");
            dcbm.addElement("Cuneo");
            dcbm.addElement("Asti");
            dcbm.addElement("Alessandria");
            dcbm.addElement("Novara");
            dcbm.addElement("Biella");
            dcbm.addElement("Verbano-Cusio-Ossola");
            dcbm.addElement("Vercelli");
            break;
        case "Puglia":
            dcbm.addElement("Bari");
            dcbm.addElement("Taranto");
            dcbm.addElement("Foggia");
            dcbm.addElement("Brindisi");
            dcbm.addElement("Lecce");
            dcbm.addElement("Barletta-Andria-Trani");
            break;
        case "Sardegna":
            dcbm.addElement("Cagliari");
            dcbm.addElement("Sassari");
            dcbm.addElement("Nuoro");
            dcbm.addElement("Oristano");
            dcbm.addElement("Olbia-Tempio");
            dcbm.addElement("Medio Campidano");
            dcbm.addElement("Carbonia-Iglesias");
            dcbm.addElement("Ogliastra");
            break;
        case "Sicilia":
            dcbm.addElement("Palermo");
            dcbm.addElement("Catania");
            dcbm.addElement("Messina");
            dcbm.addElement("Siracusa");
            dcbm.addElement("Ragusa");
            dcbm.addElement("Trapani");
            break;
        case "Toscana":
            dcbm.addElement("Firenze");
            dcbm.addElement("Prato");
            dcbm.addElement("Pistoia");
            dcbm.addElement("Livorno");
            dcbm.addElement("Lucca");
            dcbm.addElement("Pisa");
            dcbm.addElement("Arezzo");
            dcbm.addElement("Siena");
            dcbm.addElement("Grosseto");
            break;
        case "Trentino-Alto Adige":
            dcbm.addElement("Trento");
            dcbm.addElement("Bolzano");
            break;
        case "Umbria":
            dcbm.addElement("Perugia");
            dcbm.addElement("Terni");
            break;
        case "Valle d'Aosta":
            dcbm.addElement("Aosta");
            break;
        case "Veneto":
            dcbm.addElement("Verona");
            dcbm.addElement("Vicenza");
            dcbm.addElement("Belluno");
            dcbm.addElement("Padova");
            dcbm.addElement("Treviso");
            dcbm.addElement("Venezia");
            dcbm.addElement("Rovigo");
            break;
        }
    }//GEN-LAST:event_cbxregActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxprov;
    private javax.swing.JComboBox<String> cbxreg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
