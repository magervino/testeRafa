package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GEDconnection {

public static Connection ObterConexao(String env) {
    Connection conexao = null;
    try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             if (env == "Env A")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1523:SITGED02", "consulta_dicionario", "consulta");
             if (env == "Env B")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1523:SITGED03", "consulta_dicionario", "consulta");
             if (env == "Env C")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.14:1523:UATGED01", "consulta_dicionario", "consulta");
             if(env == "Env T03")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.208:1523:GEDUAT2", "novo_ged", "novo_ged");
             if(env == "Env T06")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@5.17.8.208:1523:GEDUAT5", "novo_ged", "novo_ged");
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