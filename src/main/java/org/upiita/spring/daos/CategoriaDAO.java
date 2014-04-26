package org.upiita.spring.daos;

import org.upiita.spring.entidades.Categoria;

public interface CategoriaDAO {

	public abstract void guardar(Categoria entidad);

	public abstract Categoria buscarPorId(Integer id);

}