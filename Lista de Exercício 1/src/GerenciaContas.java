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
        GerenciaContas gerenciaContas = new GerenciaContas();
        System.out.println("Exemplo de criação de uma conta: \n");
        Conta conta = gerenciaContas.criarConta("Teste");
        System.out.println(conta);

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de impressão de saldo da conta: \n");
        gerenciaContas.imprimirSaldo(conta);

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de depósito: \n");
        System.out.println("Saldo antes do depósito: " + conta.getSaldo());
        gerenciaContas.depositar(conta, 1000f);
        System.out.println("Saldo após o depósito: " + conta.getSaldo());


        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de saque: \n");
        System.out.println("Saldo antes do saque: " + conta.getSaldo());
        gerenciaContas.sacar(conta, 500f);
        System.out.println("Saldo após o saque: " + conta.getSaldo());

    }

}
