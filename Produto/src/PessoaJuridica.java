
public class PessoaJuridica extends Cliente{
	private String cnpj;
	private Cliente cliente;
	
	public PessoaJuridica(){}
	public PessoaJuridica(String $cnpj, Cliente $cliente){
		super();
		this.cnpj = $cnpj;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double gastoTotal(){
		return super.gastoTotal() * 0.9;
	}
}
