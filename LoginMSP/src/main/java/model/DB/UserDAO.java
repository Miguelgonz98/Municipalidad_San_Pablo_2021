package model.DB;

/**
 *
 * @author arnol
 */
import java.util.HashMap;
import model.User;
import java.util.List;
import javax.persistence.Query;

public class UserDAO extends DAO {
    private static UserDAO uniqueInstance;
    //private UserDAO(){}
    public static UserDAO getInstance(){
        if (uniqueInstance == null) 
            uniqueInstance = new UserDAO();
        return uniqueInstance;
    }
    public List<User> listAll() {
        String cmd = "SELECT u FROM SI_DB.SI_USERS u";
        eM = getEntityManager();
        Query query = eM.createQuery(cmd);
        return query.getResultList();
    }
    public HashMap<String, User> listAllHM(){ //list all users in HashMap type
        HashMap<String,User> users = new HashMap<>();
        List<User> usersList = this.listAll();
        for (final User u : usersList) 
            users.put(u.getUsername()+"|"+u.getEmail(), u);
        System.out.println(users);
        return users;
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

    public Object validateByEmail(User user) {
        String cmd = "select From SI_DB.SI_USERS as u WHERE u.FK_EMAIL = :uEmail and u.password = :uPassword";
        Query query = eM.createQuery(cmd, User.class);
        query.setParameter("uEmail", user.getUsername());
        query.setParameter("uPassword", user.getPwd());
        return query.getSingleResult();
    }

}
