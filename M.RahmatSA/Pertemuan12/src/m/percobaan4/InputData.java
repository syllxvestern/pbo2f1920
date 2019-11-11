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
import java.util.ArrayList;
public class InputData {
    ArrayList<Mahasiswa> ListMahasiswa;

    public InputData() {
        ListMahasiswa = new ArrayList();
    }
        
    public void isiData(String Nim, String Nama, String Alamat){
        Mahasiswa mhs=new Mahasiswa(Nim,Nama,Alamat);
        ListMahasiswa.add(mhs);
    }
    
    public ArrayList<Mahasiswa> getData(){
        return ListMahasiswa;
    }
    
}
