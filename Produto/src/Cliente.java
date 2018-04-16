import java.util.ArrayList;
import java.util.Collection;


public class Cliente {
	private long id;
	private String nome, telefone;
	private Collection<Compra> compras = new ArrayList<Compra>();
	
	public Cliente(){}
	public Cliente(long $id, String $nome, String $telefone, Collection<Compra> $compras){
		this.id = $id;
		this.nome = $nome;
		this.telefone = $telefone;
		this.compras = $compras;
	}
	public Collection<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Collection<Compra> compras) {
		this.compras = compras;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public double gastoTotal(){
		double gastoTotal = 0.0;
		for(Compra c: this.getCompras()){
			gastoTotal += c.valorTotal();
		}
		return gastoTotal;
	}
}
