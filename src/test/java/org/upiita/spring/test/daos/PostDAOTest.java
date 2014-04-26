package org.upiita.spring.test.daos;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostDAOTest {
	
	
	private static ApplicationContext contexto;	
	
	public static void inicializar() {

		contexto = new ClassPathXmlApplicationContext("/dao-context-testing.xml");	

		System.out.println("contexto de spring inicializado");
	}		
	
}
