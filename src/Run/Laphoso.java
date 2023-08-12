/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import Class.Benhnhan;
import Class.BenhnhanDAO;
import Class.CTDonthuoc;
import Class.CTDonthuocDAO;
import Class.Benh;
import Class.Hoso;
import Class.HosoDAO;
import Class.Thuoc;
import Class.ThuocDAO;
import Class.Bacsi;
import Class.BacsiDAO;
import Class.BenhDAO;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGHIA_PC
 */
public class Laphoso extends javax.swing.JFrame {

    static String ID ;
    public static String SoLuongOrder;
    public static boolean Cancel;
    public static String GhiChu;
    static String nhorang;
    static String niengrang;
    static String bocrang;
    static String trongrang;

    private ArrayList<Hoso> lisths;
    private ArrayList<CTDonthuoc> listdt;
    private List<Thuoc> listkt = new ArrayList<>();
    private List<Thuoc> listbf = new ArrayList<>();
    private List<Benhnhan> listbn = new ArrayList<>();
    DefaultTableModel model;
    ThuocDAO khothuocDAO = new ThuocDAO();
    HosoDAO hosoDAO = new HosoDAO();
    HosoDAO hsDAO = new HosoDAO();
    BenhDAO bDAO = new BenhDAO();
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    private long tienthuoc = 0;
    private long TongTien = 0;
    public List<String> data;

    public Laphoso() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
        listbf = new ThuocDAO().getListThuoc();
        listbn = new BenhnhanDAO().getListBenhnhan();
        lisths = new HosoDAO().getListHoso();
        listdt = new CTDonthuocDAO().getListDonThuoc();
        Bacsi tt = new BacsiDAO().getBacsi(ID);
        txtbs.setText(tt.getTen());
        
