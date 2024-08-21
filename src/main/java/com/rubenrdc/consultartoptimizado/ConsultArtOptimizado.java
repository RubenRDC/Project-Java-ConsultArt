package com.rubenrdc.consultartoptimizado;

import com.rubenrdc.consultartoptimizado.IGU.auth.Login;
import com.rubenrdc.consultartoptimizado.dao.CharPropieties;

/**
 *
 * @author Ruben
 */
public class ConsultArtOptimizado {

    public static void main(String[] args) {
        CharPropieties.loadConfig();
        Login ventana = new Login();
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
