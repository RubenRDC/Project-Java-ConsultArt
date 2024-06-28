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

    private static DaoConnection abc = new DaoConnection();
    private static List<String> paramsSql = new ArrayList<>();

    public UserDao() {
    }

    public static boolean checkUser(User u) {
        
        if (abc.ExtablecerC() != null) {
            String consulta = String.format("Select * From usuarios where User = ? AND Pass = ?;");
            paramsSql.add(u.getUserName());
            paramsSql.add(u.getPass());
            ResultSet rs = abc.GenericQuery(consulta, paramsSql);
            try {
                if (rs.next()) {
                    //Las credenciales coinciden con un usuario existente
                    return true;
                }
            } catch (SQLException | java.lang.NullPointerException e) {
            }
            paramsSql.clear();
            abc.getCloseC();
        }
        return false;
    }
}
