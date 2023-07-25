import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaFilmesMapTest {

    private SistemaFilmesMap sistema;

    @BeforeEach
    void setup() {
        sistema = new SistemaFilmesMap();

    }

    @Test
    void testaCadastroEPesquisa() {
        List<CategoriaFilme> categorias = new ArrayList<>();
        categorias.add(CategoriaFilme.ACAO);

        try {
            sistema.cadastraFilme(new Filme("001","Matrix",1999,136, categorias));
            Filme f = sistema.pesquisaFilme("001");
            assertEquals("Matrix", f.getNome());
            //sistema.incluiAtorEmElencoDeFilme("001", "Keanu Reeves");

        } catch (FilmeJaExisteException | FilmeNaoExisteException e) {
            fail("Não deveria lançar exceção ao cadastrar e pesquisar depois");

        }

    }

    @Test
    void testeQuestao5() {
        List<CategoriaFilme> categorias = new ArrayList<>();
        categorias.add(CategoriaFilme.ROMANCE);

        try {
            sistema.cadastraFilme(new Filme("002", "Orgulho e Preconceito", 2000, 200, categorias));
            Filme f = sistema.pesquisaFilme("002");
            assertEquals(1, sistema.contaFilmesDaCategoria(CategoriaFilme.ROMANCE));
            assertEquals(0, sistema.contaFilmesDaCategoria(CategoriaFilme.TERROR));

        } catch (FilmeJaExisteException | FilmeNaoExisteException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testeParaAQ2DePesquisa() {
        List<CategoriaFilme> categorias = new ArrayList<>();
        categorias.add(CategoriaFilme.ROMANCE);
        try {
            Filme f = new Filme("002", "Orgulho e Preconceito", 2000, 200, categorias);
            sistema.cadastraFilme(f);
            assertEquals(f, sistema.pesquisaFilme("002"));
            sistema.pesquisaFilme("004");

            fail("O sistema deveria lançar exceção.");

        } catch (FilmeJaExisteException | FilmeNaoExisteException e) {
            System.out.println(e.getMessage());

        }


    }

}

