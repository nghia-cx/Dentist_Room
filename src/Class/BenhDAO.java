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
public class BenhDAO {
    public Connection con;
    public ResultSet rs;
    public Statement stm;
    public PreparedStatement pstm;
    public BenhDAO()
    {
            try {
            String driver ="com.mysql.jdbc.Driver";
            String connection="jdbc:mysql://localhost:3306/dentistroom";
            String user = "root";
            String password ="Nghia11223344";
            con = DriverManager.getConnection(connection,user,password);
            pstm = con.prepareStatement("select * from benh",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

        } catch (SQLException ex) {
            Logger.getLogger(BenhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getMaBenh(String TenBenh)
    {
        String sql = "select MaBenh from benh where Ten like '%"+TenBenh+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                return rs.getString("MaBenh");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public List<Benh> FindByID(String TK)
    {
        rs =null;
        List<Benh> list = new ArrayList<>();
        
        String sql = "select * from benh where MaBenh like '%"+TK+"%'";       
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next())
            {
                Benh tk = new Benh();
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setTen(rs.getString("Ten"));
                tk.setChiDinh(rs.getString("ChiDinh"));          
                tk.setBaohanh(rs.getString("BaoHanh"));
                tk.setDonGia(rs.getString("DonGia"));
                list.add(tk);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BenhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return list;
        
    }
    
    public Benh getBenh(String ID)
    {
       
        String sql = "select * from benh where MaBenh like '%"+ID+"%'";
        try {
            pstm =con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Benh tk = new Benh();
            while(rs.next())
            {
                tk.setMaBenh(rs.getString("MaBenh"));
                tk.setTen(rs.getString("Ten"));
                tk.setChiDinh(rs.getString("ChiDinh"));          
                tk.setBaohanh(rs.getString("BaoHanh"));
                tk.setDonGia(rs.getString("DonGia"));
                return tk;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BenhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Benh> getListBenh(String ID)
    {
        ArrayList<Benh> list = new ArrayList<>();
        String sql = "";
        if(ID.equals("Nhổ răng"))
        {
            sql = "select * from benh where MaBenh like 'NhR%' " ;
        }
        if(ID.equals("Niềng răng"))
        {
            sql = "select * from benh where MaBenh like 'NiR%' " ;
        }
        if(ID.equals("Trồng răng"))
        {
            sql = "select * from benh where MaBenh like 'TR%' " ;
        }
        if(ID.equals("Bọc răng sứ"))
        {
            sql = "select * from benh where MaBenh like 'RS%' " ;
        }
        try{
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next())
        {
            Benh tk = new Benh();
            tk.setMaBenh(rs.getString("MaBenh"));
            tk.setTen(rs.getString("Ten"));
            tk.setChiDinh(rs.getString("ChiDinh"));          
            tk.setBaohanh(rs.getString("BaoHanh"));
            tk.setDonGia(rs.getString("DonGia"));
            list.add(tk);
                
        }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(BenhDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
