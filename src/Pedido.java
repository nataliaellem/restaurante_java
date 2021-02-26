public class Pedido {

    /* Atributos */

    // Descrição do pedido
    private String descricao;

    // Valor do pedido
    private double valor;

    // Total geral de pedidos realizados
    private static int TOTAL_PEDIDOS;

    public Pedido(String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;

        TOTAL_PEDIDOS++;
    }

    /* Métodos */

    @Override
    public String toString() {
        String pedidoStr =
                "Descrição: " + this.descricao + "\n" +
                "Valor: " + String.format("%.2f", this.valor);
        return pedidoStr;
    }

    public double getValor() {
        return valor;
    }

    public static int getTotalPedidos() {
        return TOTAL_PEDIDOS;
    }
}
