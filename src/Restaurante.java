public class Restaurante {
    public static void main(String[] args) {

        /*
        Restaurante

        -Cliente chega
        -Cliente ocupa uma mesa
        -Cliente faz pedidos
        -Cliente paga os pedidos (conta = soma dos valores do historico de pedidos)
        -Cliente vai embora

        -Funcionário atribui o cliente a uma mesa (abrir mesa)
        -Funcionario recebe pedidos
        -Funcionario recebe pagamento***
        -Funcionario desatribui o cliente da mesa (fecha mesa)


        Questões:
            -Pedido possui uma descrição e valor. Como pedir? Criar classe cardápio ou tanto faz a instancia de pedido?
            -Considerar limite de mesas no restaurante?
            -Impedir mesa de ser fechada sem pagar a conta? Considerar pagar a conta?


        Tarefas:
            *Garçon
                -abrir uma mesa
                -fechar uma mesa (aberta)
                -fazer pedidos para uma mesa
            *Gerente
                -abrir uma mesa
                -fechar uma mesa (aberta)
                -visualizar pedidos de uma mesa

         */

        /*
        CRIAR TESTES PARA TODOS OS METODOS (simular o restaurante)
         */

        Pedido p = new Pedido("prato do dia", 30);
        Pedido p2 = new Pedido("pizza", 40);
        Pedido p3 = new Pedido("salada", 40);

        System.out.println(Pedido.getTotalPedidos());
    }
}
