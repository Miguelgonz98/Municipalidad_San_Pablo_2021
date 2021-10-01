package model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name = "SI_USERS")
public class User {

    @Id
    @Column(name = "PK_USER")
    String username;
    @Column(name = "FK_official")
    String role;
    @Column(name = "FK_email")
    String email;
    @Column(name = "password")
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final User other = (User) obj;
        if (!Objects.equals(username, other.username)) return false;
        if (!Objects.equals(role, other.role)) return false;
        if (!Objects.equals(email, other.email)) return false;
        if (!Objects.equals(pwd, other.pwd)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(username);
        sb.append("E-mail: ").append(email);
        sb.append("Role: ").append(role);
        sb.append("Pwd: ").append(pwd);
        return sb.toString();
    }
}
