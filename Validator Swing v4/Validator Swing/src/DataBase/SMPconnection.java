package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SMPconnection {

public static Connection ObterConexao(String env) {
    Connection conexao = null;
    try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             if (env == "Env A")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@10.28.229.77:1521:SMPINT01", "consulta_dicionario", "consulta1");
             if (env == "Env B")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@10.28.230.87:1521:SMPUSR01", "consulta_dicionario", "consulta1");
             if (env == "Env C")
            	 conexao = DriverManager.getConnection("jdbc:oracle:thin:@10.28.152.14:1521:SMPUATC1", "consulta_dicionario", "consulta1");
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