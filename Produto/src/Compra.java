import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;


public class Compra {
	private long id;
	private Date data;
	private Cliente cliente;
	private Collection<ItemCompra> itensCompra = new ArrayList<ItemCompra>();
	
	public Compra(){}
	public Compra(long $id, Date $data, Cliente $cliente, Collection<ItemCompra> $itensCompra){
		this.id = $id;
		this.data = $data;
		this.cliente = $cliente;
		this.itensCompra = $itensCompra;
	}
	
	public Collection<ItemCompra> getItensCompra() {
		return itensCompra;
	}
	public void setItensCompra(Collection<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	//IMPLEMENTAR VATORTOTAL
	public double valorTotal(){
		double valo= 0.0;
		for(ItemCompra item: this.getItensCompra()){
			valo += item.getProduto().getPreco();
		}
		return valo;
	}
}
