/*
 * Political Map Project
 *
 * Name: Arvind Anand, Christian Womack, Tahir(Syed) Shezad
 * Block:7
 *
 * Program Purpose:
 *  This program draws a map that represents a certain state. That state displays an RGB color that represents voting data.
    The more red the map is, the more republican, blue, democratic and so on. This program is very robust and displays data
    in a very visually appealing manner with a GUI. Also, the program draws a visual representation of voter data compared to the
    US census data in which that shows how many people voted VS the population.
 *
 * Algorithm:

FOR GUI:
 *ATTACHING CLASS TO PACKAGE MAP
 *IMPORTING NESSESARY ITEMS
 *CREATING POLITICALMAP CLASS WHICH EXTENDS ATTRIBUTES FROM JFRAME
 *DECLARING VARIABLES FOR THE GUI
 *MAIN CLASS STARTS
 *TRY CATCH METHOD FOR EXCPETIONS
 *METHOD TO INTIATE GUI
 *DECLARING VARIABLES FOR GUI
 *CREATING LOGIC FOR THE MAP SELECTOR
 *ADDING MULTIPLE COMPONENTS OF THE GUI INCLUDING: LABELS, SELECTORS, BUTTONS, ETC.
 *METHOD FOR WHAT HAPPENS WHEN GO IS PRESSED
 *  -IT POPULATES THE MAP BASED OF THE MAP AND YEAR THAT IS SELECTED
 *   
 * 
 *
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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

        /*
    Christian designed to GUI in the JFrame design window and copy/pasted it into this class
    
        
    */
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
        //GET THE PATH AND SET THE TEXT CHOSEN TO THE TEXT FILE

    }
    
    
    
    
    //------------------------------------------------------------------------------
    //This method represents the action event for the GO button object

    private void goActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
        //This string is used for concatinating the relative file path. This is used in the DrawMap class to find the absolute path.
        String base = "src/data/";
        //Specific conditional for USA-county.txt for coloring specifically 
        if (mapSelector.getSelectedItem().equals("USA-county")) {
            //new DrawMap object
            DrawMap drawMap = new DrawMap(base + mapSelector.getSelectedItem() + ".txt");
            //Array that contains the states
            String[] newStateAry = new String[]{"AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
            //Calls method
            drawMap.populateCounties(newStateAry, (String) yearSelector.getSelectedItem());
        } else {
            //instance of DrawMap for other data sets
            DrawMap drawMap = new DrawMap(base + mapSelector.getSelectedItem() + ".txt");
            //Generated try/catch for IOException
            try {
                drawMap.populateMap(base + mapSelector.getSelectedItem() + yearSelector.getSelectedItem() + ".txt");
                if (mapSelector.getSelectedItem().equals("USA")) {
                    //Arvind's functionallity that is called draws a visual representation of voter data for ONLY the map of the USA
                    drawGraph(drawMap);
                }
            } catch (IOException ex) {
                Logger.getLogger(PoliticalMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    /*
        Arvind's functionallity: For any USA map for any year, the program draws a graph that represents the 
        voter turnout and compares it to census data.
        
    parameter: drawGraph uses a DrawMap object so it can use it's public double array, which stores all the sums of the
    republican, democratic, and third party data, and uses that to calculate the sum.
    
    */

    public void drawGraph(DrawMap d) {
        //HashMap is used for inputing the rounded approximation for the population of its respected year / 1000000
        HashMap map = new HashMap();
        map.put("1960", 181);
        map.put("1964", 192);
        map.put("1968", 201);
        map.put("1972", 210);
        map.put("1976", 218);
        map.put("1980", 227);
        map.put("1984", 236);
        map.put("1988", 245);
        map.put("1992", 257);
        map.put("1996", 269);
        map.put("2000", 282);
        map.put("2004", 293);
        map.put("2008", 304);
        map.put("2012", 313);
        //Sets canvas size to 1000/500 and sets the X and Y Scale
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, 900);
        StdDraw.setYscale(0, 500);
        
        //Calculated sum based on the year of voter data from the DrawMap class that is taken as a parameter
        int sum = 0;
        for (int i = 0; i < d.sums.length; i++) {
            sum = d.sums[i] + sum;
        }
        double[] ary = new double[2];
        //The sum is being set to a decimal and put into the array
        ary[0] = (double)(sum) / 100000000.0;
        
        //This calculates the decimal value for the population of the  current year
        int temp = (int) map.get((String) yearSelector.getSelectedItem());
        double temp2 = (double) temp / 100;
        ary[1] = temp2;
        
        //This section sets the x and y scale to 4 and then draws the bar graph based on the array input
        StdDraw.setPenColor(Color.ORANGE);
        StdDraw.setYscale(0, 4);
        StdDraw.setXscale(0, 4);
        StdStats.plotBars(ary);
        
        StdDraw.setPenColor(Color.black);
        //Text for bars on graph
        StdDraw.text(0, ary[0] / 2, "# of voters");
        StdDraw.text(0, (ary[0] + .1), Math.round(ary[0] * 100) + " million voters");
        StdDraw.text(1, ary[1] / 2, "# of people in the USA");
        StdDraw.text(1, (ary[1] + .1), Math.round(ary[1] * 100) + " million people");
        
        //----Sets the stage for text, text is drawn below
        StdDraw.setXscale(-1000, 1000);
        StdDraw.setYscale(-500, 500);
        StdDraw.setPenColor(Color.CYAN);
        StdDraw.filledRectangle(-1000, 100, 400, 400);
        StdDraw.setPenColor(Color.black);
        String preface = "In the year " + (String) yearSelector.getSelectedItem() +  ", a total";
        StdDraw.text(-800, 400 ,preface);
        String preface2 = "number of " + Math.round(ary[0] * 100) + " million people";
        StdDraw.text(-800, 350, preface2);
        String preface3 = "voted and " + map.get(yearSelector.getSelectedItem())+ " million was";
        StdDraw.text(-800, 300, preface3);
        String preface4 = "the population of USA.";
        StdDraw.text(-800, 250, preface4);
       
        

    }
}
