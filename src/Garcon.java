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
        for (int i = 0; i < Mesa.getTotalMesasAbertas(); i++){
            if (Mesa.getNumerosMesasOcupadas()[i] == numMesa){
                System.out.println("Número de mesa já aberta.");
                return null;
            }
        }
        if (Mesa.getMesasAbertas() >= Mesa.getLimiteMesas()){
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
                Pedido[] pedidos = mesa.getHistoricoPedidos();
                for(Pedido p : pedidos){
                    p = null;
                }
                mesa.setNumClientes(0);
                mesa.setResponsavel(null);
                mesa.decrementaTotalMesas();
                mesa.updateNumerosMesasOcupadas(mesa.getNumMesa());

            } else {
                System.out.println("Garçon não é o responsável pela mesa.");
            }
        }
    
    }

    public void fazerPedido(Mesa mesa, Pedido pedido){
        // Apenas o garçon responsável pela mesa poderá fazer pedidos
        if (this.equals(mesa.getResponsavel())){
            Pedido[] historico = mesa.getHistoricoPedidos();
            int i = 0;
            for(Pedido p : historico){
                if (p == null){
                    historico[i] = pedido;
                    break;
                }
                i++;
            }

        } else {
            System.out.println("Garçon não é o responsável pela mesa.");
        }
    }

}
