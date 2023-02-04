package model;

public class Administrador {

    private int id_administrador;
    private String user_administrador;
    private String pass_administrador;
    private String nivel_administrador;

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getUser_administrador() {
        return user_administrador;
    }

    public void setUser_administrador(String user_administrador) {
        this.user_administrador = user_administrador;
    }

    public String getPass_administrador() {
        return pass_administrador;
    }

    public void setPass_administrador(String pass_administrador) {
        this.pass_administrador = pass_administrador;
    }

    public String getNivel_administrador() {
        return nivel_administrador;
    }

    public void setNivel_administrador(String nivel_administrador) {
        this.nivel_administrador = nivel_administrador;
    }
}