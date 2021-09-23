/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author arnol
 */
public class Model {
    private static Model uniqueInstance;
    HashMap<String, User> users;
    public static Model getInstance(){
        if (uniqueInstance == null) uniqueInstance = new Model();
        return uniqueInstance;
    }
    private Model(){
        users = new HashMap<>();
        users.put("111", new User("111","111"));
        users.put("222", new User("222","222"));        
    }
    public HashMap<String, User> getUsers(){return users;}
    public void setUsers(HashMap<String, User> users){this.users = users;}
    public User searchUser(String username, String pwd) throws Exception{
        User u = users.get(username);
        if(u == null) throw new NotFoundException("Usuario no encontrado");
        if (!u.getPwd().equals(pwd)) throw new Exception("Contrasena incorrecta");
        return u;
    }
}
