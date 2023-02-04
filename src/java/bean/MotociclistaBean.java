package bean;

import dao.MotociclistaDAO;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Motociclista;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class MotociclistaBean {

    private Motociclista motociclista;
    private Motociclista motociclistaSelecionado;
    private ArrayList<Motociclista> listarTodos;
    private ArrayList<Motociclista> listarTodosFiltro;
    private String SESSAO;

    public MotociclistaBean() {
        SESSAO = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("_NIVEL_");
        if (SESSAO == null) {
            motociclista = null;
            motociclistaSelecionado = null;
            listarTodos = null;
            listarTodosFiltro = null;
            new VaiBean().p_apple();
        } else {
            motociclista = new Motociclista();
            motociclistaSelecionado = new Motociclista();
            listarTodos = new MotociclistaDAO().listarTodos();
            listarTodosFiltro = new MotociclistaDAO().listarTodos();
            if (SESSAO.equals("b")) {
                new VaiBean().p_banana();
            }
            if (SESSAO.equals("c")) {
                new VaiBean().p_banana();
            }
        }
    }

    public void salvar() {
        try {
            if (!motociclista.getId_motociclista().equals("") && !motociclista.getUser_motociclista().equals("") && !motociclista.getPass_motociclista().equals("") && !motociclista.getTelefone_motociclista().equals("") && !motociclista.getEmail_motociclista().equals("") && !motociclista.getSituacao_motociclista().equals("Situação") && motociclista.getPrecoquilo_motociclista() > 0 && motociclista.getPrecomini_motociclista() >= 0) {
                if (new MotociclistaDAO().buscaID(motociclista.getId_motociclista())) {
                    new MotociclistaDAO().alterar(motociclista);
                } else {
                    new MotociclistaDAO().inserir(motociclista);
                }
                new VaiBean().p_cherry();
            } else {
                FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Há campos em branco.", null));
            }
        } catch (Exception erro) {
            FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, String.valueOf(erro), null));
        }
    }

    public void limpar() {
        motociclista.setId_motociclista(null);
        motociclista.setUser_motociclista(null);
        motociclista.setPass_motociclista(null);
        motociclista.setEmail_motociclista(null);
        motociclista.setTelefone_motociclista(null);
        motociclista.setSituacao_motociclista("Situação");
        motociclista.setLogradouro_motociclista(null);
        motociclista.setNumero_motociclista(null);
        motociclista.setBairro_motociclista(null);
        motociclista.setCidade_motociclista(null);
        motociclista.setUf_motociclista("UF");
        motociclista.setPrecoquilo_motociclista(0.0);
        motociclista.setPrecomini_motociclista(0.0);
    }

    public void onRowSelect(SelectEvent event) {
        motociclista.setId_motociclista(motociclistaSelecionado.getId_motociclista());
        motociclista.setUser_motociclista(motociclistaSelecionado.getUser_motociclista());
        motociclista.setPass_motociclista(motociclistaSelecionado.getPass_motociclista());
        motociclista.setEmail_motociclista(motociclistaSelecionado.getEmail_motociclista());
        motociclista.setTelefone_motociclista(motociclistaSelecionado.getTelefone_motociclista());
        motociclista.setSituacao_motociclista(motociclistaSelecionado.getSituacao_motociclista());
        motociclista.setLogradouro_motociclista(motociclistaSelecionado.getLogradouro_motociclista());
        motociclista.setNumero_motociclista(motociclistaSelecionado.getNumero_motociclista());
        motociclista.setBairro_motociclista(motociclistaSelecionado.getBairro_motociclista());
        motociclista.setCidade_motociclista(motociclistaSelecionado.getCidade_motociclista());
        motociclista.setUf_motociclista(motociclistaSelecionado.getUf_motociclista());
        motociclista.setPrecoquilo_motociclista(motociclistaSelecionado.getPrecoquilo_motociclista());
        motociclista.setPrecomini_motociclista(motociclistaSelecionado.getPrecomini_motociclista());
    }

    public Motociclista getMotociclista() {
        return motociclista;
    }

    public void setMotociclista(Motociclista motociclista) {
        this.motociclista = motociclista;
    }

    public Motociclista getMotociclistaSelecionado() {
        return motociclistaSelecionado;
    }

    public void setMotociclistaSelecionado(Motociclista motociclistaSelecionado) {
        this.motociclistaSelecionado = motociclistaSelecionado;
    }

    public ArrayList<Motociclista> getListarTodos() {
        return listarTodos;
    }

    public void setListarTodos(ArrayList<Motociclista> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public ArrayList<Motociclista> getListarTodosFiltro() {
        return listarTodosFiltro;
    }

    public void setListarTodosFiltro(ArrayList<Motociclista> listarTodosFiltro) {
        this.listarTodosFiltro = listarTodosFiltro;
    }
}
