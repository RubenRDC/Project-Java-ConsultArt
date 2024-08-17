package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ruben
 */
public class UserDao {

    private static DaoConnection abc = new DaoConnection();

    public UserDao() {
    }

    public static boolean checkUser(User u) {

        if (abc.ExtablecerC() != null) {
            String consulta = String.format("Select * From usuarios where User = ? AND Pass = ?;");
            ResultSet rs = abc.GenericQuery(consulta, u.getUserName(), u.getPass());
            try {
                if (rs.next()) {
                    //Las credenciales coinciden con un usuario existente
                    return true;
                }
            } catch (SQLException | java.lang.NullPointerException e) {
            }
            abc.getCloseC();
        }
        return false;
    }
}
