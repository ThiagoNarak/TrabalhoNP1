import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by thiago on 30/03/2017.
 */
public class AgendamentoVoo {
    private static int linha,coluna;;
    static CartaoEmbarque cartaoEmbarque= new CartaoEmbarque();
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
                    String origem = scanner.nextLine();
                    origem = scanner.nextLine();
                    origem = origem.substring(0, 3);
                    System.out.println("digite o destino");
                    String destino = scanner.nextLine();
                    destino = destino.substring(0, 3);

                    Voo voo = new Voo("TAM", new Date(ano, mes, dia, hora, minuto), origem, destino);
                    voolist.add(voo);
                    voo = new Voo("TAM", new Date(ano, mes, dia, hora + 3, minuto), origem, retornarEscala(origem, destino), destino);
                    voolist.add(voo);
                    voo = new Voo("TAM", new Date(ano, mes, dia, hora + 6, minuto), origem, retornarEscala(origem, destino), destino);
                    voolist.add(voo);

                    break;
                case 'b':
                    System.out.println("Voo's disponiveis");
                    for (Voo v : voolist) {
                        imprimirVoo(v);

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
                        /*
                        firstclass 30% do valor de km
                        business 22,5% do valor de km
                        economy15% do valor de km do techo
                         */

                        case 1:

                            for (Voo v : voolist) {
                                if (v.getCodigo() == voocodigo) {
                                    double kilometragem=retornarkm(v.getOrigem(),v.getDestino());
                                    kilometragem=kilometragem*0.3;
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
                                        pessoa.setNome(scanner.nextLine());
                                        System.out.println("digite o sobrenome");
                                        pessoa.setSobrenome(scanner.nextLine());
                                        v.firstClass.setPessoa(pessoa, fila, coluna);
                                        System.out.printf("\nVALOR DA PASSAGEM: %.2f\n",kilometragem);
                                        cartaoEmbarque.setNome(pessoa.getNome());
                                        cartaoEmbarque.setSobrenome(pessoa.getSobrenome());
                                        cartaoEmbarque.setOrigem(v.getOrigem());
                                        cartaoEmbarque.setDestino(v.getDestino());
                                        cartaoEmbarque.setHorario(v.getData());
                                        cartaoEmbarque.setNomeCiaAerea(v.getCiaArea());
                                        cartaoEmbarque.setSetorAeronave(3);
                                        cartaoEmbarque.setClasse(v.firstClass.toString());
                                    }

                                }
                            }
                            break;
                        case 2:
                            for (Voo v : voolist) {
                                if (v.getCodigo() == voocodigo) {
                                    //TODO: TERMINAR IMPRESSAO DE VALOR BUSSINES
                                    double kilometragem=retornarkm(v.getOrigem(),v.getDestino());
                                    kilometragem=kilometragem*0.225;
                                    v.business.mapaAssentos();
                                    System.out.println("digite o assento a ser comprado.");
                                    System.out.println("digite a fileira em numero.");
                                    int fila = scanner.nextInt();
                                    System.out.println("digite a coluna em letra.");
                                    char coluna = scanner.next().charAt(0);

                                    if (v.business.getAssentoEstado() == true) {
                                        System.out.println("digite outro assento pois esta ocupado");
                                    } else {
                                        v.business.setAssentosBusiness(fila, coluna);
                                        System.out.println("digite o nome do comprador da passagem");
                                        Pessoa pessoa = new Pessoa();
                                        pessoa.setNome(scanner.nextLine());
                                        pessoa.setSobrenome(scanner.nextLine());
                                        v.business.setPessoa(pessoa, fila, coluna);
                                        //TODO: TERMINAR INSERSAO DO CARTAO DE EMBARQUE
                                    }

                                }
                            }

