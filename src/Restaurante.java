public class Restaurante {
    public static void main(String[] args) {

        // O restaurante possui 50 mesas (Limite de mesas estabelecido)
        Mesa[] mesas = new Mesa[Mesa.LIMITE_MESAS];

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
        mesas[3] = garcon[9].abrirMesa(2, 3);
        mesas[3] = garcon[8].abrirMesa(5, 1);
        mesas[3] = garcon[7].abrirMesa(1, 2);
        mesas[3] = gerente[0].abrirMesa(4, 3);

        // Teste: Verificando que qualquer gerente pode reatribui o responsável da mesa
        gerente[1].mudarResponsavel(garcon[1], mesas[3]);

        // Inicializar os pedidos e depois atribuí-los a uma mesa usando fazerPedido(); torna a variável TOTAL_PEDIDOS inútil, já que representa a quantidade de pedidos instanciados. Mesmo que existam pedidos iguais, eles não são contabilizados.
        // Porém, inicializar um pedido a cada chamada do método fazerPedido(); parece fazer mais sentido, já que mesmo existindo pedidos iguais, são para pessoas diferentes (ou a mesma q ta com mta fome)
        garcon[1].fazerPedido(mesas[3], new Pedido("Arroz", 50));
        garcon[1].fazerPedido(mesas[3], new Pedido("Salada", 10));

        // Teste: não deve ser possível ver os pedidos de uma mesa sem pedidos ou inexistente/não-instanciada
        gerente[0].visualizarPedidos(mesas[0]);
        gerente[0].visualizarPedidos(mesas[1]);
        gerente[0].visualizarPedidos(mesas[2]);
        gerente[0].visualizarPedidos(mesas[3]);

        // Teste: Qualquer gerente deve poder fechar qualquer mesa aberta
        gerente[1].fecharMesa(mesas[3]);

        // Teste: Conferiindo se a mesa foi realmente fechada
        System.out.println("\nMesa " + mesas[3].getNumMesa() + "\nnº pedidos: " + mesas[3].getNumPedidos() + "\tnº clientes: " + mesas[3].getNumClientes() + "\tresponsavel: " + mesas[3].getResponsavel());
        gerente[0].visualizarPedidos(mesas[3]);
        System.out.println("\n");

        // Problema(?): É possível alterar o número de pedidos de uma mesa
        mesas[11] = garcon[5].abrirMesa(0,0);
        for(int i = 0; i < 55; i++){
            mesas[11].updateNumPedidos();
        }
        gerente[0].visualizarPedidos(mesas[11]);
        System.out.println("nº de pedidos: " + mesas[11].getNumPedidos());
        mesas[11].resetNumPedidos();

        // Problema(?): É possível alterar o total de mesas abertas e burlar o limite
        for(int i = 0; i < 200; i++){
            mesas[11].decrementaTotalMesas();
        }

        // Teste: função ver eSTATICsticas, para dar algum uso para as variáveis static
        gerente[0].verEstatisticas();

        System.out.println("\n\n\n\n\n");
        /* --------------------------------------------------------------------------------------------------- */

        /* Trecho de testes do menu. Ainda em implementação */
        /* Provavelmente será transferido para a main */

        MenuConsole m = new MenuConsole();

        m.iniciar();

    }
}
