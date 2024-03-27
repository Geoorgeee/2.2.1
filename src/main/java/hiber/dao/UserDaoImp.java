package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User takeOwner(int series, String model) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("SELECT u FROM User u JOIN u.car c WHERE c.model = :carModel AND c.series = :carSeries", User.class);
        query.setParameter("carModel", model);
        query.setParameter("carSeries", series);
        User user = query.uniqueResult();
        return user;
    }

}
