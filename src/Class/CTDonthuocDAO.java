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
public class CTDonthuocDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    private String ID;
    public CTDonthuocDAO()
    {
        try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from ctdonthuoc",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean AddDonthuoc(CTDonthuoc sp)
    {
       
        String sql = "insert into ctdonthuoc(IDCTdonthuoc,IDhoso,IDthuoc,GhiChu,Dongia,Soluong)"
                + "VALUES(?,?,?,?,?,?)";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getIDCTdonthuoc());
            pstm.setString(2,sp.getIDhoso());
            pstm.setString(3,sp.getIDthuoc());
            pstm.setString(4, sp.getGhiChu());
            pstm.setString(5,sp.getDongia());
            pstm.setString(6, sp.getSoluong());
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean UpdateDonthuoc(CTDonthuoc sp)
    {
       
        String sql = "update ctdonthuoc set IDhoso=?,IDthuoc=?,GhiChu=?,Dongia=?,Soluong=?"
                + "where IDCTdonthuoc=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(6,sp.getIDCTdonthuoc());
            pstm.setString(1,sp.getIDhoso());
            pstm.setString(2,sp.getIDthuoc());
            pstm.setString(3, sp.getGhiChu());
            pstm.setString(4,sp.getDongia());
            pstm.setString(5, sp.getSoluong());

            
            return pstm.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void DeleteDonthuoc(CTDonthuoc sp)
    {
       
        String sql = "delete from ctdonthuoc where IDCTdonthuoc=?";
        try {
            pstm =con.prepareStatement(sql);
            pstm.setString(1,sp.getIDCTdonthuoc());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public  CTDonthuoc getDonthuoc(String ID)
    {
       
        String sql = "select * from ctdonthuoc where IDCTdonthuoc like '%"+ID+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            CTDonthuoc tk = new CTDonthuoc();
            while(rs.next())
            {
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setIDCTdonthuoc(rs.getString("IDCTdonthuoc"));
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setGhiChu(rs.getString("GhiChu"));
                tk.setDongia(rs.getString("Dongia"));
                tk.setSoluong(rs.getString("Soluong"));

                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<CTDonthuoc> FindByID(String TK)
    {
        rs =null;
        List<CTDonthuoc> list = new ArrayList<>();
        String sql = "select * from ctdonthuoc where IDhoso like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                CTDonthuoc tk = new CTDonthuoc();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setIDCTdonthuoc(rs.getString("IDCTdonthuoc"));
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setGhiChu(rs.getString("GhiChu"));
                tk.setDongia(rs.getString("Dongia"));
                tk.setSoluong(rs.getString("Soluong"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    public List<CTDonthuoc> FindByTen(String TK)
    {
        rs =null;
        List<CTDonthuoc> list = new ArrayList<>();
        String sql = "select * from ctdonthuoc where Ten like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                CTDonthuoc tk = new CTDonthuoc();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setIDCTdonthuoc(rs.getString("IDCTdonthuoc"));
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setGhiChu(rs.getString("GhiChu"));
                tk.setDongia(rs.getString("Dongia"));
                tk.setSoluong(rs.getString("Soluong"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BacsiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }

    
    public ArrayList<CTDonthuoc> getListDonThuoc()
    {
        ArrayList<CTDonthuoc> list = new ArrayList<>();
        String sql = "select * from ctdonthuoc";
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
                CTDonthuoc tk = new CTDonthuoc();
                tk.setIDhoso(rs.getString("IDhoso"));
                tk.setIDCTdonthuoc(rs.getString("IDCTdonthuoc"));
                tk.setIDthuoc(rs.getString("IDthuoc"));
                tk.setGhiChu(rs.getString("GhiChu"));
                tk.setDongia(rs.getString("Dongia"));
                tk.setSoluong(rs.getString("Soluong"));
                list.add(tk);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CTDonthuocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

}
