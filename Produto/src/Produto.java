import java.util.ArrayList;
import java.util.Collection;


public class Produto {
	private String descricao;
	private double preco;
	private long estoque;
	private TipoProduto tipoProduto;
	private Collection<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
	
	public Produto(){}
	public Produto(Collection<ItemCompra> $itensCompra, String $descricao, double $preco, long $estoque, TipoProduto $tipoProduto){
		this.itensCompra = $itensCompra;
		this.descricao = $descricao;
		this.preco = $preco;
		this.estoque = $estoque;
		this.tipoProduto = $tipoProduto;
	}
	
	public Collection<ItemCompra> getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra(Collection<ItemCompra> $itensCompra) {
		this.itensCompra = $itensCompra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public long getEstoque() {
		return estoque;
	}
	public void setEstoque(long estoque) {
		this.estoque = estoque;
	}
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	
	
}