                            break;
                        case 3:
                            //TODO: TERMINAR IMPRESSAO DE VALOR  ECONOMY
                            for (Voo v : voolist) {
                                if (v.getCodigo() == voocodigo) {
                                    double kilometragem=retornarkm(v.getOrigem(),v.getDestino());
                                    kilometragem=kilometragem*0.15;
                                    v.economy.mapaAssentos();
                                    System.out.println("digite o assento a ser comprado.");
                                    System.out.println("digite a fileira em numero.");
                                    int fila = scanner.nextInt();
                                    System.out.println("digite a coluna em letra.");
                                    char coluna = scanner.next().charAt(0);

                                    if (v.economy.getAssentoEstado() == true) {
                                        System.out.println("digite outro assento pois esta ocupado");
                                    } else {
                                        v.economy.setAssentosEconomy(fila, coluna);
                                        System.out.println("digite o nome do comprador da passagem");
                                        Pessoa pessoa = new Pessoa();
                                        pessoa.setNome(scanner.nextLine());
                                        pessoa.setSobrenome(scanner.nextLine());
                                        v.economy.setPessoa(pessoa, fila, coluna);
                                        //TODO: TERMINAR INSERSAO DO CARTAO DE EMBARQUE
                                    }

                                }
                            }
                            break;

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
                    //TODO: FINALIZAR CARTAO DE EMBARQUE
                    System.out.println("impressao Cartao de embarque");
                    System.out.println("CIA: "+cartaoEmbarque.getNomeCiaAerea());
                    System.out.println("nome: "+cartaoEmbarque.getNome());
                    System.out.println("Origem: "+cartaoEmbarque.getOrigem());
                    System.out.println("Destino: "+cartaoEmbarque.getDestino());
                    System.out.println("prioridade: "+cartaoEmbarque.getPrioridade());
                    System.out.println("classe: "+cartaoEmbarque.getClasse());
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

