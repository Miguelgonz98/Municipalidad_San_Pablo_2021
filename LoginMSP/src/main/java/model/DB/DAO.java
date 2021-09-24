package model.DB;
/**
 *
 * @author arnol
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class DAO {
    protected static EntityManager eM;
    private static EntityManagerFactory eMF;
    private static final String PU = "MSPH_HPU";
    
    public DAO() {
        if (eMF == null) eMF = Persistence.createEntityManagerFactory(PU);
    }
    protected EntityManager getEntityManager() {
        if (eM == null) eM = eMF.createEntityManager();
        return eM;
    }

    protected void closeEntityManager() {
        if (eM != null) {
            eM.close();
            eM = null;
        }
    }
}