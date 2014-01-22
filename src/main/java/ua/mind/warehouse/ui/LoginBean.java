package ua.mind.warehouse.ui;

import org.primefaces.context.RequestContext;
import ua.mind.warehouse.persistance.JPAUserDaoImpl;
import ua.mind.warehouse.persistance.UserDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Created by Сергій on 18.01.14.
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;

    private String password;

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

    public String login() {
        UserDAO userDao = new JPAUserDaoImpl();
        boolean result = userDao.authorized(username, password);
        if (result) {
            return "cabinet";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Login!",
                            "Please Try Again!"));
            return "fail";
        }
    }
}
