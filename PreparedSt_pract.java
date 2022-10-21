package adv_java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedSt_pract {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// step1: load the drivers
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// step2: establishing connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/engg", "root", "root");
				// step3 prepare statement
				PreparedStatement ps = connection.prepareStatement("INSERT INTO student VALUES(?,?,?)");
				System.out.println("Enter student Id: ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter student name: ");
				ps.setString(2, sc.next());
				System.out.println("Enter student marks: ");
				ps.setInt(3, sc.nextInt());
				int n=ps.executeUpdate();
				if(n!=0){
					System.out.println("Successfully inserted...");
				}else{
					System.out.println("Not inserted! please try again...");
					}
					ps.close();
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
