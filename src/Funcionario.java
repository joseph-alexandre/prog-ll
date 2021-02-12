import java.util.Date;

//Faça uma classe para representar um usuário que tem CPF, nome, ID, idade, data de contratação e salário.

public class Funcionario {
    private String CPF, nome;
    private Integer idade, id;
    private Float salario;
    private Date dataContratacao;

    public Funcionario(String CPF, String nome, Integer id, Integer idade, Float salario, Date dataContratacao) {
        this.CPF = CPF;
        this.nome = nome;
        this.id = id;
        this.idade = idade;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public Funcionario() {
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return
                this.CPF + ";" +
                this.nome + ";" +
                this.id + ";" +
                this.idade + ";" +
                this.salario + ";" +
                GenericUtils.formatarDataParaString(dataContratacao);
    }

    public static void main(String[] args) {
        // Exemplo de criação de um funcionário

        Funcionario funcionario = new Funcionario("123.456.789-10", "João da Silva", 1,
                10, 134.3f, new Date());

        System.out.println(funcionario);
    }
}
