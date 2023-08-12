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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGHIA_PC
 */
public class HosoDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    public HosoDAO()
    {
        try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from hoso",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddHoso(Hoso sp)
    {
       
        String sql = "insert into hoso(IDhoso,SDTbn,MaBenh,IDbs,TongTien,NgayTao)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getIDhoso());
            pstm.setString(2,sp.getSDTbn());
            pstm.setString(3, sp.getMaBenh());
            pstm.setString(4, sp.getIDbs());
            pstm.setString(5, sp.getTongTien());
            pstm.setDate(6,new java.sql.Date(sp.getNgayTao().getTime()));
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateHoso(Hoso sp)
    {
       
        String sql = "update hoso set Tenbn=?,SDT=?,Benh=?,Tenbs=?,TongTien=?,NgayTao=?"
                + "where IDhoso=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(6,sp.getIDhoso());
            pstm.setString(1,sp.getSDTbn());
            pstm.setString(2, sp.getMaBenh());
            pstm.setString(3, sp.getIDbs());
            pstm.setString(4, sp.getTongTien());
            pstm.setDate(5,new java.sql.Date(sp.getNgayTao().getTime()));

            
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public  Hoso getHoso(String ID)
    {
       
        String sql = "select * from hoso where IDhoso like '%"+ID+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Hoso tk = new Hoso();
            while(rs.next())
            {
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setIDbs(rs.getString("IDbs"));
                tk.setTongTien(rs.getString("TongTien"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Hoso> FindBySDT(String TK)
    {
        rs =null;
        List<Hoso> list = new ArrayList<>();
        String sql = "select * from hoso where SDTbn like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Hoso tk = new Hoso();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setIDbs(rs.getString("IDbs"));
                tk.setTongTien(rs.getString("TongTien"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }

    
    public List<Hoso> FindByID(String TK)
    {
        rs =null;
        List<Hoso> list = new ArrayList<>();
        String sql = "select * from hoso where IDhoso like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Hoso tk = new Hoso();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setIDbs(rs.getString("IDbs"));
                tk.setTongTien(rs.getString("TongTien"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    

    
    public ArrayList<Hoso> getListHoso()
    {
        ArrayList<Hoso> list = new ArrayList<>();
        String sql = "select * from hoso";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                Hoso tk = new Hoso();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setIDbs(rs.getString("IDbs"));
                tk.setTongTien(rs.getString("TongTien"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                list.add(tk);
                
        }
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
    public ArrayList<Hoso> FindByNgayNhap(String jdc1, String jdc2)
    {
        rs =null;
        ArrayList<Hoso> list = new ArrayList<>();
        String sql = "select * from hoso where NgayTao between '"+jdc1
                +"' and '"+jdc2+"'" ;
        
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Hoso tk = new Hoso();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setSDTbn(rs.getString("SDTbn"));
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setIDbs(rs.getString("IDbs"));
                tk.setTongTien(rs.getString("TongTien"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HosoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    
    
    public String TaoHS()
    {
        String shd = "";
        DateFormat dateformat = new SimpleDateFormat("yyMMddhhmm");
        shd = "HS" + dateformat.format(new Date());
        return shd;
    }
    int i = 0;
    public String TaoIDDT()
    {
        while (i <10)
        {
            i++;
            return TaoHS() + "DT"+i;
        }
        return "";
    }
    
}
