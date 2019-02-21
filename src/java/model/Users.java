// "model" folder
package model;

// import of different methods from library
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
// Serializable sends the information from the database
public class Users implements Serializable {

    // -------------------------------------------------------------------------
    //                  ATTRIBUTE CORRESPONDING TO THE DATABASE
    // -------------------------------------------------------------------------
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "sex")
    private String sex;
    
    @Column(name = "country")
    private String country;

    // -------------------------------------------------------------------------
    //                               GETTERS
    // -------------------------------------------------------------------------
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSex() {
        return this.sex;
    }

    public String getCountry() {
        return this.country;
    }
    
    // -------------------------------------------------------------------------
    //                               SETTERS
    // -------------------------------------------------------------------------
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
