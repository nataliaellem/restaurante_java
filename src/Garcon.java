public class Garcon extends Funcionario {

    public Garcon(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    @Override
    public Mesa abrirMesa(int numClientes, int numMesa) {
        if (Mesa.getTotalMesasAbertas() >= 50){
            System.out.println("Total de mesas excedido. Mesa não pode ser aberta.");
            return null;
        }
        Mesa novaMesa = new Mesa(numClientes, numMesa, this);
        return novaMesa;
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        if (mesa != null){
            // Apenas o garçon responsável pela mesa poderá fechá-la
            if (this.equals(mesa.getResponsavel())){
                for(int i = 0; i < mesa.getNumPedidos(); i++){
                    mesa.getHistoricoPedidos()[i] = null;
                }
                mesa.setNumClientes(0);
                mesa.setResponsavel(null);
                mesa.decrementaTotalMesas();
            } else {
                System.out.println("Garçon não é o responsável pela mesa.");
            }
        }
    
    }

    public void fazerPedido(Mesa mesa, Pedido pedido){
        // Apenas o garçon responsável pela mesa poderá fazer pedidos
        if (this.equals(mesa.getResponsavel())){
            Pedido[] historico = mesa.getHistoricoPedidos();
            int numPedidos = mesa.getNumPedidos();
            historico[numPedidos] = pedido;
            mesa.updateNumPedidos();

        } else {
            System.out.println("Garçon não é o responsável pela mesa.");
        }
    }

}
