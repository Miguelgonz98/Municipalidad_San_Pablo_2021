package common.dao;
import common.dao.generic.GenericDAO;
import common.model.User;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class UserDAO extends GenericDAO {
    private static UserDAO uniqueInstance;
    //private UserDAO(){}
    public static UserDAO getInstance(){
        if (uniqueInstance == null) uniqueInstance = new UserDAO();
        return uniqueInstance;
    }
    public User emailValidation(String emailPrt, String passwordPrt) {
        String cmd = "CALL authenticateUser(:emailPrt, :passwordPrt)";

        em = getEntityManager();
        Session session = em.unwrap(Session.class);
        
        Query query = session.createSQLQuery(cmd).addEntity(User.class);
        query.setParameter("emailPrt", emailPrt);
        query.setParameter("passwordPrt", passwordPrt);
        
        User u = (User) query.getSingleResult();
        
        closeEntityManager();
        return u;
    }
        public List<User> listAll() {
        try{
            System.out.println(1);
            String cmd = "SELECT u.PK_USER, u.FK_OFFICIAL, u.FK_EMAIL, "
                    + "CAST(u.password as CHAR) from si_db.si_users u";
            em = getEntityManager();
            Query query = em.createQuery(cmd);
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
    public HashMap<Integer, User> listAllHM(){ //list all users in HashMap type
        HashMap<Integer,User> users = new HashMap<>();
        List<User> usersList = this.listAll();
        for (final User u : usersList) users.put(u.getIdUser(), u);
        return users;
    }
    public void add(User user) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }
    public void update(User user) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }

    public void delete(User user) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(user));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeEntityManager();
        }
    }
   
    public User searchById(User user) {
        em = getEntityManager();
        return (User) em.find(User.class, user.getIdUser());
    }
}
