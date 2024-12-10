/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author thang
 */
public class Canbo {
    private int Macb;
    private String Hoten;
    private String Gioitinh;
    private double luong;

    public Canbo() {
    }

    public Canbo(int Macb, String Hoten, String Gioitinh, double luong) {
        this.Macb = Macb;
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
        this.luong = luong;
    }

    public int getMacb() {
        return Macb;
    }

    public void setMacb(int Macb) {
        this.Macb = Macb;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
}
