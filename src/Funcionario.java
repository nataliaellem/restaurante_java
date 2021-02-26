public abstract class Funcionario {

    /* Atributos */

    // Nome do funcionário
    private String nome;

    // Código do funcionário
    private int codigo;

    public Funcionario(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }

    /* Métodos */

    public abstract void imprimeInformacoes();

    public abstract Mesa abrirMesa(int numClientes, int numMesa);

    public abstract void fecharMesa(Mesa mesa);

    /* Getters/Setters */

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

}
