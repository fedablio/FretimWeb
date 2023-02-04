package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Motociclista;
import utility.Porta;

public class MotociclistaDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Motociclista> lista = new ArrayList<>();

    public MotociclistaDAO() {
        conn = new ConnectionFactory().getConexao();
    }

    public void inserir(Motociclista mot) {
        String sql = "INSERT INTO motociclista (id_motociclista, user_motociclista, pass_motociclista, email_motociclista, telefone_motociclista, situacao_motociclista, logradouro_motociclista, numero_motociclista, bairro_motociclista, cidade_motociclista, uf_motociclista, precoquilo_motociclista, precomini_motociclista) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mot.getId_motociclista().toLowerCase());
            stmt.setString(2, new Porta().fecha(mot.getUser_motociclista()));
            stmt.setString(3, new Porta().fecha(mot.getPass_motociclista()));
            stmt.setString(4, mot.getEmail_motociclista());
            stmt.setString(5, mot.getTelefone_motociclista());
            stmt.setString(6, mot.getSituacao_motociclista());
            stmt.setString(7, mot.getLogradouro_motociclista());
            stmt.setString(8, mot.getNumero_motociclista());
            stmt.setString(9, mot.getBairro_motociclista());
            stmt.setString(10, mot.getCidade_motociclista());
            stmt.setString(11, mot.getUf_motociclista());
            stmt.setDouble(12, mot.getPrecoquilo_motociclista());
            stmt.setDouble(13, mot.getPrecomini_motociclista());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public void alterar(Motociclista mot) {
        String sql = "UPDATE motociclista SET user_motociclista = ?, pass_motociclista = ?, email_motociclista = ?, telefone_motociclista = ?, situacao_motociclista = ?, logradouro_motociclista = ?, numero_motociclista = ?, bairro_motociclista = ?, cidade_motociclista = ?, uf_motociclista = ?, precoquilo_motociclista = ?, precomini_motociclista = ? WHERE id_motociclista = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, new Porta().fecha(mot.getUser_motociclista()));
            stmt.setString(2, new Porta().fecha(mot.getPass_motociclista()));
            stmt.setString(3, mot.getEmail_motociclista());
            stmt.setString(4, mot.getTelefone_motociclista());
            stmt.setString(5, mot.getSituacao_motociclista());
            stmt.setString(6, mot.getLogradouro_motociclista());
            stmt.setString(7, mot.getNumero_motociclista());
            stmt.setString(8, mot.getBairro_motociclista());
            stmt.setString(9, mot.getCidade_motociclista());
            stmt.setString(10, mot.getUf_motociclista());
            stmt.setDouble(11, mot.getPrecoquilo_motociclista());
            stmt.setDouble(12, mot.getPrecomini_motociclista());
            stmt.setString(13, mot.getId_motociclista().toLowerCase());
            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean buscaID(String id_motociclista) {
        boolean resultado = false;
        String sql = "SELECT id_motociclista FROM motociclista WHERE id_motociclista = '" + id_motociclista + "' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                resultado = true;
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return resultado;
    }

    public ArrayList<Motociclista> listarTodos() {
        String sql = "SELECT * FROM motociclista";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Motociclista mot = new Motociclista();
                mot.setId_motociclista(rs.getString("id_motociclista"));
                mot.setUser_motociclista(new Porta().abre(rs.getString("user_motociclista")));
                mot.setPass_motociclista(new Porta().abre(rs.getString("pass_motociclista")));
                mot.setEmail_motociclista(rs.getString("email_motociclista"));
                mot.setTelefone_motociclista(rs.getString("telefone_motociclista"));
                mot.setSituacao_motociclista(rs.getString("situacao_motociclista"));
                mot.setLogradouro_motociclista(rs.getString("logradouro_motociclista"));
                mot.setNumero_motociclista(rs.getString("numero_motociclista"));
                mot.setBairro_motociclista(rs.getString("bairro_motociclista"));
                mot.setCidade_motociclista(rs.getString("cidade_motociclista"));
                mot.setUf_motociclista(rs.getString("uf_motociclista"));
                mot.setPrecoquilo_motociclista(rs.getDouble("precoquilo_motociclista"));
                mot.setPrecomini_motociclista(rs.getDouble("precomini_motociclista"));
                lista.add(mot);
            }
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
        return lista;
    }
}