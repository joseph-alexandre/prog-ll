import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManipuladorLivro {

    private DAO dao;
    private String nomeBanco = "livros";

    public ManipuladorLivro(Boolean reiniciarBanco) {
        this.dao = new DAO(this.nomeBanco, reiniciarBanco);
    }

    public ManipuladorLivro() {
        this.dao = new DAO(this.nomeBanco);
    }

    public Livro lerLivro(){
        Livro livro;
        List<String> texto = this.dao.lerDados(this.nomeBanco);
        String linha = texto.get(0);
        String[] dados = linha.split(";");

        livro = new Livro(dados[0], dados[1], Boolean.parseBoolean(dados[2]), EstadoLivro.valueOf(dados[3]),
                GenericUtils.formatarStringParaData(dados[4]), Arrays.asList(dados[5]));
        return livro;
    }

    public void inserirLivros(List<Livro> livros){
        this.dao.inserirRegistros(livros);
    }

    public void inserirLivro(Livro livro){
        this.dao.inserirRegistro(livro);
    }

    public List<Livro> lerLivros(){
        List<Livro> livros = new ArrayList<>();
        List<String> texto = this.dao.lerDados(this.nomeBanco);

        for (String registro : texto) {
            String[] dados = registro.split(";");
            Livro livro = new Livro(dados[0], dados[1], Boolean.parseBoolean(dados[2]), EstadoLivro.valueOf(dados[3]),
                    GenericUtils.formatarStringParaData(dados[4]), Arrays.asList(dados[5]));
            livros.add(livro);
        }
        return livros;
    }
}
