package org.upiita.spring.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "posts")
public class Post {

	@Id
	@SequenceGenerator(name="postIdSecuencia", sequenceName="post_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="postIdSecuencia")
	@Column(name = "id")	
	private Integer id;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "contenido")
	private String contenido;

	@Column(name = "fecha_creacion")
	private Date fechaCreacion;	
			
	@ManyToOne
	@JoinColumn(name = "usuario-id")
	private Usuario usuario;
	
	
	// override del metodo String para que esta clase se imprima bonito :)
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("{");
		builder.append("id:").append(this.id).append(",");
		builder.append("titulo:").append(this.titulo).append(",");
		builder.append("contenido:").append(this.contenido).append(",");
		builder.append("fechaCreacion:").append(this.fechaCreacion);			
		builder.append("}");

		return builder.toString();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
