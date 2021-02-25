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


        // O restaurante tem 50 mesas, por isso será criado um array de objetos Mesa de tamanho 50

        Mesa[] mesas = new Mesa[50];


        // O restaurante terá 10 garçons

        Garcon[] garcons = new Garcon[10];
        garcons[0] = new Garcon("G1", 11);
        garcons[0] = new Garcon("G2", 12);
        garcons[0] = new Garcon("G3", 13);
        garcons[0] = new Garcon("G4", 14);
        garcons[0] = new Garcon("G5", 15);
        garcons[0] = new Garcon("G6", 16);
        garcons[0] = new Garcon("G7", 17);
        garcons[0] = new Garcon("G8", 18);
        garcons[0] = new Garcon("G9", 19);
        garcons[0] = new Garcon("G10", 20);


        // O restaurante terá 2 gerentes

        Gerente[] gerentes = new Gerente[2];

        gerentes[0] = new Gerente("José", 1);
        gerentes[1] = new Gerente("Maria", 2);

        
    
    }
}
