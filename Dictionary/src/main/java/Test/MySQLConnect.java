package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
	public static Connection getMySQLConnection()
		throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "edict";
		String userName = "root";
		String password = "quan21111999";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	public static Connection getMySQLConnection(String hostName,String dbName,String userName,String password) throws SQLException,
			ClassNotFoundException{
		String connectionURL="jdbc:mysql://"+hostName+":3306/"+dbName+"?useSSL=false";
		Connection conn= DriverManager.getConnection(connectionURL,userName,password);
		return conn;
	}
}
