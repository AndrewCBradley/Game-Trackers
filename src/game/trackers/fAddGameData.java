package game.trackers;

import java.awt.event.KeyEvent;
import java.util.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class fAddGameData extends javax.swing.JFrame
{

    /**
     * Creates new form fAddGameData
     */
    Set<String> s;
    public fAddGameData()
    {
        initComponents();
        s = new TreeSet<String>();
        //These are added for the auto completion for filling out the game
        s.add("Valorant");
        s.add("CSGO");
        s.add("Team Fortress 2");
        s.add("Rainbow Six Siege");
    }
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/game_data";
            String username = "root";
            String password = "GameTrackerManny123$";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            
            System.out.println("Connected");
            return conn;
       } catch(Exception e){System.out.println(e);}
        return null;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        bGoHome = new javax.swing.JButton();
        bEnterGameData = new javax.swing.JButton();
        fragsField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deathsField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        roundsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gameNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        assistsField = new javax.swing.JTextField();
        dateField = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(111, 200, 111));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));
        jPanel1.setRequestFocusEnabled(false);

        bGoHome.setText("Go Home");
        bGoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGoHomeActionPerformed(evt);
            }
        });

        bEnterGameData.setText("Add");
        bEnterGameData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnterGameDataActionPerformed(evt);
            }
        });

        jLabel2.setText("Frags");

        jLabel3.setText("Deaths");

        deathsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deathsFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Rounds");

        jLabel5.setText("GameName");

        gameNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameNameFieldActionPerformed(evt);
            }
        });
        gameNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gameNameFieldKeyReleased(evt);
            }
        });

        jLabel6.setText("Date");

        jLabel7.setText("Assists");

        assistsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assistsFieldActionPerformed(evt);
            }
        });

        dateField.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateField.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 12));

    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
    jLabel8.setText("Input Game Data");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(bGoHome)
                    .addGap(61, 61, 61)
                    .addComponent(jLabel8)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(22, 22, 22)))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gameNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roundsField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(bEnterGameData)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fragsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deathsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(assistsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 307, Short.MAX_VALUE))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(bGoHome))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel8)))
            .addGap(62, 62, 62)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel6)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(17, 17, 17)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(gameNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(roundsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(fragsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(deathsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(assistsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(bEnterGameData)
            .addGap(148, 148, 148))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void assistsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assistsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assistsFieldActionPerformed

    private void gameNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameNameFieldKeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getKeyCode()== KeyEvent.VK_DELETE) {

        }else{

            String to_check = gameNameField.getText();
            int to_check_len = to_check.length();
            for (String data:s) {
                String check_from_data="";
                for (int i = 0; i < to_check_len; i++) {//See if the inputted name is lining up with the stored autocomplete 
                    if (to_check_len<data.length()) {
                        check_from_data = check_from_data +data.charAt(i);
                    }
                }
                if (check_from_data.equals(to_check)) {
                    gameNameField.setText(data);
                    gameNameField.setSelectionStart(to_check_len);
                    gameNameField.setSelectionEnd(data.length());
                    break;
                }
            }
        }
    }//GEN-LAST:event_gameNameFieldKeyReleased

    private void gameNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gameNameFieldActionPerformed

    private void deathsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deathsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deathsFieldActionPerformed

    private void bEnterGameDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnterGameDataActionPerformed
        String game = "All Games";
        int rounds = 0;
        int frags= 0;
        int deaths= 0;
        int assists= 0;
        java.sql.Date sqlDate = null;
                JMenuItem item = new JMenuItem("Invalid Data");
                jPopupMenu1.add(item);

        if (dateField.getText().equals("")||gameNameField.getText().equals("")||roundsField.getText().equals("")||
                fragsField.getText().equals("")||deathsField.getText().equals("")||assistsField.getText().equals("")) {
            System.out.println("Invalid data");
            jPopupMenu1.show(bEnterGameData, 50, 50);
        }else{
            if (!dateField.getText().equals("")){
            try {
                java.util.Date date1 =  new SimpleDateFormat("MM/dd/yy").parse(dateField.getText());//Convert from European time to US and takes from picker
                //System.out.println(date1);

                sqlDate = new java.sql.Date(date1.getTime());//Be able to put into database

                //System.out.println(sqlDate);

            } catch (ParseException ex) {
                Logger.getLogger(fAddGameData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

            game = gameNameField.getText();
            rounds = Integer.parseInt(roundsField.getText());
            frags = Integer.parseInt(fragsField.getText());
            deaths = Integer.parseInt(deathsField.getText());
            assists = Integer.parseInt(assistsField.getText());

            try{
                Connection conn = getConnection();//Create connection to database

                String query = " insert into gamedata (Date, gameName, Rounds, Frags, Deaths, Assists)"
                +" values (?,?,?,?,?,?)";//Builds the sql query string to insert values into a database
                PreparedStatement prepStmt =conn.prepareStatement(query);//Gets user's values and puts it into the query string

                prepStmt.setDate(1,sqlDate);
                prepStmt.setString(2, game);
                prepStmt.setInt(3,rounds);
                prepStmt.setInt(4,frags);
                prepStmt.setInt(5,deaths);
                prepStmt.setInt(6,assists);

                prepStmt.execute();//Executes the SQL query

                conn.close();
                System.out.println("Data Added SQL");

                Game gameData = new GameRAF(sqlDate, game, rounds, frags, deaths, assists);//Uses polymorphism of the Game class. Game<-GameRAF
                GameRandomAccessFile.writeRecord(gameData);
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
    }
//        }
//        if (!dateField.getText().equals("")){
//            try {
//                java.util.Date date1 =  new SimpleDateFormat("MM/dd/yy").parse(dateField.getText());//Convert from European time to US and takes from picker
//                //System.out.println(date1);
//
//                sqlDate = new java.sql.Date(date1.getTime());//Be able to put into database
//
//                //System.out.println(sqlDate);
//
//            } catch (ParseException ex) {
//                Logger.getLogger(fAddGameData.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        if (!gameNameField.getText().equals("")){
//            game = gameNameField.getText();
//        }
//        if (!roundsField.getText().equals("")){
//            rounds = Integer.parseInt(roundsField.getText());
//        }
//        if (!fragsField.getText().equals("")){
//            frags = Integer.parseInt(fragsField.getText());
//        }
//        if (!deathsField.getText().equals("")){
//            deaths = Integer.parseInt(deathsField.getText());
//        }
//        if (!assistsField.getText().equals("")){
//            assists = Integer.parseInt(assistsField.getText());
//        }
//        try{
//            Connection conn = getConnection();//Create connection to database
//
//            String query = " insert into gamedata (Date, gameName, Rounds, Frags, Deaths, Assists)"
//            +" values (?,?,?,?,?,?)";//Builds the sql query string to insert values into a database
//            PreparedStatement prepStmt =conn.prepareStatement(query);//Gets user's values and puts it into the query string
//
//            prepStmt.setDate(1,sqlDate);
//            prepStmt.setString(2, game);
//            prepStmt.setInt(3,rounds);
//            prepStmt.setInt(4,frags);
//            prepStmt.setInt(5,deaths);
//            prepStmt.setInt(6,assists);
//
//            prepStmt.execute();//Executes the SQL query
//
//            conn.close();
//            System.out.println("Data Added SQL");
//
//            Game gameData = new GameRAF(sqlDate, game, rounds, frags, deaths, assists);//Uses polymorphism of the Game class. Game<-GameRAF
//            GameRandomAccessFile.writeRecord(gameData);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//
//        }
    }//GEN-LAST:event_bEnterGameDataActionPerformed

    private void bGoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGoHomeActionPerformed
        new Home().setVisible(true);
    }//GEN-LAST:event_bGoHomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(fAddGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(fAddGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(fAddGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(fAddGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new fAddGameData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assistsField;
    private javax.swing.JButton bEnterGameData;
    private javax.swing.JButton bGoHome;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserCombo dateField;
    private javax.swing.JTextField deathsField;
    private javax.swing.JTextField fragsField;
    private javax.swing.JTextField gameNameField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField roundsField;
    // End of variables declaration//GEN-END:variables
}
