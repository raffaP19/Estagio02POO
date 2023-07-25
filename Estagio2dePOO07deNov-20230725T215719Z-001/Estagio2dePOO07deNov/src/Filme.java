import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme {

    private String codigo;
    private String nome;
    private int anoLancamento;
    private int duracaoEmMinutos;
    private List<CategoriaFilme> categorias;

    public Filme() {
        this("", "", 0, 0, new ArrayList<>());

    }

    public Filme(String codigo, String nome, int anoLancamento, int duracaoEmMinutos,
            List<CategoriaFilme> categorias) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.categorias = categorias;

    }

    public boolean ehDaCategoria(CategoriaFilme categoria) {
        for (CategoriaFilme cat : this.categorias) {
            if (cat == categoria) {
                return true;

            }

        }
        return false;

    }

    public String getCodigo() {
        return this.codigo;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;

    }

    public String getNome() {
        return this.nome;

    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public int getAnoLancamento() {
        return this.anoLancamento;

    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;

    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;

    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return codigo.equals(filme.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}