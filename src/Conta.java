public class Conta {

    private String nomeTitular, numeroConta;
    private Float saldo = 0f;

    public Conta() {
    }

    public Conta(String nomeTitular, String numeroConta, Float saldo) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
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
        return
                 this.nomeTitular + ";" +
                 this.numeroConta  + ";" +
                 this.saldo;
    }
}
