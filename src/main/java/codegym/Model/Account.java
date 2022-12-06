package codegym.Model;



import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String username;
    public String password;
    @ManyToOne
    private Roles roles;

    public Account() {
    }

    public Account(long id, String username, String password, Roles role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles role) {
        this.roles = role;
    }
}