import java.util.List;

public interface SistemaFilmes {

    void cadastraFilme(Filme f) throws FilmeJaExisteException;

    Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException;

    List<Filme> obterFilmesLancadosEm(int ano);

    List<Filme> obterFilmesComNome(String nome);

    boolean existemFilmesDaCategoria(CategoriaFilme categoria);

    int contaFilmesDaCategoria(CategoriaFilme categoria);

}
