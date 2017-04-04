import java.util.Date;

/**
 * Created by thiago on 30/03/2017.
 */
public class CartaoEmbarque {
    private String nomeCiaAerea;
    private String nome;
    private String origem;
    private String destino;
    private String classe;
    private int setorAeronave;
    private int prioridade;
    private String sobrenome;
    private Date data;
    private String horario;
    private String embarque;
    private String localizador;
    //imprimir cartao de embarque.



    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void emitirLastCard(){

    }
    public void setCartaoEmbarque(){
        
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCiaAerea() {
        return nomeCiaAerea;
    }

    public void setNomeCiaAerea(String nomeCiaAerea) {
        this.nomeCiaAerea = nomeCiaAerea;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getSetorAeronave() {
        return setorAeronave;
    }

    public void setSetorAeronave(int setorAeronave) {
        this.setorAeronave = setorAeronave;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEmbarque() {
        return embarque;
    }

    public void setEmbarque(String embarque) {
        this.embarque = embarque;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }
}
