/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGHIA_PC
 */
public class ThuocDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    private String ID;
    public ThuocDAO()
    {
        try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from thuoc",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddThuoc(Thuoc sp)
    {
       
        String sql = "insert into thuoc(IDthuoc,Ten,DonVi,TonKho,ChucNang,NgayNhap,DonGia)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getIDthuoc());
            pstm.setString(2,sp.getTen());
            pstm.setString(3, sp.getDonvi());
            pstm.setString(4,sp.getTonkho());
            pstm.setString(5, sp.getChucnang());
            pstm.setDate(6,new java.sql.Date(sp.getNgaynhap().getTime()));
            pstm.setString(7, sp.getDongia());
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateThuoc(Thuoc sp)
    {
       
        String sql = "update thuoc set Ten=?,DonVi=?,TonKho=?,ChucNang=?,NgayNhap=?,DonGia=?"
                + "where IDthuoc=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(7,sp.getIDthuoc());
            pstm.setString(1,sp.getTen());
            pstm.setString(2, sp.getDonvi());
            pstm.setString(3, sp.getTonkho());
            pstm.setString(4, sp.getChucnang());
            pstm.setDate(5,new java.sql.Date(sp.getNgaynhap().getTime()));
            pstm.setString(6, sp.getDongia());

            
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void DeleteThuoc(Thuoc sp)
    {
       
        String sql = "delete from thuoc where ID=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getIDthuoc());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public  Thuoc getThuoc(String ID)
    {
       
        String sql = "select * from thuoc where IDthuoc like '%"+ID+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Thuoc tk = new Thuoc();
            while(rs.next())
            {
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setTen(rs.getString("Ten"));
                tk.setDonvi(rs.getString("DonVi"));
                tk.setTonkho(rs.getString("TonKho"));
                tk.setChucnang(rs.getString("ChucNang"));
                tk.setNgaynhap(rs.getDate("NgayNhap"));
                tk.setDongia(rs.getString("DonGia"));
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    List<Thuoc> list = new ArrayList<>();
    public List<Thuoc> FindByID(String TK)
    {
        rs =null;
//        List<Khothuoc> list = new ArrayList<>();
        String sql = "select * from thuoc where IDthuoc like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Thuoc tk = new Thuoc();
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setTen(rs.getString("Ten"));
                tk.setDonvi(rs.getString("DonVi"));
                tk.setTonkho(rs.getString("TonKho"));
                tk.setChucnang(rs.getString("ChucNang"));
                tk.setNgaynhap(rs.getDate("NgayNhap"));
                tk.setDongia(rs.getString("DonGia"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    
    public List<Thuoc> FindByTen(String TK)
    {
        rs =null;
        List<Thuoc> list = new ArrayList<>();
        String sql = "select * from thuoc where Ten like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Thuoc tk = new Thuoc();
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setTen(rs.getString("Ten"));
                tk.setDonvi(rs.getString("DonVi"));
                tk.setTonkho(rs.getString("TonKho"));
                tk.setChucnang(rs.getString("ChucNang"));
                tk.setNgaynhap(rs.getDate("NgayNhap"));
                tk.setDongia(rs.getString("DonGia"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    List<Thuoc> listbf = new ArrayList<>();
    public List<Thuoc> BeforeChange(String TK)
    {
        rs =null;
        
        String sql = "select * from thuoc where ID like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Thuoc tk = new Thuoc();
                tk.setTonkho(rs.getString("TonKho"));
                listbf.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return listbf;
        
    }
    
    public ArrayList<Thuoc> getListThuoc()
    {
        ArrayList<Thuoc> list = new ArrayList<>();
        String sql = "select * from thuoc";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                Thuoc tk = new Thuoc();
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setTen(rs.getString("Ten"));
                tk.setDonvi(rs.getString("DonVi"));
                tk.setTonkho(rs.getString("TonKho"));
                tk.setChucnang(rs.getString("ChucNang"));
                tk.setNgaynhap(rs.getDate("NgayNhap"));
                tk.setDongia(rs.getString("DonGia"));
                list.add(tk);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    

}
