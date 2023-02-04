package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.Porta;

public class AdministradorDAO {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public AdministradorDAO() {
        conn = new ConnectionFactory().getConexao();
    }

    public String autenticar(String user, String pass) {
        String sql = "SELECT nivel_administrador FROM administrador WHERE user_administrador = '" + new Porta().fecha(user) + "' AND pass_administrador = '" + new Porta().fecha(pass) + "' ";
        String resultado = "";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                resultado = rs.getString("nivel_administrador");
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return resultado;
    }
}