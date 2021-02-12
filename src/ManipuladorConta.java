import java.util.ArrayList;
import java.util.List;

public class ManipuladorConta {

    private DAO dao;
    private String nomeBanco = "contas";

    public ManipuladorConta(Boolean reiniciarBanco) {
        this.dao = new DAO(this.nomeBanco, reiniciarBanco);
    }

    public ManipuladorConta() {
        this.dao = new DAO(this.nomeBanco);
    }

    public Conta lerConta(){
        Conta conta;
        List<String> texto = this.dao.lerDados(this.nomeBanco);
        String linha = texto.get(0);
        String[] dados = linha.split(";");

        conta = new Conta(dados[0], dados[1], Float.parseFloat(dados[2]));
        return conta;
    }

    public void inserirContas(List<Conta> contas){
        this.dao.inserirRegistros(contas);
    }

    public void inserirConta(Conta conta){
        this.dao.inserirRegistro(conta);
    }

    public List<Conta> lerContas(){
        List<Conta> contas = new ArrayList<>();
        List<String> texto = this.dao.lerDados(this.nomeBanco);

        for (String registro : texto) {
            String[] dados = registro.split(";");
            Conta conta = new Conta(dados[0], dados[1], Float.parseFloat(dados[2]));
            contas.add(conta);
        }
        return contas;
    }
}
