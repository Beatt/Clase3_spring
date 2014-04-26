package org.upiita.spring.daos.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.upiita.spring.daos.PostDAO;
import org.upiita.spring.entidades.Post;

@Component("postDAO")
@Transactional
public class HibernatePostDAO implements PostDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void guardar(Post entidad){
		
		sessionFactory.getCurrentSession().save(entidad);
	}
	
	@Override
	public Post buscarPorId(Integer id){
		
		Post post =  (Post) sessionFactory.getCurrentSession().get(Post.class, id);
		
		return post;
	}	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Post> obtenerTodos() {
		
		return null;
	}

}
