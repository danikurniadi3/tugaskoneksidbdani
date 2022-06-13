/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugaskoneksidb;
import java.sql.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DaniPC
 */
public class cariProduk extends javax.swing.JFrame {
 DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    /**
     * Creates new form cariProduk
     */
    public cariProduk() {
        initComponents();
    }

    private void tampilData(){
        try{
            Object[] judul_kolom = {"Kode Barang","Nama Barang","Satuan","Harga","Stock","Create Date"};
            tabModel = new DefaultTableModel(null,judul_kolom);
            jTableProduk.setModel(tabModel);
            
            Connection conn =(Connection)koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk = stt.executeQuery("SELECT * from produk");
            while(RsProduk.next()){
                Object[] data = {
                    RsProduk.getString("kodeProduk"),
                    RsProduk.getString("namaProduk"),
                    RsProduk.getString("satuan"),
                    RsProduk.getString("harga"),
                    RsProduk.getString("stok"),
                    RsProduk.getString("createDate")
                };
                tabModel.addRow(data);
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
        private void cariData(String key){
        try{
            Object[] judul_kolom = {"Kode Barang","Nama Barang","Satuan","Harga","Stock","Create Date"};
            tabModel = new DefaultTableModel(null,judul_kolom);
            jTableProduk.setModel(tabModel);
            
            Connection conn =(Connection)koneksi.koneksiDB();
            Statement stt = conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsProduk = stt.executeQuery("SELECT * from produk WHERE kodeProduk LIKE '%"+key+"%' OR namaProduk LIKE '%"+key+"%' OR satuan LIKE '%"+key+"%'");
            while(RsProduk.next()){
                Object[] data = {
                    RsProduk.getString("kodeProduk"),
                    RsProduk.getString("namaProduk"),
                    RsProduk.getString("satuan"),
                    RsProduk.getString("harga"),
                    RsProduk.getString("stok"),
                    RsProduk.getString("createDate")
                };
                tabModel.addRow(data);
            }
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCariActionPerformed(evt);
            }
        });
        jTextCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCariKeyReleased(evt);
            }
        });

        jLabel1.setText("Cari Data");

        jTableProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProduk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextCari, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(485, 485, 485))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCariActionPerformed

    private void jTextCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCariKeyReleased
        // TODO add your handling code here:
        String key=jTextCari.getText();
        System.out.println(key);

        if(key!=""){
            cariData(key);
        }else{
            tampilData();
        }
    }//GEN-LAST:event_jTextCariKeyReleased

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
            java.util.logging.Logger.getLogger(cariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cariProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cariProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduk;
    private javax.swing.JTextField jTextCari;
    // End of variables declaration//GEN-END:variables
}
