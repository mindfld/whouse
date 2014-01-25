package ua.mind.warehouse.domain.entities.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Сергій on 17.01.14.
 */

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static User anonymous = new User ("Anonymous",Role.DIRECTOR,"anon","anon");

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Role role;

    @Column
    private String password;

    @Column
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
    }

    public User(String name, Role role, String password, String login) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.login = login;
    }
    public static User getAnonymous(){
        return anonymous;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (!name.equals(user.name)) return false;
        if (role != user.role) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
