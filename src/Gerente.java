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
        for(Pedido p : mesa.getHistoricoPedidos()){
            p = null;
        }
        mesa.setNumClientes(0);
    }

    void visualizarPedidos(Mesa mesa){
        System.out.println();
    }


}
