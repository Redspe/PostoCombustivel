package projetos.postocombustivel;

import java.util.ArrayList;

public class Bomba {

    private int id;
    private Tanque tanque;
    private double faturamentoBomba;

    public Bomba(int id, Tanque tanque, double faturamentoBomba) {
        this.id = id;
        this.tanque = tanque;
        this.faturamentoBomba = faturamentoBomba;
    }

    public static void listarBombas(ArrayList<Bomba> listaBombas) {
        for (int i = 0; i < listaBombas.size(); i++) {
            IO.println("\nBomba " + listaBombas.get(i).getId() + ":");
            IO.println("  Tipo: " + listaBombas.get(i).getTanque().getTipo().getTipo());
            IO.println("  Preço do litro: R$ " + listaBombas.get(i).getTanque().getTipo().getPreco());
        }
    }

    public static void abastecerPorLitro(ArrayList<Bomba> listaBombas, int bomba) {
        double precoLitro = listaBombas.get(bomba).getTanque().getTipo().getPreco();

        listarBombas(listaBombas);

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

        listarBombas(listaBombas);

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
