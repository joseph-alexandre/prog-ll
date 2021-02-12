import java.util.ArrayList;
import java.util.List;

public class Setor {
    private String setor;
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Setor(String setor, List<Funcionario> funcionarios) {
        this.setor = setor;
        this.funcionarios = funcionarios;
    }

    public Setor() {
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void adicionarFuncionarioNoSetor(Funcionario funcionario){
        this.funcionarios.add(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " adicionado no setor de " + this.setor + ".");
    }

    public void removerFuncionarioNoSetor(Funcionario funcionario){
        this.funcionarios.remove(funcionario);
        System.out.println("Funcionário " + funcionario.getNome() + " removido no setor de " + this.setor + ".");
    }

    @Override
    public String toString() {
        List<String> nomesFuncionarios = GenericUtils.pegarNomesFuncionarios(this.getFuncionarios());
        String resultadoNomeFuncionario = GenericUtils.formatarListaString(nomesFuncionarios) != "" ?
                GenericUtils.formatarListaString(nomesFuncionarios) : "Não há funcionários neste setor";
        return "Setor: " + setor + "." + " Funcionarios: "+ resultadoNomeFuncionario;
    }
}
