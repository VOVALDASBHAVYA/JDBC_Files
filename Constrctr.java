package adv_java_jdbc;

import java.util.Properties;

public class Constrctr {
	static String s;
	Constrctr(){
		System.out.println("default constructor");
//		return ;the purpose of using return is for ????
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Constrctr();
		Constrctr con=new Constrctr();
//		System.out.println(con.s);
//		Properties(); 

	}

}
