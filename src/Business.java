import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thiago on 30/03/2017.
 */

public class Business extends Assento {
    //atributos

    private double preco;
    private double taxaCancelamento;
    private int prioridade;
    private Assento assentosBusiness[][] = new Assento[8][4];
    private Pessoa pessoa[][] = new Pessoa[8][4];

    //construtor personalisado

    public Business() {
        this.preco = preco;
        this.taxaCancelamento = 0.7;
        this.prioridade = 2;

        // Inicializa matriz de assentos
        char assentoLetra = 'A';
        for (int fila = 0; fila < assentosBusiness.length; fila++) {
            for (int coluna = 0; coluna < assentosBusiness[fila].length; coluna++) {
                assentosBusiness[fila][coluna] = new Assento(fila, assentoLetra);
                assentoLetra++;
            }
        }
    }

    //metodo de cancelamento
    public void CancelamentoVoo(Voo voo) {
        double pagamento;
        boolean podeCancelar = false;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dataVoo;
        dataVoo = voo.getData();
        //variavel

        String dataa = dateFormat.format(date);

        int anoAtual = Integer.parseInt(dataa.substring(0, 4));

        int mesAtual = Integer.parseInt(dataa.substring(6, 7));

        int diaAtual = Integer.parseInt(dataa.substring(9, 10));

        int horaAtual = Integer.parseInt(dataa.substring(11, 13));

        int minutoAtual = Integer.parseInt(dataa.substring(14, 16));

        //pegar do horario do voo

        int anoVoo = 5;
        int mesVoo = 4;
        int diaVoo = 1;

        int horaVoo = 13;
        int minutoVoo = 30;

        if (anoAtual < anoVoo) {
            podeCancelar = false;
        } else {
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

            if (podeCancelar == true) {
                pagamento = preco * taxaCancelamento;
            } else {
                System.out.println("Não pode cancelar");
            }

        }
    }
    // cancela assento que havia sido reservado

    public void cancelAssento(int fila, char coluna) {
        assentosBusiness[fila - 1][coluna - 'A'].setAssentoEstado(false);
    }

    // reserva assento desejado
    public void setAssentosBusiness(int fila, char coluna) {
        assentosBusiness[fila - 1][coluna - 'A'].setAssentoEstado(true);
    }

    // imprime mapa de assentos
    public void mapaAssentos() {
        System.out.printf("%n%40s%n", "MAPA CLASSE BUSINESS");
        System.out.printf("%16s%9s%9s%9s%n", "A", "B", "C", "D");

        for (int fileira = 0; fileira < assentosBusiness.length; fileira++) {
            System.out.printf("Fila #%-8d ", fileira + 4);
            for (int coluna = 0; coluna < assentosBusiness[fileira].length; coluna++) {
                if (assentosBusiness[fileira][coluna].getAssentoEstado()) {
                    System.out.printf("%-8s ", "X ");
                    AgendamentoVoo.contadorPassageirosPartirvoo++;

                } else {
                    System.out.printf("%-8s ", "O ");
                }

            }
            System.out.println();


        }
        System.out.print("\nLegenda: X - Ocupado / O - Livre\n");
        System.out.println();

    }

    public Pessoa[][] getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa[][] pessoa) {
        this.pessoa = pessoa;
    }

    public void setPessoa(Pessoa pessoa, int fila, char coluna) {
        this.pessoa[fila - 1][coluna - 'A'] = pessoa;

    }
}
