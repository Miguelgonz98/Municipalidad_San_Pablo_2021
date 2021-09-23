package model.DB;

/**
 *
 * @author arnol
 */
import model.User;
import java.util.List;
import javax.persistence.Query;

public class UserDAO extends DAO {

    public List<User> listAll() {
        String cmd = "SELECT u FROM SI_USERS u";
        eM = getEntityManager();
        Query query = eM.createQuery(cmd);
        return query.getResultList();
    }

    public void add(User user) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.persist(user);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }
    public void update(User user) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.merge(user);
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

    public void delete(User user) {
        try {
            eM = getEntityManager();
            eM.getTransaction().begin();
            eM.remove(eM.merge(user));
            eM.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

    public Object searchById(User user) {
        eM = getEntityManager();
        return eM.find(User.class, user.getUsername());
    }

    public Object validateBy(User user) {
        String cmd = "From SI_USERS as u WHERE u.FK_EMAIL = :uEmail and u.password = :uPassword";
        Query query = eM.createQuery(cmd, User.class);
        query.setParameter("uEmail", user.getUsername());
        query.setParameter("uPassword", user.getPwd());
        return query.getSingleResult();
    }

}
