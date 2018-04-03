import java.util.ArrayList;
import java.util.Collection;


public class Autor {
	private long id;
	private String nome;
	private Collection<Livro> livros = new ArrayList<Livro>();
	private Nacionalidade nacionalidade;
	
	public Autor(){}
	public Autor(long $id, String $nome, Collection<Livro> $livros, Nacionalidade $nacionalidade){
		this.id = $id;
		this.nome = $nome;
		this.livros = $livros;
		this.nacionalidade = $nacionalidade;
		
	}
	
	public Collection<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Collection<Livro> livros) {
		this.livros = livros;
	}
	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
