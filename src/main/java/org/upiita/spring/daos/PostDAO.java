package org.upiita.spring.daos;

import java.util.List;

import org.upiita.spring.entidades.Post;

public interface PostDAO {

	public abstract void guardar(Post entidad);

	public abstract Post buscarPorId(Integer id);

	public abstract List<Post> obtenerTodos();

}