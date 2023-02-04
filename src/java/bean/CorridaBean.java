package bean;

import dao.CorridaDAO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Corrida;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class CorridaBean {

    private ArrayList<Corrida> listarTodas;
    private ArrayList<Corrida> listarTodasFiltro;
    private Corrida corridaSelecionada;
    private String SESSAO;
    private Boolean disabled1 = true;

    public CorridaBean() {
        SESSAO = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("_NIVEL_");
        if (SESSAO == null) {
            listarTodas = null;
            listarTodasFiltro = null;
            corridaSelecionada = null;
            new VaiBean().p_apple();
        } else {
            listarTodas = new CorridaDAO().listarTodas();
            listarTodasFiltro = new CorridaDAO().listarTodas();
            corridaSelecionada = new Corrida();
            if (SESSAO.equals("c")) {
                new VaiBean().p_banana();
            }
        }
    }

    public void onRowSelect(SelectEvent event) {
        disabled1 = false;
    }

    public ArrayList<Corrida> getListarTodas() {
        return listarTodas;
    }

    public void setListarTodas(ArrayList<Corrida> listarTodas) {
        this.listarTodas = listarTodas;
    }

    public ArrayList<Corrida> getListarTodasFiltro() {
        return listarTodasFiltro;
    }

    public void setListarTodasFiltro(ArrayList<Corrida> listarTodasFiltro) {
        this.listarTodasFiltro = listarTodasFiltro;
    }

    public Corrida getCorridaSelecionada() {
        return corridaSelecionada;
    }

    public void setCorridaSelecionada(Corrida corridaSelecionada) {
        this.corridaSelecionada = corridaSelecionada;
    }

    public String getSESSAO() {
        return SESSAO;
    }

    public void setSESSAO(String SESSAO) {
        this.SESSAO = SESSAO;
    }

    public Boolean getDisabled1() {
        return disabled1;
    }

    public void setDisabled1(Boolean disabled1) {
        this.disabled1 = disabled1;
    }
}
