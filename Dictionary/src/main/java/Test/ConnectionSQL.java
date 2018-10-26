package Test;

import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionSQL {
	public static Connection getMyConnection() throws SQLException,
			ClassNotFoundException{
		return MySQLConnect.getMySQLConnection();
	}
	public static void main(String[] args)throws SQLException,
			ClassNotFoundException{
		System.out.println("Get connection ...");
		Connection conn=ConnectionSQL.getMyConnection();
		System.out.println("Get connection "+conn);
		System.out.println("Done!");
	}
}
