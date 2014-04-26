package org.upiita.spring.daos;

import org.upiita.spring.entidades.DatosUsuario;

public interface DatosUsuarioDAO {

	public abstract void guardar(DatosUsuario autor);

	public abstract DatosUsuario buscarPorId(Integer autorId);

}