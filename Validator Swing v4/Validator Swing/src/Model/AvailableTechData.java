/**
 * 
 */
package Model;

import java.util.List;

/**
 * @author JORGEENC
 *
 */
public class AvailableTechData {

	//Variables for first SQL	
	private int Id_Servico;
	private String Linha_Negocio;
	private String Tecnologia;
	private String Distribuicao;
	private String Caracteristica;
	private String SubCaracteristca;

	
	/**
	 * @return the id_Servico
	 */
	public int getId_Servico() {
		return Id_Servico;
	}
	/**
	 * @param idServico the id_Servico to set
	 */
	public void setId_Servico(int idServico) {
		Id_Servico = idServico;
	}
	/**
	 * @return the linha_Negocio
	 */
	public String getLinha_Negocio() {
		return Linha_Negocio;
	}
	/**
	 * @param linhaNegocio the linha_Negocio to set
	 */
	public void setLinha_Negocio(String linhaNegocio) {
		Linha_Negocio = linhaNegocio;
	}
	/**
	 * @return the tecnologia
	 */
	public String getTecnologia() {
		return Tecnologia;
	}
	/**
	 * @param tecnologia the tecnologia to set
	 */
	public void setTecnologia(String tecnologia) {
		Tecnologia = tecnologia;
	}
	public void setDistribuicao(String distribuicao) {
		Distribuicao = distribuicao;
	}
	public String getDistribuicao() {
		return Distribuicao;
	}
	public void setCaracteristica(String caracteristica) {
		Caracteristica = caracteristica;
	}
	public String getCaracteristica() {
		return Caracteristica;
	}
	
	/**
	 * @return the subCaracteristca
	 */
	public String getSubCaracteristca() {
		return SubCaracteristca;
	}
	/**
	 * @param subCaracteristca the subCaracteristca to set
	 */
	public void setSubCaracteristca(String subCaracteristca) {
		SubCaracteristca = subCaracteristca;
	} 	
}