        showTable();
    }
    
    
    public void tt()
    {

    }
    public void showTable() {
        model.setNumRows(0);

        for (Thuoc tk : new ThuocDAO().getListThuoc()) {

            Object dataRow[] = new Object[10];
            dataRow[0] = jTable1.getRowCount() + 1;
            dataRow[1] = tk.getIDthuoc();
            dataRow[2] = tk.getTen();
            dataRow[3] = tk.getDonvi();
            dataRow[4] = tk.getTonkho();
            dataRow[5] = tk.getChucnang();
            dataRow[6] = tk.getNgaynhap();
            long dg = Long.parseLong(tk.getDongia());
            dataRow[7] = numberFormat.format(dg);

            model.addRow(dataRow);
        }
    }
    
    public void showTable1() 
    {
        model.setNumRows(0);

        for (Thuoc tk : listbf) {

            Object dataRow[] = new Object[10];
            dataRow[0] = jTable1.getRowCount() + 1;
            dataRow[1] = tk.getIDthuoc();
            dataRow[2] = tk.getTen();
            dataRow[3] = tk.getDonvi();
            dataRow[4] = tk.getTonkho();
            dataRow[5] = tk.getChucnang();
            dataRow[6] = tk.getNgaynhap();
            long dg = Long.parseLong(tk.getDongia());
            dataRow[7] = numberFormat.format(dg);

            model.addRow(dataRow);
        }
    }
    
    
    public List<String> getData(String s)
    {
        data = new ArrayList<>();
        if (s.equals("Nhổ răng"))
        {
            
            data.add("Nhổ răng sữa");
            data.add("Nhổ răng vĩnh viễn");
            data.add("Nhổ răng sâu");
            data.add("Nhổ răng khôn");
            
        }
        else if (s.equals("Niềng răng"))
        {
            data.add("Mắc cài kim loại chun đơn giản");
            data.add("Mắc cài kim loại chun tiêu chuẩn");
            data.add("Mắc cài kim loại chun tự động");
            data.add("Mắc cài sứ buộc chun");
            data.add("Mắc cài sứ tự động");
            
        }
        else if (s.equals("Bọc răng sứ"))
        {
            data.add("Răng sứ Titan");
            data.add("Răng sứ Titanium");
            data.add("Răng sứ Nacera");
            data.add("Răng sứ Zirconia");
            data.add("Răng sứ Lisi Nano");
           
        }
        else if (s.equals("Trồng răng"))
        {
            data.add("Trồng răng implant Hàn Quốc I");
            data.add("Trồng răng implant Hàn Quốc II");
            data.add("Trồng răng implant Pháp");
            data.add("Trồng răng implant Mỹ");
            data.add("Trồng răng implant Đức");
            
        }
        return data;
        
    }
    
    public void showComboData(List<String> data)
    {
        jComboBox3.removeAllItems();
        for (String str: data)
        {
            jComboBox3.addItem(str);
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

        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtbn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbtnam = new javax.swing.JRadioButton();
        rbtnu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txttt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Lập hồ sơ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jButton2.setText("Quay lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 40));
        getContentPane().add(txtbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 290, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Tên bệnh nhân:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Ngày sinh:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, 20));

        txtbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbsActionPerformed(evt);
            }
        });
        getContentPane().add(txtbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 290, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Bác sĩ:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, 20));

        txtsdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtActionPerformed(evt);
            }
        });
        getContentPane().add(txtsdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 290, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("SĐT:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Giới tính:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        rbtnam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnam.setText("Nam");
        getContentPane().add(rbtnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 143, -1, 30));

        rbtnu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtnu.setText("Nữ");
        getContentPane().add(rbtnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 143, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Khám/Chữa bệnh:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("Kho thuốc");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên", "Đơn vị", "Tồn kho", "Chức năng", "Ngày nhập", "Đơn giá"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 810, 160));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("Tổng chi phí:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, -1, -1));
        getContentPane().add(txttt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 290, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 110, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Accept.png"))); // NOI18N
        jButton3.setText("Xác nhận");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 130, 40));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhổ răng", "Niềng răng", "Bọc răng sứ", "Trồng răng", " " }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setInheritsPopupMenu(true);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 130, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("Chí phí khám/chữa bệnh:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 190, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 255));
        jLabel12.setText("Chi phí đơn thuốc: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, -1, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 190, 40));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 240, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("Dịch vụ:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 262, -1, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 210, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ve-sinh-rang-mieng.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 946, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

            MenuBS menu = new MenuBS();
            this.setVisible(false);
            menu.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbsActionPerformed

    private void txtsdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        int row = jTable1.getSelectedRow();
        if (evt.getClickCount() >= 2) {
            String IDthuoc = jTable1.getValueAt(row, 1).toString();
            
            DonThuocChiTiet.IDthuoc = IDthuoc;
            Order qlod = new Order(this, true);
            qlod.setVisible(true);

            if (Cancel) {
                return;
            } else {

                listkt = khothuocDAO.FindByID(IDthuoc);
                
                DonThuocChiTiet.listkt = listkt;
                Thuoc xm = khothuocDAO.getThuoc(IDthuoc);
 
                String s = String.valueOf(Integer.parseInt(model.getValueAt(row, 4).toString()) - Integer.parseInt(SoLuongOrder));
                xm.setTonkho(s);
                new ThuocDAO().UpdateThuoc(xm);
                showTable();
                
                long dg = Long.parseLong(xm.getDongia());
                long sl = Long.parseLong(SoLuongOrder);
                tienthuoc += dg*sl;
                jTextField2.setText(numberFormat.format(tienthuoc));
                TongTien = Long.parseLong(jTextField1.getText().replace(",", ""))+tienthuoc;
                txttt.setText(numberFormat.format(TongTien));

                
            }
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtbn.setText("");
        jDateChooser1.setDate(null);
        txtsdt.setText("");
        jComboBox1.setSelectedItem(false);
        jComboBox3.setSelectedItem(false);
        txttt.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        rbtnam.setSelected(false);
        rbtnu.setSelected(false);
        showTable1();

        
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean flag = false;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String ns = dateformat.format(jDateChooser1.getDate());
        if (txtbn.getText().equals("") || txtsdt.getText().equals("") || ns.equals("")
                || ((String) jComboBox1.getSelectedItem()).equals("") || (!rbtnam.isSelected() && !rbtnu.isSelected()) )
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập đầy đủ thông tin!");
            flag = false;
        }
        else
        {
            flag = true;
        }
        if (flag)
        {
            DonThuocChiTiet.TenBn = txtbn.getText();
            DonThuocChiTiet.ngaysinh = ns;
            DonThuocChiTiet.sdt = txtsdt.getText();
            DonThuocChiTiet.bs = txtbs.getText();
            DonThuocChiTiet.tt = txttt.getText();
            DonThuocChiTiet.kcb = (String) jComboBox1.getSelectedItem();
            DonThuocChiTiet.ctb =  bDAO.getMaBenh((String) jComboBox3.getSelectedItem());
            DonThuocChiTiet.tkcb = jTextField1.getText();
            if (rbtnam.isSelected()) {
                DonThuocChiTiet.gt = (String) rbtnam.getText();
            }
            else if(rbtnu.isSelected())
            {
                DonThuocChiTiet.gt = (String) rbtnu.getText();
            }
        

            // Them benh nhan moi
            Benhnhan sp = new Benhnhan();

            sp.setSDT(txtsdt.getText());
            sp.setTen(txtbn.getText());
            if (rbtnam.isSelected())
            {
                sp.setGioitinh((String) rbtnam.getText());
            }
            else if (rbtnu.isSelected())
            {
                sp.setGioitinh((String) rbtnu.getText());
            }
            try {
                sp.setNgaysinh(dateformat.parse(ns));

            } catch (ParseException ex) {
                Logger.getLogger(DSBenhnhan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int count = 0;
            for (Benhnhan bn: new BenhnhanDAO().getListBenhnhan())
            {
                if (bn.getSDT().equals(txtsdt.getText()))
                {
                    count++;
                }
                
            }

            if(count == 0)
            {
                new BenhnhanDAO().AddBenhnhan(sp);
                JOptionPane.showMessageDialog(rootPane, "Bệnh nhân mới được thêm thành công!");
                listbn.add(sp); 
                
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Bệnh nhân đã có trong danh sách!");
            }
 
            
            // Them ho so moi
            Hoso hs = new Hoso();
            
            String idhs = hosoDAO.TaoHS();

            DonThuocChiTiet.idhs = idhs;
            String nt = dateformat.format(new Date());
            hs.setIDhoso(idhs);
            hs.setSDTbn(txtsdt.getText());
 
            hs.setMaBenh(bDAO.getMaBenh((String) jComboBox3.getSelectedItem()));
            hs.setIDbs(ID);
            hs.setTongTien(txttt.getText());
            try {
                hs.setNgayTao(new SimpleDateFormat("yyyy-MM-dd").parse(nt));
            } catch (ParseException ex) {
                Logger.getLogger(Laphoso.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(new HosoDAO().AddHoso(hs))
            {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật hồ sơ mới thành công!");
                lisths.add(hs); 
                showTable();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Thông tin hồ sơ đã tồn tại!");
            }
            
            // Them don thuoc moi
            CTDonthuoc dt = new CTDonthuoc();

            for (Thuoc kt: listkt)
            {
                System.out.println(idhs);
                dt.setIDhoso(idhs);
                dt.setIDCTdonthuoc(hosoDAO.TaoIDDT());
                dt.setIDthuoc(kt.getIDthuoc());
                dt.setDongia(kt.getDongia());
                dt.setGhiChu(GhiChu);
                dt.setSoluong(SoLuongOrder);
//                long dg = Long.parseLong(kt.getDongia());
//                long sl = Long.parseLong(SoLuongOrder);

                if(new CTDonthuocDAO().AddDonthuoc(dt))
                {
                    listdt.add(dt); 
                }
            }

            DonThuocChiTiet hsct = new DonThuocChiTiet(this, true);
            hsct.setVisible(true);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:

        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
//        System.out.println(evt.getActionCommand());

        String item = jComboBox1.getSelectedItem().toString();
        showComboData(getData(item));
        


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
//        String item = (String) jComboBox1.getSelectedItem();    
        String c = (String) jComboBox3.getSelectedItem();
        System.out.println(c);
        Benh t = new BenhDAO().getBenh(bDAO.getMaBenh(c));
        long gia = Long.parseLong(t.getDonGia());
        jTextField1.setText(numberFormat.format(gia));

        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1PropertyChange

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
            java.util.logging.Logger.getLogger(Laphoso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laphoso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laphoso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laphoso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laphoso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rbtnam;
    private javax.swing.JRadioButton rbtnu;
    private javax.swing.JTextField txtbn;
    private javax.swing.JTextField txtbs;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttt;
    // End of variables declaration//GEN-END:variables

    private Object NhorangDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private Thuoc ThuocDAO() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
