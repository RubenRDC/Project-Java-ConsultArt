package com.rubenrdc.consultartoptimizado.models;

import com.rubenrdc.consultartoptimizado.models.interfaces.Exportables;

/**
 *
 * @author Ruben
 */
public class User implements Exportables{

    private String userName, pass, nameSubname;
    private int id;
    private Object[] row = new Object[3];
    private String[] RowAtributos = new String[3];

    public User(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public Object[] getRow() {
        row[0] = id;
        row[1] = userName;
        row[2] = nameSubname;
        return row;
    }

    public String[] getTitulosAtributos() {

        RowAtributos[0] = "ID";
        RowAtributos[1] = "UserName";
        RowAtributos[2] = "NameSubname";
        return RowAtributos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