                                imprimirVoo(v);
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setPiloto();
                            break;
                        case 2:
                            System.out.println("digite o Voo a inserir tripulacao.");
                            for (Voo v:voolist) {

                                imprimirVoo(v);
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setCoPiloto();
                            break;
                        case 3:
                            System.out.println("digite o Voo a inserir tripulacao.");
                            for (Voo v:voolist) {

                                imprimirVoo(v);
                            }
                            voo=voolist.get(scanner.nextInt());
                            voo.setTripulacao();
                            break;
                    }
                    break;
                case 'i': break; //extra
                case 'j': break; //extra

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
            System.out.printf("\ncodigo: %d |Compania %s, data: %s ,Origem: %s, Destino %s\n",
                    v.getCodigo(),
                    v.getCiaArea(),
                    v.getData(),
                    v.getOrigem(),
                    v.getDestino());
        }else{
            System.out.printf("\ncodigo: %d |Compania %s, data: %s,Origem: %s,Escala: %s, Destino %s\n",
                    v.getCodigo(),
                    v.getCiaArea(),
                    v.getData(),
                    v.getOrigem(),
                    v.getEscala(),
                    v.getDestino());

        }
    }
    public static int retornarkm(String origem,String destino){

        final int[][] distancias = {

                {   0, 1641, 1248, 3022, 1292, 2155, 2121, 2061, 2207,  815, 1461,  486, 1967,  201, 2673,  604, 1235, 2580, 2946,  398, 3359, 1482,  277, 1226, 1731,  903, 1102},
                {1641,    0, 2111, 1432, 1592, 2212, 1778, 2665, 2904, 1133, 1693, 1636,  329, 1680, 1292, 1550,  973, 3188, 1886, 1676, 2333, 2450, 1687,  481, 2463,  750, 2275},
                {1248, 2111,    0, 3117,  624, 1118, 1372,  820,  973, 1893,  666, 1726, 2349, 1439, 2556, 1831, 1178, 1341, 2477, 1639, 2786,  339,  964, 1932,  486, 1652,  378},
                {3022, 1432, 3117,    0, 2496, 2667, 2107, 3370, 3620, 2562, 2503, 3067, 1110, 3089,  661, 2983, 1988, 3785, 1335, 3103, 1626, 3428, 3009, 1913, 3300, 2169, 3394},
                {1292, 1592,  624, 2496,    0,  878,  873, 1081, 1314, 1687,  173, 1716, 1791, 1485, 1932, 1775,  620, 1619, 1900, 1657, 2246,  933, 1060, 1524,  873, 1313,  947},
                {2155, 2212, 1118, 2667,  878,    0,  559,  780, 1007, 2547,  705, 2593, 2309, 2352, 2013, 2654, 1320, 1119, 1634, 2530, 1827, 1212, 1905, 2284,  894, 2132, 1490},
                {2121, 1778, 1372, 2107,  873,  509,    0, 1302, 1543, 2329,  740, 2495, 1822, 2302, 1453, 2524, 1029, 1679, 1137, 2452, 1414, 1575, 1915, 1942, 1326, 1862, 1745},
                {2061, 2665,  820, 3370, 1081,  780, 1302,    0,  251, 2670,  972, 2545, 2836, 2259, 2734, 2645, 1693,  546, 2412, 2459, 2601,  675, 1784, 2599,  338, 2362, 1076},
                {2207, 2904,  973, 3620, 1314, 1007, 1543,  251,    0, 2857, 1215, 2693, 3082, 2402, 2981, 2802, 1931,  376, 2641, 2603, 2809,  748, 1930, 2821,  489, 2573, 1160},
                { 815, 1133, 1893, 2562, 1687, 2547, 2329, 2670, 2857,    0, 1854,  555, 1451,  730, 2383,  435, 1300, 3213, 1744,  629, 3300, 2190, 1028,  652, 2368,  495, 1855},
                {1461, 1693,  666, 2503,  173,  705,  740,  972, 1215, 1854,    0, 1889, 1868, 1656, 1912, 1948,  724, 1497, 1813, 1829, 2138,  936, 1225, 1662,  810, 1467, 1022},
                { 486, 1636, 1726, 3067, 1716, 2593, 2495, 2545, 2693,  555, 1889,    0, 1964,  299, 2819,  151, 1521, 3066, 3200,  104, 3632, 1968,  763, 1162, 2216,  905, 1581},
                {1967,  329, 2349, 1110, 1791, 2309, 1822, 2836, 3082, 1451, 1868, 1964,    0, 2009, 1054, 1874, 1177, 3341, 1724, 2005, 2159, 2687, 2000,  803, 2664, 1072, 2545},
                { 201, 1680, 1439, 3089, 1485, 2352, 2302, 2259, 2402,  730, 1656,  299, 2009,    0, 2778,  434, 1383, 2775, 3090,  202, 3510, 1671,  475, 1234, 1928,  929, 1282},
                {2673, 1292, 2556,  661, 1932, 2013, 1453, 2734, 2981, 2383, 1912, 2819, 1054, 2778,    0, 2765, 1509, 3132,  761, 2833, 1149, 2849, 2605, 1746, 2689, 1921, 2865},
                { 604, 1550, 1831, 2983, 1775, 2654, 2524, 2645, 2802,  435, 1948,  151, 1874,  434, 2765,    0, 1527, 3172, 3179,  253, 3616, 2085,  875, 1071, 2320,  843, 1706},
                {1235,  973, 1178, 1988,  620, 1320, 1029, 1693, 1931, 1300,  724, 1521, 1177, 1383, 1509, 1527,    0, 2222, 1711, 1498, 2127, 1512, 1114,  964, 1493,  835, 1413},
                {2580, 3188, 1341, 3785, 1619, 1119, 1679,  546,  376, 3213, 1497, 3066, 3341, 2775, 3132, 3172, 2222,    0, 2706, 2977, 2814, 1123, 2303, 3142,  852, 2909, 1536},
                {2946, 1886, 2477, 1335, 1900, 1634, 1137, 2412, 2641, 2855, 1813, 3200, 1724, 3090,  761, 3179, 1711, 2706,    0, 3190,  449, 2707, 2808, 2274, 2463, 2362, 2835},
                { 398, 1676, 1639, 3103, 1657, 2530, 2452, 2459, 2603,  629, 1829,  104, 2005,  202, 2833,  253, 1498, 2977, 3190,    0, 3618, 1874,  675, 1209, 2128,  934, 1483},
                {3359, 2333, 2786, 1626, 2246, 1827, 1414, 2601, 2809, 3300, 2138, 3632, 2159, 3510, 1149, 3616, 2127, 2814,  449, 3618,    0, 2982, 3206, 2726, 2704, 2806, 3156},
                {1482, 2450,  339, 3428,  933, 1212, 1575,  675,  748, 2190,  936, 1968, 2687, 1671, 2849, 2085, 1512, 1123, 2707, 1874, 2982,    0, 1209, 2266,  357, 1979,  412},
                { 277, 1687,  964, 3009, 1060, 1905, 1915, 1784, 1930, 1028, 1225,  763, 2000,  475, 2605,  875, 1114, 2303, 2808,  675, 3206, 1209,    0, 1323, 1453,  994,  839},
                {1226,  481, 1932, 1913, 1524, 2284, 1942, 2599, 2821,  652, 1662, 1162,  803, 1234, 1746, 1071,  964, 3142, 2274, 1209, 2726, 2266, 1323,    0, 2348,  329, 2023},
                {1731, 2463,  489, 3300,  873,  894, 1326,  338,  489, 2368,  810, 2216, 2664, 1928, 2689, 2320, 1493,  852, 2463, 2128, 2704,  357, 1453, 2348,    0, 2091,  741},
                { 903,  750, 1652, 2169, 1313, 2132, 1862, 2362, 2573,  495, 1467,  905, 1079,  929, 1921,  843,  835, 2909, 2362,  934, 2806, 1979,  994,  329, 2091,    0, 1713},
                {1102, 2275,  378, 3394,  947, 1490, 1745, 1076, 1160, 1855, 1022, 1581, 2545, 1282, 2865, 1706, 1413, 1536, 2835, 1483, 3156,  412,  839, 2023,  741, 1713,    0}};


        if(origem.equals("ARA")){
            linha=0;
        }
        if(origem.equals("BEL")){
            linha=1;
        }
        if(origem.equals("B.H")){
            linha=2;
        }
        if(origem.equals("BOA")){
            linha=3;
        }
        if(origem.equals("BRA")){
            linha=4;
        }
        if(origem.equals("CAM")){
            linha=5;
        }
        if(origem.equals("CUI")){
            linha=6;
        }
        if(origem.equals("CUR")){
            linha=7;
        }
        if(origem.equals("FLO")){
            linha=8;
        }
        if(origem.equals("FOR")){
            linha=9;
        }
        if(origem.equals("GOI")){
            linha=10;
        }
        if(origem.equals("JOA")){
            linha=11;
        }
        if(origem.equals("MAC")){
            linha=12;
        }
        if(origem.equals("MCO")){
            linha=13;
        }
        if(origem.equals("MAN")){
            linha=14;
        }
        if(origem.equals("NAT")){
            linha=15;
        }
        if(origem.equals("PAL")){
            linha=16;
        }
        if(origem.equals("PAL")){
            //PORTO ALEGRE
            linha=17;
        }
        if(origem.equals("POV")){
            //PORTO VELHO
            linha=18;
        }
        if(origem.equals("REC")){
            linha=19;
        }
        if(origem.equals("RIO")){
            linha=20;
        }
        if(origem.equals("RJN")){
            linha=21;
        }
        if(origem.equals("SAL")){
            linha=22;
        }
        if(origem.equals("SLU")){
            linha=23;
        }
        if(origem.equals("SPA")){
            linha=24;
        }
        if(origem.equals("TER")){
            linha=25;
        } if(origem.equals("VIT")){
            linha=26;
        }
        //DESTINO
        if(destino.equals("ARA")){
            coluna=0;
        }
        if(destino.equals("BEL")){
            coluna=1;
        }
        if(destino.equals("B.H")){
            coluna=2;
        }
        if(destino.equals("BOA")){
            coluna=3;
        }
        if(destino.equals("BRA")){
            coluna=4;
        }
        if(destino.equals("CAM")){
            coluna=5;
        }
        if(destino.equals("CUI")){
            coluna=6;
        }
        if(destino.equals("CUR")){
            coluna=7;
        }
        if(destino.equals("FLO")){
            coluna=8;
        }
        if(destino.equals("FOR")){
            coluna=9;
        }
        if(destino.equals("GOI")){
            coluna=10;
        }
        if(destino.equals("JOA")){
            coluna=11;
        }
        if(destino.equals("MAC")){
            coluna=12;
        }
        if(destino.equals("MCO")){
            coluna=13;
        }
        if(destino.equals("MAN")){
            coluna=14;
        }
        if(destino.equals("NAT")){
            coluna=15;
        }
        if(destino.equals("PAL")){
            coluna=16;
        }
        if(destino.equals("PAL")){
            //PORTO ALEGRE
            coluna=17;
        }
        if(destino.equals("POV")){
            //PORTO VELHO
            coluna=18;
        }
        if(destino.equals("REC")){
            coluna=19;
        }
        if(destino.equals("RIO")){
            coluna=20;
        }
        if(destino.equals("RJN")){
            coluna=21;
        }
        if(destino.equals("SAL")){
            coluna=22;
        }
        if(destino.equals("SLU")){
            coluna=23;
        }
        if(destino.equals("SPA")){
            coluna=24;
        }
        if(destino.equals("TER")){
            coluna=25;
        } if(destino.equals("VIT")){
            coluna=26;
        }
        return distancias[linha][coluna] ;
    }

}