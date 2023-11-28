package springHibernate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import springHibernate.dao.ObatDao;
import springHibernate.model.Obat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dewanggga
 */
@Service("ObatService")
@Transactional(readOnly = true)
        
public class ObatServiceImpl implements ObatService{
    @Autowired
    private ObatDao obatDao;
    
    @Transactional
    @Override
    public void save(Obat obat) {
        obatDao.save(obat);
    }
    
    @Transactional
    @Override
    public void update(Obat obat) {
        obatDao.update(obat);
    }

    @Transactional
    @Override
    public void delete(Obat obat) {
        obatDao.delete(obat);
    }

    @Transactional
    @Override
    public Obat getObat(String Kd_Obat) {
        return obatDao.getObat(Kd_Obat);
    }

    @Transactional
    @Override
    public List<Obat> getObats() {
        return obatDao.getObats();
    }   
}