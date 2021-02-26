import java.util.Scanner;

public class MenuConsole {

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        String senha;

        while (opcao != 0) {
            System.out.println("====== RESTAURANTE FOMINHA ======");
            System.out.println("[1] Garçon");
            System.out.println("[2] Gerente");
            System.out.println("[0] Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando");
                    break;
                case 1:
                    System.out.println("Digite a senha (Dica: a senha é 1): ");
                    senha = scanner.next();// Obs: senha facilitada, poderia ser um nextInt
                    if(senha.equals("1")){
                        menuGarcon();
                    }else{
                        System.out.println("Senha inválida");
                    }
                    break;
                case 2:
                    System.out.println("Digite a senha (Dica: a senha é 2): ");
                    senha = scanner.next();// Obs: senha facilitada, poderia ser um nextInt
                    if(senha.equals("2")){
                        menuGarcon();
                    }else{
                        System.out.println("Senha inválida");
                    }
                default:
                    System.out.println("Opção inválida.");

            }
        }

    }

    public void menuGerente() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;


        while (opcao != 0) {
            System.out.println("====== MENU GERENTE ======");
            System.out.println("[1] Visualizar pedidos de uma mesa");
            System.out.println("[2] Abrir uma mesa");
            System.out.println("[3] Fechar uma mesa");
            System.out.println("[0] Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Voltando...");
                    break;
                case 1:
                    // ver pedidos
                    // ex: gerente[codGerente].visualizarPedidos(mesas[numMesa]);
                    // ex: Gerente x = gerente; Mesa y = mesa; x.visualizarPedidos(y);
                    break;
                case 2:
                    // Abrir uma mesa
                    break;
                case 3:
                    // Fechar uma mesa
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void menuGarcon() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("====== MENU GARÇON ======");
            System.out.println("[1] Fazer um pedido");
            System.out.println("[2] Abrir uma mesa");
            System.out.println("[3] Fechar uma mesa");
            System.out.println("[0] Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Voltando...");
                    break;
                case 1:
                    // fazer pedido
                    break;
                case 2:
                    // Abrir uma mesa
                    break;
                case 3:
                    // Fechar uma mesa
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

