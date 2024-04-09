package projetos.postocombustivel;

import java.util.ArrayList;
import static projetos.postocombustivel.PostoCombustivel.proxIdBomba;

public class Bomba {

    private int id;
    private Tanque tanque;
    private double faturamentoBomba;

    public Bomba(int id, Tanque tanque, double faturamentoBomba) {
        this.id = id;
        this.tanque = tanque;
        this.faturamentoBomba = faturamentoBomba;
    }

    /**
     * Cadastra uma nova bomba de combustivel no sistema
     *
     * @param listaBombas
     * @param listaTanques
     */
    public static void cadastrar(ArrayList<Bomba> listaBombas, ArrayList<Tanque> listaTanques) {
        if (!listaTanques.isEmpty()) {

            IO.println("\nEscolha um tanque: ");
            Tanque.listar(listaTanques); // Lista todos os tanques disponiveis

            String msg = "\nDigite o número do tanque escolhido (ou 0 para sair): ";
            String errorMsg = "Número inválido! Escolha um dos números disponívies acima.";
            int opc = IO.chooseInRange(0, listaTanques.size(), msg, errorMsg) - 1;
            if (opc == -1) {
                return;
            }

            Tanque tanqueEscolhido = listaTanques.get(opc);

            Bomba novaBomba = new Bomba(proxIdBomba(), tanqueEscolhido, 0);
            listaBombas.add(novaBomba);

            IO.println("\nNova bomba cadastrada com sucesso!");
            IO.aperteContinuar();
        } else {
            IO.println("\nNão há nenhum tanque cadastrado no momento!");
            IO.aperteContinuar();
        }

    }

    public static void listar(ArrayList<Bomba> listaBombas) {
        for (int i = 0; i < listaBombas.size(); i++) {
            IO.println("\nBomba " + listaBombas.get(i).getId() + ":");
            IO.println("  Tipo: " + listaBombas.get(i).getTanque().getTipo().getTipo());
            IO.println("  Preço do litro: R$ " + listaBombas.get(i).getTanque().getTipo().getPreco());
        }
    }

    public static void abastecerPorLitro(ArrayList<Bomba> listaBombas, int bomba) {
        double precoLitro = listaBombas.get(bomba).getTanque().getTipo().getPreco();

        listar(listaBombas);

        double qtdAbastecer = IO.readDouble("\nDigite a quantidade de litros a abastecer: ");

        double litrosTanque = listaBombas.get(bomba).getTanque().getQtdLitros();

        if (litrosTanque >= qtdAbastecer) {
            IO.println("\nAbastecendo...");

            double custo = qtdAbastecer * precoLitro;

            listaBombas.get(bomba).getTanque().setQtdLitros(litrosTanque - qtdAbastecer);
            listaBombas.get(bomba).setFaturamentoBomba(listaBombas.get(bomba).getFaturamentoBomba() + custo);

            IO.println("\nAbastecimento completo.");
            IO.printlnf("Litros:    %.2f L", qtdAbastecer);
            IO.printlnf("Custo:  R$ %.2f", custo);
            IO.println("\nObrigado e volte sempre!");
            IO.aperteContinuar();
        } else {
            IO.println("Quantidade insuficiente de combustível no tanque.");
        }
    }

    public static void abastecerPorValor(ArrayList<Bomba> listaBombas, int bomba) {
        double precoLitro = listaBombas.get(bomba).getTanque().getTipo().getPreco();

        listar(listaBombas);

        double valorAbastecer = IO.readDouble("\nDigite o valor a abastecer: R$ ");
        double qtdAbastecer = valorAbastecer / precoLitro;

        double litrosTanque = listaBombas.get(bomba).getTanque().getQtdLitros();

        if (litrosTanque >= qtdAbastecer) {
            IO.println("\nAbastecendo...");

            double custo = qtdAbastecer * precoLitro;

            listaBombas.get(bomba).getTanque().setQtdLitros(litrosTanque - qtdAbastecer);
            listaBombas.get(bomba).setFaturamentoBomba(listaBombas.get(bomba).getFaturamentoBomba() + custo);

            IO.println("\nAbastecimento completo.");
            IO.printlnf("Litros:    %.2f L", qtdAbastecer);
            IO.printlnf("Custo:  R$ %.2f", custo);
            IO.println("\nObrigado e volte sempre!");
            IO.aperteContinuar();
        } else {
            IO.println("Quantidade insuficiente de combustível no tanque.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tanque getTanque() {
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public double getFaturamentoBomba() {
        return faturamentoBomba;
    }

    public void setFaturamentoBomba(double faturamentoBomba) {
        this.faturamentoBomba = faturamentoBomba;
    }

}
