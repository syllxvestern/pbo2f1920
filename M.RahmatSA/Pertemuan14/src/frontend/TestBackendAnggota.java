/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import backend.*;

public class TestBackendAnggota {
    public static void main(String[] args) {
        Anggota ang1 = new Anggota("M","Perempatan","0895394555540");
        Anggota ang2 = new Anggota("M","Belok","0895394555540");
        Anggota ang3 = new Anggota("M","Kanan","0895394555540");
        
        ang1.save();
        ang2.save();
        ang3.save();
        
        ang2.setAlamat("hmmm");
        ang2.save();
        
        for(Anggota a : new Anggota().getAll()){
            System.out.println("Nama : "+a.getNama()+", Alamat : "+a.getAlamat()+", Telepon: "+a.getTelepon());
        }
        
        for(Anggota a : new Anggota().search("Lampung")){
            System.out.println("Nama : "+a.getNama()+", Alamat : "+a.getAlamat()+", Telepon: "+a.getTelepon());
        }
    }
}
