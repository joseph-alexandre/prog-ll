// Enumerador de auxílio para a criação do Livro

public enum EstadoLivro {

    BOM("Bom"),
    RUIM("Ruim");

    private String descricao;

    EstadoLivro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
