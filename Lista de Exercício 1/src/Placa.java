//Classe auxiliar para o exercício de Carro

public class Placa {

    private Character[] digitosLetras = new Character[3];
    private Integer[] digitosNumeros = new Integer[3];

    public Placa() {
    }

    public Character[] getDigitosLetras() {
        return digitosLetras;
    }

    public void setDigitosLetras(Character... digitosLetras) throws Exception {
        if(digitosLetras.length > 3){
            throw new Exception("Só pode haver três letras.");
        } else {
            this.digitosLetras = digitosLetras;
        }
    }

    public Integer[] getDigitosNumeros() {
        return digitosNumeros;
    }

    public void setDigitosNumeros(Integer... digitosNumeros) throws Exception {
        if(digitosNumeros.length > 3){
            throw new Exception("Só pode haver três números.");
        } else {
            this.digitosNumeros = digitosNumeros;
        }
    }

    private String formatarPlaca(){
        String resultado = "";
        String resultadoLetra = "";
        String resultadoNumero = "";
        for (Character letra : this.digitosLetras){
            resultadoLetra += letra;
        }

        for (Integer numero : this.digitosNumeros){
            resultadoNumero += numero;
        }
        resultado = resultadoLetra + "-" + resultadoNumero;
        return resultado;
    }

    @Override
    public String toString() {
        return formatarPlaca();
    }

    public static void main(String[] args) throws Exception {
        Placa placa = new Placa();
        placa.setDigitosLetras('A', 'B', 'C');
        placa.setDigitosNumeros(1,3,4);

        System.out.println(placa);
    }
}
