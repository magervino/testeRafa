
public class Copia {
	private long id, codigo;
	private double preco;
	private Copia copia;
	
	public Copia(){}
	public Copia(long $id, long $codigo, double $preco, Copia $copia){
		this.id = $id;
		this.codigo = $codigo;
		this.preco = $preco;
		this.copia = $copia;
	}
	
	public Copia getCopia() {
		return copia;
	}
	public void setCopia(Copia copia) {
		this.copia = copia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
