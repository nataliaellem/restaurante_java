public class Gerente extends Funcionario{

    public Gerente(String nome, int codigo) {
        super(nome, codigo);
    }

    /* Métodos */

    public void imprimeInformacoes(){
        if (super.getNome() != null && super.getCodigo() != 0){
            System.out.println("\n====== Dados do funcionário ======");
            System.out.println("Cargo: Gerente");
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
        int totalMesas = Mesa.getMesasAbertas();
        if (totalMesas >= Mesa.getLimiteMesas()){
            System.out.println("Total de mesas excedido. Mesa não pode ser aberta.");
            return null;
        }else {
            Mesa novaMesa = new Mesa(numClientes, numMesa, this);
            return novaMesa;
        }
    }

    @Override
    public void fecharMesa(Mesa mesa) {
        Pedido[] pedidos = mesa.getHistoricoPedidos(); 
        for(Pedido p : pedidos){
            p = null;
        }
        mesa.setNumClientes(0);
        mesa.setResponsavel(null);
        mesa.decrementaTotalMesas();
        mesa.updateNumerosMesasOcupadas(mesa.getNumMesa());
    }


    public void visualizarPedidos(Mesa mesa){
        if(mesa != null && mesa.getResponsavel() != null) {
            double conta = 0;
            Pedido[] pedidos = mesa.getHistoricoPedidos();

            System.out.println("\n===== Pedidos da mesa " + mesa.getNumMesa() + " =====");
            System.out.println("Responsável pela mesa: " + mesa.getResponsavel().getNome());
            System.out.println("Número de clientes: " + mesa.getNumClientes() + "\n");
            int totalPedidos = 0;
            for (Pedido p : pedidos) {
                if (p != null) {
                    System.out.println("Pedido " + (totalPedidos+1));
                    System.out.println(p.toString() + "\n");
                    conta += p.getValor();
                    totalPedidos++;
                }
            }
            System.out.println("Total de pedidos: " + totalPedidos);
            System.out.println("Total da conta da mesa: " + String.format("%.2f", conta));
        }
        else{
            System.out.println("Mesa vazia");
        }
    }

    // Um gerente tem permissão de fechar e visualizar pedidos de qualquer mesa
    // E o gerente pode mudar o responsável por alguma mesa
    public void mudarResponsavel(Garcon novoResponsavel, Mesa mesa){
        mesa.setResponsavel(novoResponsavel);
    }

    public void verEstatisticas(){
        System.out.println("\n======== Estatísticas ========");
        System.out.println("Quantidade de mesas usadas: " + Mesa.getMesasAbertas() + "/" + Mesa.getLimiteMesas());
        System.out.println("Total de mesas abertas: " + Mesa.getTotalMesasAbertas());
        System.out.println("Total de pedidos realizados: " + Pedido.getTotalPedidos());
    }


}
