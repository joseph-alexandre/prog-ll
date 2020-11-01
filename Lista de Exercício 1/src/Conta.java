public class Conta {

    private String nomeTitular, numeroConta;
    private Float saldo = 0f;

    public Conta() {
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo, Boolean isDeposito) {
        if(isDeposito){
            this.saldo += saldo;
        } else {
            this.saldo -= saldo;
        }
    }

    @Override
    public String toString() {
        return "Conta: \n" +
                "Nome do Titular: " + nomeTitular +
                "\nNúmero da conta: " + numeroConta  +
                "\nSaldo: " + saldo;
    }
}
