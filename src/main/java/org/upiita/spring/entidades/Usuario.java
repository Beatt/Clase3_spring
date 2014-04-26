package org.upiita.spring.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "usuarios")
public class Usuario {
	
	@Id
	@Column(name = "id")
	
	/*
	 * El parametro name sirve solo para hibernate (JPA)
	 * sequenceName nombre real de la secuencia en la BD
	 */
	@SequenceGenerator(name="usuariosIdSeq", sequenceName="usuarios_id_seq",
			allocationSize = 1)
	
	// Este annotation es el que genera los numeros del id 
	 // lo genera usando @SequenceGenerator
	@GeneratedValue(generator = "usuariosIdSeq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	/*
	 * Algo imporntante ENTIDAD DUEÑA quien contiene la llave foreana (JPA)
	 */	
	// MAPEO BIDIRECCIONAL
	@OneToOne
	// LA ENTIDAD DUEÑA USA JOIN COLUMN
	//  Y EL ATRIBUTO NAME IGUAL AL NOMBRE DE LA COLUMNA DE SU RELACION
	@JoinColumn(name = "datos_autor_id")
	private DatosUsuario datosUsuario;
	
	
	/*
	 * Fecth permite cambiar la estrategia de carga de hibernate(JPA)
	 * EAGER carga prematuramente en memoria.
	 */
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Post> post;

	
	// override del metodo String para que esta clase se imprima bonito :)
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("{");
		builder.append("id:").append(this.id).append(",");		
		builder.append("nombre:").append(this.nombre).append(",");
		builder.append("email:").append(this.email).append(",");
		builder.append("password:").append(this.password);		
		builder.append("}");

		return builder.toString();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DatosUsuario getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(DatosUsuario datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}	

}
