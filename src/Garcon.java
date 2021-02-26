public class Garcon extends Funcionario {

    public Garcon(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    public void imprimeInformacoes(){
        if (super.getNome() != null && super.getCodigo() != 0){
            System.out.println("\n==== Dados do funcionário ====");
            System.out.println("Cargo: Garçom");
            System.out.println("Nome: " + super.getNome());
            System.out.println("Código: " + super.getCodigo() + "\n");
        }
    }

    @Override
    public Mesa abrirMesa(int numClientes, int numMesa) {
        if (Mesa.getMesasAbertas() >= Mesa.LIMITE_MESAS){
            System.out.println("Total de mesas excedido. Mesa não pode ser aberta.");
            return null;
        }else {
            Mesa novaMesa = new Mesa(numClientes , numMesa, this);
            return novaMesa;
        }
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        if (mesa != null){
            // Apenas o garçon responsável pela mesa poderá fechá-la
            if (this.equals(mesa.getResponsavel())){
                for(int i = 0; i < mesa.getNumPedidos(); i++){
                    mesa.getHistoricoPedidos()[i] = null;
                }
                mesa.resetNumPedidos();
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
