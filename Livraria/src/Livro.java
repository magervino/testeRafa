import java.util.ArrayList;
import java.util.Collection;

public class Livro {
	private long id;
	private int isbn, ano;
	private String titulo;
	private Editora editora;
	private Collection<Autor> autores = new ArrayList<Autor>();
	private Categoria categoria;
	private Collection<Copia> copias = new ArrayList<Copia>();
	
	public Livro(){}
	public Livro(Editora $editora, long $id, int $isbn, int $ano, String $titulo, 
			Collection<Autor> $autores, Categoria $categoria, Collection<Copia> $copias){
		this.editora = $editora;
		this.id = $id;
		this.isbn = $isbn;
		this.ano = $ano;
		this.titulo = $titulo;
		this.autores = $autores;
		this.categoria = $categoria;
		this.copias = $copias;
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Collection<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Collection<Copia> getCopias() {
		return copias;
	}
	public void setCopias(Collection<Copia> copias) {
		this.copias = copias;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
