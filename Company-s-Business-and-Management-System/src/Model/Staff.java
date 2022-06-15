/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.raven.swing.table.EventAction;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;
import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class Staff {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }
    
    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachithuongtru() {
        return diachithuongtru;
    }

    public void setDiachithuongtru(String diachithuongtru) {
        this.diachithuongtru = diachithuongtru;
    }

    public String getTrinhdohocvan() {
        return trinhdohocvan;
    }

    public void setTrinhdohocvan(String trinhdohocvan) {
        this.trinhdohocvan = trinhdohocvan;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;

    }

    public Staff(int id, String hoten, String gioitinh, String diachithuongtru, String noisinh, String ngaysinh, String trinhdohocvan, String phongban, String chucvuhientai) {
        this.id = id;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachithuongtru = diachithuongtru;
        this.noisinh = noisinh;
        this.ngaysinh = ngaysinh;
        this.trinhdohocvan = trinhdohocvan;
        this.phongban = phongban;
        this.chucvuhientai = chucvuhientai;
    }

    public String getChucvuhientai() {
        return chucvuhientai;
    }

    public void setChucvuhientai(String chucvuhientai) {
        this.chucvuhientai = chucvuhientai;
    }
    private int id;
    private String hoten;
    private String gioitinh;
    
    private String diachithuongtru;
    private String noisinh;
    private String ngaysinh;
    private String trinhdohocvan;
    private String phongban;
    private String chucvuhientai;

    public Staff() {
    }

   

}
