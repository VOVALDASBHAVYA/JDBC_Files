package adv_java_jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallbleStatmnt_Demo {

	public static void main(String[] args) {
//		step1: load the drivers
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//		step2: establishing connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/engg", "root", "root");
//		step3: prepare statement
			CallableStatement cs=connection.prepareCall("{call proc1(?,?)}");//this is to call the procedures
//			CallableStatement cstmt = connection.prepareCall("sql command");this is to execute the command
//			CallableStatement cstmt = connection.prepareCall("{?=call function(args)}");this is to call the functions
			cs.registerOutParameter(2, Types.INTEGER);//in types we don't have int, Integer we have as in mysql we hav XintX[integer],bigint 
//			cs.setInt(1, 25);
			cs.setInt(1, 5);
			cs.execute();
			int result=cs.getInt(2);
			System.out.println("sqrt value = "+result);
			cs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
