package model;

import java.util.HashMap;
import model.DB.UserDAO;

/**
 *
 * @author arnol
 */
public class Model {
    private static Model uniqueInstance;
    HashMap<String, User> users;
    public static Model getInstance(){
        if (uniqueInstance == null) 
            uniqueInstance = new Model();
        return uniqueInstance;
    }
    private Model(){
        users = new HashMap<>();
    }
    private void updateModel(){
        //Little test cases with no DB connection
        users = new HashMap<>();
        //users.put("111", new User("111","111","1","test@test.com"));
        users.put("222", new User("222","222","1","test2@test.com")); 
//        try{
//            users = UserDAO.getInstance().listAllHM();
//            System.out.println(users);
//        }catch(Exception ex){
//            System.err.print(ex.getMessage());
//            throw ex;
//        }
    
        
    }
    public HashMap<String, User> getUsers(){return users;}
    public void setUsers(HashMap<String, User> users){this.users = users;}
    public User searchUser(String username, String pwd) throws Exception{
        this.updateModel();
        User u = users.get(username);
        if(u == null) throw new Exception("Usuario no encontrado");
        if (!u.getPwd().equals(pwd)) throw new Exception("Contrasena incorrecta");
        return u;
    }
}
