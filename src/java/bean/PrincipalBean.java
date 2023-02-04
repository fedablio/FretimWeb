package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PrincipalBean {

    private boolean botaoMot;
    private boolean botaoCor;
    private String SESSAO;

    public PrincipalBean() {
        SESSAO = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("_NIVEL_");
        if (SESSAO == null) {
            new VaiBean().p_apple();
        } else {
            if (SESSAO.equals("a")) {
                botaoMot = false;
                botaoCor = false;
            }
            if (SESSAO.equals("b")) {
                botaoMot = false;
                botaoCor = true;
            }
            if (SESSAO.equals("c")) {
                botaoMot = true;
                botaoCor = true;
            }
        }
    }

    public boolean isBotaoMot() {
        return botaoMot;
    }

    public void setBotaoMot(boolean botaoMot) {
        this.botaoMot = botaoMot;
    }

    public boolean isBotaoCor() {
        return botaoCor;
    }

    public void setBotaoCor(boolean botaoCor) {
        this.botaoCor = botaoCor;
    }
}