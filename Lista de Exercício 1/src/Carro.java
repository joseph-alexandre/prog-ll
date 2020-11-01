//Desenvolva uma classe para representar um carro com placa 
//(tendo trˆes letras e quatro nu ́meros), cor, modelo, se  ́e 
//convers ́ıvel ou n ̃ao, se  ́e novo e est ́a se movendo. Implemente os m ́etodos para atualizar as varia ́veis.
public class Carro {
    private String cor, modelo;
    private Placa placa;
    private boolean conversivel, novo, emMovimento;

    public Carro(String cor, String modelo, Placa placa, boolean conversivel, boolean novo, boolean emMovimento) {
        this.cor = cor;
        this.modelo = modelo;
        this.placa = placa;
        this.conversivel = conversivel;
        this.novo = novo;
        this.emMovimento = emMovimento;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public boolean isConversivel() {
        return conversivel;
    }

    public void setConversivel(boolean conversivel) {
        this.conversivel = conversivel;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public boolean isEmMovimento() {
        return emMovimento;
    }

    public void setEmMovimento(boolean emMovimento) {
        this.emMovimento = emMovimento;
    }

    public String toString(){
        return "Placa: " + placa + "\nCor: " + cor + "\nModelo: " + modelo + "\nConversível: " + GenericUtils.formatarBoolean(conversivel)
                + "\nÉ novo? " + GenericUtils.formatarBoolean(novo) + "\nEstá em movimento? " + GenericUtils.formatarBoolean(emMovimento);
    }

    public static void main(String[] args) throws Exception {

        // Exemplo de criação da placa
        Placa placa = new Placa();
        placa.setDigitosLetras('A', 'B', 'C');
        placa.setDigitosNumeros(1,2,3);

        // Exemplo de criação do Carro
        Carro carro = new Carro("Vermelho", "Fusca", placa, false, true, true);
        System.out.println(carro);

        // Exemplo de alteração da variável EmMovimento
        carro.setEmMovimento(false);
        System.out.println(carro);
    }
}
