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
public class BacsiDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    private ArrayList<Bacsi> list;
    public BacsiDAO()
    {
    try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from bacsi",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddBacsi(Bacsi tt )
    {
       
        String sql = "insert into bacsi(ID,Ten,GioiTinh,NgaySinh,DiaChi,SDT,Email,ChucVu,MK)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,tt.getID());
            pstm.setString(2,tt.getTen());
            pstm.setString(3, tt.getGioitinh());
            pstm.setDate(4,new java.sql.Date(tt.getNgaysinh().getTime()));
            pstm.setString(5, tt.getDiachi());
            pstm.setString(6, tt.getSDT());
            pstm.setString(7, tt.getEmail());
            pstm.setString(8, tt.getMK());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateBacsi(Bacsi tt)
    {
       
        String sql = "update bacsi set Ten=?,GioiTinh=?,NgaySinh=?,DiaChi=?,SDT=?,Email=?,ChucVu=?,MK=?"
                + "where ID=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(8, tt.getID());
            pstm.setString(1,tt.getTen());
            pstm.setString(2, tt.getGioitinh());
            pstm.setDate(3,new java.sql.Date(tt.getNgaysinh().getTime()));
            pstm.setString(4, tt.getDiachi());
            pstm.setString(5, tt.getSDT());
            pstm.setString(6, tt.getEmail());
            pstm.setString(7, tt.getMK());
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void DeleteBacsi(Bacsi tt)
    {
       
        String sql = "delete from bacsi where ID=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,tt.getID());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    public  Bacsi getBacsi(String ID)
    {
       
        String sql = "select * from bacsi where ID like '%"+ID+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Bacsi tt = new Bacsi();
            while(rs.next())
            {
                
                tt.setID(rs.getString("ID"));
                tt.setTen(rs.getString("Ten"));
                tt.setGioitinh(rs.getString("GioiTinh"));
                tt.setNgaysinh(rs.getDate("NgaySinh"));
                tt.setDiachi(rs.getString("DiaChi"));
                tt.setSDT(rs.getString("SDT"));
                tt.setEmail(rs.getString("Email"));
                tt.setMK(rs.getString("MK"));
                return tt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Bacsi> FindByID(String ID)
    {
        rs =null;
        List<Bacsi> list = new ArrayList<>();
        String sql = "select * from bacsi where ID like '%"+ID+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Bacsi tt = new Bacsi();
                tt.setID(rs.getString(1));
                tt.setTen(rs.getString(2));
                tt.setGioitinh(rs.getString(3));
                tt.setNgaysinh(rs.getDate(4));
                tt.setDiachi(rs.getString(5));
                tt.setSDT(rs.getString(6));
                tt.setEmail(rs.getString(7));
                tt.setMK(rs.getString(8));
                list.add(tt);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    public ArrayList<Bacsi> getListBacsi()
    {
        ArrayList<Bacsi> list = new ArrayList<>();
        String sql = "select * from bacsi";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                Bacsi tt = new Bacsi();
                tt.setID(rs.getString("ID"));
                tt.setTen(rs.getString("Ten"));
                tt.setGioitinh(rs.getString("GioiTinh"));
                tt.setNgaysinh(rs.getDate("NgaySinh"));
                tt.setDiachi(rs.getString("DiaChi"));
                tt.setSDT(rs.getString("SDT"));
                tt.setEmail(rs.getString("Email"));
                tt.setMK(rs.getString("MK"));
                list.add(tt);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
