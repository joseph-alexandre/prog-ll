//Utilizando o ponto, crie uma classe para representar um círculo, ela deve calcular a área do círculo

public class Circulo {

    private Ponto ponto;
    private Double area;

    public Circulo() {
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public Double getArea() {
        return area;
    }

    public Double calcularAreaCirculo(){
        this.area = Math.PI * Math.pow(getPonto().getPonto(), 2);
        return this.area;
    }

    public static void main(String[] args) {
        Ponto ponto = new Ponto(5);
        Circulo circulo = new Circulo();
        circulo.setPonto(ponto);


        System.out.println(circulo.calcularAreaCirculo());
    }
}
