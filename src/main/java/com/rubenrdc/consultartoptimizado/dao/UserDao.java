package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class UserDao {

    private DaoConnection abc = new DaoConnection();
    private List<String> paramsSql = new ArrayList<>();

    public UserDao() {
    }

    public boolean existUser(User u) {
        boolean existe = false;
        if (abc.ExtablecerC() != null) {
            String consulta = String.format("Select * From usuarios where User = ? AND Pass = ?;");
            paramsSql.add(u.getUserName());
            paramsSql.add(u.getPass());
            ResultSet rs = abc.GenericQuery(consulta, paramsSql);
            try {
                if (rs.next()) {
                    existe = true;
                    return existe;
                }

            } catch (SQLException | java.lang.NullPointerException e) {

            }
            paramsSql.clear();
            abc.getCloseC();
        }
        return existe;
    }
}
