import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Escreva uma classe para representar um livro, título, ISBN, autores, data de lançamento, se está emprestado e
   estado (bom ou ruim).
*/

public class Livro {

    private String titulo, ISBN;
    private Boolean emprestado;
    private EstadoLivro estado;
    private Date dataLancamento;
    private List<String> autores;

    public Livro(String titulo, String ISBN, Boolean emprestado, EstadoLivro estado, Date dataLancamento, List<String> autores) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.emprestado = emprestado;
        this.estado = estado;
        this.dataLancamento = dataLancamento;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Boolean emprestado) {
        this.emprestado = emprestado;
    }

    public EstadoLivro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return
                "Título: " + titulo + "\n" +
                "ISBN: " + ISBN + "\n" +
                "Emprestado: " + GenericUtils.formatarBoolean(emprestado) + "\n" +
                "Estado: " + estado.getDescricao() + "\n" +
                "Data de Lançamento: " + GenericUtils.formatarData(dataLancamento) + "\n" +
                "Autores: " + GenericUtils.formatarListaString(autores);
    }

    public static void main(String[] args) {

        //Exemplo de criação de um livro
        List<String> autores = new ArrayList<>();
        autores.add("John Smith");
        autores.add("Luke Joe");

        Livro livro = new Livro("A luta", "123456", true, EstadoLivro.BOM, new Date(), autores);
        System.out.println(livro);
    }
}
