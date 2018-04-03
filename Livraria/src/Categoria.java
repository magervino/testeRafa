import java.util.ArrayList;
import java.util.Collection;


public class Categoria {
	private long id;
	private int codigo;
	private String descricao;
	private Collection<Livro> livros = new ArrayList<Livro>();
	
	public Categoria(){}
	public Categoria(long $id, int $codigo, String $descricao, Collection<Livro> $livros){
		this.id = $id;
		this.codigo = $codigo;
		this.descricao = $descricao;
		this.livros = $livros;
	}
	
	public Collection<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Collection<Livro> livros) {
		this.livros = livros;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
