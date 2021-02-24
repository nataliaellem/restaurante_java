public class Gerente extends Funcionario{

    public Gerente(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    @Override
    public Mesa abrirMesa(int numClientes, int numMesa) {
        Mesa novaMesa = new Mesa(numClientes, numMesa, this);
        return novaMesa;
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        for (int i = 0; i < mesa.getNumPedidos(); i++) {
            mesa.getHistoricoPedidos()[i] = null;
        }
        mesa.setNumClientes(0);
        mesa.setResponsavel(null);
        mesa.decrementaTotalMesas();
    }


        public void visualizarPedidos(Mesa mesa){
        if(mesa.getResponsavel() != null) {
            System.out.println("=== Pedidos da mesa " + mesa.getNumMesa() + " ===");
            System.out.println("Responsável pela mesa: " + mesa.getResponsavel().getNome() + "\n");
            double conta = 0;
            Pedido[] pedidos = mesa.getHistoricoPedidos();
            for (int i = 0; i <= mesa.getNumPedidos(); i++) {
                if (pedidos[i] != null) {
                    int numeroDoPedido = i + 1;
                    System.out.println("Pedido " + numeroDoPedido);
                    System.out.println(pedidos[i].toString() + "\n");
                    conta += pedidos[i].getValor();
                }
            }
            System.out.println("Total da conta da mesa: " + conta);
        }
        else{
            System.out.println("Mesa vazia");
        }

    }


}
