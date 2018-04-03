import java.util.ArrayList;
import java.util.Collection;


public class Nacionalidade {
	private long id;
	private String nome;
	private Collection<Autor> autores = new ArrayList<Autor>();
	
	public Nacionalidade(){}
	public Nacionalidade(long $id, String $nome, Collection<Autor> $autores){
		this.id = $id;
		this.nome = $nome;
		this.autores = $autores;
	}
	
	public Collection<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
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
