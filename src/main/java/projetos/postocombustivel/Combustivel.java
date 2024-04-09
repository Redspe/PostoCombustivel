package projetos.postocombustivel;

import java.util.ArrayList;

public class Combustivel {

    private String tipo;
    private double preco;

    public Combustivel(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    /**
     * Cadastra um novo tipo de combustivel no sistema
     * 
     * @param listaCombs Lista de combustiveis em uso
     */
    public static void cadastrar(ArrayList<Combustivel> listaCombs) {
        IO.println("\nDigite 'SAIR' para cancelar.");
        String tipo = IO.readStr("Digite o tipo de combustível: ");

        if (tipo.equals("SAIR")) {
            return;
        }

        String msg = "Digite o preço (1.23): R$ ";
        String errorMsg = "Número inválido! O preço deve estar entre 0 e 999.";
        double preco = IO.chooseInRange(0.0, 999.99, msg, errorMsg);

        Combustivel novoComb = new Combustivel(tipo, preco);

        listaCombs.add(novoComb);

        IO.println("\nNovo combustível cadastrado com sucesso!");
        IO.aperteContinuar();
    }

    public static void listar(ArrayList<Combustivel> listaCombs) {
        if (!listaCombs.isEmpty()) {
            for (int i = 0; i < listaCombs.size(); i++) {
                IO.println("\nCombustível " + (i + 1) + ":");
                IO.println("  Tipo: " + listaCombs.get(i).getTipo());
                IO.println("  Preço: R$ " + listaCombs.get(i).getPreco());
            }
        } else {
            IO.println("\nNão há nenhum combustível cadastrado no momento!");
            IO.aperteContinuar();
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
