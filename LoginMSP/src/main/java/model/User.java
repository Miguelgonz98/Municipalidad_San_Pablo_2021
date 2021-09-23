/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author arnol
 */
public class User {
    String pwd;
    String username;
    String role;
    public User(String username, String pwd, String role){
        this.username= username;
        this.pwd = pwd;
        this. role = role;
    }
    public User(){
        this("","","");
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole(){return role;}
    public void setRole(String role){
        this.role = role;
    }
}
