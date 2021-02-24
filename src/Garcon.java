public class Garcon extends Funcionario {

    public Garcon(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    @Override
    public Mesa abrirMesa(int numClientes, int numMesa) {
        Mesa novaMesa = new Mesa(numClientes, numMesa);
        novaMesa.setResponsavel(this);
        return novaMesa;
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        for(Pedido p : mesa.getHistoricoPedidos()){
            p = null;
        }
        mesa.setNumClientes(0);
    }

    public void fazerPedido(Mesa mesa, Pedido pedido){
        Pedido[] historico = mesa.getHistoricoPedidos();
        int numPedidos = mesa.getNumPedidos();
        historico[numPedidos] = pedido;
        mesa.updateNumPedidos();
    }

}
