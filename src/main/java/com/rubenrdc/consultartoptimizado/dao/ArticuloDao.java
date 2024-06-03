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
public class ArticuloDao implements funtionsCom {

    private List<String> paramsSql= new ArrayList<>(),datosArt = new ArrayList<>();

    private DaoConnection abc = new DaoConnection();

    public ArticuloDao() {
    }

    public Articulo buscarArt(String cod) {
        Articulo art=null;
        int i = 0;
        DepositosDao depDao = new DepositosDao();
        String[][] stocks = new String[depDao.getLimitDep()][2];
        String query = "SELECT * FROM articulos WHERE codigo = ?;";

        if (abc.ExtablecerC() != null) {
            try {
                paramsSql.add(cod);
                ResultSet rs = abc.GenericQuery(query, paramsSql);

                if (rs.next()) {
                    int idArt = rs.getInt("id");
                    String code = rs.getString("codigo");
                    String desc = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(idArt, code, desc, foto);

                    String CStock = "SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = ?;";
                    ResultSet rs3 = abc.QueryById(CStock, idArt);
                    while (rs3.next()) {

                        stocks[i][0] = (rs3.getString("depositos.descrip"));
                        stocks[i][1] = (rs3.getString("ubicaciones.exist"));

                        art.setStocks(stocks);
                        //System.out.println(stocks[i][0] + " " + stocks[i][1]);
                        i++;
                    }
                }
            } catch (SQLException ex) {

            }
            paramsSql.clear();
            abc.getCloseC();
            return art;
        }

        return art;
    }

    public Articulo ObtenerUbic(Articulo art, String Deposito) {
        if (abc.ExtablecerC() != null) {
            int p = 1, u = 0;
            String[][] UbicPrinc = new String[art.getLimitUbicP()][2];
            String[][] UbicExtra = new String[art.getLimitUbicExtra()][2];
            String ubicConcat;

            String cUbics = "SELECT * FROM ubicaciones INNER JOIN depositos ON depositos.id=ubicaciones.idDep WHERE idArt = ? AND depositos.descrip=?;";
            paramsSql.add(0, String.valueOf(art.getId()));
            paramsSql.add(1, Deposito);
            ResultSet rsUbics = abc.GenericQuery(cUbics, paramsSql);
            try {
                if (rsUbics.next()) {
                    int idUbicP = rsUbics.getInt("ubicaciones.id");

                    UbicPrinc[0][0] = Integer.toString(idUbicP);
                    UbicPrinc[0][1] = rsUbics.getString("ubicaciones.ubic");

                    art.setUbicPrinc(UbicPrinc);

                    ubicConcat = (rsUbics.getString("ubicaciones.ubic")) + " | ";

                    String cUbicExt = "SELECT * FROM ubicacion_extra WHERE idUbic = ?";
                    ResultSet rsUbicExt = abc.QueryById(cUbicExt, idUbicP);

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
                    art.setUbicExtra(UbicExtra);
                    art.setUbicConcat(ubicConcat);
                }

            } catch (NumberFormatException | SQLException e) {
                System.out.println(e);
            }
            paramsSql.clear();
            abc.getCloseC();
        }

        return art;
    }

    public List getListArt(String code, int limiteLista) {
        Articulo art;
        String Query = "SELECT * FROM articulos WHERE codigo LIKE ? OR descripcion LIKE ? LIMIT " + limiteLista;
        List<Articulo> list = new ArrayList<Articulo>();

        if (abc.ExtablecerC() != null) {
            paramsSql.add("%" + code + "%");
            paramsSql.add("%" + code + "%");
            ResultSet rs = abc.GenericQuery(Query, paramsSql);
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
            paramsSql.clear();
            abc.getCloseC();
        }
        return list;
    }

    public Articulo StrictSearchArt(String cod) {
        Articulo art = null;
        String Query = "SELECT * FROM articulos WHERE codigo = ?";
        System.out.println("Query busquedaEstrictaArt Por Codigo" + Query);

        if (abc.ExtablecerC() != null) {
            paramsSql.add(cod);
            ResultSet rs = abc.GenericQuery(Query, paramsSql);
            try {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String codigo = rs.getString("codigo");
                    String descrip = rs.getString("descripcion");
                    String foto = rs.getString("foto");

                    art = new Articulo(id, codigo, descrip, foto);

                }
            } catch (SQLException e) {
                System.out.println("SQLException " + e);
            }
            paramsSql.clear();
            abc.getCloseC();
        }

        return art;
    }

    public void addArticulo(Articulo varArt) {

        datosArt.add(0, varArt.getCodigo());
        datosArt.add(1, varArt.getDesc());
        datosArt.add(2, varArt.getFoto());

        boolean exito = UpOrDelectOrInsert(datosArt);
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
        datosArt.clear();
    }

    public void updateArticulo(Articulo varArt) {

        datosArt.add(0, varArt.getCodigo());
        datosArt.add(1, varArt.getDesc());
        datosArt.add(2, varArt.getFoto());
        datosArt.add(3, String.valueOf(varArt.getId()));

        boolean exito = UpOrDelectOrInsert(datosArt);
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
        datosArt.clear();
    }

    public void eliminarArt(int idArt) {
        boolean exito = false;
        datosArt.add(String.valueOf(idArt));
        exito = UpOrDelectOrInsert(datosArt);

        datosArt.clear();
        if (exito) {
            msgInfo(1);
        } else {
            msgInfo(0);
        }
    }

    private boolean UpOrDelectOrInsert(List<String> datosArt) {
        String query = "";
        boolean exito = false;
        if (abc.ExtablecerC() != null) {
            if (datosArt.size() == 4) {
                query = "UPDATE articulos SET codigo = ? ,descripcion = ? ,foto = ? WHERE id = ? ;";
                return abc.GenericUpdate(query, datosArt);
            }

            if (datosArt.size() == 3) {
                query = "INSERT INTO articulos (codigo,descripcion,foto) VALUES (?,?,?);";
                return abc.GenericUpdate(query, datosArt);
            }

            if (datosArt.size() == 1) {
                query = "SELECT id FROM ubicaciones WHERE idArt = ?";
                int idArt = Integer.parseInt(datosArt.get(0));
                ResultSet rs = abc.QueryById(query, idArt);

                try {

                    while (rs.next()) {
                        paramsSql.add(rs.getString("id"));

                        query = "DELETE FROM ubicacion_extra WHERE idUbic = ?";
                        abc.GenericUpdate(query, paramsSql);

                        query = "DELETE FROM ubicaciones WHERE id = ?";
                        abc.GenericUpdate(query, paramsSql);
                    }
                    query = "DELETE FROM articulos WHERE id = ?";
                    exito = abc.GenericUpdate(query, datosArt);

                } catch (SQLException ex) {

                }
            }
            paramsSql.clear();
            abc.getCloseC();
        }
        return exito;
    }
}
