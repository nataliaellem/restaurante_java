public class Garcon extends Funcionario {

    public Garcon(String nome, int codigo) {
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
        for(int i = 0; i < mesa.getNumPedidos(); i++){
            mesa.getHistoricoPedidos()[i] = null;
        }
        mesa.setNumClientes(0);
        mesa.setResponsavel(null);
        mesa.decrementaTotalMesas();
    }

    public void fazerPedido(Mesa mesa, Pedido pedido){
        Pedido[] historico = mesa.getHistoricoPedidos();
        int numPedidos = mesa.getNumPedidos();
        historico[numPedidos] = pedido;
        mesa.updateNumPedidos();
    }

}
