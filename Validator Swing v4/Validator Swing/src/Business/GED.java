package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.GEDconnection;
import DataBase.NovoAtlasconnection;
import Model.AvailableTechData;
import Model.GedData;

public class GED {

	public static ResultSet SearchAddresses(Integer quantity, String env)
			throws Exception {
		Connection conexao = GEDconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		String query = "Select Cod_Endereco, Num_Ordem, Cod_Bairro, Cod_Logradouro, Cod_Cidade From Novo_Ged.Endereco Where rownum <= "
				+ quantity.intValue();
		System.out.println(query);
		resultSet = statement.executeQuery(query);
		return resultSet;
	}

	public static ResultSet SerialNumberByTechAndEquipType(String techId,
			String equipType, String env) throws Exception {
		Connection conexao = NovoAtlasconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;

		if (equipType.contentEquals("EMTA:2:D2.0:C1:")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'EMTA:2:D2.0:C1:'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("EMTA:2:D3.0:C8:W")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'EMTA:2:D3.0:C8:W'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("EMTA:2:D2.0:C1:W")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'EMTA:2:D2.0:C1:W'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("SMART CARD")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId + "' and  modl.tp_model_type_dam = 'SMART CARD'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:SD:1")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'DigitalSTB:SD:1'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:HD:1")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'DigitalSTB:HD:1'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:HDDVR:1")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'DigitalSTB:HDDVR:1'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:2T:1")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = 'DigitalSTB:2T:1'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("3P:HD:1:D3.0:F2.X:W")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = '3P:HD:1:D3.0:F2.X:W'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("3P:HD:2:D3.0:F5.X:W")) {
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam  from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '"
					+ techId
					+ "' and  modl.tp_model_type_dam = '3P:HD:2:D3.0:F5.X:W'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		return null;
	}

	public static String SearchString(Integer quantity, String env)
			throws SQLException {
		Connection conexao = GEDconnection.ObterConexao(env);

		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		String query = "Select Num_Ordem, Cod_Bairro, Cod_Logradouro, Cod_Cidade From Novo_Ged.Endereco Where rownum <= "
				+ quantity.intValue();
		System.out.println(query);
		resultSet = statement.executeQuery(query);
		String str = new String();

		while (resultSet.next()) {
			str = String.valueOf(resultSet.getInt(1)) + " -- "
					+ String.valueOf(resultSet.getInt(2)) + " -- "
					+ String.valueOf(resultSet.getInt(3)) + "\n";
		}

		conexao.close();

		return str;
	}

	/**
	 * 
	 * @param quantity
	 * @param env
	 * @throws Exception
	 */
	public static List<GedData> GEDSearchAddresses(Integer quantity, String env, String nodeOption)
			throws Exception {

		List<GedData> addressesCodes = new ArrayList<GedData>();
		Connection conexao = GEDconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		int IdElemento_Servico;
		int divQty;
		int addressesQty = 0;
		
		divQty = quantity.intValue() / 10;
		String strAdd = new String();
		String tmp = new String();
		
		String query = 	" SELECT E.COD_ENDERECO, E.NUM_ORDEM, E.COD_BAIRRO, E.COD_LOGRADOURO, E.COD_CIDADE, " +
					 	" E.NOM_COMPLETO, E.NUM_CEP, E.NUM_ENDERECO,(SELECT TC.COD_TIPO_COMPL FROM NOVO_GED.TIPO_COMPLEMENTO TC " + 
					 	" WHERE TC.ID_TIPO_COMPLEMENTO = E.ID_TIPO_COMPLEMENTO1) COD_TIPO_COMPL1, TXT_TIPO_COMPL1, " + 
					 	"(SELECT TC.COD_TIPO_COMPL FROM NOVO_GED.TIPO_COMPLEMENTO TC " + 
					 	" WHERE TC.ID_TIPO_COMPLEMENTO = E.ID_TIPO_COMPLEMENTO2) COD_TIPO_COMPL2, TXT_TIPO_COMPL2 " + 
					 	" FROM NOVO_GED.ENDERECO E, NOVO_GED.NODE_EDIFICACAO NE " +
					 	" WHERE E.COD_ENDERECO = NE.COD_EDIFICACAO " +
					 	" AND NE.COD_NODE ='" +  nodeOption + "' " +
					 	" AND E.IND_DISPONIVEL ='S'" +
					 	" AND  ROWNUM <= "
				+ quantity.intValue();
		System.out.println(query);
		resultSet = statement.executeQuery(query);

		while (resultSet.next() && addressesQty!= divQty) {
			int cod_endereco = resultSet.getInt(1);			
			strAdd = CRM.SearchAddressbyID(String.valueOf(cod_endereco), env);
			if(strAdd.contains("Yes")){
				tmp = "*********JC*********";
				resultSet.next();				
			}else {			
				int num_ordem = resultSet.getInt(2);
				int cod_bairro = resultSet.getInt(3);
				int cod_logradouro = resultSet.getInt(4);
				int cod_cidade = resultSet.getInt(5);
				String Nom_Completo = resultSet.getString(6) + "[ " + strAdd + " ]";
				int Num_CEP = resultSet.getInt(7);
				int Num_Logradouro = resultSet.getInt(8);
				String Nom_Complement1 = resultSet.getString(9) != null ? resultSet.getString(9)  : "N/A";
				String Txt_Complement1 = resultSet.getString(10)!= null ? resultSet.getString(10) : "N/A";
				String Nom_Complement2 = resultSet.getString(11)!= null ? resultSet.getString(11) : "N/A";
				String Txt_Complement2 = resultSet.getString(12)!= null ? resultSet.getString(12) : "N/A";
					
				GedData gedAddressCodes = new GedData();
				gedAddressCodes.setCod_Endereco(cod_endereco);
				gedAddressCodes.setNum_Ordem(num_ordem);
				gedAddressCodes.setCod_Bairro(cod_bairro);
				gedAddressCodes.setCod_Logradouro(cod_logradouro);
				gedAddressCodes.setCod_Cidade(cod_cidade);
				
				//Addresses complements 
				gedAddressCodes.setNom_Completo(Nom_Completo);
				gedAddressCodes.setNum_CEP(Num_CEP);
				gedAddressCodes.setNum_Logradouro(Num_Logradouro);
				gedAddressCodes.setNom_Complement1(Nom_Complement1);
				gedAddressCodes.setTxt_Complement1(Txt_Complement1);
				gedAddressCodes.setNom_Complement2(Nom_Complement2);
				gedAddressCodes.setTxt_Complement2(Txt_Complement2);
								
				IdElemento_Servico = getIdElemento_Servico(cod_endereco, num_ordem,
						cod_bairro, cod_logradouro, cod_cidade, conexao);
	
				//available technologies
				List<AvailableTechData> availableTechs = getAvailable_Technologies(IdElemento_Servico,conexao);
				gedAddressCodes.setAvailableTechs(availableTechs);
				
				gedAddressCodes.setIdElemento_Servico(IdElemento_Servico);
	
				addressesCodes.add(gedAddressCodes);
	
				String str = "Cod_Endereco: " + cod_endereco + " Num_Ordem: "
						+ num_ordem + " Cod Bairro: " + cod_bairro
						+ " Cod Logradouro: " + cod_logradouro + " Cod cidade: "
						+ cod_cidade;
				System.out.println(str);
				
				addressesQty ++;
				strAdd = "";
			}	
		}

		conexao.close();

		return addressesCodes;
	}

	/**
	 * 
	 * @param cod_endereco
	 * @param num_ordem
	 * @param cod_bairro
	 * @param cod_logradouro
	 * @param cod_cidade
	 * @return
	 */
	public static int getIdElemento_Servico(int cod_endereco, int num_ordem,
			int cod_bairro, int cod_logradouro, int cod_cidade,
			Connection conexao) {
		int idElemtno_Servico = 0;
		ResultSet resultSet;

		String sql = "Select Id_Elemento_Servico "
				+ "   From Novo_Ged.Elemento_Servico  "
				+ "   Where (Cod_Cidade = "
				+ cod_cidade
				+ " And Cod_Node Is Null)  "
				+ "     Or (Cod_Cidade = "
				+ cod_cidade
				+ " And Cod_Bairro = "
				+ cod_bairro
				+ ")  "
				+ "     Or (Cod_Cidade = "
				+ cod_cidade
				+ " And Cod_Logradouro = "
				+ cod_logradouro
				+ " And  "
				+ "        (Mod("
				+ num_ordem
				+ ", 2) = 1 And  "
				+ "        ("
				+ num_ordem
				+ " Between Num_Impar_Ini And  "
				+ "        Num_Impar_Fim Or (Num_Impar_Ini Is Null And  "
				+ "        Num_Impar_Fim Is Null))) And  "
				+ "        (Mod("
				+ num_ordem
				+ ", 2) = 0 And  "
				+ "        ("
				+ num_ordem
				+ " Between Num_Par_Ini And Num_Par_Fim Or  "
				+ "        (Num_Par_Ini Is Null And Num_Par_Fim Is Null))))  "
				+ "     Or (Cod_Cidade = "
				+ cod_cidade
				+ " And  "
				+ "        Cod_Node In  "
				+ "        (Select Edif.Cod_Node  "
				+ "            From Novo_Ged.Node_Edificacao Edif,  "
				+ "                 Novo_Ged.Geo_Node        Node,  "
				+ "                 Novo_Ged.Geo_Status_Node Sts     "
				+ "           Where Edif.Cod_Node = Node.Cod_Node  "
				+ "             And Node.Cd_Status_Node = Sts.Cd_Status_Node  "
				+ "             And Sts.Fc_Node_Ativo = 'S'  "
				+ "             And Edif.Cod_Edificacao = "
				+ cod_endereco
				+ "))";

		System.out.println(" getIdElemento_Servico function ");

		try {
			Statement statement = conexao.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				idElemtno_Servico = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idElemtno_Servico;

	}

	public static List<AvailableTechData> getAvailable_Technologies(int IdElemento_Servico,
			Connection conexao) {

		ResultSet resultSet;
		List<AvailableTechData> availableTechs = new ArrayList<AvailableTechData>();

		String sql = "SELECT Lpad(Cod_Operadora_Servico, 4, '0') Cod_Operadora, "
				+ "     (SELECT Nom_Operadora_Servico "
				+ "   FROM Novo_Ged.Operadora_Servico "
				+ "   WHERE Cod_Operadora_Servico = c.Cod_Operadora_Servico "
				+ "   ) \"OPERADORA\", "
				+ "   c.Id_Servico, "
				+ "     (SELECT Ds_Servico FROM Novo_Ged.Servico WHERE Id_Servico = c.Id_Servico "
				+ "     ) \"LINHA_DE_NEGOCIO\", "
				+ "     Connect_By_Root c.Id_Caracteristica Id_Caracteristica, "
				+ "     Connect_By_Root Ds_Caracteristica \"TECNOLOGIA\", "
				+ "     c.Id_Tipo_Distribuicao_Servico Tipo_Distribuicao, "
				+ "     (SELECT Ds_Tipo_Distribuicao_Servico "
				+ "     FROM Novo_Ged.Tipo_Distribuicao_Servico "
				+ "     WHERE Id_Tipo_Distribuicao_Servico = c.Id_Tipo_Distribuicao_Servico "
				+ "     ) \"DISTRIBUICAO\", "
				+ "     DECODE(Level, 1, NULL, 2, c.Id_Caracteristica, 3, "
				+ "     (SELECT Id_Caracteristica "
				+ "     FROM Novo_Ged.Caracteristica_Servico "
				+ "     WHERE Id_Caracteristica_Servico = c.Id_Caracteristica_Servico_Pai "
				+ "     )), "
				+ "     DECODE(Level, 1, NULL, 2, d.Ds_Caracteristica, 3, "
				+ "     (SELECT "
				+ "       (SELECT Ds_Caracteristica "
				+ "       FROM Novo_Ged.Caracteristica "
				+ "       WHERE Id_Caracteristica = s.Id_Caracteristica "
				+ "       ) "
				+ "     FROM Novo_Ged.Caracteristica_Servico s "
				+ "     WHERE Id_Caracteristica_Servico = c.Id_Caracteristica_Servico_Pai "
				+ "     )) \"CARACTERISTICA\", "
				+ "     DECODE(Level, 3, c.Id_Caracteristica), "
				+ "     DECODE(Level, 3, d.Ds_Caracteristica) \"SUB_CARACTERISTICA\" "
				+ "   FROM Novo_Ged.Caracteristica_Servico c, "
				+ "     Novo_Ged.Caracteristica d "
				+ "   WHERE c.Id_Caracteristica      = d.Id_Caracteristica "
				+ "   AND c.Id_Servico               = DECODE(3, 2, 2, 1, NULL, c.Id_Servico) " //3 for id_servicio
				+ "   AND Id_Caracteristica_Servico IN "
				+ "     (SELECT Id_Caracteristica_Servico "
				+ "   FROM Novo_Ged.Abrangencia_Elemento_Servico a "
				+ "     WHERE Id_Elemento_Servico IN (" + IdElemento_Servico + ") "
				+ "     AND a.Fc_Status_Servico    = 'A' "
				+ "     MINUS "
				+ "     SELECT Id_Caracteristica_Servico "
				+ "     FROM Novo_Ged.Abrangencia_Elemento_Servico a "
				+ "     WHERE Id_Elemento_Servico IN (" + IdElemento_Servico + ") "
				+ "     AND a.Fc_Status_Servico   IN ('B','C') "
				+ "     ) "
				+ "     CONNECT BY Prior c.Id_Caracteristica_Servico = ID_CARACTERISTICA_SERVICO_PAI "
				+ "     START WITH Id_Caracteristica_Servico_Pai    IS NULL ";

		try {
			Statement statement = conexao.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
						
			while (resultSet.next()) {
				AvailableTechData acTechData = new AvailableTechData();
				int Id_Servicio = resultSet.getInt(3);
				String Linha_Negocio = resultSet.getString(4);
				String Tecnologia = resultSet.getString(6);
				String Caracteristica = resultSet.getString(10)!= null ? resultSet.getString(10) : "N/A";;
				String SubCaracteristca = resultSet.getString(12)!= null ? resultSet.getString(12) : "N/A";;
				
				acTechData.setId_Servico(Id_Servicio);
				acTechData.setLinha_Negocio(Linha_Negocio);
				acTechData.setTecnologia(Tecnologia);
				acTechData.setCaracteristica(Caracteristica);
				acTechData.setSubCaracteristca(SubCaracteristca);
				
				availableTechs.add(acTechData);				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return availableTechs;

	}
}