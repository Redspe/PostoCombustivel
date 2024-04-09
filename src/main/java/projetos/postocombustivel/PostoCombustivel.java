package projetos.postocombustivel;

import java.util.ArrayList; // import the ArrayList class

public class PostoCombustivel {

    private static final ArrayList<Combustivel> listaCombs = new ArrayList();
    private static final ArrayList<Tanque> listaTanques = new ArrayList();
    private static final ArrayList<Bomba> listaBombas = new ArrayList();

    private static int idBomba = 0;

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            IO.clearConsole();
            IO.println("  +-------- Sistema Posto Ipiranha --------+  ");
            IO.println("""
                   
                   Escolha uma opção: 
                     1. Abastecer
                   
                     2. Menu Combustível
                     3. Menu Tanque
                     4. Menu Bomba
                   
                     5. Calcular faturamento total
                   
                     9. Fechar o programa
                   """);

            int opc = IO.readInt("Digite o número: ");

            switch (opc) {
                case 1 ->
                    abastecer();
                case 2 ->
                    menuCombustivel();
                case 3 ->
                    menuTanque();
                case 4 ->
                    menuBomba();
                case 5 ->
                    calcularFaturamento();
                case 9 ->
                    sair = true;
                default -> {
                    IO.println("Escolha uma opção válida!");
                    IO.aperteContinuar();
                }
            }
        }
    }

    private static void menuCombustivel() {
        boolean sair = false;

        while (!sair) {
            IO.clearConsole();
            IO.println("  +-------- Sistema Posto Ipiranha --------+  ");
            IO.println("""
                   
                   Escolha uma opção: 
                     1. Cadastrar novo combustível
                     2. Excluir tipo de combustível
                     3. Editar preço do combustível
                     
                     4. Visualizar lista de combustíveis
                   
                     0. Voltar ao menu principal
                   """);

            int opc = IO.readInt("Digite o número: ");

            switch (opc) {
                case 1 ->
                    Combustivel.cadastrar(listaCombs);

                case 2 ->
                    Combustivel.excluir(listaCombs);

                case 3 ->
                    Combustivel.editarPreco(listaCombs);

                case 4 -> {
                    Combustivel.listar(listaCombs);
                    IO.aperteContinuar();
                }

                case 0 ->
                    sair = true;

                default -> {
                    IO.println("Escolha uma opção válida!");
                    IO.aperteContinuar();
                }
            }
        }
    }

    private static void menuTanque() {
        boolean sair = false;

        while (!sair) {
            IO.clearConsole();
            IO.println("  +-------- Sistema Posto Ipiranha --------+  ");
            IO.println("""
                   
                   Escolha uma opção: 
                     1. Cadastrar um novo tanque
                     2. Excluir um tanque
                     3. Editar um tanque
                     
                     4. Visualizar lista de tanques
                   
                     0. Voltar ao menu principal
                   """);

            int opc = IO.readInt("Digite o número: ");

            switch (opc) {
                case 1 ->
                    Tanque.cadastrar(listaTanques, listaCombs);

                case 2 ->
                    Tanque.excluir(listaTanques);

                case 3 ->
                    Tanque.editar(listaTanques);

                case 4 -> {
                    Tanque.listar(listaTanques);
                    IO.aperteContinuar();
                }

                case 0 ->
                    sair = true;

                default ->
                    IO.println("Escolha uma opção válida!");
            }
        }
    }

    private static void menuBomba() {
        boolean sair = false;

        while (!sair) {
            IO.clearConsole();
            IO.println("  +-------- Sistema Posto Ipiranha --------+  ");
            IO.println("""
                   
                   Escolha uma opção: 
                     1. Cadastrar novo tanque
                     2. Excluir um tanque
                     3. Editar um tanque
                     
                     4. Visualizar lista de tanques
                   
                     0. Voltar ao menu principal
                   """);

            int opc = IO.readInt("Digite o número: ");

            switch (opc) {
                case 1 ->
                    Bomba.cadastrar(listaBombas, listaTanques);

                case 2 ->
                    Bomba.excluir(listaBombas);

                case 3 ->
                    Bomba.editar(listaBombas);

                case 4 -> {
                    Bomba.listar(listaBombas);
                    IO.aperteContinuar();
                }

                case 0 ->
                    sair = true;

                default ->
                    IO.println("Escolha uma opção válida!");
            }
        }
    }

    /**
     * Pega o id anterior e retorna o proximo
     *
     * @return o proximo id de bomba disponivel
     */
    public static int proxIdBomba() {
        idBomba++;
        return idBomba;
    }

    public static void abastecer() {
        // escolher bomba e abastecer
        if (!listaBombas.isEmpty()) {
            IO.println("\nEscolha uma bomba (ou 0 para sair):");
            Bomba.listar(listaBombas);

            String msg = "\nDigite o número da bomba escolhida: ";
            String errorMsg = "Número inválido! Escolha um dos números disponívies acima.";
            int opcBomba = IO.chooseInRange(0, listaBombas.size(), msg, errorMsg) - 1;
            if (opcBomba == -1) {
                return;
            }

            boolean sair = false;
            while (true) {
                IO.println("""
                       
                       Escolha o tipo:
                         1. Abastecer por litro
                         2. Abastecer por preço
                       """);
                int opc = IO.readInt("Digite o número: ");

                switch (opc) {
                    case 1 -> {
                        Bomba.abastecerPorLitro(listaBombas, opcBomba);
                        sair = true;
                    }
                    case 2 -> {
                        Bomba.abastecerPorValor(listaBombas, opcBomba);
                        sair = true;
                    }
                    default ->
                        IO.println("Número inválido! Escolha um dos disponíveis acima.");
                }
                if (sair) {
                    break;
                }
            }

        } else {
            IO.println("\nNão há nenhuma bomba cadastrado no momento!");
            IO.aperteContinuar();
        }
    }

    public static void calcularFaturamento() {
        if (!listaBombas.isEmpty()) {
            double fatTotal = 0;

            IO.println("\nFaturamento: ");

            for (Bomba listaBomba : listaBombas) {
                IO.println("  Bomba " + listaBomba.getId() + ": R$ " + listaBomba.getFaturamentoBomba());
                fatTotal += listaBomba.getFaturamentoBomba();
            }

            IO.println("\nFaturamento total: R$ " + fatTotal);

            IO.aperteContinuar();
        } else {
            IO.println("\nNão há nenhuma bomba cadastrado no momento!");
            IO.aperteContinuar();
        }
    }
}
