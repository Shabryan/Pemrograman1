/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sparepart;

import koneksi.koneksi;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.print.PrinterException;

/**
 *
 * @author user
 */
  

    public class sparepart extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(sparepart.class.getName());

        /**
         * Creates new form sparepart
         */
        public sparepart() {
            initComponents();

            tampilSupplier();
            tampilKategori();
            tampilData();
        }

        private void bersih() {

            txtNamaSparepart.setText("");
            txtHarga.setText("");
            txtStok.setText("");

            cmbSupplier.setSelectedIndex(0);
            cmbKategori.setSelectedIndex(0);

            txtNamaSparepart.requestFocus();

        }

        private void tampilSupplier() {
            try {
                Connection conn = koneksi.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM supplier");
                cmbSupplier.removeAllItems();
                while (rs.next()) {
                    cmbSupplier.addItem(
                            rs.getString("id_supplier")
                            + " - "
                            + rs.getString("nama_supplier"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        private void tampilKategori() {

            try {

                Connection conn = koneksi.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM kategori");

                cmbKategori.removeAllItems();

                while (rs.next()) {
                    cmbKategori.addItem(rs.getString("nama_kategori"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        private void tampilData() {

            DefaultTableModel model = new DefaultTableModel();

            model.addColumn("ID");
            model.addColumn("Nama Sparepart");
            model.addColumn("Supplier");
            model.addColumn("Kategori");
            model.addColumn("Harga");
            model.addColumn("Stok");

            try {

                Connection conn = koneksi.getConnection();

                Statement st = conn.createStatement();

                String sql
                        = "SELECT sparepart.id_sparepart,"
                        + " sparepart.nama_sparepart,"
                        + " supplier.nama_supplier,"
                        + " kategori.nama_kategori,"
                        + " sparepart.harga,"
                        + " sparepart.stok "
                        + "FROM sparepart "
                        + "JOIN supplier ON supplier.id_supplier=sparepart.id_supplier "
                        + "JOIN kategori ON kategori.id_kategori=sparepart.id_kategori";

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    model.addRow(new Object[]{
                        rs.getString("id_sparepart"),
                        rs.getString("nama_sparepart"),
                        rs.getString("nama_supplier"),
                        rs.getString("nama_kategori"),
                        rs.getString("harga"),
                        rs.getString("stok")
                    });
                }
                tblSparepart.setModel(model);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        private int getIdSupplier() {

            String supplier = cmbSupplier.getSelectedItem().toString();
            String id = supplier.split(" - ")[0];

            return Integer.parseInt(id);

        }

        private int getIdKategori() {

            try {

                Connection conn = koneksi.getConnection();

                String sql = "SELECT id_kategori FROM kategori WHERE nama_kategori=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, cmbKategori.getSelectedItem().toString());

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    return rs.getInt("id_kategori");

                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }

            return 0;

        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSparepart = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        txtNamaSparepart = new javax.swing.JTextField();
        cmbSupplier = new javax.swing.JComboBox<>();
        cmbKategori = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdSparepart = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Data Sparepart");

        jLabel3.setText("Nama Sparepart");

        jLabel4.setText("Supplier");

        jLabel5.setText("Kategori");

        jLabel6.setText("Harga");

        jLabel7.setText("Stock");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        tblSparepart.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSparepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSparepartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSparepart);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(this::btnCetakActionPerformed);

        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PT Astra Motor", "PT Federal", "PT Yamaha" }));

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oli", "Filter", "Busi", "Ban" }));

        jLabel2.setText("ID Sparepart");

        txtIdSparepart.addActionListener(this::txtIdSparepartActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(267, 267, 267))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnSimpan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEdit)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnHapus)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtNamaSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtIdSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnCetak)))))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIdSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaSparepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnCetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {

            Connection conn = koneksi.getConnection();

            String sql
                    = "INSERT INTO sparepart(nama_sparepart,id_supplier,id_kategori,harga,stok) VALUES(?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNamaSparepart.getText());
            pst.setInt(2, getIdSupplier());
            pst.setInt(3, getIdKategori());
            pst.setInt(4, Integer.parseInt(txtHarga.getText()));
            pst.setInt(5, Integer.parseInt(txtStok.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

            tampilData();
            bersih();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }       // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void tblSparepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSparepartMouseClicked
        int baris = tblSparepart.getSelectedRow();
        
        txtIdSparepart.setText(
            tblSparepart.getValueAt(baris, 0).toString());

        txtNamaSparepart.setText(
                tblSparepart.getValueAt(baris, 1).toString());

        cmbSupplier.setSelectedItem(
                tblSparepart.getValueAt(baris, 2).toString());

        cmbKategori.setSelectedItem(
                tblSparepart.getValueAt(baris, 3).toString());

        txtHarga.setText(
                tblSparepart.getValueAt(baris, 4).toString());

        txtStok.setText(
                tblSparepart.getValueAt(baris, 5).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_tblSparepartMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        try {

            Connection conn = koneksi.getConnection();

            String sql = "UPDATE sparepart SET "
                    + "nama_sparepart=?,"
                    + "id_supplier=?,"
                    + "id_kategori=?,"
                    + "harga=?,"
                    + "stok=? "
                    + "WHERE id_sparepart=?";

            PreparedStatement pst = conn.prepareStatement(sql);

           pst.setString(1, txtNamaSparepart.getText());
           pst.setInt(2, getIdSupplier());
           pst.setInt(3, getIdKategori());
            pst.setInt(4, Integer.parseInt(txtHarga.getText()));
            pst.setInt(5, Integer.parseInt(txtStok.getText()));
            pst.setInt(6, Integer.parseInt(txtIdSparepart.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            tampilData();
            bersih();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

        try {
            Connection conn = koneksi.getConnection();
            String sql = "DELETE FROM sparepart WHERE id_sparepart=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtIdSparepart.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilData();
            bersih();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtIdSparepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdSparepartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdSparepartActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
   
    try {

        boolean complete = tblSparepart.print();

        if (complete) {
            JOptionPane.showMessageDialog(this, "Data berhasil dicetak");
        } else {
            JOptionPane.showMessageDialog(this, "Pencetakan dibatalkan");
        }

    } catch (java.awt.print.PrinterException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    

}    // TODO add your handling code here:
    }//GEN-LAST:event_btnCetakActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new sparepart().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSparepart;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdSparepart;
    private javax.swing.JTextField txtNamaSparepart;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
