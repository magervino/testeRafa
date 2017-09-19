package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NovoAtlasconnection {

public static Connection ObterConexao(String env) {
    Connection conexao = null;
    
    try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             //DriverManager.setLoginTimeout(40);
             if (env == "Env A")
            	 //5.17.8.14:1522
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1522:ASMATL02", "consulta_dicionario", "consulta");
             if (env == "Env B")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1522:SITATL02", "consulta_dicionario", "consulta");
             if (env == "Env C")
            	 //5.17.8.14:1523
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1523:SITATL01", "consulta_dicionario", "consulta");
             if (env == "Env T03")
            	 //5.17.8.25:1523
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.25:1523:ATLUAT2", "consulta_dicionario", "con$ulta123");
             if(env == "Env T06")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.25:1523:ATLUAT5", "consulta_dicionario", "con$ulta123");
             if(env == "Env T01")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.25:1523:ATLUAT1", "consulta_dicionario", "con$ulta123");
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