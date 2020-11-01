import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
Escreva um programa para gerenciar os funcionários de uma empresa. Software deve atender os
seguintes requisitos: cadastrar novos funcionários, alocar a um setor, calcular reajuste anual igual a
inflação, registrar demissão e listar funcionários demitidos ou contratados.
 */
public class GerenciaFuncionarios {
    private List<Funcionario> contratados = new ArrayList<>();
    private List<Setor> setores = new ArrayList<>();
    private List<Funcionario> demitidos = new ArrayList<>();
    private final Float IPCA_INFLACAO = 2.99f;

    public GerenciaFuncionarios() {
    }

    public List<Funcionario> getContratados() {
        return contratados;
    }

    public List<Funcionario> getDemitidos() {
        return demitidos;
    }

    public void setContratados(List<Funcionario> contratados) {
        this.contratados = contratados;
    }

    public void setDemitidos(List<Funcionario> demitidos) {
        this.demitidos = demitidos;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        this.contratados.add(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " adicionado.");
    }

    public void adicionarSetor(Setor setor){
        this.setores.add(setor);
        System.out.println("Setor " + setor.getSetor() + " adicionado.");
    }

    public void alocarFuncionarioSetor(Integer idSetor, Funcionario funcionario){
        this.getSetores().get(idSetor).adicionarFuncionarioNoSetor(funcionario);
    }

    public void demitirFuncionario(Funcionario funcionario){
        this.contratados.remove(funcionario);
        this.demitidos.add(funcionario);
        this.desalocarFuncionarioSetor(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " demitido.");
    }

    private void desalocarFuncionarioSetor(Funcionario funcionario){
        Funcionario funcionarioDemitido = new Funcionario();
        for (int i = 0; i < this.setores.size(); i++) {
            for (int j = 0; j < this.setores.get(i).getFuncionarios().size(); j++) {
                if(this.setores.get(i).getFuncionarios().get(j) == funcionario){
                    this.setores.get(i).removerFuncionarioNoSetor(funcionario);
                }
            }
        }
    }

    public void calcularAjusteAnualInflacao(){
        for (Funcionario funcionario : this.contratados){
            calculoInflacao(funcionario);
        }
        System.out.println("Reajuste realizado.");
    }

    private void calculoInflacao(Funcionario funcionario){
        Float adicional = funcionario.getSalario() * (this.IPCA_INFLACAO / 100);
        funcionario.setSalario(funcionario.getSalario() + adicional);
    }


    @Override
    public String toString() {
        List<String> nomesFuncionariosContratados = GenericUtils.pegarNomesFuncionarios(this.getContratados());

        List<String> nomesFuncionariosDemitidos = GenericUtils.pegarNomesFuncionarios(this.getDemitidos());

        String resultadoNomesFuncionariosContratados = GenericUtils.formatarListaString(nomesFuncionariosContratados) != "" ?
                GenericUtils.formatarListaString(nomesFuncionariosContratados) : "Não há funcionários contratados.";

        String resultadoNomesFuncionariosDemitidos = GenericUtils.formatarListaString(nomesFuncionariosDemitidos) != "" ?
                GenericUtils.formatarListaString(nomesFuncionariosDemitidos) : "Não há funcionários demitidos.";

        return "Nessa empresa há contratados: "
                +  resultadoNomesFuncionariosContratados
                + ". E demitidos: "
                + resultadoNomesFuncionariosDemitidos + ".";
    }

    public static void main(String[] args) {
        List<Setor> setores = new ArrayList<>();

        Setor setor = new Setor();
        setor.setSetor("Vendas");

        Setor setor2 = new Setor();
        setor2.setSetor("Marketing");

        Setor setor3 = new Setor();
        setor3.setSetor("Desenvolvimento");

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Joseph Smith");
        funcionario1.setDataContratacao(new Date());
        funcionario1.setSalario(4000f);
        funcionario1.setCPF("123.456.789-10");
        funcionario1.setId(1);
        funcionario1.setIdade(20);

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Lukas Walker");
        funcionario2.setDataContratacao(new Date(110, 1, 12));
        funcionario2.setSalario(3000f);
        funcionario2.setCPF("135.324.123-60");
        funcionario2.setId(2);
        funcionario2.setIdade(25);

        Funcionario funcionario3 = new Funcionario();
        funcionario3.setNome("Johnny Boy");
        funcionario3.setDataContratacao(new Date(100, 5, 25));
        funcionario3.setSalario(6000f);
        funcionario3.setCPF("167.175.987-50");
        funcionario3.setId(3);
        funcionario3.setIdade(40);

        GerenciaFuncionarios gerenciaFuncionarios = new GerenciaFuncionarios();
        gerenciaFuncionarios.adicionarSetor(setor);
        gerenciaFuncionarios.adicionarSetor(setor2);
        gerenciaFuncionarios.adicionarSetor(setor3);

        System.out.println("Exemplo para adicionar funcionários: \n");
        gerenciaFuncionarios.adicionarFuncionario(funcionario1);
        gerenciaFuncionarios.adicionarFuncionario(funcionario2);
        gerenciaFuncionarios.adicionarFuncionario(funcionario3);

        System.out.println(gerenciaFuncionarios);

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo para alocar um funcionário a um setor: \n");
        gerenciaFuncionarios.alocarFuncionarioSetor(2, funcionario1);
        System.out.println(gerenciaFuncionarios.getSetores());

        System.out.println("\n-----------------------\n");


        System.out.println("Exemplo para demitir um funcionário:  \n");

        gerenciaFuncionarios.demitirFuncionario(funcionario1);
        System.out.println(gerenciaFuncionarios.getSetores());

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo para calcular reajuste salarial baseado na inflação: \n");
        System.out.println("Salário antes do reajuste: \n");
        System.out.println(gerenciaFuncionarios.getContratados());
        gerenciaFuncionarios.calcularAjusteAnualInflacao();
        System.out.println("\nSalário após o reajuste: \n");
        System.out.println(gerenciaFuncionarios.getContratados());

        System.out.println("\n-----------------------\n");

        System.out.println("Listagem de contratados: \n");
        System.out.println(gerenciaFuncionarios.getContratados());

        System.out.println("\n-----------------------\n");

        System.out.println("Listagem de demitidos: \n");
        System.out.println(gerenciaFuncionarios.getDemitidos());


        System.out.println("\n-----------------------\n");


        System.out.println("Listagem geral: \n");
        System.out.println(gerenciaFuncionarios);

    }

}
