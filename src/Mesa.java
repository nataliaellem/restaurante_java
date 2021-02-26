public class Mesa {

    /* Atributos */

    // Número identificador da mesa
    private int numMesa;

    // Número de clientes na mesa
    private int numClientes;

    // Histórico de pedidos da mesa
    private Pedido[] historicoPedidos;

    // Funcionário responsável pela mesa
    private Funcionario responsavel;

    // Total de pedidos feitos pela mesa
    private int numPedidos;

    // Limite de mesas abertas/instanciadas
    public static int LIMITE_MESAS = 50;

    // Quantidade de mesas abertas no restaurante
    private static int MESAS_ABERTAS;

    // Total geral de mesas abertas
    private static int TOTAL_MESAS_ABERTAS;

    public Mesa(int numClientes, int numMesa, Funcionario responsavel){
        this.numMesa = numMesa;
        this.numClientes = numClientes;
        this.responsavel = responsavel;
        this.numPedidos = 0;
        this.historicoPedidos = new Pedido[100]; // Máximo de 100 pedidos por mesa
        MESAS_ABERTAS++;
        TOTAL_MESAS_ABERTAS++;
    }

    /* Métodos */

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

    public Pedido[] getHistoricoPedidos(){
        return this.historicoPedidos;
    }

    public static int getTotalMesasAbertas() {
        return TOTAL_MESAS_ABERTAS;
    }

    public static int getMesasAbertas() {
        return MESAS_ABERTAS;
    }

    // Método auxiliar no fechamento de uma mesa que decrementa 1 no total de mesas abertas
    public void decrementaTotalMesas(){
        MESAS_ABERTAS --;
    }

    public int getNumPedidos(){
        return this.numPedidos;
    }

    // Método que incrementa 1 ao número de pedidos
    public void updateNumPedidos(){
        this.numPedidos++;
    }

    // Método auxiliar no fechamento de uma mesa que zera o nº de pedidos da mesa
    public void resetNumPedidos() {
        this.numPedidos = 0;
    }
}
