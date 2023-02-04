package bean;

import dao.AdministradorDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Administrador;

@ManagedBean
@RequestScoped
public class AdministradorBean {

    private Administrador administrador;

    public AdministradorBean() {
        administrador = new Administrador();
    }

    public void autenticar() {
        try {
            if (!administrador.getUser_administrador().equals("") && !administrador.getPass_administrador().equals("")) {
                String valor = new AdministradorDAO().autenticar(administrador.getUser_administrador(), administrador.getPass_administrador());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("_NIVEL_", valor);
                if (!valor.equals("")) {
                    new VaiBean().p_banana();
                } else {
                    FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e/ou senha inválidos.", null));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Há campos em branco.", null));
            }
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void limpar() {
        administrador.setUser_administrador(null);
        administrador.setPass_administrador(null);
        administrador.setNivel_administrador(null);
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
