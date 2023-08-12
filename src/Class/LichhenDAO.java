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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGHIA_PC
 */
public class LichhenDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    private String ID;
    public LichhenDAO()
    {
        try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from lichhen",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddLich(Lichhen sp)
    {
       
        String sql = "insert into lichhen(MaHen,SDTbn,MaBenh,NgayHen,GioHen)"
                + "VALUES(?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getMaHen());
            pstm.setString(2,sp.getSDTbn());
            pstm.setString(3, sp.getMaBenh());
            pstm.setDate(4,new java.sql.Date(sp.getNgayHen().getTime()));
            pstm.setTime(5,new java.sql.Time(sp.getGioHen().getTime()) );
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateLich(Lichhen sp)
    {
       
        String sql = "update lichhen set SDTbn=?,MaBenh=?,NgayHen=?,GioHen=?"
                + "where MaHen=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(5,sp.getMaHen());
            pstm.setString(1,sp.getSDTbn());
            pstm.setString(2, sp.getMaBenh());
            pstm.setDate(3,new java.sql.Date(sp.getNgayHen().getTime()));
            pstm.setTime(4,new java.sql.Time(sp.getGioHen().getTime()));

            
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void DeleteLich(Lichhen sp)
    {
       
        String sql = "delete from lichhen where MaHen=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getMaHen());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public  Lichhen getLich(String mahen)
    {
       
        String sql = "select * from lichhen where MaHen like '%"+mahen+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Lichhen tk = new Lichhen();
            while(rs.next())
            {
                tk.setMaHen(rs.getString("MaHen"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setNgayHen(rs.getDate("NgayHen"));
                tk.setGioHen(rs.getTime("GioHen"));

                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public  Lichhen getNgayHen(String Date)
    {
       
        String sql = "select * from lichhen where NgayHen like '%"+Date+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Lichhen tk = new Lichhen();
            while(rs.next())
            {
                tk.setMaHen(rs.getString("MaHen"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setNgayHen(rs.getDate("NgayHen"));
                tk.setGioHen(rs.getTime("GioHen"));

                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    List<Lichhen> list = new ArrayList<>();
    public List<Lichhen> listNgayHen(String TK)
    {
        rs =null;
//        List<Khothuoc> list = new ArrayList<>();
        String sql = "select * from lichhen where NgayHen like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Lichhen tk = new Lichhen();
                tk.setMaHen(rs.getString("MaHen"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setNgayHen(rs.getDate("NgayHen"));
                tk.setGioHen(rs.getTime("GioHen"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    
    
    public ArrayList<Lichhen> getListLich()
    {
        ArrayList<Lichhen> list = new ArrayList<>();
        String sql = "select * from lichhen";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                Lichhen tk = new Lichhen();
                tk.setMaHen(rs.getString("MaHen"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setNgayHen(rs.getDate("NgayHen"));
                tk.setGioHen(rs.getTime("GioHen"));
                list.add(tk);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LichhenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
    int i = 0;
    public String TaoMaHen()
    {
        String shd = "";
        DateFormat dateformat = new SimpleDateFormat("yyMMddhhmm");
        shd = "LH" + dateformat.format(new Date());
        return shd;
    }

}
