package common.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SI_USERS")
public class User implements Serializable {

    public User(int idUser, Official official, String email, byte[] password) {
        this.idUser = idUser;
        this.official = official;
        this.email = email;
        this.password = password;
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

    public User() {

    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the official
     */
    public Official getOfficial() {
        return official;
    }

    /**
     * @param official the official to set
     */
    public void setOfficial(Official official) {
        this.official = official;
    }

    /**
     * @return the roles
     */
    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Id
    @Column(name = "PK_USER")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int idUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_official", referencedColumnName = "PK_OFFICIAL")
    private Official official;

    @OneToMany
    @JoinTable(
            name = "SI_USER_ROLES",
            joinColumns = @JoinColumn(name = "FK_user"),
            inverseJoinColumns = @JoinColumn(name = "FK_rol")
    )
    private List<Rol> roles;

    @Column(name = "FK_email")
    private String email;

    private byte[] password;
}
