import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by thiago on 30/03/2017.
 */
public class AgendamentoVoo {
    static int codigo=1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char menu;
        //CRIADO VETOR DE VOOS
        ArrayList<Voo> voolist=new ArrayList<>();
        do{
            System.out.println("MENU");
            System.out.println("a- Configurar Voo");
            System.out.println("b- Verificar voos disponiveis");
            System.out.println("c- Comprar passagem");
            System.out.println("d- Mos dos assentos");
            System.out.println("e- Emititrar mapar catao de embarque");
            System.out.println("f- Cadastrar passageiros");
            System.out.println("g- Cadatrar tripulantes");
            System.out.println("h- Mostrar voos (origem <-- destino)");
            System.out.println("i- Cancelamento da viagem (EXTRA)");
            System.out.println("j- Imprimir passageiros do voo (EXTRA)");
            menu=scanner.next().charAt(0);
            switch (menu) {
                case 'a':
                    System.out.println("digite compania");
                    String compania = scanner.nextLine();
                    compania = scanner.nextLine();

                    System.out.println("digite o ano");
                    int ano = scanner.nextInt();
                    System.out.println("digite o mes");
                    int mes = scanner.nextInt();
                    System.out.println("digite o dia");
                    int dia = scanner.nextInt();
                    System.out.println("digite hora");
                    int hora = scanner.nextInt();
                    System.out.println("digite minuto");
                    int minuto = scanner.nextInt();
                    System.out.println("digite a origem");
                    String origem=scanner.nextLine();
                    origem=scanner.nextLine();
                    origem=origem.substring(0,4);
                    System.out.println("digite o destino");
                    String destino= scanner.nextLine();
                    destino=destino.substring(0,4);

                    Voo voo = new Voo("TAM", new Date(ano, mes, dia, hora, minuto), "FOR", "SAO");
                    voolist.add(voo);
                    voo = new Voo("TAM", new Date(ano, mes, dia, hora + 3, minuto), "FOR", retornarEscala(origem,destino), "SAO");
                    voolist.add(voo);
                    voo = new Voo("TAM", new Date(ano, mes, dia, hora + 6, minuto), "FOR", retornarEscala(origem,destino), "SAO");
                    voolist.add(voo);
                    break;
                case 'b':
                    System.out.println("Voo's disponiveis");
                    for (Voo v : voolist) {
                        if (v.getEscala() == null) {
                            System.out.printf("\nCompania %s, data: %s,Origem: %s, Destino %s\n",
                                    v.getCiaArea(),
                                    v.getData(),
                                    v.getOrigem(),
                                    v.getDestino());
                        } else {
                            System.out.printf("\nCompania %s, data: %s,Origem: %s, Escala: %s, Destino %s\n",
                                    v.getCiaArea(),
                                    v.getData(),
                                    v.getOrigem(),
                                    v.getEscala(),
                                    v.getDestino());
                        }

                    }

                    break;
                case 'c':
                    System.out.println("Voo's disponiveis");
                    for (Voo v : voolist) {
                        //TODO: IMPLEMENTAR CONDICAO DE MOSTRAR APENAS OS VOOS DISPONIVEIS ATRAVEZ DATA e HORA -gaby

                        imprimirVoo(v);
                    }
                    System.out.println("digite o codigo do voo a ser comprado passagem.");
                    int voocodigo = scanner.nextInt();
                    System.out.println("digite a classe que deseja comprar: ");
                    System.out.println("1- FirstClass");
                    System.out.println("2- Business");
                    System.out.println("3- Economy");
                    int classe = scanner.nextInt();
                    switch (classe) {
                        case 1:
                            for (Voo v : voolist) {
                                if (v.getCodigo() == voocodigo) {
                                    v.firstClass.mapaAssentos();
                                    System.out.println("digite o assento a ser comprado.");
                                    System.out.println("digite a fileira em numero.");
                                    int fila = scanner.nextInt();
                                    System.out.println("digite a coluna em letra.");
                                    char coluna = scanner.next().charAt(0);

                                    if (v.firstClass.getAssentoEstado() == true) {
                                        System.out.println("digite outro assento pois esta ocupado");
                                    } else {
                                        v.firstClass.setAssentosPrimeiraClasse(fila, coluna);
                                        System.out.println("digite o nome do comprador da passagem");
                                        Pessoa pessoa = new Pessoa();
                                        pessoa.setNome(scanner.nextLine());
                                        pessoa.setSobrenome(scanner.nextLine());
                                        v.firstClass.setPessoa(pessoa, fila, coluna);
                                    }

                                }
                            }

                    }

                    break;
                case 'd':
                    //implementado passageiros Voo mostrar assentos por voo via codigo //Gabrielly Lima.
                    System.out.println("Digite o codigo do Voo que deseja que seja mostrado a lista de assentos");
                    int menuAssentos= scanner.nextInt();
                    for (Voo v:voolist) {
                        if(v.getCodigo()==menuAssentos) {

                            v.business.mapaAssentos();
                            v.economy.mapaAssentos();
                            v.firstClass.mapaAssentos();

                        }
                    }

                    break;
                case 'e':
                    //EMITIR CARTAO EMBARQUE
                    break;

                case 'g':
                    System.out.println("deseja incluir qual tripulação abaixo.");
                    System.out.println("1- piloto");
                    System.out.println("2- coPiloto");
                    System.out.println("3- comissarios");
                    int menuTripulacao=scanner.nextInt();
                    switch (menuTripulacao){
                        case 1:
                            System.out.println("digite o Voo a inserir tripulacao.");
                            for (Voo v:voolist) {

                                System.out.printf("\ncodigo: %d |Compania %s, data: %s,horario %s ,Origem: %s, Destino %s\n",
                                        v.getCodigo(),
                                        v.getCiaArea(),
                                        v.getData(),
                                        v.getHorario(),
                                        v.getOrigem(),
                                        v.getDestino());
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setPiloto();
                            break;
                        case 2:
                            System.out.println("digite o Voo a inserir tripulacao.");
                            for (Voo v:voolist) {

                                System.out.printf("\ncodigo: %d |Compania %s, data: %s,horario %s ,Origem: %s, Destino %s\n",
                                        v.getCodigo(),
                                        v.getCiaArea(),
                                        v.getData(),
                                        v.getHorario(),
                                        v.getOrigem(),
                                        v.getDestino());
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setCoPiloto();
                            break;
                        case 3:
                            System.out.println("digite o Voo a inserir tripulacao.");
                            for (Voo v:voolist) {

                                System.out.printf("\ncodigo: %d |Compania %s, data: %s,horario %s ,Origem: %s, Destino %s\n",
                                        v.getCodigo(),
                                        v.getCiaArea(),
                                        v.getData(),
                                        v.getHorario(),
                                        v.getOrigem(),
                                        v.getDestino());
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setTripulacao();
                            break;
                    }
                    break;
                case 'h': break;
                case 'i': break;
                case 'j': break;

            }

        }while(menu!='0');
    }
    public static String retornarEscala(String origem,String destino){
        String capitais[] = {"(ARA)", "(BEL)", "(BHZ)", "BVI)", "(BRA)", "(CPG)", "(CUB)", "(CUR)", "(FLO)", "(FOR)",
                "(GOI)", "(JPE)", "(MAC)", "(MCO)", "(MAN)", "(NAT)", "(PAL)", "(POA)", "(POV)", "(REC)", "(RBR)", "(RIO)",
                "(SAL)", "(SLU)", "(SAO)", "(THE)", "(VIT)"};
        Random r = new Random();
        boolean refazer =false;
        do {
            if (origem.equals(capitais[r.nextInt(27)]) || destino.equals(capitais[r.nextInt(27)])) {
                refazer = true;
            }else{
                refazer=false;
            }
        }while(refazer==true);
        return capitais[r.nextInt(capitais.length)];
    }
    public static void imprimirVoo(Voo v){
        if (v.getEscala() == null) {
            System.out.printf("\ncodigo: %d |Compania %s, data: %s,horario %s ,Origem: %s, Destino %s\n",
                    v.getCodigo(),
                    v.getCiaArea(),
                    v.getData(),
                    v.getHorario(),
                    v.getOrigem(),
                    v.getDestino());
        }else{
            System.out.printf("\ncodigo: %d |Compania %s, data: %s,horario %s ,Origem: %s,Escala: %s, Destino %s\n",
                    v.getCodigo(),
                    v.getCiaArea(),
                    v.getData(),
                    v.getHorario(),
                    v.getOrigem(),
                    v.getEscala(),
                    v.getDestino());

        }
    }
}