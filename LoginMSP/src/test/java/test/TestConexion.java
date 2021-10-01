package test;

import model.DB.UserDAO;
import model.Model;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class TestConexion {
    @Test
    public void probarConex(){
        assertNotNull(UserDAO.getInstance());
    }
}
