/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.*;


public class Buku {

    private int idBuku;
    private Kategori kategori = new Kategori();
    private String judul;
    private String penerbit;
    private String penulis;

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public Buku() {
    }

    public Buku(Kategori kategori, String judul, String penerbit, String penulis) {
        this.kategori = kategori;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
    }

    public Buku getById(int id) {
        Buku buku = new Buku();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "    b.idBuku as idBuku, "
                + "    b.judul as judul,"
                + "    b.penerbit as penerbit, "
                + "    b.penulis as penulis, "
                + "    k.idkategori as idkategori, "
                + "    k.nama as nama, "
                + "    k.keterangan as keterangan"
                + "    FROM buku b "
                + "    LEFT JOIN kategori k ON b.idkategori = k.idkategori "
                + "    where b.idBuku = '" + id + "'");
        try {
            while (rs.next()) {
                buku = new Buku();
                buku.setIdBuku(rs.getInt("idBuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buku;
    }

    public ArrayList<Buku> getAll() {
        ArrayList<Buku> ListBuku = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "    b.idBuku as idBuku, "
                + "    b.judul as judul, "
                + "    b.penerbit as penerbit,"
                + "    b.penulis as penulis, "
                + "    k.idkategori as idkategori, "
                + "    k.nama as nama, "
                + "    k.keterangan as keterangan "
                + "    FROM buku b "
                + "    LEFT JOIN kategori k ON b.idkategori = k.idkategori ");
        try{
            while(rs.next()){
                Buku buku = new Buku();
                buku.setIdBuku(rs.getInt("idBuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenulis(rs.getString("penulis"));
                
                ListBuku.add(buku);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return ListBuku;
    }
    
    public ArrayList<Buku> search(String keyword){
        ArrayList<Buku> ListBuku = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("Select "
                + "    b.idBuku as idbuku,"
                + "    b.judul as judul,"
                + "    b.penerbit as penerbit,"
                + "    b.penulis as penulis,"
                + "    k.idkategori as idkategori,"
                + "    k.nama as nama,"
                + "    k.keterangan as keterangan "
                + "    FROM buku b "
                + "    left join kategori k on b.idkategori = k.idkategori "
                + "    where b.judul like '%"+keyword+"%' "
                + "    OR b.penerbit like '%"+keyword+"%' "
                + "    OR b.penulis LIKE '%"+keyword+"%' ");
        try{
            while(rs.next()){
                Buku buku = new Buku();
                buku.setIdBuku(rs.getInt("idbuku"));
                buku.getKategori().setIdkategori(rs.getInt("idkategori"));
                buku.getKategori().setNama(rs.getString("nama"));
                buku.getKategori().setKeterangan(rs.getString("keterangan"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setPenerbit(rs.getString("penulis"));
                
                ListBuku.add(buku);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ListBuku;
    }
    
    public void save(){
        if(getById(idBuku).getIdBuku() == 0){
            String SQL = "INSERT INTO buku (judul,idkategori, penulis, penerbit) VALUES("
                    + " '"+this.judul+"', "
                    + " '"+this.getKategori().getIdkategori()+"', "
                    + " '"+this.penulis+"', "
                    + " '"+this.penerbit+"' "
                    + " )";
            this.idBuku = DBHelper.insertQueryGetId(SQL);
        }else{
            String SQL = "UPDATE buku set "
                    + " judul = '"+this.judul+"', "
                    + " idkategori = '"+this.getKategori().getIdkategori()+"', "
                    + " penulis = '"+this.penulis+"', "
                    + " penerbit = '"+this.penerbit+"' "
                    + " WHERE idBuku = '"+this.idBuku+"'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM buku where idBuku = '"+this.idBuku+"'";
        DBHelper.executeQuery(SQL);
    }
}
