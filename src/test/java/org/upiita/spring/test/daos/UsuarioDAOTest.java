package org.upiita.spring.test.daos;

//HACEMOS UN ESTATIC IMPORT!!
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.upiita.spring.daos.UsuarioDAO;
import org.upiita.spring.entidades.Usuario;


/*
 * LOS TEST DE JUNIT NO SE EJECUTAN EN ORDEN NO TIENE
 * 	GARANTIZADO NINGUN ORDEN
 */
public class UsuarioDAOTest {
	
	//TESTING PUEDE SER DE 2 TIPOS:
	//   -- UNIT TESTING  (TEST UNITARIO) => PARA PROBAR UN SOLO METODO
	
	//   -- TEST DE INTEGRACION  => es para BD Y PARA PRUEBAS COMPLEJAS
	
	private static UsuarioDAO usuarioDAO;	
	
	private static ApplicationContext contexto;	
	
	@BeforeClass //EJECUTA ESTE METODO ANTES DE CUALQUIER TEST
	             //SOLO LO EJECUTA UNA VEZ
	public static void inicializar() {
		
		//creamos el contexto de spring de pruebas
		contexto = new ClassPathXmlApplicationContext("/dao-context-testing.xml");		
		usuarioDAO = (UsuarioDAO) contexto.getBean("usuarioDAO");

		System.out.println("contexto de spring inicializado");
	}	
	
	@Test // ESTE ANNOTATION ES DE JUNIT (UN FRAMEWORK PARA TESTING)
	public void testCreaUsuario(){
		
		//CREARMOS UN USUARIO DE PRUEBAS
		Usuario usuario = new Usuario();
		//usuario.setId(3);
		usuario.setNombre("Usuario prueba");
		usuario.setEmail("prueba@email.com");
		usuario.setPassword("123");
		
		usuarioDAO.guardar(usuario);
		
		Usuario usuarioBD = usuarioDAO.buscarPorId(3);
		
		//CHECA QUE LA VARIABLE NO VENGA NULL
		//SI VIENEN NULL DETIENEN EL TESTING Y NOS INFORMA DEL ERROR
		//este metodo es junit
		assertNotNull(usuarioBD);
		
		//este metodo es de spring framework
		//Assert.notEmpty(new ArrayList());
		
	}
	
	@Test
	public void testMapeoUsuarioDatosUsuario() {
		
		Usuario usuario = usuarioDAO.buscarPorId(1);
		
		assertNotNull(usuario);
		
		assertNotNull(usuario.getDatosUsuario());
		
		System.out.println("Usuario " + usuario);
		System.out.println("datos usuario " + usuario.getDatosUsuario());
		
	}// Fin testMapeoUsuarioDatosUsuario
	
	@Test
	public void testMapeoUsuarioPosts() {
		
		Usuario usuario = usuarioDAO.buscarPorId(1);
		
		// No empty checa que la colección (List) no venga vacia
		// que traiga datos
		Assert.notEmpty(usuario.getPost());
		
		
	}
	
}




