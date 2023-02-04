package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Corrida;

public class CorridaDAO {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Corrida> lista = new ArrayList<>();

    public CorridaDAO() {
        conn = new ConnectionFactory().getConexao();
    }

    public ArrayList<Corrida> listarTodas() {
        String sql = "SELECT * FROM corrida;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Corrida cor = new Corrida();
                cor.setId_corrida(rs.getString("id_corrida"));
                cor.setId_motociclista(rs.getString("id_motociclista"));
                cor.setOrigem_corrida(rs.getString("origem_corrida"));
                cor.setDestino_corrida(rs.getString("destino_corrida"));
                cor.setDistancia_corrida(rs.getDouble("distancia_corrida"));
                cor.setData_corrida(rs.getDate("data_corrida"));
                cor.setHora_corrida(rs.getTime("hora_corrida"));
                cor.setValor_corrida(rs.getDouble("valor_corrida"));
                cor.setLat_corrida(rs.getString("lat_corrida"));
                cor.setLon_corrida(rs.getString("lon_corrida"));
                lista.add(cor);
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return lista;
    }
}
