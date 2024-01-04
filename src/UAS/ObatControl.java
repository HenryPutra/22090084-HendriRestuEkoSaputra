/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UAS;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp5cd
 */
public class ObatControl {
    String sql=null;
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    
public ObatControl(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_barang","root","");
        st=con.createStatement();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Koneksi data base gagal, Terjadi kesalahan pada : \n"+ e);
    }
}
public List tampil(){
    List LogObat = new ArrayList();
    sql="select kode_obat,nama_obat,jenis_obat,jumlah_stok,harga_beli,harga_jual from data_obat order by idobat asc";
        try{
         rs = st.executeQuery(sql);
         while (rs.next()){
             dataobat Do =new dataobat();
             Do.setKdObat(rs.getString("kode_obat"));
             Do.setNmObat(rs.getNString("nama_obat"));
             Do.setJnObat(rs.getNString("jenis_obat"));
             Do.setJmlstok(rs.getInt("jumlah_stok"));
             Do.setHgbeli(rs.getInt("harga_jual"));
             Do.setHgjual(rs.getInt("harga_beli"));
             LogObat.add(Do);
         }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan pada : \n" + e);
        }
        return LogObat;
}
public int tambahObat(dataobat e){
    sql ="insert into data_obat (kode_obat,nama_obat,jenis_obat,jumlah_stok,harga_beli,harga_jual) values('"+e.getKdObat()+"','"+e.getNmObat()
    +"','"+e.getJnObat()+"','"+e.getJmlstok()+"','"+e.getHgbeli()+"','"+e.getHgjual()+"')";
    int hasil=0;
    try{
        hasil=st.executeUpdate(sql);
    }catch(Exception a){
        JOptionPane.showMessageDialog(null,"Terjadi kesalahan pada :\n"+ a);
    }
    return hasil;
}

public int editObat(dataobat e) {
    sql = "update data_obat set nama_obat='" + e.getNmObat() + "', jenis_obat='" + e.getJnObat()
            + "', jumlah_stok='" + e.getJmlstok() + "', harga_beli='" + e.getHgbeli()
            + "', harga_jual='" + e.getHgjual() + "' where kode_obat='" + e.getKdObat() + "'";
    int hasil = 0;
    try {
        hasil = st.executeUpdate(sql);
    } catch (Exception a) {
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada :\n" + a);
    }
    return hasil;
}
public int deleteObat(dataobat e){
    sql = "delete from data_obat where kode_obat='"+e.getKdObat()+"'";
    int hasil = 0;
    try{
        hasil=st.executeUpdate(sql);
    }catch (Exception a){
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n" +a);
    }
    return hasil;
}
public int getJumlahobat() throws SQLException{
    sql = "select count(*) as jumlah_obat " + "from data_obat";
    rs=st.executeQuery(sql);
    int jumlah;
    while(rs.next()){
        jumlah = rs.getInt("jumlah_obat");
        return jumlah;
    }
    return 0;
}

public List cariObat(String cari){
  List LogObat = new ArrayList();
  sql = "SELECT kode_obat, nama_obat, jenis_obat, jumlah_stok, harga_beli, harga_jual FROM data_obat WHERE jenis_obat LIKE '%" + cari + "%' OR nama_obat LIKE '%" + cari + "%'";

          try{
              rs=st.executeQuery(sql);
              while (rs.next()){
                  dataobat Do= new dataobat();
                  Do.setKdObat(rs.getString("kode_obat"));
                  Do.setNmObat(rs.getString("nama_obat"));
                  Do.setJnObat(rs.getString("jenis_obat"));
                  Do.setJmlstok(rs.getInt("jumlah_stok"));
                  Do.setHgbeli(rs.getInt("harga_beli"));
                  Do.setHgjual(rs.getInt("harga_jual"));
                  LogObat.add(Do);
          }
          }catch (Exception a){
              JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n" +a);
          }
          return LogObat;
}
}
