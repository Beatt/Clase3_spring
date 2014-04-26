package org.upiita.spring.daos.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.upiita.spring.daos.DatosUsuarioDAO;
import org.upiita.spring.entidades.DatosUsuario;

@Component("datosUsuarioDAO")
@Transactional
public class HibernateDatosUsuarioDAO implements DatosUsuarioDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void guardar(DatosUsuario datosUsuario){
		
		sessionFactory.getCurrentSession().save(datosUsuario);
	}
	
	@Override
	public DatosUsuario buscarPorId(Integer id){
		
		return (DatosUsuario) sessionFactory.getCurrentSession().get(DatosUsuario.class, id);
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
