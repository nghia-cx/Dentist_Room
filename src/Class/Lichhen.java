/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGHIA_PC
 */
public class Lichhen {
    private String MaHen,SDTbn,MaBenh;
    private Date NgayHen,GioHen;

    SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm");

    public String getMaHen() {
        return MaHen;
    }

    public void setMaHen(String MaHen) {
        this.MaHen = MaHen;
    }

    public String getSDTbn() {
        return SDTbn;
    }

    public void setSDTbn(String SDTbn) {
        this.SDTbn = SDTbn;
    }

    public String getMaBenh() {
        return MaBenh;
    }

    public void setMaBenh(String MaBenh) {
        this.MaBenh = MaBenh;
    }

    public Date getNgayHen() {
        return NgayHen;
    }

    public void setNgayHen(Date NgayHen) {
        this.NgayHen = NgayHen;
    }

    public Date getGioHen() {
        return GioHen;
    }

    public void setGioHen(Date GioHen) {
        this.GioHen = GioHen;
    }

//    public SimpleDateFormat getTimeformat() {
//        return timeformat;
//    }
//
//    public void setTimeformat(SimpleDateFormat timeformat) {
//        this.timeformat = timeformat;
//    }

    
    
    
}
