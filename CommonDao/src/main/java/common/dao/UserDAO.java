package common.dao;

import common.dao.generic.GenericDAO;
import common.model.User;
import javax.persistence.Query;
import org.hibernate.Session;

public class UserDAO extends GenericDAO {

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
}
