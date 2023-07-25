import java.util.*;

public class SistemaFilmesMap implements SistemaFilmes {

    private Map<String, Filme> filmes;

    public SistemaFilmesMap() {
        this.filmes = new HashMap<String, Filme>();
    }

    @Override
    public void cadastraFilme(Filme f) throws FilmeJaExisteException {
        if (this.filmes.containsKey(f.getCodigo())) {
            throw new FilmeJaExisteException("Já existe filme com este código");
        } else {
            this.filmes.put(f.getCodigo(), f);

        }

    } // Já veio junto da prova;

    @Override
    public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException {
        Filme filme = this.filmes.get(codigo);
        if (filme == null) {
            throw new FilmeNaoExisteException("Esse filme não existe " + codigo);
        } else {
            return filme;

        }

    }


    public List<Filme> pesquisaFilme(CategoriaFilme categoria) throws FilmeNaoExisteException {
        List<Filme> listaF = new ArrayList<>();
        for (Filme f: this.filmes.values()) {
            if (f.ehDaCategoria(categoria)) {
                listaF.add(f);

            }

        }
        return listaF;

    } // Cod Prova 2;

    @Override
    public List<Filme> obterFilmesLancadosEm(int ano) {
        List<Filme> filmesF = new LinkedList<>();
        for (Filme f: this.filmes.values()) {
            if (f.getAnoLancamento() == ano) {
                filmesF.add(f);

            }

        }
        return filmesF;

    }

    @Override
    public List<Filme> obterFilmesComNome(String nome) {
        List<Filme> filmes = new ArrayList<>();
        for (Filme f: this.filmes.values()) {
            if (f.getNome().equals(nome)) {
                return filmes;

            }

        }
        return null;

    }

    @Override
    public boolean existemFilmesDaCategoria(CategoriaFilme categoria) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int contaFilmesDaCategoria(CategoriaFilme categoria) {
        int contEhDaCategoria = 0;
        for (Filme f : this.filmes.values()) {
            if (f.ehDaCategoria(categoria)) {
                contEhDaCategoria++;

            }

        }
        return contEhDaCategoria;

    } // Rafaela;
    /**
     *
     * @param codigoFilme
     * @param nomeAtor
     * @throws FilmeNaoExisteException

    public void incluiAtorEmElencoDeFilme(String codigoFilme, String nomeAtor) throws  FilmeNaoExisteException {
        Filme f = this.filmes.get(codigoFilme);
        if (f == null) {
            throw new FilmeNaoExisteException("Não existe filme com o código " + codigoFilme);

        }else {
            f.incluiAtorNoElenco(nomeAtor);

        } // Cod Prova 2;

    }
    */

}
