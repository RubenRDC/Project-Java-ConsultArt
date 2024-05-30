package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class UserDao {

    DaoConnection abc = new DaoConnection();

    public UserDao() {
    }

    public boolean existUser(User u){
        boolean existe = false;
        abc.ExtablecerC();
        String consulta = String.format("Select * From usuarios where User = \"%s\" AND Pass = \"%s\";", u.getUserName(), u.getPass());
        
        try {
            ResultSet rs = abc.ConsultaG(consulta);
            if (rs.next()) {
                existe = true;
                return existe;
            }

        } catch (SQLException | java.lang.NullPointerException e) {

        }
        abc.getCloseC();
        
        return existe;
    }
}
