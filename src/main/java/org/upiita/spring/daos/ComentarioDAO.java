package org.upiita.spring.daos;

import org.upiita.spring.entidades.Comentario;

public interface ComentarioDAO {

	public abstract void guardar(Comentario entidad);

	public abstract Comentario buscarPorId(Integer id);

}