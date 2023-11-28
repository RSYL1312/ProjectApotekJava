package springHibernate.configuration;

import springHibernate.model.Obat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import springHibernate.model.Obat;

/**
 *
 * @author Dewanggga
 */
public class ObatTableModel extends AbstractTableModel{
    private List<Obat> obats = new ArrayList<>();
    private final String HEADER[] = {"Kd Obat", "Nama Obat", "Penyakit", "Jenis Obat", "Jumlah"};
    
    public ObatTableModel(List<Obat> obats) {
        this.obats = obats;
    }
    @Override
    public int getRowCount() {
        return obats.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int columnIndex){
            return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obat obat = obats.get(rowIndex);
        
        switch (columnIndex){
            case 0:
                return obat.getKd_Obat();
            case 1:
                return obat.getNama_Obat();
            case 2:
                return obat.getPenyakit();
            case 3:
                return obat.getJenis_Obat();
            case 4:
                return obat.getJumlah();
            default:
                return null;
        }
    }
}