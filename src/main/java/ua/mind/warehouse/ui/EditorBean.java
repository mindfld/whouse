package ua.mind.warehouse.ui;

import javax.faces.bean.ManagedBean;

/**
 * Created by Сергій on 17.01.14.
 */
@ManagedBean(name = "editor")
public class EditorBean {

    private String value = "This editor is provided by PrimeFaces";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

