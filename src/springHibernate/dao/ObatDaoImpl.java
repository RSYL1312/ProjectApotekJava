package springHibernate.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springHibernate.model.Obat;

/**
 *
 * @author Dewanggga
 */
@Repository
public class ObatDaoImpl implements ObatDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Obat obat) {
        sessionFactory.getCurrentSession().save(obat);
    }

    @Override
    public void update(Obat obat) {
        sessionFactory.getCurrentSession().update(obat);
    }

    @Override
    public void delete(Obat obat) {
        sessionFactory.getCurrentSession().delete(obat);
    }

    @Override
    public Obat getObat(String Kd_Obat) {
        return (Obat) sessionFactory.getCurrentSession().get(Obat.class, Kd_Obat);
    }

    @Override
    public List<Obat> getObats() {
        return sessionFactory.getCurrentSession().createCriteria(Obat.class).list();
    }

}
