package springHibernate.controller;

import java.util.List;
import javax.swing.JOptionPane;
import springHibernate.App;
import springHibernate.configuration.ObatTableModel;
import springHibernate.model.Obat;
import springHibernate.view.Obatview;

/**
 *
 * @author Dewanggga
 */
public class ObatController {
    private final Obatview obatview;
    private ObatTableModel obatTableModel;
    private List<Obat> obats;
    
    public ObatController(Obatview obatview) {
        this.obatview = obatview;
    }

    public void tampilData() {
        obats = App.getObatService().getObats();
        obatTableModel = new ObatTableModel(obats);
        this.obatview.getTable().setModel(obatTableModel);
    }
    
    public void show(){
        int index = this.obatview.getTable().getSelectedRow();
        this.obatview.getKd_Obat().setText(String.valueOf(this.obatview.getTable().getValueAt(index, 0)));
        this.obatview.getNama_Obat().setText(String.valueOf(this.obatview.getTable().getValueAt(index, 1)));
        this.obatview.getPenyakit().setText(String.valueOf(this.obatview.getTable().getValueAt(index, 2)));
        this.obatview.getJenis_Obat().setText(String.valueOf(this.obatview.getTable().getValueAt(index, 3)));
        this.obatview.getJumlah().setText(String.valueOf(this.obatview.getTable().getValueAt(index, 4)));
        
    }
    
    public void clear() {
        this.obatview.getKd_Obat().setText("");
        this.obatview.getNama_Obat().setText("");
        this.obatview.getPenyakit().setText("");
        this.obatview.getJenis_Obat().setText("");
        this.obatview.getJumlah().setText("");
    }
    
    public void saveObat() {
        Obat obat = new Obat();
        obat.setKd_Obat(this.obatview.getKd_Obat().getText());
        obat.setNama_Obat(this.obatview.getNama_Obat().getText());
        obat.setPenyakit(this.obatview.getPenyakit().getText());
        obat.setJenis_Obat(this.obatview.getJenis_Obat().getText());
        String txt_Jumlah = this.obatview.getJumlah().getText();
        int ValueJumlah = Integer.parseInt(txt_Jumlah);
        obat.setJumlah(ValueJumlah);
        App.getObatService().save(obat);
        JOptionPane.showMessageDialog(null,"Data Berhasil di Simpan", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void updateObat() {
        Obat obat = new Obat();
        obat.setKd_Obat(this.obatview.getKd_Obat().getText());
        obat.setNama_Obat(this.obatview.getNama_Obat().getText());
        obat.setPenyakit(this.obatview.getPenyakit().getText());
        obat.setJenis_Obat(this.obatview.getJenis_Obat().getText());
        try {
            String txt_Jumlah = this.obatview.getJumlah().getText();
            int ValueJumlah = Integer.parseInt(txt_Jumlah);
            obat.setJumlah(ValueJumlah);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Jumlah value. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // or handle the error in another appropriate way
        }

        App.getObatService().update(obat);
        JOptionPane.showMessageDialog(null,"Data Berhasil di Edit", "info", JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteObat() {
        if (this.obatview.getKd_Obat().getText() == null) {
            JOptionPane.showMessageDialog(null, "Obat belum dipilih", "error",JOptionPane.ERROR_MESSAGE);
        } else {
            Obat obat = new Obat();
            obat.setKd_Obat(this.obatview.getKd_Obat().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data obat ini ingin dihapus ?", 
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION) {
                App.getObatService().delete(obat);
                JOptionPane.showMessageDialog(null,"Data obat ini Berhasil di Hapus", 
                        "info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}
