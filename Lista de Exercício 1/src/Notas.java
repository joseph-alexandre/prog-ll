
/*
* Crie um programa para você armazenar as notas da disciplina, lembrando que ela se base-a em 30% da nota entrega
* de trabalhos e 70% em duas apresentações de portfólio.
* */

public class Notas {
    private Float notaTrabalho, portfolio1, portifolio2;

    public Notas(){
    }

    public Float getNotaTrabalho() {
        return notaTrabalho;
    }

    public void setNotaTrabalho(Float notaTrabalho) {
        this.notaTrabalho = notaTrabalho;
    }

    public Float getPortfolio1() {
        return portfolio1;
    }

    public void setPortfolio1(Float portfolio1) {
        this.portfolio1 = portfolio1;
    }

    public Float getPortifolio2() {
        return portifolio2;
    }

    public void setPortifolio2(Float portifolio2) {
        this.portifolio2 = portifolio2;
    }

    public float calculaNotas(){
        return this.notaTrabalho * 0.3f + this.portfolio1 * 0.35f + this.portifolio2 * 0.35f;
    }

    public String toString(){
        return notaTrabalho + " " + portfolio1 + " " + portifolio2 +
            "\n Media: " + calculaNotas();
    }

    public static void main(String[] args) {
        System.out.println("Exemplo de cálculo de notas: \n");
        Notas notas = new Notas();
        notas.setNotaTrabalho(10f);
        notas.setPortfolio1(5f);
        notas.setPortifolio2(10f);
        System.out.println(notas.calculaNotas());
    }

}
