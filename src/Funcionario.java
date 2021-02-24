public abstract class Funcionario {

    /* Atributos */

    // nome
    private String nome;

    // codigo
    private int codigo;

    public Funcionario(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }


    /* Métodos */

    public abstract Mesa abrirMesa(int numClientes, int numMesa);

    public abstract void fecharMesa(Mesa mesa);

    /* Getters/Setters */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    // O código do funcionário pode mudar?
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
