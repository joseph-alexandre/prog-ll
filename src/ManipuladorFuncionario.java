import java.util.ArrayList;
import java.util.List;

public class ManipuladorFuncionario {

    private DAO dao;
    public ManipuladorFuncionario(Boolean reiniciarBanco) {
        this.dao = new DAO("funcionarios", reiniciarBanco);
    }

    public ManipuladorFuncionario() {
        this.dao = new DAO("funcionarios");
    }

    public Funcionario lerFuncionario(String caminho){
        Funcionario funcionario;
        List<String> texto = this.dao.lerDados(caminho);
        String linha = texto.get(0);
        String[] dados = linha.split(";");

        funcionario = new Funcionario(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]),
                Float.parseFloat(dados[4]), GenericUtils.formatarStringParaData(dados[5]));
        return funcionario;
    }

    public void inserirFuncionarios(List<Funcionario> funcionarios){
        this.dao.inserirRegistros(funcionarios);
    }

    public void inserirFuncionario(Funcionario funcionario){
        this.dao.inserirRegistro(funcionario);
    }

    public List<Funcionario> lerFuncionarios(String caminho){
        List<Funcionario> funcionarios = new ArrayList<>();
        List<String> texto = this.dao.lerDados(caminho);

        for (String registro : texto) {
            String[] dados = registro.split(";");
            Funcionario funcionario = new Funcionario(dados[0], dados[1], Integer.parseInt(dados[2]), Integer.parseInt(dados[3]),
                    Float.parseFloat(dados[4]), GenericUtils.formatarStringParaData(dados[5]));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }
}
