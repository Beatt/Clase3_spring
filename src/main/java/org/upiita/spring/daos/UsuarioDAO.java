package org.upiita.spring.daos;

import org.upiita.spring.entidades.Usuario;

public interface UsuarioDAO {

	public abstract void guardar(Usuario autor);

	public abstract Usuario buscarPorId(Integer autorId);

	public abstract Usuario buscarPorNombreYPassword(String nombre,String password);

	public abstract Usuario buscaPorNombre(String nombre);

}