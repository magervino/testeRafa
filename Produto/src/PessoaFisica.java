
public class PessoaFisica extends Cliente{
	private String cpf;
	Cliente cliente = new Cliente();
	
	public PessoaFisica(){}
	public PessoaFisica(String $cpf, Cliente $cliente){
		super();
		this.cpf = $cpf;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
