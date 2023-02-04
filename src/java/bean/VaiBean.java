package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class VaiBean {

    private String versao;

    public VaiBean() {
        versao = "1.1.2";
    }

    public void sair() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            p_apple();
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exceção", String.valueOf(erro)));
        }
    }

    public void p_apple() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("apple.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_banana() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("banana.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_cherry() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cherry.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_cocoa() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("cocoa.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_fig() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("fig.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_guava() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("guava.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_lemon() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("lemon.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_melon() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("melon.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_orange() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("orange.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_peach() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("peach.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_pear() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("pear.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_perry() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perry.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void p_plum() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("plum.jsf");
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
