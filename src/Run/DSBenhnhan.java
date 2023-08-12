/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Class.Benhnhan;
import Class.BenhnhanDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGHIA_PC
 */
public class DSBenhnhan extends javax.swing.JFrame {

    static String ID;
    private ArrayList<Benhnhan> listbn;
    DefaultTableModel model;
    private boolean flag = false;
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form ChiTietBenh
     */
    public DSBenhnhan() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
        listbn = new BenhnhanDAO().getListBenhnhan();
        showTable();
    }

    public void showTable() {
        model.setNumRows(0);
        for (Benhnhan tk : new BenhnhanDAO().getListBenhnhan()) {

            Object dataRow[] = new Object[8];
            dataRow[0] = jTable1.getRowCount() + 1;
            dataRow[1] = tk.getTen();
            dataRow[2] = tk.getSDT();
            dataRow[3] = tk.getGioitinh();
            dataRow[4] = tk.getNgaysinh();
            dataRow[5] = tk.getDiaChi();
            dataRow[6] = tk.getEmail();
            dataRow[7] = tk.getMK();

            model.addRow(dataRow);
        }
    }
    
    public void fillTable(String str)
    {

        model.setNumRows(0);
        for (Benhnhan tk :new BenhnhanDAO().FindByID(str))
        {
            Object dataRow[]=new Object[8];
            dataRow[0] = jTable1.getRowCount() + 1;
            dataRow[1] = tk.getTen();
            dataRow[2] = tk.getSDT();
            dataRow[3] = tk.getGioitinh();
            dataRow[4] = tk.getNgaysinh();
            dataRow[5] = tk.getDiaChi();
            dataRow[6] = tk.getEmail();
            dataRow[7] = tk.getMK();
            
            model.addRow(dataRow);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 13, 90, 30));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên", "SĐT", "Giới tính", "Ngày sinh", "Địa chỉ", "Email", "MK"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 810, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Danh sách bệnh nhân");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 110, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 110, 40));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 110, 40));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        jButton5.setText("Thêm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 110, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("SĐT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tên");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 80, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Giới tính");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 80, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ngày sinh");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 80, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 400, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 400, 30));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Nam");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, 30));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Nữ");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        jButton6.setText("Tìm kiếm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 110, 40));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 180, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 400, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Địa chỉ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 80, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 80, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 400, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mật khẩu");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 80, 30));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 400, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ve-sinh-rang-mieng.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 891, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        MenuBS menu = new MenuBS();
        this.setVisible(false);
        menu.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here
        
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") 
                || (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()))
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập đầy đủ thông tin!");
            flag = false;
        }
        else
        {
            flag = true;
        }
        if (flag){
            if (JOptionPane.showConfirmDialog(rootPane, "Bạn muốn thêm bệnh nhân không?") == JOptionPane.NO_OPTION)
            {
                return;
            }
            Benhnhan sp = new Benhnhan();

            sp.setSDT(jTextField1.getText());
            sp.setTen(jTextField2.getText());
            sp.setDiaChi(jTextField3.getText());
            sp.setEmail(jTextField4.getText());
            sp.setMK(jTextField5.getText());
            if (jRadioButton1.isSelected())
            {
                sp.setGioitinh((String) jRadioButton1.getText());
            }
            else if (jRadioButton2.isSelected())
            {
                sp.setGioitinh((String) jRadioButton2.getText());
            }
            try {
                
                sp.setNgaysinh(dateformat.parse(dateformat.format(jDateChooser1.getDate())));

            } catch (ParseException ex) {
                Logger.getLogger(DSBenhnhan.class.getName()).log(Level.SEVERE, null, ex);
            }



            if(new BenhnhanDAO().AddBenhnhan(sp))
            {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
                listbn.add(sp); 
                showTable();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "SDT đã tồn tại!");
            }
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jDateChooser1.setDate(null);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") 
                || (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()))
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập đầy đủ thông tin!");
            flag = false;
        }
        else
        {
            flag = true;
        }
        if (JOptionPane.showConfirmDialog(rootPane, "Bạn muốn thay đổi không?") == JOptionPane.NO_OPTION)
        {
            return;
        }
        Benhnhan sp = new Benhnhan();
        sp.setSDT(jTextField1.getText());
        sp.setTen(jTextField2.getText());
        sp.setDiaChi(jTextField3.getText());
        sp.setEmail(jTextField4.getText());
        sp.setMK(jTextField5.getText());
        if (jRadioButton1.isSelected())
        {
            sp.setGioitinh((String) jRadioButton1.getText());
        }
        else if (jRadioButton2.isSelected())
        {
            sp.setGioitinh((String) jRadioButton2.getText());
        }
        try {
            sp.setNgaysinh(dateformat.parse(dateformat.format(jDateChooser1.getDate())));

        } catch (ParseException ex) {
            Logger.getLogger(DSBenhnhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(new BenhnhanDAO().UpdateBenhnhan(sp))
        {
            showTable();
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");   
        }
        
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công!");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row >= 0)
        {
            jTextField1.setText(jTable1.getValueAt(row, 2).toString());
            jTextField2.setText(jTable1.getValueAt(row, 1).toString());
            jTextField3.setText(jTable1.getValueAt(row, 5).toString());
            jTextField4.setText(jTable1.getValueAt(row, 6).toString());
            jTextField5.setText(jTable1.getValueAt(row, 7).toString());
            try {
                jDateChooser1.setDate(dateformat.parse(jTable1.getValueAt(row, 4).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(DSBenhnhan.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().equals("") || jTextField2.getText().equals("") 
                || (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()))
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập đầy đủ thông tin!");
            flag = false;
        }
        else
        {
            flag = true;
        }
        if (JOptionPane.showConfirmDialog(rootPane, "Bạn muốn xóa bệnh nhân không?") == JOptionPane.NO_OPTION)
        {
            return;
        }
        Benhnhan sp = new Benhnhan();
        
        sp.setSDT(jTextField1.getText());
        sp.setTen(jTextField2.getText());
        sp.setDiaChi(jTextField3.getText());
        sp.setEmail(jTextField4.getText());
        if (jRadioButton1.isSelected())
        {
            sp.setGioitinh((String) jRadioButton1.getText());
        }
        else if (jRadioButton2.isSelected())
        {
            sp.setGioitinh((String) jRadioButton2.getText());
        }

        try {
            sp.setNgaysinh(dateformat.parse(dateformat.format(jDateChooser1.getDate())));

        } catch (ParseException ex) {
            Logger.getLogger(DSBenhnhan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new BenhnhanDAO().DeleteBenhnhan(sp);
        showTable();
        JOptionPane.showMessageDialog(rootPane, "Bệnh nhân đã được xóa!");  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin tìm kiếm!");
        }
        else
        {
            String s = jTextField1.getText();
            fillTable(s);
        }
        
        
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
            java.util.logging.Logger.getLogger(DSBenhnhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DSBenhnhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DSBenhnhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSBenhnhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DSBenhnhan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}