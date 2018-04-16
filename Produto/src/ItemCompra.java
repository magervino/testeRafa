
public class ItemCompra {
	private long qntde;
	private Compra compra;
	private Produto produto;
	
	public ItemCompra(){}
	public ItemCompra(long $qntde, Compra $compra, Produto $produto){
		this.qntde = $qntde;
		this.compra = $compra;
		this.produto = $produto;
	}
	public long getQntde() {
		return qntde;
	}
	public void setQntde(long qntde) {
		this.qntde = qntde;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
