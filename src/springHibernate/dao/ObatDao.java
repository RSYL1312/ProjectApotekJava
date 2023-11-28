package springHibernate.dao;
import springHibernate.model.Obat;
import java.util.List;
/**
 *
 * @author Dewanggga
 */
public interface ObatDao {
    public void save(Obat obat);
    public void update(Obat obat);
    public void delete(Obat obat);
    public Obat getObat(String Kd_Obat);
    public List<Obat> getObats();
    
}
