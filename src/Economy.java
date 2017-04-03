import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by thiago on 30/03/2017.
 */
public class Economy extends Assento {
    //atributos

    private double preco;
    private double taxaCancelamento;
    private int prioridade;
    private Assento assentosEconomy[][] = new Assento[10][6];
    private Pessoa pessoa[][] =new Pessoa[10][6];



    //construtor personalisado

    public Economy() {
        this.preco = preco;
        this.taxaCancelamento = 0.5;
        this.prioridade = 3;

        // Inicializa matriz de assentos
        char assentoLetra = 'A';
        for (int fila = 0; fila < assentosEconomy.length; fila++) {
            for (int coluna = 0; coluna < assentosEconomy[fila].length; coluna++) {
                assentosEconomy[fila][coluna] = new Assento(fila, assentoLetra);
                assentoLetra++;
            }
        }
    }
    public void setPessoa(Pessoa pessoa,int fila,char coluna){
        this.pessoa[fila - 1][coluna - 'A']=pessoa;

    }
    //metodo de cancelamento

    public void CancelamentoVoo(Voo voo){
        double pagamento;
        boolean podeCancelar = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dataVoo;
        dataVoo= voo.getData();
        //variavel

        String dataa = dateFormat.format(date);

        int anoAtual = Integer.parseInt(dataa.substring(0, 4));

        int mesAtual = Integer.parseInt(dataa.substring(6, 7));

        int diaAtual = Integer.parseInt(dataa.substring(9, 10));

        int horaAtual = Integer.parseInt(dataa.substring(11, 13));

        int minutoAtual = Integer.parseInt(dataa.substring(14, 16));

        //pegar do horario do voo

        int anoVoo = 5 ;
        int mesVoo = 4;
        int diaVoo = 1;

        int horaVoo=13;
        int minutoVoo=30;

        if(anoAtual < anoVoo){
            podeCancelar = false;
        }else {
            if (anoAtual == anoVoo) {
                if (mesAtual < mesVoo) {
                    podeCancelar = false;
                } else {
                    if (mesAtual == mesVoo) {
                        if (diaAtual < diaVoo) {
                            podeCancelar = false;
                        } else {
                            if (diaAtual == diaVoo) {
                                minutoVoo = minutoVoo - 30;
                                if (minutoVoo <= 0) {
                                    horaVoo--;
                                    minutoVoo = 60 + minutoVoo;

                                    if (horaVoo == 0 && minutoVoo < 30) {
                                        diaVoo--;
                                        horaVoo = 23;
                                        minutoVoo = 60 - minutoVoo;
                                        if (diaVoo == 0) {
                                            diaVoo = 31;
                                            mesVoo--;
                                            if (mesVoo == 0) {
                                                mesVoo = 12;
                                                anoVoo--;
                                            }
                                        }
                                    }


                                    if (horaAtual < horaVoo) {
                                        podeCancelar = true;
                                    } else {
                                        if (horaAtual == horaVoo && minutoAtual < minutoVoo) {
                                            podeCancelar = true;
                                        } else {
                                            podeCancelar = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }
        }


    if(podeCancelar == true){
        pagamento = preco * taxaCancelamento;
    }else{
        System.out.println("Não pode cancelar");
    }

    }

    // cancela assento que havia sido reservado
    public void cancelAssento(int fila, char coluna) {
        assentosEconomy[fila - 12][coluna - 'A'].setAssentoEstado(false);
    }

    // resernva assento
    public void setAssentosEconomy(int fila, char coluna) {
        assentosEconomy[fila - 12][coluna - 'A'].setAssentoEstado(true);
    }

    // imprime mapa de assento
    public void mapaAssentos(){
        System.out.printf("%n%45s%n", "MAPA CLASSE ECONOMY");
        System.out.printf("%16s%9s%9s%9s%9s%9s%n", "A", "B", "C", "D", "E", "F");

        for (int fileira = 0; fileira < assentosEconomy.length; fileira++){
            System.out.printf("Fila #%-8d ", fileira + 12);
            for (int coluna = 0; coluna < assentosEconomy[fileira].length; coluna++) {
                if (assentosEconomy[fileira][coluna].getAssentoEstado())
                    System.out.printf("%-8s ", "X ");
                else
                    System.out.printf("%-8s ", "O ");
            }
            System.out.println();

        }
        System.out.print("\nLegenda: X - Ocupado / Y - Livre\n");
        System.out.println();
    }


}
