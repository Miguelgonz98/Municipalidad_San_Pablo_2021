package model.DB;

/**
 * @author DiCarlo, modified by Arnold
 */
import java.util.HashMap;
import model.User;
import java.util.List;
import javax.persistence.Query;

public class UserDAO extends DAO {
    private static UserDAO uniqueInstance;
    //private UserDAO(){}
    public static UserDAO getInstance(){
        if (uniqueInstance == null) uniqueInstance = new UserDAO();
        return uniqueInstance;
    }
    public List<User> listAll() {
        try{
            System.out.println(1);
            String cmd = "SELECT u.PK_USER, u.FK_OFFICIAL, u.FK_EMAIL, "
                    + "CAST(u.password as CHAR) from si_db.si_users u";
            eM = getEntityManager();
            Query query = eM.createQuery(cmd);
            List<User> l = query.getResultList();
            l.forEach(u -> {
                System.out.println(u.toString());
            });
            return l;
        }catch(Exception e){
            e.printStackTrace(System.out);
            return null;
        }
    }
    public HashMap<String, User> listAllHM(){ //list all users in HashMap type
        HashMap<String,User> users = new HashMap<>();
        List<User> usersList = this.listAll();
        for (final User u : usersList) users.put(u.getUsername(), u);
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
   
    public User searchById(User user) {
        eM = getEntityManager();
        return (User) eM.find(User.class, user.getUsername());
    }
    /*
    public User validateByEmail(String userOrEmail, String pwd) {
        String cmd = "select From SI_DB.SI_USERS as u WHERE  u.password = :uPassword and "
                + "(u.FK_EMAIL = :uEmailOrUname or u.PK_USER = :uEmailOrUname)";
        Query query = eM.createQuery(cmd, User.class);
        query.setParameter("uEmailOrUname", userOrEmail);
        query.setParameter("uPassword", pwd);
        return (User)query.getSingleResult();
    }
    */

}
