
public class EmpregadoVoluntario extends Empregado{
	private int id;
	private Empregado empregado;
	
	public EmpregadoVoluntario(){}

	public EmpregadoVoluntario(int id, Empregado empregado) {
		super();
		this.id = id;
		this.empregado = empregado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
}
