public class Pedido {

    /* Atributos */

    // descrição do pedido
    private String descricao;

    // valor do pedido
    private double valor;

    // total geral de pedidos (static)
    private static int TOTAL_PEDIDOS;

    public Pedido(String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;

        TOTAL_PEDIDOS++;
    }

    // Métodos

    @Override
    public String toString() {
        String pedidoStr =
                "Descrição: " + this.descricao + "\n" +
                "Valor: " + this.valor;
        return pedidoStr;
    }


    /* Getters/Setters */

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getTotalPedidos() {
        return TOTAL_PEDIDOS;
    }
}
