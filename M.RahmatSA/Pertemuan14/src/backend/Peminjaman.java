/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;


public class Peminjaman {

    private int idPeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalPinjam;
    private String tanggalKembali;

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman() {
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("Select "
                + " p.idPeminjaman as idpeminjaman, "
                + " p.tanggalPinjam as TanggalPinjam,"
                + " p.tanggalKembali as TanggalKembali, "
                + " a.idAnggota as idAnggota, "
                + " a.nama as nama,"
                + " a.alamat as alamat,"
                + " a.telepon as telepon,"
                + " b.idBuku as idBuku, "
                + " b.judul as judul,"
                + " b.penerbit as penerbit,"
                + " b.penulis as penulis"
                + " FROM peminjaman p "
                + " left join anggota a on a.idAnggota = p.idAnggota "
                + " left join buku as b on b.idBuku = p.idBuku"
                + " where p.idPeminjaman= '" + id + "'");
        try {
            while (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idPeminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("idAnggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdBuku(rs.getInt("idBuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalKembali(rs.getString("tanggalKembali"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalPinjam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + " p.idPeminjaman as idpeminjaman, "
                + " p.tanggalPinjam as TanggalPinjam,"
                + " p.tanggalKembali as TanggalKembali, "
                + " a.idAnggota as idAnggota, "
                + " a.nama as nama,"
                + " a.alamat as alamat,"
                + " a.telepon as telepon,"
                + " b.idBuku as idBuku, "
                + " b.judul as judul,"
                + " b.penerbit as penerbit,"
                + " b.penulis as penulis"
                + " FROM peminjaman p "
                + " left join anggota a on a.idAnggota = p.idAnggota "
                + " left join buku as b on b.idBuku = p.idBuku");
        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idPeminjaman"));
                peminjaman.getAnggota().setIdAnggota(rs.getInt("idAnggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama"));
                peminjaman.getAnggota().setAlamat(rs.getString("alamat"));
                peminjaman.getAnggota().setTelepon(rs.getString("telepon"));
                peminjaman.getBuku().setIdBuku(rs.getInt("idBuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul"));
                peminjaman.getBuku().setPenerbit(rs.getString("penerbit"));
                peminjaman.getBuku().setPenulis(rs.getString("penulis"));
                peminjaman.setTanggalKembali(rs.getString("tanggalKembali"));
                peminjaman.setTanggalPinjam(rs.getString("tanggalPinjam"));
                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public void searchAnggota(int id) {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM anggota WHERE idAnggota = '" + id + "'");
        try {
            while (rs.next()) {
                getAnggota().setIdAnggota(rs.getInt("idAnggota"));
                getAnggota().setNama(rs.getString("nama"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBuku(int id) {
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM buku WHERE idbuku = '" + id + "'");

        try {
            while (rs.next()) {
                getBuku().setIdBuku(rs.getInt("idbuku"));
                getBuku().setJudul(rs.getString("judul"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Peminjaman> searchIdBuku(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("Select "
                + " p.idPeminjaman as idpeminjaman, "
                + " p.tanggalPinjam as TanggalPinjam,"
                + " p.tanggalKembali as TanggalKembali, "
                + " a.idAnggota as idAnggota, "
                + " a.nama as nama,"
                + " a.alamat as alamat,"
                + " a.telepon as telepon,"
                + " b.idBuku as idBuku, "
                + " b.judul as judul,"
                + " b.penerbit as penerbit,"
                + " b.penulis as penulis"
                + " FROM peminjaman p "
                + " left join anggota a on a.idAnggota = p.idAnggota "
                + " left join buku as b on b.idBuku = p.idBuku"
                + " where b.idBuku like '%" + keyword + "%' ");
        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.buku.getJudul();
                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public void save() {
        if (getById(idPeminjaman).getIdPeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idAnggota,idBuku,tanggalPinjam,tanggalKembali) VALUES("
                    + " '" + this.getAnggota().getIdAnggota() + "', "
                    + " '" + this.getBuku().getIdBuku() + "', "
                    + " '" + this.tanggalPinjam + "', "
                    + " '" + this.tanggalKembali + "' "
                    + " )";
            this.idPeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman set "
                    + " judul = '" + this.getBuku().getJudul() + "', "
                    + " nama = '" + this.getAnggota().getNama() + "', "
                    + " tanggalPinjam = '" + this.tanggalPinjam + "', "
                    + " tanggalKembali = '" + this.tanggalKembali + "', "
                    + " WHERE idPeminjaman = '" + this.idPeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman where idPeminjaman = '" + this.idPeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}
