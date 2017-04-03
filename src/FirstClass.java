import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thiago on 30/03/2017.
 */
public class FirstClass extends Assento {
    //atributos

    private double preco;
    private double taxaCancelamento;
    private int prioridade;
    private Assento assentosPrimeiraClasse[][] = new Assento[3][4];
    private Pessoa pessoa[][] =new Pessoa[3][4];

    //construtor personalisado

    public FirstClass() {
        this.preco = preco;
        this.taxaCancelamento = 0.9;
        this.prioridade = 1;

        // Inicializa matriz de assentos
        char assentoLetra = 'A';
        for (int fila = 0; fila < assentosPrimeiraClasse.length; fila++) {
            for (int coluna = 0; coluna < assentosPrimeiraClasse[fila].length; coluna++) {
                assentosPrimeiraClasse[fila][coluna] = new Assento(fila, assentoLetra);
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
        assentosPrimeiraClasse[fila - 1][coluna - 'A'].setAssentoEstado(false);
    }


    // reserva assento
    public void setAssentosPrimeiraClasse(int fila, char coluna) {
        assentosPrimeiraClasse[fila - 1][coluna - 'A'].setAssentoEstado(true);
    }
    // imprime mapa de assentos
    public void mapaAssentos(){

        System.out.printf("%n%40s%n", "MAPA PRIMEIRA CLASSE");
        System.out.printf("%16s%9s%9s%9s%n", "A", "B", "C", "D");

        for (int fileira = 0; fileira < assentosPrimeiraClasse.length; fileira++){
            System.out.printf("Fila #%-8d ", fileira + 1);
            for (int coluna = 0; coluna < assentosPrimeiraClasse[fileira].length; coluna++) {
                if (assentosPrimeiraClasse[fileira][coluna].getAssentoEstado())
                    System.out.printf("%-8s ", "X ");
                else
                    System.out.printf("%-8s ", "O ");
            }
            System.out.println();

        }
        System.out.print("\nLegenda: X - Ocupado / O - Livre\n");
        System.out.println();
    }
}
