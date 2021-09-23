package model;
@javax.persistence.Entity
@javax.persistence.Table( name = "SI_USERS" )
public class User {
    @javax.persistence.Id
    @javax.persistence.Column( name = "PK_USER" )
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
