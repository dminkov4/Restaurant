package mitko.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    private long id;

    @NotNull
    @Size(max = 100, message="Max 100 Characters")
    private String name;

    @NotNull
    @Email
    @Size(max = 255, message="Max 255 Characters")
    private String email;

    @NotNull
    @Size(max = 50, message="Max 50 Characters")
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    public User() {
    }

    public User(long id, @NotNull @Size(max = 100, message = "Max 100 Characters") String name,
                @NotNull @Size(max = 255, message = "Max 255 Characters") String email,
                @NotNull @Size(max = 50, message = "Max 50 Characters") String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
