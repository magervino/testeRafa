
public class EmpregadoComissionado extends EmpregadoContratado{
	private int id;
	private EmpregadoContratado empregadoContratado;

	public EmpregadoComissionado(){}
	public EmpregadoComissionado(int $id, EmpregadoContratado $empregadoContratado){
		super();
		this.id = $id;
		this.empregadoContratado = $empregadoContratado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EmpregadoContratado getEmpregadoContratado() {
		return empregadoContratado;
	}
	public void setEmpregadoContratado(EmpregadoContratado empregadoContratado) {
		this.empregadoContratado = empregadoContratado;
	}
	
}
