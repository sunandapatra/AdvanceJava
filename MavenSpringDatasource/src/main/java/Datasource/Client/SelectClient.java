package Datasource.Client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Datasource.Interface.SelectInterface;

public class SelectClient {
        public static void main(String args[]) {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Datasource/Application-config.xml");
			SelectInterface s=(SelectInterface)ctx.getBean("selectImple");
			System.out.println("First name is: "+s.fetchFirstName(2));
			System.out.println("Last salary is: "+s.fetchLastName(2));
        }
}

