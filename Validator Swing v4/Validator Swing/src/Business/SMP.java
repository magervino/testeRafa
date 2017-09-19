package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DataBase.SMPconnection;

public class SMP {

	public static String validateSerialnumber(String equipment, String env) throws Exception {
		 Connection conexao = SMPconnection.ObterConexao(env);
		 Statement statement = conexao.createStatement();
		 String dbOwner = "";
		 if (env == "Env A")
			 dbOwner = "SMPUNOIUTCM";
		 if (env == "Env B")
			 dbOwner = "SMPUNOENVBCM";
		 if (env == "Env C")
			 dbOwner = "SMPUNOENVCCM";
         String queryGeneric = "select equipment_id from " + dbOwner + ".V_EQUIPMENT_SEARCH_BY_ID1 where equipment_id = '" + equipment + "'";
         String querySTB = "select STB_ID from " + dbOwner + ".V_NET_STB_SEARCH_NQ where STB_ID = '" + equipment + "'";
         String queryMAC = "select mac_address from " + dbOwner + ".V_DEVICE_MAC_ADDRESS_SEARCH_NQ where mac_address = '" + equipment + "'";
         String querySerial = "select serial_number from " + dbOwner + ".V_NET_SERIAL_NUMBER_SEARCH_NQ where serial_number = '" + equipment + "'";
         ResultSet resultSet;
         
         resultSet = statement.executeQuery(queryGeneric);
         if (!resultSet.next()) {
        	 resultSet = statement.executeQuery(querySTB);
        	 if (!resultSet.next()) {
        		 resultSet = statement.executeQuery(queryMAC);
        		 if (!resultSet.next()) {
        			 resultSet = statement.executeQuery(querySerial);
        			 if (!resultSet.next()) {
        				 return ("Equipment: " + equipment + " does not exists in SMP");
        			 }
        		 }
        	 }
         }
         System.out.println(equipment + " already created in SMP");
         return ("EquipExist");
	}
	
	public static String validateAddressId(String address, String env) throws Exception {
		Connection conexao = SMPconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		String dbOwner = "";
		if (env == "Env A")
			dbOwner = "SMPUNOIUTCM";
		if (env == "Env B")
			dbOwner = "SMPUNOENVBCM";
		if (env == "Env C")
			dbOwner = "SMPUNOENVCCM";
        String queryAddress = "select NET_ADDRESS_ID from " + dbOwner + ".V_ADDRESS_SUB_MAP where NET_ADDRESS_ID = '" + address + "'";
        String queryAddressMap = "select mac_address from " + dbOwner + ".V_DEVICE_MAC_ADDRESS_SEARCH_NQ where mac_address = '" + address + "'";
        ResultSet resultSet;
        
        resultSet = statement.executeQuery(queryAddress);
        if (resultSet.next()) {
     	   //String resultEquipment = resultSet.getString("equipment_id");
     	   conexao.close();
     	   return ("\nAddress ID " + address + " exists in SMP? - Yes"); 
        } 
        else {
       	 resultSet = statement.executeQuery(queryAddressMap);
       	 if (resultSet.next()) {
       		 //String resultEquipment = resultSet.getString("MAC_ADDRESS");
       	   	 conexao.close();
       	   	return ("\nAddress ID " + address + " exists in SMP? - Yes");
       	 }
        }
          return ("\nAddress ID " + address + " exists in SMP? - No");
	}
}