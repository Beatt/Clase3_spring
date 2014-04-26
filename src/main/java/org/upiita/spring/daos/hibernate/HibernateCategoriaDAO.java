package org.upiita.spring.daos.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.upiita.spring.daos.CategoriaDAO;
import org.upiita.spring.entidades.Categoria;

@Component("categoriaDAO")
@Transactional
public class HibernateCategoriaDAO implements CategoriaDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void guardar(Categoria entidad){
		
		sessionFactory.getCurrentSession().save(entidad);
	}
	
	@Override
	public Categoria buscarPorId(Integer id){
		
		Categoria categoria = (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, id);
		
		return categoria;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
