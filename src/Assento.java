/**
 * Created by thiago on 30/03/2017.
 */
public class Assento {

    //ATRIBUTOS---------------------------------
    private int fileira;
    private char coluna;
    private tipoAlimentacao alimentacao;
    private double largura;
    private double comprimento;
    private boolean assentoEstado = false;
    private Pessoa pessoa;

    // Construtor padrão para não ser preciso inicializar Assento dentro do construtor de firstClass
    public Assento(){

    }

    public Assento(int fileira, char coluna){
        this.fileira = fileira;
        this.coluna = coluna;
    }





    public int getNum() {
        return fileira;
    }

    public void setNum(int num) {
        this.fileira = num;
    }

    public char getFileira() {
        return coluna;
    }

    public void setFileira(char fileira) {
        this.coluna = fileira;
    }

    public tipoAlimentacao getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(tipoAlimentacao alimentacao) {
        this.alimentacao = alimentacao;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    // reserva ou cancela um assento
    public void setAssentoEstado(boolean estado){
        assentoEstado = estado;;
    }
    // retorna o estado do assento: se ta ocupado ou não
    public boolean getAssentoEstado(){
        return assentoEstado;
    }
}
