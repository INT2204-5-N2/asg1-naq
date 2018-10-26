package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryData {
	public static void main(String[] args)throws ClassNotFoundException,
			SQLException{
		Connection conn=ConnectionSQL.getMyConnection();
		Statement statement=conn.createStatement();
		String sql="Select STT, English, Vietnamese from edict";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()){
			int stt=rs.getInt(1);
			String english=rs.getString(2);
			String vietnamese=rs.getString(3);
			System.out.println(stt+"	"+english+"	"+vietnamese);
		}
		conn.close();
	}
}
