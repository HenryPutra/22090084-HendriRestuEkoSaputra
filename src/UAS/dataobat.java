package UAS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author hp5cd
 */
public class dataobat {
    public String kode_obat, nama_obat, jenis_obat;
    public int jumlah_stok, harga_beli, harga_jual;
    
public String getKdObat(){
    return kode_obat;
} 
public void setKdObat(String kode_obat){
    this.kode_obat = kode_obat;
}
public String getNmObat(){
    return nama_obat;
}
public void setNmObat(String nama_obat){
    this.nama_obat = nama_obat;
}
public String getJnObat(){
    return jenis_obat;
}
public void setJnObat(String jenis_obat){
    this.jenis_obat = jenis_obat;
}
public int getJmlstok(){
    return jumlah_stok;
}
public void setJmlstok(int jumlah_stok){
    this.jumlah_stok = jumlah_stok;
}
public int getHgbeli(){
    return harga_beli;
}
public void setHgbeli(int harga_beli){
    this.harga_beli = harga_beli;
}
public int getHgjual(){
    return harga_jual;
}
public void setHgjual(int harga_jual){
    this.harga_jual = harga_jual;
}

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
