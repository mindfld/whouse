package ua.mind.warehouse.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.mind.warehouse.domain.entities.user.User;
import ua.mind.warehouse.persistance.dao.UserDAO;
import ua.mind.warehouse.persistance.jdbcimpl.JDBCUserDao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Сергій on 18.01.14.
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");


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
        UserDAO userTemplate = (JDBCUserDao)context.getBean("userJDBCTemplate");
        User user = userTemplate.getUserByCredentials(username, password);
        if (user != null) {
            HttpSession session = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession(true);
            session.setAttribute("user", user);
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
    public String logout() {
            HttpSession session = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession(true);
            session.invalidate();
            return "index";

    }
}
