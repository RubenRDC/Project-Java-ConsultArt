/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.Articulo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public class ArticuloDao {

    private List<String> datos = new ArrayList<>();

    private DaoConnection abc = new DaoConnection();

    private funtionsCom funtions = new funtionsCom();

    public ArticuloDao() {
    }

    public Articulo buscarArt(String cod) {
        Articulo art = null;
        int i = 0;
        DepositosDao depDao = new DepositosDao();
        String[][] stocks = new String[depDao.getLimitDep()][2];
        String consulta = String.format("SELECT * FROM articulos WHERE codigo = \"%s\";", cod);

        if (abc.ExtablecerC() != null) {
            //System.out.println("abc.ExtablecerC() " + abc.ExtablecerC());
            ResultSet rs = abc.ConsultaG(consulta);
            try {
                if (rs.next()) {
                    int idArt = rs.getInt("id");
                    String code = rs.getString("codigo");
                    String desc = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(idArt, code, desc, foto);

                    String CStock = String.format("SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = %d;", idArt);
                    ResultSet rs3 = abc.ConsultaG(CStock);
                    while (rs3.next()) {

                        stocks[i][0] = (rs3.getString("depositos.descrip"));
                        stocks[i][1] = (rs3.getString("ubicaciones.exist"));

                        art.setStocks(stocks);
                        //System.out.println(stocks[i][0] + " " + stocks[i][1]);
                        i++;
                    }
                } else {
                    art = null;
                    /*art.setCodigo(null);
                art.setDesc(null);
                art.setStocks(null);
                art.setFoto(null);
                art.setUbicConcat(null);
                Relacion = null;*/
                }
            } catch (SQLException ex) {

            }

            abc.getCloseC();
        }

        return art;
    }

    public Articulo ObtenerUbic(Articulo art, String Deposito) {
        //clearUbic();
        //System.out.println("Ejecutando setUbic...");
        if (abc.ExtablecerC() != null) {
            int p = 1, u = 0;
            String[][] UbicPrinc = new String[1][2];
            String[][] UbicExtra = new String[10][2];
            String ubicConcat;
            String cUbics = String.format("SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = %d AND depositos.descrip=\"%s\";", art.getId(), Deposito);//INNER JOIN depositos ON depositos.id=ubicaciones.idDep
            //System.out.println("cUbics= " + cUbics);
            try {
                ResultSet rsUbics = abc.ConsultaG(cUbics);

                if (rsUbics.next()) {
                    int idUbicP = rsUbics.getInt("ubicaciones.id");

                    UbicPrinc[0][0] = Integer.toString(idUbicP);
                    UbicPrinc[0][1] = rsUbics.getString("ubicaciones.ubic");

                    art.setUbicPrinc(UbicPrinc);

                    ubicConcat = (rsUbics.getString("ubicaciones.ubic")) + " | ";

                    String cUbicExt = String.format("SELECT * FROM ubicacion_extra WHERE idUbic = %d", idUbicP);
                    ResultSet rsUbicExt = abc.ConsultaG(cUbicExt);

                    while (rsUbicExt.next()) {
                        UbicExtra[u][0] = rsUbicExt.getString("ubicacion_extra.id");
                        UbicExtra[u][1] = rsUbicExt.getString("ubicacion_extra.ubic");

                        if (p < 3) {
                            ubicConcat += rsUbicExt.getString("ubicacion_extra.ubic");
                            ubicConcat += " | ";
                            p++;
                        } else {
                            ubicConcat += "\n";
                            ubicConcat += rsUbicExt.getString("ubicacion_extra.ubic");
                            ubicConcat += " | ";
                            p = 1;
                        }

                        u++;
                    }
                    if (UbicExtra == null) {
                        art.setUbicExtra(null);
                    } else {
                        art.setUbicExtra(UbicExtra);
                    }
                    art.setUbicConcat(ubicConcat);
                } else {
                    art.setUbicPrinc(null);
                    art.setUbicExtra(null);
                    art.setUbicConcat(null);
                }

            } catch (NumberFormatException | SQLException e) {
                System.out.println(e);
            }
            abc.getCloseC();
        }

        return art;
    }

    public List enlistarArt(String code, int limiteLista) {
        Articulo art;
        String Query = String.format("SELECT * FROM articulos WHERE codigo LIKE '%%%s%%' OR descripcion LIKE '%%%s%%' LIMIT %d;", code, code, limiteLista);
        List<Articulo> list = new ArrayList<Articulo>();

        if (abc.ExtablecerC() != null) {
            ResultSet rs = abc.ConsultaG(Query);
            try {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String cod = rs.getString("codigo");
                    String descrip = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(id, cod, descrip, foto);

                    list.add(art);
                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            abc.getCloseC();
        }

        return list;
    }

    /**
     * Busqueda Estricta por Id o Codigo
     *
     * @param iDoCod Id del Articulo o Codigo
     * @param Por ID(0) | Codigo(1)
     * @return Un objeto Articulo
     */
    public Articulo busquedaEstrictaArt(String iDoCod, int Por) {
        Articulo art = null;
        String Query = "";
        if (Por == 0) {
            Query = String.format("SELECT * FROM articulos WHERE id = %d", Integer.valueOf(iDoCod));
        } else {
            Query = String.format("SELECT * FROM articulos WHERE codigo = '%s'", iDoCod);
            System.out.println("Query busquedaEstrictaArt Por Codigo" + Query);
        }
        if (abc.ExtablecerC() != null) {
            ResultSet rs = abc.ConsultaG(Query);
            try {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String cod = rs.getString("codigo");
                    String descrip = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(id, cod, descrip, foto);

                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            abc.getCloseC();
        }

        return art;
    }

    public void addArticulo(Articulo varArt) {

        datos.add(0, varArt.getCodigo());
        datos.add(1, varArt.getDesc());
        datos.add(2, varArt.getFoto());

        boolean exito = UpOrDelectOrInsert(datos);
        if (exito) {
            funtions.msgInfo(1);
        } else {
            funtions.msgInfo(0);
        }
        datos.clear();

    }

    public void updateArticulo(Articulo varArt) {

        datos.add(0, String.valueOf(varArt.getId()));
        datos.add(1, varArt.getCodigo());
        datos.add(2, varArt.getDesc());
        datos.add(3, varArt.getFoto());

        boolean exito = UpOrDelectOrInsert(datos);
        if (exito) {
            funtions.msgInfo(1);
        } else {
            funtions.msgInfo(0);
        }
        datos.clear();
    }
    public void eliminarArt(int idArt) {
        boolean exito = false;
        datos.add(String.valueOf(idArt));
        exito = UpOrDelectOrInsert(datos);

        datos.clear();
        if (exito) {
            funtions.msgInfo(1);
        } else {
            funtions.msgInfo(0);
        }
    }

    private boolean UpOrDelectOrInsert(List<String> datosArt) {
        String query = "";

        boolean exito = false;
        if (abc.ExtablecerC() != null) {
            if (datosArt.size() == 4) {
                query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
                try {
                    PreparedStatement cs = abc.ExtablecerC().prepareStatement(query);
                    cs.setString(1, datosArt.get(1));
                    cs.setString(2, datosArt.get(2));
                    cs.setString(3, datosArt.get(3));
                    cs.setInt(4, Integer.parseInt(datosArt.get(0)));
                    
                    
                    int rs = cs.executeUpdate();
                    
                    if (rs > 0) {
                        return exito = true;
                    } else {
                        return exito;
                    }
                } catch (SQLException ex) {
                    System.out.println("ex "+ ex);
                }
            }

            if (datosArt.size() == 3) {
                query = "INSERT INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
                try {
                    PreparedStatement cs = abc.ExtablecerC().prepareStatement(query);
                    cs.setString(1, datosArt.get(0));
                    cs.setString(2, datosArt.get(1));
                    cs.setString(3, datosArt.get(2));
                    int rs = cs.executeUpdate();
                    if (rs > 0) {
                        return exito = true;
                    } else {
                        return exito;
                    }
                } catch (SQLException ex) {

                }
            }

            if (datosArt.size() == 1) {
                query = "SELECT id FROM ubicaciones WHERE idArt = ?";
                int idArt = Integer.parseInt(datosArt.get(0));

                try {
                    ResultSet rs = abc.ConsultPorId(query, idArt);

                    while (rs.next()) {

                        int idUbic = rs.getInt("id");
                        query = "DELETE FROM ubicacion_extra WHERE idUbic = ?";
                        abc.EliminarPorId(query, idUbic);

                        query = "DELETE FROM ubicaciones WHERE id = ?";
                        abc.EliminarPorId(query, idUbic);

                    }
                    query = "DELETE FROM articulos WHERE id = ?";
                    exito = abc.EliminarPorId(query, idArt);

                } catch (SQLException ex) {

                }
            }

        }

        abc.getCloseC();
        return exito;

    }

}
