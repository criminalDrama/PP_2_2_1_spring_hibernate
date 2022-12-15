package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   @SuppressWarnings("unckeked")
   public User getUser(String model, int seria){
//      Query query = sessionFactory.getCurrentSession()
//              .createQuery("from User as u where u.car.model = :paramModel and u.car.series = :paramSeries")
//              .setParameter("paramModel", model)
//              .setParameter("paramSeries", seria);
//      return (User) query.getSingleResult();
         return (User) sessionFactory.getCurrentSession().createQuery("from User as u where u.car.model = :paramName and  u.car.series = :paramName2").setParameter("paramName", model).setParameter("paramName2", seria).setMaxResults(1).getSingleResult();
   }

}
