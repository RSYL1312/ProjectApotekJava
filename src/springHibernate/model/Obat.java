package springHibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dewanggga
 */
@Entity
@Table(name = "tb_apotek")
public class Obat implements Serializable {
    @Id
    @Column(name = "Kd_Obat", length = 4)
    private String Kd_Obat;
    
    @Column(name = "Nama_Obat", length = 50)
    private String Nama_Obat;
    
    @Column(name = "Penyakit", length = 50)
    private String Penyakit;
    
    @Column(name = "Jenis_Obat", length = 5)
    private String Jenis_Obat;
    
    @Column(name = "Jumlah", length = 6)
    private int Jumlah;
    
    public String getKd_Obat() { return Kd_Obat; }
    public void setKd_Obat(String Kd_Obat) { this.Kd_Obat = Kd_Obat; }
    
    public String getNama_Obat() { return Nama_Obat; }
    public void setNama_Obat(String Nama_Obat) { this.Nama_Obat = Nama_Obat; }
    
    public String getPenyakit() { return Penyakit; }
    public void setPenyakit(String Penyakit) { this.Penyakit = Penyakit; }
    
    public String getJenis_Obat() { return Jenis_Obat; }
    public void setJenis_Obat(String Jenis_Obat) { this.Jenis_Obat = Jenis_Obat; }
    
    public int getJumlah() { return Jumlah; }
    public void setJumlah(int Jumlah) { this.Jumlah = Jumlah; }
}
