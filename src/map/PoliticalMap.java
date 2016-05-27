/*
 * Political Map Project
 *
 * Name: Arvind Anand, Christian Womack, Tahir(Syed) Shezad
 * Block:7
 *
 * Program Purpose:
 *  vBeta 2.3: USA-County works for colors
 *
 * Algorithm:
 *   - Still messy but cleaner
 * 
 * Future/possible improvements: 
 *  Add extra functionality, clean code, almost done
 */
package map;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author
 */
public class PoliticalMap extends JFrame {
    //declaring variables for the menu
    private javax.swing.JButton go;
    private javax.swing.JComboBox mapSelector;
    private javax.swing.JComboBox yearSelector;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public String[] states;
    public String[] years;

    public PoliticalMap() {
        initComponents();
    }

    public static void main(String[] args) throws IOException {
        
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PoliticalMap().setVisible(true);

            }
        });

    }

    //UI UNDER DEVELOPMENT
    private void initComponents() {

        mapSelector = new javax.swing.JComboBox();
        go = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        yearSelector = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mapSelector.setModel(new javax.swing.DefaultComboBoxModel(states = new String[]{"USA", "USA-county", "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"}));
        mapSelector.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapSelectorActionPerformed(evt);
            }
        });

        go.setText("Go!");
        go.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    goActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PoliticalMap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //setting jlabel2 to a certain font
        jLabel2.setFont(new java.awt.Font("MS PMincho", 1, 24)); // NOI18N
        //setting text
        jLabel2.setText("Choose your state here ");
        
        yearSelector.setModel(new javax.swing.DefaultComboBoxModel(years = new String[]{"1960", "1964", "1968", "1972", "1976", "1980", "1984", "1988", "1992", "1996", "2000", "2004", "2008", "2012"}));

        jLabel3.setFont(new java.awt.Font("MS PMincho", 1, 24)); // NOI18N
        jLabel3.setText("Choose your year here");

        jLabel4.setText("Copyright © The Flying Falafels 2016");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/map/VERSUS.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("DokChampa", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 171));
        jLabel5.setText("PURPLE");

        jLabel7.setFont(new java.awt.Font("DokChampa", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(189, 0, 0));
        jLabel7.setText("AMERICA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(go, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                       
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(mapSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(yearSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel7))
                                .addComponent(jLabel6))
                        .addGap(60, 60, 60))
                .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(mapSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(yearSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(go, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        ));

        pack();
    }

    private void mapSelectorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //File file = new File("C:\\Users\\hcps-womackcz\\Documents\\PurpleAmerica_Anand_Shezad_Womack\\src\\data\\" + comboBox.getText() + ".txt");
        //GET THE PATH AND SET THE TEXT CHOSEN TO THE TEXT FILE

    }

    private void goActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
               String base = "src/data/";
        if (mapSelector.getSelectedItem().equals("USA-county")) {
            DrawMap drawMap = new DrawMap(base + mapSelector.getSelectedItem() + ".txt");
            String[] newStateAry = new String[]{"AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};      
            drawMap.populateCounties(newStateAry, (String)yearSelector.getSelectedItem());
        } else {
            DrawMap drawMap = new DrawMap(base + mapSelector.getSelectedItem() + ".txt");
            try {
                drawMap.populateMap(base + mapSelector.getSelectedItem() + yearSelector.getSelectedItem() + ".txt");
                //+ "" THE YEAR TO END OF THE STATE IF APPLICABLE (DON'T REQUIRE ONE)
            } catch (IOException ex) {
                Logger.getLogger(PoliticalMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
