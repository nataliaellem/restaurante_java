import java.util.Scanner;

public class MenuConsole {

    private static int NUM_FUNCIONARIOS;
    private static int MAX_FUNCIONARIOS = 20;
    private static int MAX_MESAS = 50;

    Mesa[] mesas = new Mesa[MAX_MESAS];
    Funcionario[] funcionarios = new Funcionario[MAX_FUNCIONARIOS];

    private Funcionario autenticar(String nome, int codigo){
        for(int i = 0; i < MAX_FUNCIONARIOS; i++){
            if(funcionarios[i] != null && nome.equals(funcionarios[i].getNome()) && codigo == funcionarios[i].getCodigo()){
                return funcionarios[i];
            }
        }
        return null;
    }


    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1, codigo;
        String nome;

        while (opcao != 0) {
            System.out.println("====== RESTAURANTE ======");
            System.out.println("[1] Garçon");
            System.out.println("[2] Gerente");
            System.out.println("[0] Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    System.out.print("\nDigite seu nome: ");
                    nome = scanner.next();
                    System.out.print("Digite seu codigo: ");
                    codigo = scanner.nextInt();
                    menuGarcon(nome, codigo);
                    break;
                case 2:
                    System.out.print("\nDigite seu nome: ");
                    nome = scanner.next();
                    System.out.print("Digite seu codigo: ");
                    codigo = scanner.nextInt();
                    menuGerente(nome, codigo);
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }

    }

    public void menuGerente(String nome, int codigo) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1, nClientes, nMesa, code;
        Gerente gerente = null;

        if(autenticar(nome, codigo) != null && autenticar(nome, codigo) instanceof Gerente) {
            gerente = (Gerente) autenticar(nome, codigo);
        } else {
            funcionarios[NUM_FUNCIONARIOS] = gerente = new Gerente(nome, codigo);;
            NUM_FUNCIONARIOS ++;
        }

        while (opcao != 0) {
            System.out.println("\n====== MENU GERENTE ======");
            System.out.println("[1] Ver pedidos de uma mesa");
            System.out.println("[2] Abrir uma mesa");
            System.out.println("[3] Fechar uma mesa");
            System.out.println("[4] Ver estatísticas");
            System.out.println("[5] Ver dados do funcionário");
            System.out.println("[0] Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Voltando...");
                    break;
                case 1:
                    System.out.println("\n==== Ver pedidos ====");
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    gerente.visualizarPedidos(mesas[nMesa-1]);
                    break;
                case 2:
                    System.out.println("\n==== Abrir mesa ====");
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    System.out.print("Digite o nº de clientes: ");
                    nClientes = scanner.nextInt();
                    mesas[nMesa-1] = gerente.abrirMesa(nClientes, nMesa);
                    break;
                case 3:
                    System.out.println("\n==== Fechar mesa ====");
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    gerente.fecharMesa(mesas[nMesa-1]);
                    break;
                case 4:
                    gerente.verEstatisticas();
                    break;
                case 5:
                    gerente.imprimeInformacoes();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public void menuGarcon(String nome, int codigo) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1, nClientes, nMesa;
        double valor;
        String descricao;
        Garcon garcon = null;

        if(autenticar(nome, codigo) != null && autenticar(nome, codigo) instanceof Garcon) {
            garcon = (Garcon) autenticar(nome, codigo);
        } else {
            funcionarios[NUM_FUNCIONARIOS] = garcon = new Garcon(nome, codigo);;
            NUM_FUNCIONARIOS ++;
        }

        while (opcao != 0) {
            System.out.println("\n====== MENU GARÇON ======");
            System.out.println("[1] Fazer um pedido");
            System.out.println("[2] Abrir uma mesa");
            System.out.println("[3] Fechar uma mesa");
            System.out.println("[4] Ver dados do funcionário");
            System.out.println("[0] Voltar");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Voltando...");
                    break;
                case 1:
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    System.out.print("Digite a descrição do pedido: ");
                    descricao = scanner.next();
                    System.out.print("Digite o valor do pedido: ");
                    valor = scanner.nextDouble();
                    garcon.fazerPedido(mesas[nMesa-1], new Pedido(descricao, valor));
                    break;
                case 2:
                    System.out.println("\n==== Abrir mesa ====");
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    System.out.print("Digite o nº de clientes: ");
                    nClientes = scanner.nextInt();
                    mesas[nMesa-1] = garcon.abrirMesa(nClientes, nMesa);
                    break;
                case 3:
                    System.out.println("\n==== Fechar mesa ====");
                    System.out.print("Digite o nº da mesa: ");
                    nMesa = scanner.nextInt();
                    garcon.fecharMesa(mesas[nMesa-1]);
                    break;
                case 4:
                    garcon.imprimeInformacoes();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

