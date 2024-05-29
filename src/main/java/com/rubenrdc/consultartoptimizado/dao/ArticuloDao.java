/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rubenrdc.consultartoptimizado.dao;

import com.rubenrdc.consultartoptimizado.funtionsComp.funtionsCom;
import com.rubenrdc.consultartoptimizado.models.Articulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruben
 */
public class ArticuloDao {

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
        if (abc.ExtablecerC() != null) {
            String cod = varArt.getCodigo();
            String desc = varArt.getDesc();
            String foto = varArt.getFoto();

            boolean exito = abc.UpOrDelectOrInsert(String.format("INSERT INTO articulos (codigo,descripcion,foto) VALUES (\"%s\",\"%s\",\"%s\")", cod, desc, foto));
            if (exito) {
                funtions.msgInfo(1);
            } else {
                funtions.msgInfo(0);
            }
            abc.getCloseC();
        }

    }

    public void updateArticulo(Articulo varArt) {
        if (abc.ExtablecerC() != null) {
            int id = varArt.getId();
            String cod = varArt.getCodigo();
            String desc = varArt.getDesc();
            String foto = varArt.getFoto();

            boolean exito = abc.UpOrDelectOrInsert(String.format("UPDATE articulos SET codigo = \"%s\",descripcion = \"%s\",foto = \"%s\" WHERE id=%d", cod, desc, foto, id));
            if (exito) {
                funtions.msgInfo(1);
            } else {
                funtions.msgInfo(0);
            }
            abc.getCloseC();
        }

    }

    public void deleteArticulo(int idArt) {
        if (abc.ExtablecerC() != null) {
            ResultSet rs = abc.ConsultaG(String.format("SELECT id FROM ubicaciones WHERE idArt = %d", idArt));
            try {
                while (rs.next()) {
                    int idUbic = rs.getInt("id");

                    abc.UpOrDelectOrInsert(String.format("DELETE FROM ubicacion_extra WHERE idUbic = %d", idUbic));
                    abc.UpOrDelectOrInsert(String.format("DELETE FROM ubicaciones WHERE id = %d", idUbic));
                }
                boolean exito = abc.UpOrDelectOrInsert(String.format("DELETE FROM articulos WHERE id = %d", idArt));

                if (exito) {
                    funtions.msgInfo(1);
                } else {
                    funtions.msgInfo(0);
                }
            } catch (SQLException ex) {

            }
            abc.getCloseC();
        }
    }

}
