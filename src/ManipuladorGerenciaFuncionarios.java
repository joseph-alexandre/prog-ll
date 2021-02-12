import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManipuladorGerenciaFuncionarios {

    private DAO dao;
    private String databaseDemitidos = "Funcionários demitidos";
    private String databaseContratados = "Funcionários contratados";
    private ManipuladorFuncionario manipuladorFuncionario = new ManipuladorFuncionario();

    public void setDaoContratados(Boolean recriarDatabase){
        if(recriarDatabase){
            this.dao = new DAO(this.databaseContratados, true);
        }
        this.dao = new DAO(this.databaseContratados);
    }

    public void setDaoContratados(){
        this.dao = new DAO(this.databaseContratados);
    }

    public void setDaoDemitidos(Boolean recriarDatabase) {
        if (recriarDatabase) {
            this.dao = new DAO(this.databaseDemitidos, true);
        }
        this.dao = new DAO(this.databaseDemitidos);
    }


    public void setDaoDemitidos() {
        this.dao = new DAO(this.databaseDemitidos);
    }


    public Boolean inserirDemitido(Funcionario funcionario){
        if(!this.dao.validaBanco(this.databaseDemitidos)) {
            return false;
        }
        this.manipuladorFuncionario.inserirFuncionario(funcionario);
        return true;
    }

    public Boolean inserirDemitidos(List<Funcionario> funcionarios){
        if(!this.dao.validaBanco(this.databaseDemitidos)) {
            return false;
        }
        this.manipuladorFuncionario.inserirFuncionarios(funcionarios);
        return true;
    }

    public Boolean inserirContratado(Funcionario funcionario){
        if(!this.dao.validaBanco(this.databaseContratados)) {
            return false;
        }
        this.manipuladorFuncionario.inserirFuncionario(funcionario);
        return true;
    }


    public Boolean inserirContratados(List<Funcionario> funcionarios){
        if(!this.dao.validaBanco(this.databaseContratados)) {
            return false;
        }
        this.manipuladorFuncionario.inserirFuncionarios(funcionarios);
        return true;
    }

    public List<Funcionario> lerContratados(){
        return this.manipuladorFuncionario.lerFuncionarios(this.databaseContratados);
    }

    public List<Funcionario> lerDemitidos(){
        return this.manipuladorFuncionario.lerFuncionarios(this.databaseDemitidos);
    }

    /*
    * Os outros métodos foram omitidos, pois foi decidido ser implementado somente a funcionalidade de inserir contratados
    * e demitidos no banco.
    * */
    public static void main(String[] args) {
    ManipuladorGerenciaFuncionarios manipuladorGerenciaFuncionarios = new ManipuladorGerenciaFuncionarios();
        List<Funcionario> funcionariosContratados = new ArrayList<>();
        List<Funcionario> funcionariosDemitidos = new ArrayList<>();


        Funcionario funcionarioContatado1 = new Funcionario();
        funcionarioContatado1.setNome("Funcionário contratado 1");
        funcionarioContatado1.setSalario(23323f);
        funcionarioContatado1.setCPF("322322332");
        funcionarioContatado1.setIdade(23);
        funcionarioContatado1.setDataContratacao(new Date());
        funcionarioContatado1.setId(1);

        Funcionario funcionarioContatado2 = new Funcionario();
        funcionarioContatado2.setNome("Funcionário contratado 2");
        funcionarioContatado2.setSalario(434344334f);
        funcionarioContatado2.setCPF("1111111");
        funcionarioContatado2.setIdade(18);
        funcionarioContatado2.setDataContratacao(new Date());
        funcionarioContatado2.setId(2);


        funcionariosContratados.add(funcionarioContatado1);
        funcionariosContratados.add(funcionarioContatado2);

        manipuladorGerenciaFuncionarios.setDaoContratados();

        manipuladorGerenciaFuncionarios.inserirContratados(funcionariosContratados);

        for (Funcionario funcionario : manipuladorGerenciaFuncionarios.lerContratados()) {
            System.out.println(funcionario);
        }

        System.out.println("\n-----------------------------------------\n");

        manipuladorGerenciaFuncionarios.setDaoDemitidos();

        Funcionario funcionarioDemitido1 = new Funcionario();
        funcionarioDemitido1.setNome("Funcionário demitido 1");
        funcionarioDemitido1.setSalario(23323f);
        funcionarioDemitido1.setCPF("322322332");
        funcionarioDemitido1.setIdade(23);
        funcionarioDemitido1.setDataContratacao(new Date());
        funcionarioDemitido1.setId(1);

        Funcionario funcionarioDemitido2 = new Funcionario();
        funcionarioDemitido2.setNome("Funcionário demitido 2");
        funcionarioDemitido2.setSalario(434344334f);
        funcionarioDemitido2.setCPF("1111111");
        funcionarioDemitido2.setIdade(18);
        funcionarioDemitido2.setDataContratacao(new Date());
        funcionarioDemitido2.setId(2);

        funcionariosDemitidos.add(funcionarioDemitido1);
        funcionariosDemitidos.add(funcionarioDemitido2);

        manipuladorGerenciaFuncionarios.inserirDemitidos(funcionariosDemitidos);

        for (Funcionario funcionario : manipuladorGerenciaFuncionarios.lerDemitidos()) {
            System.out.println(funcionario);
        }


    }
}
