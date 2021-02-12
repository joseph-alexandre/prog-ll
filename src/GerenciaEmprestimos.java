/*
Crie um programa para gerenciar empréstimos de livros, ele deveŕa suportar o cadastro de livro, remooç̃ao de livro,
busca por autor ou qualquer outro atributo e atualizac̃oes do estado(bom ou ruim) e situac̃ao (emprestado ou não)
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciaEmprestimos {
    private List<Livro> livros = new ArrayList<>();

    public GerenciaEmprestimos() {
    }

    public GerenciaEmprestimos(List<Livro> livros) {
        this.livros = livros;
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
        return GenericUtils.formatarListaString(this.pegarTitulosDisponiveis());
    }

    public static void main(String[] args) {
        GerenciaEmprestimos gerenciaEmprestimos = new GerenciaEmprestimos();
        ManipuladorLivro manipuladorLivro = new ManipuladorLivro();

        Livro livro = new Livro();
        livro.setTitulo("Livro1");
        livro.setISBN("123");
        livro.setEmprestado(true);
        livro.setEstado(EstadoLivro.BOM);
        livro.setDataLancamento(new Date());
        livro.setAutores(Arrays.asList("Autor 1", "Autor 2"));

        Livro livro2 = new Livro();
        livro2.setTitulo("Livro1");
        livro2.setISBN("123");
        livro2.setEmprestado(true);
        livro2.setEstado(EstadoLivro.BOM);
        livro2.setDataLancamento(new Date());
        livro2.setAutores(Arrays.asList("Autor 3", "Autor 4"));

        List<Livro> livros = new ArrayList<>();
        livros.add(livro);
        livros.add(livro2);

        gerenciaEmprestimos.definirEstado(livro2, EstadoLivro.RUIM);

        gerenciaEmprestimos.definirSituacao(livro, false);

        gerenciaEmprestimos.setLivros(livros);

        manipuladorLivro.inserirLivros(gerenciaEmprestimos.getLivros());

        livros = manipuladorLivro.lerLivros();

        for (Livro registro : livros) {
            System.out.println(registro);
        }

    }
}
