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

    // Total de pedidos feitos pela mesa
    private int numPedidos;

    // Total de mesas abertas (static)
    private static int TOTAL_MESAS_ABERTAS;

    public Mesa(int numMesa, int numClientes){
        this.numMesa = numMesa;
        this.numClientes = numClientes;
        this.responsavel = responsavel;
        this.numPedidos = 0;
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
        return this.responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public int getNumPedidos(){
        return this.numPedidos;
    }

    public Pedido[] getHistoricoPedidos(){
        return this.historicoPedidos;
    }

    public static int getTotalMesasAbertas() {
        return TOTAL_MESAS_ABERTAS;
    }

    // Método que incrementa 1 ao número de pedidos
    public void updateNumPedidos(){
        this.numPedidos++;
    }
}