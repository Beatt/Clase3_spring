package org.upiita.spring.daos.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.upiita.spring.daos.ComentarioDAO;
import org.upiita.spring.entidades.Comentario;

@Component("comentarioDAO")
@Transactional
public class HibernateComentarioDAO implements ComentarioDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void guardar(Comentario entidad){
		
		sessionFactory.getCurrentSession().save(entidad);
	}
	
	@Override
	public Comentario buscarPorId(Integer id){
		
		return (Comentario) sessionFactory.getCurrentSession().get(Comentario.class, id);
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
