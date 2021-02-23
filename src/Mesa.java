public class Mesa {

    /* Atributos */

    // nº da mesa
    private int numMesa;

    // nº de clientes na mesa
    private int numClientes;

    // histórico de pedidos da mesa (vetor 100)
    private Pedido[] historicoPedidos;

    // funcionário responsável pela mesa
    private Funcionario responsavel;

    // Total de mesas abertas (static)
    private static int TOTAL_MESAS_ABERTAS;

    public Mesa(int numMesa, int numClientes, Funcionario responsavel){
        this.numMesa = numMesa;
        this.numClientes = numClientes;
        this.responsavel = responsavel;
        this.historicoPedidos = new Pedido[100];

        TOTAL_MESAS_ABERTAS++;
    }

    /* Getters/Setters */

    public int getNumMesa() {
        return numMesa;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public static int getTotalMesasAbertas() {
        return TOTAL_MESAS_ABERTAS;
    }
}
