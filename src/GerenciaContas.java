import java.util.ArrayList;
import java.util.List;

public class GerenciaContas {

    private List<Conta> contas = new ArrayList<>();

    public GerenciaContas() {
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Conta criarConta(String titular){
        Conta conta = new Conta();
        conta.setNumeroConta(this.gerarNumeroContaAleatorio());
        conta.setNomeTitular(titular);
        this.contas.add(conta);

        return conta;
    }

    public void depositar(Conta conta, Float valor){
        conta.setSaldo(valor, true);
        System.out.println("Foi realizado um depósito de R$" + valor + " na conta do titular " + conta.getNomeTitular());
    }

    public void sacar(Conta conta, Float valor){
        conta.setSaldo(valor, false);
        System.out.println("Foi realizado um saque de R$" + valor + " na conta do titular " + conta.getNomeTitular());
    }
    public void imprimirSaldo(Conta conta){
        System.out.println(conta.getSaldo());
    }

    private String gerarNumeroContaAleatorio(){
        String numeroConta = GenericUtils.gerarDigitoAleatorio()
                + GenericUtils.gerarDigitoAleatorio()
                + GenericUtils.gerarDigitoAleatorio()
                + GenericUtils.gerarDigitoAleatorio() + "-" + GenericUtils.gerarDigitoAleatorio();
        return numeroConta;
    }



    public static void main(String[] args) {
        Conta conta = new GerenciaContas().criarConta("João Lucas");
        ManipuladorConta manipuladorConta = new ManipuladorConta();

        conta.setSaldo(3232f, true);

        manipuladorConta.inserirConta(conta);

        Conta contaSalva = manipuladorConta.lerConta();

        System.out.println(contaSalva);


    }

}
