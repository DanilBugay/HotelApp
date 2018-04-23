package Hotel.dao.mySQL;

import Hotel.dao.IDAO.UserDAO;
import Hotel.entity.Roomuser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MySQLUserDAO implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Roomuser> login(String uLogin, String uPass) {
        Query query = em.createQuery("select u from Roomuser u WHERE ULogin = :uLogin and UPass = :uPass");
        query.setParameter("uLogin", uLogin);
        query.setParameter("uPass", uPass);
        return query.getResultList();
    }

    @Override
    public Roomuser getUserById(int id) {
        return em.find(Roomuser.class, id);
    }

    @Override
    public List<Roomuser> getUserByLogin(String uLogin) {
        Query query = em.createNativeQuery("select * from roomuser WHERE u_login = :uLogin");
        query.setParameter("uLogin", uLogin);
        return query.getResultList();
    }

    @Override
    public int regUser(Roomuser user) {
        em.persist(user);
        return user.getId();
    }

}
