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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author NGHIA_PC
 */
public class BenhnhanDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    private ArrayList<Bacsi> list;
    public BenhnhanDAO()
    {
    try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from benhnhan",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddBenhnhan(Benhnhan tt )
    {
       
        String sql = "insert into benhnhan(SDT,Ten,GioiTinh,NgaySinh,DiaChi,Email,MK)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,tt.getSDT());
            pstm.setString(2,tt.getTen());
            pstm.setString(3, tt.getGioitinh());
            pstm.setString(5,tt.getDiaChi());
            pstm.setString(6, tt.getEmail());
            pstm.setString(7, tt.getMK());
            pstm.setDate(4,new java.sql.Date(tt.getNgaysinh().getTime()));
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateBenhnhan(Benhnhan tt)
    {
       
        String sql = "update benhnhan set Ten=?,GioiTinh=?,NgaySinh=?,DiaChi=?,Email=?,MK=?"
                + "where SDT=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(7,tt.getSDT());
            pstm.setString(1,tt.getTen());
            pstm.setString(2, tt.getGioitinh());
            pstm.setString(4,tt.getDiaChi());
            pstm.setString(5,tt.getEmail());
            pstm.setString(6, tt.getMK());
            pstm.setDate(3,new java.sql.Date(tt.getNgaysinh().getTime()));
            
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void DeleteBenhnhan(Benhnhan tt)
    {
       
        String sql = "delete from benhnhan where SDT=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,tt.getSDT());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public  Benhnhan getBenhnhan(String SDT)
    {
       
        String sql = "select * from benhnhan where SDT like '%"+SDT+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Benhnhan tt = new Benhnhan();
            while(rs.next())
            {
                tt.setSDT(rs.getString("SDT"));
                tt.setTen(rs.getString("Ten"));
                tt.setNgaysinh(rs.getDate("NgaySinh"));
                tt.setGioitinh(rs.getString("GioiTinh"));
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setEmail(rs.getString("Email"));
                tt.setMK(rs.getString("MK"));
                return tt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
    public List<Benhnhan> FindByID(String SDT)
    {
        rs =null;
        List<Benhnhan> list = new ArrayList<>();
        String sql = "select * from benhnhan where SDT like '%"+SDT+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Benhnhan tt = new Benhnhan();
                tt.setSDT(rs.getString("SDT"));
                tt.setTen(rs.getString("Ten"));
                tt.setNgaysinh(rs.getDate("NgaySinh"));
                tt.setGioitinh(rs.getString("GioiTinh")); 
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setEmail(rs.getString("Email"));
                tt.setMK(rs.getString("MK"));
                list.add(tt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    public ArrayList<Benhnhan> getListBenhnhan()
    {
        ArrayList<Benhnhan> list = new ArrayList<>();
        String sql = "select * from benhnhan";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                Benhnhan tt = new Benhnhan();
                tt.setSDT(rs.getString("SDT"));
                tt.setTen(rs.getString("Ten"));
                tt.setNgaysinh(rs.getDate("NgaySinh"));
                tt.setGioitinh(rs.getString("GioiTinh")); 
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setEmail(rs.getString("Email"));
                tt.setMK(rs.getString("MK"));
                list.add(tt);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(BenhnhanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
