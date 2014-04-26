package org.upiita.spring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.upiita.spring.daos.PostDAO;
import org.upiita.spring.daos.UsuarioDAO;
import org.upiita.spring.entidades.Post;
import org.upiita.spring.entidades.Usuario;

@Controller
public class BlogControlador {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PostDAO postDAO;
		
	//UNA EXPRESION REGULAR ES UN MECANISMO DE TODOS LENGUAJES
	//QUE LES PERMITE RECONOCER PATRONES EN CADENAS	
	// en {PARAMETRO:EXPRESION_REGULAR}
	@RequestMapping(value = "/usuario/{usuarioId:[0-9]+}")
	public String muestraUsuario(@PathVariable Integer usuarioId, Model modelo){
		
		Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
		modelo.addAttribute("usuario", usuario);
		
		return "usuario";
	}
	
	//--------------- SOLUCION EJERCICIO 1 -----------------
	//captura todas rutas de la forma
	// /post/1  o /post/2 etc ..
	@RequestMapping(value="/post/{postId:[0-9]+}")
	public String muestraPost(@PathVariable Integer postId, Model modelo){
		
		//4 TIP DEL LA SOLCUION DEL EJERCICIO
		Post post = postDAO.buscarPorId(postId);
		
		//5 tip, PASAR LOS DATOS A LA VISTA
		modelo.addAttribute("post", post);
		
		return "post";
	}
	
	@RequestMapping(value="/posts")
	public String muestraPosts(Model modelo){
		
		return "posts";
	}
		
}
