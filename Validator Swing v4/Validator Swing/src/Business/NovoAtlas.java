package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DataBase.NovoAtlasconnection;

public class NovoAtlas {
				  
	public static ResultSet SerialNumberByTech(String techId, String env) throws Exception {
		 Connection conexao = NovoAtlasconnection.ObterConexao(env);
		 Statement statement = conexao.createStatement();
         ResultSet resultSet;
         String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "'";
         System.out.println(query);
		 resultSet = statement.executeQuery(query);
		 return resultSet;
	}
		
	public static ResultSet SerialNumberByTechAndEquipType(String techId, String equipType, String env) throws Exception {
		Connection conexao = NovoAtlasconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
        ResultSet resultSet;
		
		if (equipType.contentEquals("EMTA:2:D2.0:C1:")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'EMTA:2:D2.0:C1:'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("EMTA:2:D3.0:C8:W")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'EMTA:2:D3.0:C8:W'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("EMTA:2:D2.0:C1:W")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'EMTA:2:D2.0:C1:W'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("SMART CARD")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'SMART CARD'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:SD:1")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'DigitalSTB:SD:1'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:HD:1")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'DigitalSTB:HD:1'";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:HDDVR:1")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'DigitalSTB:HDDVR:1'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("DigitalSTB:2T:1")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = 'DigitalSTB:2T:1'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("3P:HD:1:D3.0:F2.X:W")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = '3P:HD:1:D3.0:F2.X:W'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		if (equipType.contentEquals("3P:HD:2:D3.0:F5.X:W")){
			String query = "select eq.id_local, eq.id_equipamento, ender.cd_enderecavel, loc.nm_local, tipo.nm_tipo_equipamento as Tipo_equipamento, modl.tp_model_type_dam, eq.nr_serie from nethome.tipo_equipamento tipo, nethome.equipamento eq,  nethome.modelo_equipamento   modl,  nethome.enderecavel ender,  nethome.mod_equip_tipo_ender meqt,   nethome.local   loc  where eq.id_local = loc.id_local  and eq.id_modelo_equipamento = modl.id_modelo_equipamento   and modl.id_tipo_equipamento = tipo.id_tipo_equipamento and ender.id_equipamento = eq.id_equipamento and ender.id_mod_equip_tipo_ender = meqt.id_mod_equip_tipo_ender  and eq.id_estado_equipamento = 2  and modl.tp_model_type_dam is not null        	        and loc.id_tipo_local in (4, 5)        	        and eq.id_operacao = 19        	        and meqt.fc_enderecavel_principal = 'S' and eq.id_local = '" + techId + "' and  modl.tp_model_type_dam = '3P:HD:2:D3.0:F5.X:W'";
			resultSet = statement.executeQuery(query);
			return resultSet;
		}
		return null;
	}
}				  