/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m.percobaan4;

/**
 *
 * @author RuminazVlntine
 */
public class Mahasiswa {
    private String Nim,Nama,Alamat;
    
    public Mahasiswa (String Nim, String Nama, String Alamat){
        this.Nim=Nim;
        this.Nama=Nama;
        this.Alamat=Alamat;
    }
    
public String getNim(){
    return Nim;
}
public String getNama(){
    return Nama;
}
public String getAlamat(){
    return Alamat;
}

}
