package common.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SI_OFFICIALS")
public class Official implements Serializable {

    public Official(int idOfficial, String name, String surname, String email, Department department) {
        this.idOfficial = idOfficial;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
    }

    public Official(int idOfficial) {
        this.idOfficial = idOfficial;
    }

    public Official() {

    }

    /**
     * @return the idOfficial
     */
    public int getIdOfficial() {
        return idOfficial;
    }

    /**
     * @param idOfficial the idOfficial to set
     */
    public void setIdOfficial(int idOfficial) {
        this.idOfficial = idOfficial;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
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
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @param roles the roles to set
     */
    
    @Id
    @Column(name = "PK_OFFICIAL")
    private int idOfficial;
    
    private String name;
    
    private String surname;

    private String email;
    
    @OneToOne
    @JoinColumn(name = "FK_department")
    private Department department;
}
