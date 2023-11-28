package springHibernate.service;

import java.util.List;
import springHibernate.model.Obat;

/**
 *
 * @author Dewanggga
 */
public interface ObatService {
    public void save(Obat obat);
    public void update(Obat obat);
    public void delete(Obat obat);
    public Obat getObat(String Kd_Obat);
    public List<Obat> getObats();
}
