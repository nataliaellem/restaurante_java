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

    public Mesa(int numMesa, int numClientes, Funcionario responsavel){
        this.numMesa = numMesa;
        this.numClientes = numClientes;
        this.responsavel = responsavel;
        this.numPedidos = 0;
        this.historicoPedidos = new Pedido[100];

        // O restaurante possui apenas 50 mesas, não será possível deixar abertas mais do que 50 mesas
        if (TOTAL_MESAS_ABERTAS < 50){
            TOTAL_MESAS_ABERTAS++;
        } else {
            System.out.println("Não há mais mesas disponíveis.");
        }
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

    // Método que decrementa 1 de TOTAL_MESAS_ABERTAS quando uma mesa é fechada

    public static void decrementaTotalMesas(){
        Mesa.TOTAL_MESAS_ABERTAS = TOTAL_MESAS_ABERTAS - 1;
    }
}
