/*
Crie um programa para gerenciar empréstimos de livros, ele deveŕa suportar o cadastro de livro, remooç̃ao de livro,
busca por autor ou qualquer outro atributo e atualizac̃oes do estado(bom ou ruim) e situac̃ao (emprestado ou não)
*/


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciaEmprestimos {
    private List<Livro> livros = new ArrayList<>();

    public GerenciaEmprestimos() {
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
        System.out.println("Livro " + livro.getTitulo() + " adicionado.");
    }

    public void removerLivro(Livro livro){
        this.livros.remove(livro);
        System.out.println("Livro " + livro.getTitulo() + " removido.");
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for(Livro livro : this.livros){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivroPorIsbn(String isbn) {
        List<Livro> livros = new ArrayList<>();
        livros = this.livros.stream().filter(livro -> livro.getISBN().equalsIgnoreCase(isbn)).collect(Collectors.toList());
        return livros;
    }

    public List<Livro> buscarLivroPorAutor(String nomeAutor) {
        List<Livro> livros = new ArrayList<>();

        for (int i = 0; i < this.livros.size(); i++) {
            for (int j = 0; j < this.livros.get(i).getAutores().size(); j++) {
                if(this.livros.get(i).getAutores().get(j).equalsIgnoreCase(nomeAutor)){
                    livros.add(this.livros.get(i));
                }
            }
        }
        return livros;
    }

    public Livro buscarLivroPelaData(Date data){
        for(Livro livro : this.livros){
            if(livro.getDataLancamento().equals(data)){
                return livro;
            }
        }
        return null;
    }

    public List<Livro> buscarLivroPeloEstado(EstadoLivro estado){
        List<Livro> livros = new ArrayList<>();
        for(Livro livro : this.livros){
            if(livro.getEstado().equals(estado)){
                livros.add(livro);
            }
        }
        return livros;
    }

    public List<Livro> buscarLivroPelaSituacao(Boolean situacao){
        List<Livro> livros = new ArrayList<>();
        for(Livro livro : this.livros){
            if(livro.isEmprestado() == situacao){
                livros.add(livro);
            }
        }
        return livros;
    }

    public void definirEstado(Livro livro, EstadoLivro estado){
        livro.setEstado(estado);
    }

    public void definirSituacao(Livro livro, Boolean isEmprestado){
        livro.setEmprestado(isEmprestado);
    }

    private List<String> pegarTitulosDisponiveis(){
        List<String> titulos = new ArrayList<>();
        for (Livro livro : this.livros){
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }

    @Override
    public String toString() {
        return "Livros disponíveis: " + GenericUtils.formatarListaString(this.pegarTitulosDisponiveis()) + ".";
    }

    public static void main(String[] args) {
        GerenciaEmprestimos gerenciaEmprestimos = new GerenciaEmprestimos();

        List<String> autoresLivro1 = new ArrayList<>();
        List<String> autoresLivro2 = new ArrayList<>();
        List<String> autoresLivro3 = new ArrayList<>();

        autoresLivro1.add("John Doe");
        autoresLivro2.add("Johnny Walker");
        autoresLivro3.add("Joseph Smith");

        Livro livro1 = new Livro("A lenda", "1234", false, EstadoLivro.BOM, new Date(), autoresLivro1);
        Livro livro2 = new Livro("A luta", "5678", true, EstadoLivro.BOM, new Date(120, 11, 02), autoresLivro2);
        Livro livro3 = new Livro("A onda", "91011", true, EstadoLivro.RUIM, new Date(110, 03, 02), autoresLivro3);

        System.out.println("Exemplo de adicionar um livro: \n");
        gerenciaEmprestimos.adicionarLivro(livro1);
        gerenciaEmprestimos.adicionarLivro(livro2);
        gerenciaEmprestimos.adicionarLivro(livro3);

        System.out.println(gerenciaEmprestimos);

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo da remoção de um livro: \n");

        gerenciaEmprestimos.removerLivro(livro1);
        System.out.println(gerenciaEmprestimos);


        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar um livro pelo autor: \n");
        System.out.println(gerenciaEmprestimos.buscarLivroPorAutor("Johnny Walker"));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar um livro pelo ISBN: \n");
        System.out.println(gerenciaEmprestimos.buscarLivroPorIsbn("5678"));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar um livro pela data: \n");

        System.out.println(gerenciaEmprestimos.buscarLivroPelaData(new Date(110, 03, 02)));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar um livro pelo título: \n");
        System.out.println(gerenciaEmprestimos.buscarLivroPorTitulo("A onda"));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar livros pelo estado: \n");
        System.out.println(gerenciaEmprestimos.buscarLivroPeloEstado(EstadoLivro.RUIM));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de buscar livros pela situação: \n");
        System.out.println(gerenciaEmprestimos.buscarLivroPelaSituacao(true));

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de como definir o estado de um livro: \n");
        gerenciaEmprestimos.definirEstado(livro2, EstadoLivro.RUIM);
        System.out.println(livro2);

        System.out.println("\n-----------------------\n");

        System.out.println("Exemplo de como definir a situação de um livro: \n");
        gerenciaEmprestimos.definirSituacao(livro3, false);
        System.out.println(livro3);

        System.out.println("\n-----------------------\n");

        System.out.println(gerenciaEmprestimos);

    }
}
