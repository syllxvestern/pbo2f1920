/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.*;
import backend.*;


public class Anggota {

    private int idAnggota;
    private String nama;
    private String alamat;
    private String telepon;

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Anggota() {
    }

    public Anggota(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public Anggota getById(int id) {
        Anggota ang = new Anggota();
        ResultSet rs2 = DBHelper.selectQuery("Select * from anggota " + " where idAnggota = '" + id + "'");

        try {
            while (rs2.next()) {
                ang = new Anggota();
                ang.setIdAnggota(rs2.getInt("idAnggota"));
                ang.setNama(rs2.getString("nama"));
                ang.setAlamat(rs2.getString("alamat"));
                ang.setTelepon(rs2.getString("alamat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ang;
    }

    public ArrayList<Anggota> getAll() {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        ResultSet rs2 = DBHelper.selectQuery("Select * from anggota");

        try {
            while (rs2.next()) {
                Anggota ang = new Anggota();
                ang.setIdAnggota(rs2.getInt("idAnggota"));
                ang.setNama(rs2.getString("nama"));
                ang.setAlamat(rs2.getString("alamat"));
                ang.setTelepon(rs2.getString("telepon"));

                ListAnggota.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }

    public ArrayList<Anggota> search(String keyword) {
        ArrayList<Anggota> ListAnggota = new ArrayList();

        String sql = "SELECT * FROM anggota where " + " nama like '%" + keyword + "%' " + " or alamat like '%" + keyword + "%' or telepon like '%" + keyword + "%' ";

        ResultSet rs2 = DBHelper.selectQuery(sql);

        try {
            while (rs2.next()) {
                Anggota ang = new Anggota();
                ang.setIdAnggota(rs2.getInt("idAnggota"));
                ang.setNama(rs2.getString("nama"));
                ang.setAlamat(rs2.getString("alamat"));
                ang.setTelepon(rs2.getString("telepon"));

                ListAnggota.add(ang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListAnggota;
    }

    public void save() {
        if (getById(idAnggota).getIdAnggota() == 0) {
            String SQL = "Insert into anggota (nama,alamat,telepon) values("
                    + " '" + this.nama + "', "
                    + " '" + this.alamat + "', "
                    + " '" + this.telepon + "' "
                    + " )";
            this.idAnggota = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "Update anggota set"
                    + " nama = '" + this.nama + "', "
                    + " alamat = '" + this.alamat + "', "
                    + " telepon = '" + this.telepon + "' "
                    + "Where idAnggota = '" + this.idAnggota + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM anggota WHERE idAnggota = '" + this.idAnggota + "'";
        DBHelper.executeQuery(SQL);
    }
}
