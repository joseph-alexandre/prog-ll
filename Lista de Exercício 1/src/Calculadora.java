
import java.util.ArrayList;
import java.util.List;

/*
* Desenvolva um programa para uma calculadora com as funções de somar N números, subtrair dois números, multiplicas N números
* e dividir.
* */
public class Calculadora {

    public List<Float> valoresN = new ArrayList<>();
    public Float a, b;

    public Calculadora(){
    }

    public Float somar(){
        Float soma = 0f;
        for(Float valor : valoresN){
            soma += valor;
        }
        return soma;
    }

    public float subtrair(){
        return a - b;
    }

    public Float multiplicar(){
        Float resultado = 1f;
        for (int i = 0; i < valoresN.size(); i++) {
            resultado *= valoresN.get(i);
        }
        return resultado;
    }

    public float dividir(){
        return a / b;
    }


    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        // Teste de soma de N números

        calculadora.valoresN.add(1.1f);
        calculadora.valoresN.add(3f);
        calculadora.valoresN.add(5f);

        System.out.println("Soma: " + calculadora.somar());
        calculadora.valoresN.clear();
        // Teste de subtração de 2 números

        calculadora.a = 3f;
        calculadora.b = 1f;

        System.out.println("Subtração: " + calculadora.subtrair());

        // Teste de Multiplicação


        calculadora.valoresN.add(3f);
        calculadora.valoresN.add(5f);
        calculadora.valoresN.add(10f);
        System.out.println("Multiplicação: " + calculadora.multiplicar());

        // Teste de divisão

        calculadora.a = 3f;
        calculadora.b = 5f;

        System.out.println("Divisão: " + calculadora.dividir());

    }

}
