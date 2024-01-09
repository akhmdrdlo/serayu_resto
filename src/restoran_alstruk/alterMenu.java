/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran_alstruk;

import function.getMenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akhmad
 */
public class alterMenu extends javax.swing.JFrame {
    DefaultTableModel model;
    private Connection con=null;
    private JTable table=null;
    /**
     * Creates new form alterMenu
     */
    public alterMenu() {
        initComponents();
        setLocationRelativeTo(this);
        menuTable.setAutoCreateRowSorter(true);
        findMenu();
        String []listgame={"KD Menu","Nama Menu","Harga"};
        model = new DefaultTableModel (listgame,0);
        menuTable.setModel (model);
        tampilkan();
    }
    
    public Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/restoran","root","");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
         
    }    
    
    public ArrayList<getMenu> ListMenu (String ValToSearch){
        
        ArrayList<getMenu> menuList = new ArrayList<getMenu>();
        Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `menu` WHERE CONCAT (`kd_menu`, `nama_menu`, `harga`) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
            
            getMenu menu;
            
            while(rs.next()){
                menu = new getMenu(
                        rs.getInt("kd_menu"),
                        rs.getString("nama_menu"),
                        rs.getString("harga")
                );
                
                menuList.add(menu);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return menuList;
    }
  
    
    
    public void findMenu(){
        ArrayList<getMenu> users = ListMenu(txtsearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers (new Object[]{"Id","Nama","Harga"});
        Object[] row = new Object [5];
        
        for(int i=0;i<users.size(); i++){
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getNama();
            row[2] = users.get(i).getHarga();
            
            model.addRow(row);
        }
        menuTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        txtNamaMenu = new javax.swing.JTextField();
        editMenu = new javax.swing.JButton();
        tambahMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuTable.setModel(new javax.swing.table.DefaultTableModel(
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
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 393, 380, 220));

        txtsearch.setBorder(null);
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 240, 20));

        btnsearch.setBorder(null);
        btnsearch.setContentAreaFilled(false);
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 80, 30));

        txtHarga.setBorder(null);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 125, 29));

        txtNamaMenu.setBorder(null);
        txtNamaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaMenuActionPerformed(evt);
            }
        });
        getContentPane().add(txtNamaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 125, 29));

        editMenu.setBorder(null);
        editMenu.setBorderPainted(false);
        editMenu.setContentAreaFilled(false);
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });
        getContentPane().add(editMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 70, 20));

        tambahMenu.setBorder(null);
        tambahMenu.setBorderPainted(false);
        tambahMenu.setContentAreaFilled(false);
        tambahMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahMenuActionPerformed(evt);
            }
        });
        getContentPane().add(tambahMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 80, 20));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 70, 20));

        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 100, 20));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 20, -1));

        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 70, 20));

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        findMenu();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtNamaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaMenuActionPerformed

    private void tambahMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahMenuActionPerformed
    try { 
        con=DriverManager.getConnection("jdbc:mysql://localhost/restoran","root","");
        PreparedStatement pStatement =
            con.prepareStatement("INSERT INTO menu (nama_menu,harga)" + "VALUES (?,?)");
        
        pStatement.setString(1, txtNamaMenu.getText());
        pStatement.setString(2, txtHarga.getText());
        
        if (pStatement.executeUpdate()>0)
            JOptionPane.showMessageDialog(this,
            "Penambahan sukses", "Informasi",
            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,
            "Penambahan gagal", "Informasi",
            JOptionPane.INFORMATION_MESSAGE);

        pStatement.close();
        con.close();
        txtNamaMenu.setText("");
        txtHarga.setText("");
        }
        catch (SQLException e){
            System.out.println("koneksi gagal " + e.toString());
        }
    }//GEN-LAST:event_tambahMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new alterMenu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/restoran", "root", "");
            PreparedStatement pStatement = con.prepareStatement("UPDATE menu SET nama_menu = ?, harga = ? WHERE kd_menu = ?");

            pStatement.setString(1, txtNamaMenu.getText());
            pStatement.setString(2, txtHarga.getText());
            pStatement.setInt(3, Integer.parseInt(txtID.getText()));

            if (pStatement.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(this, "Perubahan sukses", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Perubahan gagal", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }

                pStatement.close();
                con.close();
                txtNamaMenu.setText("");
                txtHarga.setText("");
        } catch (SQLException e) {
            System.out.println("koneksi gagal " + e.toString());
        }
    }//GEN-LAST:event_editMenuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new pesanMenu().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTableMouseClicked
        // TODO add your handling code here:
        int i =menuTable.getSelectedRow();
        if (i>-1){
            txtID.setText(model.getValueAt (i,0).toString());
            txtNamaMenu.setText(model.getValueAt (i,1).toString());
            txtHarga.setText (model.getValueAt (i,2).toString());
        }
    }//GEN-LAST:event_menuTableMouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        findMenu();
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new mainmenu().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(alterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alterMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
     private void tampilkan() {
       int row=menuTable.getRowCount();
       for(int a=0; a<row; a++){
           model.removeRow(0);
       }
    try{
        Connection cn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restoran","root","");
        ResultSet rs=cn.createStatement().executeQuery ("Select * from menu");
        while(rs.next()){
            String data[]={rs.getString(1),rs.getString(2),rs.getString(3)};
            model.addRow(data);
        }
    } catch (SQLException ex) {
        Logger.getLogger (alterMenu.class.getName()).log(Level.SEVERE, null, ex);
     }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton editMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable menuTable;
    private javax.swing.JButton tambahMenu;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNamaMenu;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}