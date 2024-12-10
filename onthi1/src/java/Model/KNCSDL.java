/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author thang
 */
public class KNCSDL {

    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/qlcb";

    public KNCSDL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, "root", "");
    }

    public void close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }

    public ResultSet getdata() throws SQLException {
        String sql = "Select * from canbo";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public void Themdata(String hoten, String gt, double luong) throws SQLException {
        String sql = "Insert into canbo(Hoten,Gioitinh,Luong) Values (?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, hoten);
        ps.setString(2, gt);
        ps.setDouble(3, luong);
        int rs = ps.executeUpdate();
        if (rs > 0) {
            System.out.println("Thêm thành công !!!!");
        } else {
            System.out.println("Thêm thất bại!!!");
        }
        conn.close();
    }

    public void Sua(int macb, String hoten, String gt, double luong) throws SQLException {
        String sql = "UPDATE canbo SET Hoten = ?, Gioitinh = ?, Luong = ? WHERE Macb = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, hoten);
        ps.setString(2, gt);
        ps.setDouble(3, luong);
        ps.setInt(4, macb);
        int rs = ps.executeUpdate();
        if (rs > 0) {
            System.out.println("Sửa thành công !!!!");
        } else {
            System.out.println("Sửa thất bại!!!");
        }
        conn.close();
    }
    public ResultSet Getmacb(int macb) throws SQLException
    {
        String sql = "Select * from canbo Where Macb = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, macb);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public void Xoa(int macb) throws SQLException
    {
        String sql = "Delete from canbo Where Macb = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, macb);
        int rs = ps.executeUpdate();
        if (rs > 0) {
            System.out.println("Xoá thành công !!!!");
        } else {
            System.out.println("Xoá thất bại!!!");
        }
        conn.close();
    }
}
