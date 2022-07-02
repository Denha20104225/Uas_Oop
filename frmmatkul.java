package frmmatkul;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;        
/**
 *
 * @author Ade Denha Gunawan
 */
public class frmmatkul extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    dbKoneksi cnn = new dbKoneksi();
    /**
     * Creates new form frmmatkul
     */
    public frmmatkul() {
        initComponents();
        this.initTable();
        this.getdata();
        this.cdmCLOSE.setVisible(false);
    }
    private void initTable() {
      model = new DefaultTableModel();
      table.setModel(model);
      model.addColumn("Id Matkul");
      model.addColumn("Nama Matkul");
      model.addColumn("SKS");
      model.addColumn("Semester");
    }
    private void tampildata(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("Terjadi Kendala Pada Query");
        }
    }

    private void getdata() {
        String sql = "Select id_matkul, Nama_Matkul,sks,semester FROM dtmatkul;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[4];
                obj[0] = this.rs.getString("id_matkul");
                obj[1] = this.rs.getString("Nama_Matkul");
                obj[2] = this.rs.getString("sks");
                obj[3] = this.rs.getString("semester");
            }
        }catch(Exception e){
            
        }
            
    }
    private boolean UpdateData(String SQL){
        boolean hsl = false;
        try{   
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(SQL);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kendala Instruksi SQL");
        }
        return hsl;
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
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cdmTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txID = new javax.swing.JTextField();
        txNAMA = new javax.swing.JTextField();
        txSKS = new javax.swing.JTextField();
        txSMST = new javax.swing.JTextField();
        cdmSP = new javax.swing.JButton();
        cdmUP = new javax.swing.JButton();
        cdmDEL = new javax.swing.JButton();
        cdmCLOSE = new javax.swing.JButton();
        cdmTUTUP = new javax.swing.JButton();
        lbCRUDmat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel1.setText("List Data Matakuliah");

        cdmTambah.setText("Tambah Data");
        cdmTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmTambahActionPerformed(evt);
            }
        });

        jLabel2.setText("Id Matakuliah");

        jLabel3.setText("Nama Matakuliah");

        jLabel4.setText("SKS");

        jLabel5.setText("Semester");

        cdmSP.setText("Simpan");
        cdmSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmSPActionPerformed(evt);
            }
        });

        cdmUP.setText("Update");
        cdmUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmUPActionPerformed(evt);
            }
        });

        cdmDEL.setText("Hapus");
        cdmDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmDELActionPerformed(evt);
            }
        });

        cdmCLOSE.setText("Batal");
        cdmCLOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmCLOSEActionPerformed(evt);
            }
        });

        cdmTUTUP.setText("Tutup Form");
        cdmTUTUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdmTUTUPActionPerformed(evt);
            }
        });

        lbCRUDmat.setText("Detail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cdmTambah))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cdmSP)
                                .addGap(18, 18, 18)
                                .addComponent(cdmUP)
                                .addGap(18, 18, 18)
                                .addComponent(cdmDEL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cdmCLOSE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cdmTUTUP))))
                    .addComponent(lbCRUDmat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txNAMA)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txSKS, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txSMST, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cdmTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCRUDmat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSMST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cdmSP)
                    .addComponent(cdmUP)
                    .addComponent(cdmDEL)
                    .addComponent(cdmCLOSE)
                    .addComponent(cdmTUTUP))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cdmTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmTambahActionPerformed
        this.cdmTambah.setEnabled(false);
        this.cdmUP.setEnabled(false);
        this.cdmDEL.setEnabled(false);
        this.cdmTUTUP.setEnabled(false);
        this.cdmSP.setEnabled(true);
        this.cdmCLOSE.setEnabled(true);
        
        this.txID.setText("");
        this.txNAMA.setText("");
        this.txSKS.setText("");
        this.txSMST.setText("");
        
        this.lbCRUDmat.setText("Tambah Data Matkul");
    }//GEN-LAST:event_cdmTambahActionPerformed

    private void cdmUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmUPActionPerformed
        String ID_Matkul = this.txID.getText();
        String Nama_Matkul = this.txNAMA.getText();
        String SKS = this.txSKS.getText();
        String Semester = this.txSMST.getText();
    
        String SQLUpdate = "UPDATE dtmatkul SET Nama_Matkul='"+Nama_Matkul+"',sks='"+SKS+"',semester='"+Semester+"' WHERE id_matkul='"+ID_Matkul+"';";
        if(this.UpdateData(SQLUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data Terupdate");
        }
    }//GEN-LAST:event_cdmUPActionPerformed

    private void cdmTUTUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmTUTUPActionPerformed
        this.dispose();
    }//GEN-LAST:event_cdmTUTUPActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
      this.txID.setText(model.getValueAt(table.getSelectedRow(),0).toString());
      this.txNAMA.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
      this.txSKS.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
      this.txSMST.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
      
      this.lbCRUDmat.setText("Edit Data"+this.txID.getText());
      this.cdmSP.setEnabled(false);
      this.cdmUP.setEnabled(true);
      this.cdmDEL.setEnabled(true);
    }//GEN-LAST:event_tableMouseClicked

    private void cdmDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmDELActionPerformed
      String ID_Matkul = this.txID.getText();
      String Nama_Matkul = this.txNAMA.getText();
      
      int opsi = JOptionPane.showConfirmDialog(null, "Yakin Menghapus Data "+Nama_Matkul+"("+ID_Matkul+")?","Konfirmasi", JOptionPane.YES_NO_CANCEL_OPTION);
      if(opsi == JOptionPane.YES_OPTION){
          String SQLDelete = "DELETE FROM dtmatkul WHERE Id_Matkul='"+ID_Matkul+"';";
          if(this.UpdateData(SQLDelete)){
              this.getdata();
              JOptionPane.showMessageDialog(null, "Data Terhapus");
          }
      }
    }//GEN-LAST:event_cdmDELActionPerformed

    private void cdmCLOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmCLOSEActionPerformed
        this.cdmTUTUP.setEnabled(true);
        this.cdmTambah.setEnabled(true);
        this.cdmSP.setEnabled(false);
        this.cdmCLOSE.setVisible(false);
    }//GEN-LAST:event_cdmCLOSEActionPerformed

    private void cdmSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdmSPActionPerformed
        String ID_Matkul = this.txID.getText();
        String Nama_Matkul = this.txNAMA.getText();
        String SKS = this.txSKS.getText();
        String Semester = this.txSMST.getText();
        
        String SQLInsert = "INSERT INTO dtmatkul(id_matkul,Nama_Matkul,sks,semester) VALUES ('"+ID_Matkul+"','"+Nama_Matkul+"','"+SKS+"','"+Semester+"');";
        if(this.UpdateData(SQLInsert)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data Ditambahkan");
        }
        this.cdmCLOSE.setVisible(false);
        this.cdmTambah.setEnabled(true);
        this.cdmTUTUP.setEnabled(true);
        this.cdmSP.setEnabled(false);
    }//GEN-LAST:event_cdmSPActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmmatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmatkul().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cdmCLOSE;
    private javax.swing.JButton cdmDEL;
    private javax.swing.JButton cdmSP;
    private javax.swing.JButton cdmTUTUP;
    private javax.swing.JButton cdmTambah;
    private javax.swing.JButton cdmUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCRUDmat;
    private javax.swing.JTable table;
    private javax.swing.JTextField txID;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txSKS;
    private javax.swing.JTextField txSMST;
    // End of variables declaration//GEN-END:variables
}