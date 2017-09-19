package Business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import WhiteListData.*;
import DataBase.CRMconnection;

public class CRM {

	public static String SearchCPFCNPJbyID (String document, String env) throws Exception{
		Connection conexao = CRMconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		String queryCNPJorCPF = "select * from sa.table_contact where x_main_ident_value = '" + document + "'"; 
		System.out.println(queryCNPJorCPF);
		resultSet = statement.executeQuery(queryCNPJorCPF);
		if(resultSet.next()){
			String cpforcnpj = resultSet.getString("x_main_ident_type");
			if (cpforcnpj.contains("CPF")){
				String query = "select First_name, last_name, phone, e_mail, birth_date, x_gender, x_main_ident_value, x_mother_name from sa.table_contact where x_main_ident_value = '" + document + "'";
				resultSet = statement.executeQuery(query);
				resultSet.next();
				String resultDocument = "Details for CPF: " + resultSet.getString("x_main_ident_value") + "\nFirst Name: " + resultSet.getString("first_name") + "\nLast Name: " + resultSet.getString("last_name") +
     			   "\nPhone: " + resultSet.getString("phone") + "\nEmail: " + resultSet.getString("e_mail") + "\nBirth Date: " + resultSet.getString("birth_date") +
     			   "\nMother Name: " + resultSet.getString("x_mother_name");
        		conexao.close();
        		return (resultDocument); 
			}
			if (cpforcnpj.contains("CNPJ")) {
        		String query = "select last_name, phone, e_mail, x_gender, x_main_ident_value, x_org_ident, x_state_inscription, x_municipal_inscription  from sa.table_contact where x_main_ident_value = '" + document + "'";
       	 		resultSet = statement.executeQuery(query);
       	 		resultSet.next();
       	 		String resultDocument = "Details for CNPJ: " + resultSet.getString("x_main_ident_value") + "\nOrg Name: " + resultSet.getString("last_name") +
       	 				"\nPhone: " + resultSet.getString("phone") + "\nEmail: " + resultSet.getString("e_mail") + "\nState Inscription: " + resultSet.getString("x_state_inscription") +
       	 				"\nMunicipal Inscription: " + resultSet.getString("x_municipal_inscription");
       	 		conexao.close();
       	 		return (resultDocument); 
        	}
		}
        conexao.close();
       	return ("Document " + document + " do not exist in DB");
        
	}
	
	public static String SearchAddressbyID (String address, String env) throws Exception{
		Connection conexao = CRMconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		String query = "select * from sa.table_address where x_address_id = '" + address + "'";
		System.out.println(query);
        resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
     	   String resultAddress = "Address details:\n\nZipCode: " + resultSet.getString("ZIPCODE") + "\nState: " + resultSet.getString("STATE") + "\nStreet Name: " + resultSet.getString("STREET_NAME") + "\nStreet number: " + resultSet.getString("STREET_NUMBER") + "\n\nAddress ID " + resultSet.getString("x_address_id") + " existis in CRM? - Yes";
     	   conexao.close();
     	   return resultAddress; 
        } 
        else {
        	conexao.close();
        	return ("Address ID " + address + " existis in CRM? - No");
        }	   
	}


	public static String SearchCBPWhiteList (String cbpImput, String env) throws IOException, Exception{
		Connection conexao = CRMconnection.ObterConexao(env);
		Statement statement = conexao.createStatement();
		ResultSet resultSet;
		int details = 0;
		String textResult = "Results:";
		String CBPwhiteList;
		String query;
		FileReader arqR = new FileReader(new File("src/WhiteListData/CRMWhitelistFVT3c9.txt")); 
		BufferedReader lerArq = new BufferedReader(arqR);
		try {
			System.out.println("I am checking whitelist file...");
			while(true){
				CBPwhiteList=lerArq.readLine();
				System.out.println(CBPwhiteList);
		          if(CBPwhiteList==null) {
		            break;
		          }
		          if (CBPwhiteList.equals(cbpImput)){
		        	  	textResult = textResult + "\nCBP: " + cbpImput + " was found in white list and can be considered a good customer."; 
		        		query = "SELECT DISTINCT(A.CUSTOMER_ID), A.NAME, A.TYPE, A.SUBTYPE, B.INSTANCE_NAME, B.STATUS, C.INSTAL_ADDRESS_ID, E.NAME_TEXT \"OFFER_NAME\" FROM SA.TABLE_CUSTOMER A, SA.TABLE_SUBS_CUSTOMER_VW B, TBAP_ITEM@CRM2OMS C,   TBNAME@CRM2OMS E WHERE 1 = 1 AND A.CUSTOMER_ID = B.CUSTOMER_ID     AND A.CUSTOMER_ID = C.CUSTOMER_ID    AND C.OFFER_DEF_ID = E.CID    AND C.OFFER_DEF_VER = E.PCVERSION_ID    AND C.STATUS = 'AC'    AND C.STATE = 'AS'    AND C.END_DATE > SYSDATE   AND E.LANGUAGE = 'PT'    AND A.CUSTOMER_ID = '" + cbpImput + "'";
		      			System.out.println (query);
		      			resultSet = statement.executeQuery(query);
		      			//resultSet.first();
		      			//textResult = textResult + "\n------------------------\nCustomer name: " + resultSet.getString("NAME") + "\nCBP Type: " +  resultSet.getString("TYPE") + "\nCBP sub type: " + resultSet.getString("SUBTYPE") + "\n-------------------------";
		      			while (resultSet.next()) {
		      				if (details == 0){
		      					textResult = textResult + "\n------------------------\nCustomer name: " + resultSet.getString("NAME") + "\nCBP Type: " +  resultSet.getString("TYPE") + "\nCBP sub type: " + resultSet.getString("SUBTYPE") + "\n-------------------------";
		      					//textResult = textResult + "\nServices:" + resultSet.getString("INSTANCE_NAME"); 
		      					textResult = textResult + "\nServices:" ;
		      					textResult = textResult + "\nProduct: " + resultSet.getString("INSTANCE_NAME");
		      					textResult = textResult + "\nStatus: " + resultSet.getString("STATUS");
		      					textResult = textResult + "\nInstallation address id: " + resultSet.getString("INSTAL_ADDRESS_ID");
		      					textResult = textResult + "\nOffer: " + resultSet.getString("OFFER_NAME") + "\n----------------";
		      					System.out.println(textResult);
		      					details = 1;
		      				} else {
		      					textResult = textResult + "\nProduct: " + resultSet.getString("INSTANCE_NAME");
		      					textResult = textResult + "\nStatus: " + resultSet.getString("STATUS");
		      					textResult = textResult + "\nInstallation address id: " + resultSet.getString("INSTAL_ADDRESS_ID");
		      					textResult = textResult + "\nOffer: " + resultSet.getString("OFFER_NAME") + "\n----------------";
		      				}
		      				
		      			}
		      			return textResult;
		          }
			}
			//arqW.close();
			//}
			return "CBP: " + cbpImput + " do not exist or not found on White list";
		}catch (IOException e) { 
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
		}
		return textResult;
	}
	
}

