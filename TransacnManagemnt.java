package adv_java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransacnManagemnt {

	public static void main(String[] args) {
		//step1: loading the drivers
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//		step2: establishing connection
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/engg","root","root");
			connection.setAutoCommit(false);
//		step3: preparing statement
			Statement st=connection.createStatement();
//		step4: executing the query
			int n=st.executeUpdate("INSERT INTO STUDENT VALUES(1002,'Vovaldas',100)");
			int m=st.executeUpdate("INSERT INTO STUDENT VALUES(1000,'Bha',98)");
			if(n!=0){
				System.out.println("Successfully inserted...");
			}else{
				System.out.println("Not inserted, try to insert again...");
				}
			Savepoint beforeDeleteSavePoint=connection.setSavepoint();
			st.executeUpdate("DELETE FROM STUDENT WHERE SID=1000");
//			ResultSet rs=st.executeQuery("DELETE FROM STUDENT WHERE SID=1000");
//			while(rs.next()){
//				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
//			}
			connection.rollback(beforeDeleteSavePoint);
//			connection.rollback();
			connection.commit();
//		step5: close the statement and connection
			st.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
