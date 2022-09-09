package game.trackers;

import static game.trackers.fAddGameData.getConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public class fGameData extends javax.swing.JFrame
{

    /**
     * Creates new form fGameData
     * @throws java.lang.Exception
     */
    public fGameData() throws Exception
    {
        initComponents();
    }
    public LinkedList gameListSQL() throws Exception{//Creates an instance of the LinkedList of games so it can be uploaded to SQL
        LinkedList gameList = new LinkedList();
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/game_data";
            String username = "root";
            String password = "GameTrackerManny123$";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            
            String query1 = "SELECT * FROM gamedata";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1); 
            Game game;
            while(rs.next()){
                game = new Game(rs.getDate("Date"),rs.getString("gameName"),rs.getInt("Rounds"),rs.getInt("Frags"),
                rs.getInt("Deaths"),rs.getInt("Assists"));
                gameList.add(game);
            }
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return gameList;
    }
    public void showGameDataSQL() throws Exception{
        SimpleDateFormat date1 =  new SimpleDateFormat("MM/dd/yy");
        LinkedList list = gameListSQL();
        DefaultTableModel model = (DefaultTableModel)jTableGameData.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[1]=date1.format(list.get(i).getDate());
            row[2]= list.get(i).getGameName();
            row[3]= list.get(i).getRounds();
            row[4]= list.get(i).getFrags();
            row[5]= list.get(i).getDeaths();
            row[6]= list.get(i).getAssists();
            model.addRow(row);//Adds it to the table
        }
    }
    public void showGameDataRAF() throws Exception{
        LinkedList list = GameRandomAccessFile.readRecords();
        SimpleDateFormat date1 =  new SimpleDateFormat("MM/dd/yy");
        DefaultTableModel model = (DefaultTableModel)jTableGameData.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];//How many columbs are in the able
        for (int i = 0; i < list.size(); i++) {
            row[0]= ((GameRAF)list.get(i)).getId();//Polymorphism
            row[1]=date1.format(list.get(i).getDate());
            row[2]= list.get(i).getGameName();
            row[3]= list.get(i).getRounds();
            row[4]= list.get(i).getFrags();
            row[5]= list.get(i).getDeaths();
            row[6]= list.get(i).getAssists();
            model.addRow(row);//Adds it to the table
        }
    }
    public void showGameDataDatesRAF(LinkedList list) throws Exception{
        if (list==null||list.isEmpty()) {
            System.out.println("List not valid");
        }else{
            SimpleDateFormat date1 =  new SimpleDateFormat("MM/dd/yy");
            DefaultTableModel model = (DefaultTableModel)jTableGameData.getModel();
            model.setRowCount(0);
            Object[] row = new Object[7];
            for (int i = 0; i < list.size(); i++) {
                row[0]= ((GameRAF)list.get(i)).getId();//Polymorphism
                row[1]=date1.format(list.get(i).getDate());
                row[2]= list.get(i).getGameName();
                row[3]= list.get(i).getRounds();
                row[4]= list.get(i).getFrags();
                row[5]= list.get(i).getDeaths();
                row[6]= list.get(i).getAssists();
                model.addRow(row);
            }
        }
    }
    public void refreshSQL() throws Exception{
        DefaultTableModel model = (DefaultTableModel) jTableGameData.getModel();
        model.setRowCount(0);//Clears the table
        showGameDataSQL();
    }
    public void refreshRAF() throws Exception{
        DefaultTableModel model = (DefaultTableModel) jTableGameData.getModel();
        model.setRowCount(0);//Clears the table
        showGameDataRAF();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bGoHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGameData = new javax.swing.JTable();
        jButtonRefreshSQL = new javax.swing.JButton();
        jButtonRefreshRAF = new javax.swing.JButton();
        jButtonDeleteRecord = new javax.swing.JButton();
        jDeleteRecordField = new javax.swing.JTextField();
        jButtonSearchByDate = new javax.swing.JButton();
        dateField = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(111, 200, 111));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Game Data");

        bGoHome.setText("Go Home");
        bGoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGoHomeActionPerformed(evt);
            }
        });

        jTableGameData.setAutoCreateRowSorter(true);
        jTableGameData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Game", "Rounds", "Frags", "Deaths", "Assists"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGameData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTableGameData);
        if (jTableGameData.getColumnModel().getColumnCount() > 0) {
            jTableGameData.getColumnModel().getColumn(0).setResizable(false);
            jTableGameData.getColumnModel().getColumn(1).setResizable(false);
            jTableGameData.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableGameData.getColumnModel().getColumn(2).setResizable(false);
            jTableGameData.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableGameData.getColumnModel().getColumn(3).setResizable(false);
            jTableGameData.getColumnModel().getColumn(4).setResizable(false);
            jTableGameData.getColumnModel().getColumn(5).setResizable(false);
            jTableGameData.getColumnModel().getColumn(6).setResizable(false);
        }

        jButtonRefreshSQL.setText("Refresh SQL");
        jButtonRefreshSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshSQLActionPerformed(evt);
            }
        });

        jButtonRefreshRAF.setText("Refresh RAF");
        jButtonRefreshRAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshRAFActionPerformed(evt);
            }
        });

        jButtonDeleteRecord.setText("Delete Record");
        jButtonDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteRecordActionPerformed(evt);
            }
        });

        jDeleteRecordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteRecordFieldActionPerformed(evt);
            }
        });

        jButtonSearchByDate.setText("Search Date");
        jButtonSearchByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchByDateActionPerformed(evt);
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

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(bGoHome)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButtonRefreshSQL)
                .addComponent(jButtonRefreshRAF))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonDeleteRecord)
                        .addComponent(jButtonSearchByDate))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jDeleteRecordField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(33, 33, 33))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bGoHome)
                .addComponent(jLabel1))
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonDeleteRecord)
                .addComponent(jDeleteRecordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButtonSearchByDate)
                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(57, 57, 57)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jButtonRefreshSQL)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButtonRefreshRAF))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGoHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bGoHomeActionPerformed
    {//GEN-HEADEREND:event_bGoHomeActionPerformed
        new Home().setVisible(true);
    }//GEN-LAST:event_bGoHomeActionPerformed

    private void jButtonRefreshSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshSQLActionPerformed
        try {
            refreshSQL();
        } catch (Exception ex) {
            Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshSQLActionPerformed

    private void jButtonRefreshRAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshRAFActionPerformed
        try {
            refreshRAF();
        } catch (Exception ex) {
            Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRefreshRAFActionPerformed

    private void jButtonDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteRecordActionPerformed
        if (!jDeleteRecordField.getText().equals("")) {//Checks if there a record at stored location
            int id =Integer.parseInt(jDeleteRecordField.getText());
            try {
                System.out.println("Deletion of ID: "+GameRandomAccessFile.deleteRecord(id));
                refreshRAF();
            } catch (IOException ex) {
                Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Invalid Record");
        }

    }//GEN-LAST:event_jButtonDeleteRecordActionPerformed

    private void jButtonSearchByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchByDateActionPerformed
        java.sql.Date sqlDate = null;
        DefaultTableModel model = (DefaultTableModel) jTableGameData.getModel();
        model.setRowCount(0);
        try {
            java.util.Date date1 =  new SimpleDateFormat("MM/dd/yy").parse(dateField.getText());//Convert from European time to US and takes from picker
            //System.out.println(date1);
            
            sqlDate = new java.sql.Date(date1.getTime());//Be able to put into database
            System.out.println("Search Button: Date is" + dateField.getText());
            showGameDataDatesRAF(GameRandomAccessFile.searchRecordByDate(sqlDate));//Displays just the games on chosen game
        } catch (ParseException ex) {
            Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSearchByDateActionPerformed

    private void jDeleteRecordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteRecordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDeleteRecordFieldActionPerformed

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
            java.util.logging.Logger.getLogger(fGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(fGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(fGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(fGameData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    new fGameData().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(fGameData.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGoHome;
    private datechooser.beans.DateChooserCombo dateField;
    private javax.swing.JButton jButtonDeleteRecord;
    private javax.swing.JButton jButtonRefreshRAF;
    private javax.swing.JButton jButtonRefreshSQL;
    private javax.swing.JButton jButtonSearchByDate;
    private javax.swing.JTextField jDeleteRecordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGameData;
    // End of variables declaration//GEN-END:variables
}
