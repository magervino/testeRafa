/**
 * 
 */
package Model;

import java.util.List;

/**
 * @author JORGEENC
 *
 */
public class GedData {

	//Variables for first SQL	
	private int Cod_Endereco;
	private int Num_Ordem;
	private int Cod_Bairro;
	private int Cod_Logradouro;
	private int Cod_Cidade;
	private int IdElemento_Servico;
	private String Nom_Completo;
	
	
    //Select Num_Ordem, Cod_Bairro, Cod_Logradouro, Cod_Cidade
    //--Into Vnumordem, Vbairro, Vlogr, Vcidade
    //From Novo_Ged.Endereco
    //Where Cod_Endereco = 3000;
	
	// Addresses complements 
	private String Nom_Logradouro;
	private int Num_Logradouro;
	private int Num_CEP;
	private String Nom_Complement1;
	private String Txt_Complement1;
	private String Nom_Complement2;
	private String Txt_Complement2;
	private String Nom_Complement3;
	private String Txt_Complement3;
	private String Nom_Complement4;
	private String Txt_Complement4;
	
	/**
	 * @return the nom_Logradouro
	 */
	public String getNom_Logradouro() {
		return Nom_Logradouro;
	}
	/**
	 * @param nomLogradouro the nom_Logradouro to set
	 */
	public void setNom_Logradouro(String nomLogradouro) {
		Nom_Logradouro = nomLogradouro;
	}
	/**
	 * @return the num_Logradouro
	 */
	public int getNum_Logradouro() {
		return Num_Logradouro;
	}
	/**
	 * @param numLogradouro the num_Logradouro to set
	 */
	public void setNum_Logradouro(int numLogradouro) {
		Num_Logradouro = numLogradouro;
	}
	/**
	 * @return the num_CEP
	 */
	public int getNum_CEP() {
		return Num_CEP;
	}
	/**
	 * @param numCEP the num_CEP to set
	 */
	public void setNum_CEP(int numCEP) {
		Num_CEP = numCEP;
	}
	/**
	 * @return the nom_Complement1
	 */
	public String getNom_Complement1() {
		return Nom_Complement1;
	}
	/**
	 * @param nomComplement1 the nom_Complement1 to set
	 */
	public void setNom_Complement1(String nomComplement1) {
		Nom_Complement1 = nomComplement1;
	}
	/**
	 * @return the txt_Complement1
	 */
	public String getTxt_Complement1() {
		return Txt_Complement1;
	}
	/**
	 * @param txtComplement1 the txt_Complement1 to set
	 */
	public void setTxt_Complement1(String txtComplement1) {
		Txt_Complement1 = txtComplement1;
	}
	/**
	 * @return the nom_Complement2
	 */
	public String getNom_Complement2() {
		return Nom_Complement2;
	}
	/**
	 * @param nomComplement2 the nom_Complement2 to set
	 */
	public void setNom_Complement2(String nomComplement2) {
		Nom_Complement2 = nomComplement2;
	}
	/**
	 * @return the txt_Complement2
	 */
	public String getTxt_Complement2() {
		return Txt_Complement2;
	}
	/**
	 * @param txtComplement2 the txt_Complement2 to set
	 */
	public void setTxt_Complement2(String txtComplement2) {
		Txt_Complement2 = txtComplement2;
	}
	/**
	 * @return the nom_Complement3
	 */
	public String getNom_Complement3() {
		return Nom_Complement3;
	}
	/**
	 * @param nomComplement3 the nom_Complement3 to set
	 */
	public void setNom_Complement3(String nomComplement3) {
		Nom_Complement3 = nomComplement3;
	}
	/**
	 * @return the txt_Complement3
	 */
	public String getTxt_Complement3() {
		return Txt_Complement3;
	}
	/**
	 * @param txtComplement3 the txt_Complement3 to set
	 */
	public void setTxt_Complement3(String txtComplement3) {
		Txt_Complement3 = txtComplement3;
	}
	/**
	 * @return the nom_Complement4
	 */
	public String getNom_Complement4() {
		return Nom_Complement4;
	}
	/**
	 * @param nomComplement4 the nom_Complement4 to set
	 */
	public void setNom_Complement4(String nomComplement4) {
		Nom_Complement4 = nomComplement4;
	}
	/**
	 * @return the txt_Complement4
	 */
	public String getTxt_Complement4() {
		return Txt_Complement4;
	}
	/**
	 * @param txtComplement4 the txt_Complement4 to set
	 */
	public void setTxt_Complement4(String txtComplement4) {
		Txt_Complement4 = txtComplement4;
	}
	//Array with available technologies
	private List<AvailableTechData> availableTechs;
	
	/**
	 * @return the num_Ordem
	 */
	/**
	 * @return the num_Ordem
	 */
	public int getNum_Ordem() {
		return Num_Ordem;
	}
	/**
	 * @param numOrdem the num_Ordem to set
	 */
	public void setNum_Ordem(int numOrdem) {
		Num_Ordem = numOrdem;
	}
	/**
	 * @return the cod_Bairro
	 */
	public int getCod_Bairro() {
		return Cod_Bairro;
	}
	/**
	 * @param codBairro the cod_Bairro to set
	 */
	public void setCod_Bairro(int codBairro) {
		Cod_Bairro = codBairro;
	}
	/**
	 * @return the cod_Logradouro
	 */
	public int getCod_Logradouro() {
		return Cod_Logradouro;
	}
	/**
	 * @param codLogradouro the cod_Logradouro to set
	 */
	public void setCod_Logradouro(int codLogradouro) {
		Cod_Logradouro = codLogradouro;
	}
	/**
	 * @return the cod_Cidade
	 */
	public int getCod_Cidade() {
		return Cod_Cidade;
	}
	/**
	 * @param codCidade the cod_Cidade to set
	 */
	public void setCod_Cidade(int codCidade) {
		Cod_Cidade = codCidade;
	}
	public void setCod_Endereco(int cod_Endereco) {
		Cod_Endereco = cod_Endereco;
	}
	public int getCod_Endereco() {
		return Cod_Endereco;
	}
	public void setIdElemento_Servico(int idElemento_Servico) {
		IdElemento_Servico = idElemento_Servico;
	}
	public int getIdElemento_Servico() {
		return IdElemento_Servico;
	}
	public void setAvailableTechs(List<AvailableTechData> availableTechs) {
		this.availableTechs = availableTechs;
	}
	public List<AvailableTechData> getAvailableTechs() {
		return availableTechs;
	}
	public void setNom_Completo(String nom_Completo) {
		Nom_Completo = nom_Completo;
	}
	public String getNom_Completo() {
		return Nom_Completo;
	}


	
}
