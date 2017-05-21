package jdbcTemplet.Client;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import jdbcTemplet.Interface.InterfaceTemplet;

public class ClientTemplet {
	public static void main(String args[]) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"Datasource/Templet-config.xml");
		InterfaceTemplet select = (InterfaceTemplet) ctx.getBean("db");
		
		  System.out.println("Employee count with Clerk disgnation is: " +select.getUserCount("Sunanda"));
		 
		Map m = select.getUserDetails(2);
		System.out.println("Details of Users: " + m.toString());

		
		  System.out.println("Clerk designation employees details are: ");
		  
		 List l = select.getUserDetails("Sunanda"); 
		 for (int i = 0; i < l.size(); i++) {
			 Map m1 = (Map) l.get(i);
			 System.out.println(m1.toString()); 
			 }
		 
		boolean bool = select.registerUser(15,"Alka","Sahu","alkasahu@gmail.com","alkasahu","alkasahu");
		System.out.println("User registered "+bool);
		bool = select.modifyAddress(3, "biswajitsahu@gmail.com");
		System.out.println("User Email updated "+bool);
		Thread.sleep(5000);
		bool = select.delUser(8);
		System.out.println("User deleted "+bool);
	}
}
