package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CRMconnection {

public static Connection ObterConexao(String env) {
    Connection conexao = null;
    try {
    		System.out.println(env);
             Class.forName("oracle.jdbc.driver.OracleDriver");
             if (env == "Env A")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@netuathp1:1710:NETCRM21", "consulta_dicionario", "con$ulta123"); //ENVA
             if (env == "Env B")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@netuathp1:1710:NETCRM22", "sa", "sa"); //ENVB
             if (env == "Env C")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@netuathp1:1710:NETCRM1", "sa", "sa"); //ENVC
    } catch (ClassNotFoundException e) {
             e.printStackTrace();
    } catch (SQLException e) {
             e.printStackTrace();
    }
    return conexao;
}

public static void CloseConnection(Connection conexao) throws SQLException {
	conexao.close();
}

}