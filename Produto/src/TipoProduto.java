import java.util.ArrayList;
import java.util.Collection;


public class TipoProduto {
	private long id;
	private String descricao;
	private Collection<Produto> produtos = new ArrayList<Produto>();
	
	public TipoProduto(){}
	public TipoProduto(long $id, String $descricao, Collection<Produto> $produtos){
		this.id = $id;
		this.descricao = $descricao;
		this.produtos = $produtos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
