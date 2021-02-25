public class Gerente extends Funcionario{

    public Gerente(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    @Override
    public Mesa abrirMesa(int numClientes, int numMesa) {
        if (Mesa.TOTAL_MESAS_ABERTAS >= 50){
            System.out.println("Total de mesas excedido. Mesa não pode ser aberta.");
            return null;
        }
        Mesa novaMesa = new Mesa(numClientes, numMesa, this);
        return novaMesa;
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        Pedido[] pedidios = mesa.getHistoricoPedidos();
        for(Pedido p : pedidios){
            p = null;
        }
        mesa.setNumClientes(0);
        mesa.decrementaTotalMesas();
    }

    public void visualizarPedidos(Mesa mesa){
        System.out.println("=== Pedidos da mesa "+ mesa.getNumMesa() + " ===\n");
        double conta = 0;
        Pedido[] pedidos = mesa.getHistoricoPedidos();
            for (int i = 0; i <= mesa.getNumPedidos(); i++){
                if (pedidos[i] != null){
                    int numeroDoPedido = i+1;
                    System.out.println("Pedido "+ numeroDoPedido);
                    System.out.println(pedidos[i].toString() + "\n");
                    conta += pedidos[i].getValor();
                }
            }
            System.out.println("Total da conta da mesa: " + conta);

    }

    // Um gerente tem permissão de fechar e visualizar pedidos de qualquer mesa
    // E o gerente pode mudar o responsável por alguma mesa

    public void mudarResponsavel(Garcon novoResponsavel, Mesa mesa){
        mesa.setResponsavel(novoResponsavel);
    }


}
