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

    // O restaurante terá 50 mesas
    private static int LIMITE_MESAS = 50;

    // Quantidade de mesas abertas (com clientes) no restaurante
    private static int MESAS_ABERTAS;

    // Total geral de mesas abertas
    private static int TOTAL_MESAS_ABERTAS;

    // Array que guarda os números das mesas abertas
    private static int[] NUMEROS_MESAS_OCUPADAS = new int[50];

    public Mesa(int numClientes, int numMesa, Funcionario responsavel){
        this.numMesa = numMesa;
        this.numClientes = numClientes;
        this.responsavel = responsavel;
        this.historicoPedidos = new Pedido[100]; // Máximo de 100 pedidos por mesa
        for (int i = 0; i < 100; i++){
            this.historicoPedidos[i] = null;
        }
        MESAS_ABERTAS++;
        TOTAL_MESAS_ABERTAS++;
        NUMEROS_MESAS_OCUPADAS[TOTAL_MESAS_ABERTAS + 1] = numMesa;

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

    public int getNumPedidos(){
        Pedido[] pedidos = this.historicoPedidos;
        int contador = 0;
        for (Pedido p : pedidos){
            if (p != null){
                contador++;
            }
        }
        return contador;
    }

    public static int getTotalMesasAbertas() {
        return TOTAL_MESAS_ABERTAS;
    }

    public static int getMesasAbertas() {
        return MESAS_ABERTAS;
    }

    public static int getLimiteMesas(){
        return LIMITE_MESAS;
    }

    // Método auxiliar no fechamento de uma mesa que decrementa 1 no total de mesas abertas
    public void decrementaTotalMesas(){
        MESAS_ABERTAS --;
    }

    public static int[] getNumerosMesasOcupadas(){
        return NUMEROS_MESAS_OCUPADAS;
    }

    // Método que tira um número de mesa do vetor NUMEROS_MESAS_OCUPADAS quando uma mesa é fechada
    public static void updateNumerosMesasOcupadas(int num){
        for (int i : NUMEROS_MESAS_OCUPADAS){
            if (i == num){
                i = 0;
            }
        }
    }



}
