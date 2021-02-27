public class Restaurante {
    public static void main(String[] args) {

        // O restaurante possui 10 garçons (nomeados de G1 a G10)
        Garcon[] garcon = new Garcon[10];
        for(int i = 0; i < 10; i++){
            String s = "G" + (i+1);
            garcon[i] = new Garcon(s, i+11);
        }

        // O restaurante possui 2 gerentes
        Gerente[] gerente = new Gerente[2];
        gerente[0] = new Gerente("José", 1);
        gerente[1] = new Gerente("Maria", 2);

        // Problema: uma mesa pode ser aberta sobreescrevendo uma existente
        // Problema: é possível ter duas mesas com o mesmo número
        Mesa mesa1 = garcon[9].abrirMesa(2, 3);
        Mesa mesa2 = garcon[8].abrirMesa(5, 1);
        Mesa mesa3 = garcon[7].abrirMesa(1, 2);

        // Teste: Verificando que qualquer gerente pode reatribui o responsável da mesa
        gerente[1].mudarResponsavel(garcon[1], mesa3);

        // Inicializar os pedidos e depois atribuí-los a uma mesa usando fazerPedido(); torna a variável TOTAL_PEDIDOS inútil, já que representa a quantidade de pedidos instanciados. Mesmo que existam pedidos iguais, eles não são contabilizados.
        // Porém, inicializar um pedido a cada chamada do método fazerPedido(); parece fazer mais sentido, já que mesmo existindo pedidos iguais, são para pessoas diferentes em mesas diferentes (ou a mesma q ta com mta fome)
        garcon[9].fazerPedido(mesa1, new Pedido("Pizza", 50));
        garcon[1].fazerPedido(mesa3, new Pedido("Pizza", 50));
        garcon[1].fazerPedido(mesa3, new Pedido("Salada", 10));

        // Teste: não deve ser possível ver os pedidos de uma mesa sem pedidos ou inexistente/não-instanciada
        gerente[0].visualizarPedidos(mesa1);
        gerente[0].visualizarPedidos(mesa2);
        gerente[0].visualizarPedidos(mesa3);

        // Teste: Qualquer gerente deve poder fechar qualquer mesa aberta
        gerente[1].fecharMesa(mesa3);

        // Teste: Conferiindo se a mesa foi realmente fechada
        System.out.println("\nMesa " + mesa3.getNumMesa() + "\nnº pedidos: " + mesa3.getNumPedidos() + "\tnº clientes: " + mesa3.getNumClientes() + "\tresponsavel: " + mesa3.getResponsavel());
        gerente[0].visualizarPedidos(mesa3);
        System.out.println("\n");

    
        Mesa mesa50 = garcon[5].abrirMesa(87,50);
        gerente[0].visualizarPedidos(mesa50);


        // Teste: função ver eSTATICsticas, para dar algum uso para as variáveis static
        gerente[0].verEstatisticas();

        System.out.println("\n\n\n\n\n");
        /* --------------------------------------------------------------------------------------------------- */

        /* Trecho de testes do menu. Ainda em implementação */
        /* Provavelmente será transferido para a main */

        //MenuConsole m = new MenuConsole();

       // m.iniciar();

    }
}
