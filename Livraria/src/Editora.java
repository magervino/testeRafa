import java.util.ArrayList;
import java.util.Collection;


public class Editora {
	private long id;
	private String nome;
	private Collection<Livro> livros = new ArrayList<Livro>();
	
	public Editora(){}
	public Editora(long $id, String $nome, Collection<Livro> $livros){
		this.id = $id;
		this.nome = $nome;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
