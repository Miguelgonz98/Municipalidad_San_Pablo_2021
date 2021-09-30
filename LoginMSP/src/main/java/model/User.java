package model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "SI_USERS")
public class User {

    @Id
    @javax.persistence.Column(name = "PK_USER")
    String username;
    @javax.persistence.Column(name = "FK_official")
    String role;
    @javax.persistence.Column(name = "FK_email")
    String email;
    @javax.persistence.Column(name = "password")
    String pwd;

    public User(String username, String pwd, String role, String email) {
        this.username = username;
        this.pwd = pwd;
        this.role = role;
        this.email = email;
    }

    public User() {
        this("", "", "", "");
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Username: ").append(username);
        sb.append("E-mail: ").append(email);
        sb.append("Role: ").append(role);
        sb.append("Pwd: ").append(pwd);
        return sb.toString();
    }
}
