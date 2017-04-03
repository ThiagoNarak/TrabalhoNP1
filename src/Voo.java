import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by thiago on 30/03/2017.
 */

public class Voo extends Compania {

    //ATRIBUTOS------------------------------------------------
    private Date data;
    private String horario;
    private String origem;
    private String destino;
    private CartaoEmbarque cartao[];
    private Pessoa pessoa[];
    private ArrayList<Pessoa>tripulacaolist=new ArrayList<>();
    private Pessoa piloto = new Piloto();
    private Pessoa coPiloto = new CoPiloto();
    private int codigo;

    FirstClass firstClass; // CRIA UMA CASSE FIRSTCLASS PARA O VOO
    Business business;    // CRIA UMA CLASSE BUSINES PARA O VOO
    Economy economy ;          // CRIA UMA CLASSE ECONOMY PARA O VOO

    //CONSTRUTOR SUPER------------------------------------------------
    public Voo(String ciaArea, Date data, String origem, String destino) {
        super(ciaArea);
        firstClass= new FirstClass();
        business = new Business();
        economy = new Economy();
        this.data = data;
        this.horario = horario;
        this.origem = origem;
        this.destino = destino;
        this.codigo = AgendamentoVoo.codigo;
        AgendamentoVoo.codigo++;
    }

    //GETSETS------------------------------------------------
    public String getData() {
        String data;
        data = String.format("%d/%d/%d hora: %d:%d",this.data.getYear(),this.data.getMonth(),this.data.getDay(),this.data.getHours(),this.data.getMinutes());
        return data;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        //faz o tratamento direto das 3 primeiras letras do local
        this.origem = origem.substring(0,3);
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        //faz o tratamento direto das 3 primeiras letras do local
        this.destino = destino.substring(0,3);
    }

    //METODOS TRIPULACAO AVIAO----------------------------------------------------
    public void setPiloto(){
        if (!((Piloto)piloto).isOcupado()){

            Scanner scanner= new Scanner(System.in);
            Pessoa piloto= new Piloto();

            System.out.println("Digite a matricula do piloto.");
            piloto.setId(scanner.nextLine());
            System.out.println("Digite o Nome do piloto.");
            piloto.setNome(scanner.nextLine());
            System.out.println("digite o Sobrenome do piloto");
            piloto.setSobrenome(scanner.nextLine());
            ((Piloto)piloto).setOcupado(true);
            this.piloto=piloto;
        }else{
            System.out.println("piloto ja cadastrado.");
            System.out.println("id: "+((Pessoa)piloto).getId());
            System.out.println("Nome:  "+((Pessoa)piloto).getNome());
            System.out.println("Sobrenome:  "+((Pessoa)piloto).getSobrenome());

        }
    }
    public void setCoPiloto(){
        if(!((CoPiloto) coPiloto).isOcupado()){
            Scanner scanner= new Scanner(System.in);
            Pessoa coPiloto= new CoPiloto();
            System.out.println("Digite a matricula do Copiloto.");
            coPiloto.setId(scanner.nextLine());
            System.out.println("Digite o Nome do piloto.");
            coPiloto.setNome(scanner.nextLine());
            System.out.println("digite o Sobrenome do piloto");
            coPiloto.setSobrenome(scanner.nextLine());
            ((CoPiloto)coPiloto).setOcupado(true);
            this.coPiloto =coPiloto;
        }else{
            System.out.println("Co piloto ja cadastrado.");
            System.out.println("id: "+((Pessoa) coPiloto).getId());
            System.out.println("Nome:  "+((Pessoa) coPiloto).getNome());
            System.out.println("Sobrenome:  "+((Pessoa) coPiloto).getSobrenome());
        }


    }
    public void setTripulacao(){
        if(tripulacaolist.size()>=4){
            System.out.println("impossivel adicionar mais tripulantes a este voo\n Lista dos tripulantes ");
            for (Pessoa lista:tripulacaolist) {
                System.out.println("-------------------------------------------");
                System.out.println("ID: "+lista.getId());
                System.out.println("Nome: "+lista.getNome());
                System.out.println("Sobrenome: "+lista.getSobrenome());
            }

        }else {
            Scanner scanner = new Scanner(System.in);
            Pessoa tripulacao = new ComissarioBordo();
            System.out.println("Digite a matricula do Tripulante.");
            tripulacao.setId(scanner.nextLine());
            System.out.println("Digite o Nome do Tripulante.");
            tripulacao.setNome(scanner.nextLine());
            System.out.println("digite o Sobrenome do Tripulante");
            tripulacao.setSobrenome(scanner.nextLine());

            tripulacaolist.add(tripulacao);
        }
    }

    public void getVoosDisponiveis(){

    }


}