package projetos.postocombustivel;

import java.util.ArrayList;

public class Tanque {

    private Combustivel tipo;
    private int estado;
    private double qtdLitros;

    // transformar em porcentagem
    public static final int VAZIO = 0;
    public static final int METADE = 1;
    public static final int CHEIO = 2;

    public Tanque(Combustivel tipo, int estado, double qtdLitros) {
        this.tipo = tipo;
        this.estado = estado;
        this.qtdLitros = qtdLitros;
    }

    /**
     * Cadastra um novo tanque de combustivel no sistema
     * 
     * @param listaTanques Lista de tanques em uso
     * @param listaCombs Lista de combustiveis em uso
     */
    static void cadastrar(ArrayList<Tanque> listaTanques, ArrayList<Combustivel> listaCombs) {
        if (!listaCombs.isEmpty()) {
            IO.println("\nEscolha um tipo de combustível: ");
            Combustivel.listar(listaCombs); // Lista todos os combs disponiveis

            String msg = "\nDigite o número do combustível escolhido (ou 0 para sair): ";
            String errorMsg = "Número inválido! Escolha um dos números disponívies acima.";
            int opc = IO.chooseInRange(0, listaCombs.size(), msg, errorMsg) - 1;
            if (opc == -1) {
                return;
            }

            Combustivel combEscolhido = listaCombs.get(opc);

            int estadoTanque = Tanque.CHEIO; // placeholder

            double qtdLitros = IO.readDouble("Digite a quantidade de litros no tanque: ");

            Tanque novoTanque = new Tanque(combEscolhido, estadoTanque, qtdLitros);
            listaTanques.add(novoTanque);

            IO.println("\nNovo tanque cadastrado com sucesso!");
        } else {
            IO.println("\nNão há nenhum combustível cadastrado no momento!");
            IO.aperteContinuar();
        }
    }

    public static void listar(ArrayList<Tanque> listaTanques) {
        if (!listaTanques.isEmpty()) {
            for (int i = 0; i < listaTanques.size(); i++) {
                IO.println("\nTanque " + (i + 1) + ":");
                IO.println("  Tipo: " + listaTanques.get(i).getTipo().getTipo());
                IO.println("  Estado: " + listaTanques.get(i).getEstado());
                IO.println("  Quantidade de litros: " + listaTanques.get(i).getQtdLitros());
            }
        } else {
            IO.println("\nNão há nenhum combustível cadastrado no momento!");
            IO.aperteContinuar();
        }
    }

    public Combustivel getTipo() {
        return tipo;
    }

    public void setTipo(Combustivel tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getQtdLitros() {
        return qtdLitros;
    }

    public void setQtdLitros(double qtdLitros) {
        this.qtdLitros = qtdLitros;
    }

}
