package pojo;
// Generated Oct 18, 2017 5:58:56 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "sipro")
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3333491396502530358L;
	private String usuario;
	private String password;
	private String salt;
	private String email;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private int sistemaUsuario;
	private Set<Colaborador> colaboradors = new HashSet<Colaborador>(0);
	private Set<ProductoUsuario> productoUsuarios = new HashSet<ProductoUsuario>(0);
	private Set<ComponenteUsuario> componenteUsuarios = new HashSet<ComponenteUsuario>(0);
	private Set<UsuarioPermiso> usuarioPermisos = new HashSet<UsuarioPermiso>(0);
	private Set<ProyectoUsuario> proyectoUsuarios = new HashSet<ProyectoUsuario>(0);
	private Set<SubproductoUsuario> subproductoUsuarios = new HashSet<SubproductoUsuario>(0);

	public Usuario() {
	}

	public Usuario(String usuario, String password, String salt, String email, Date fechaCreacion, int estado,
			int sistemaUsuario) {
		this.usuario = usuario;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.sistemaUsuario = sistemaUsuario;
	}

	public Usuario(String usuario, String password, String salt, String email, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado, int sistemaUsuario,
			Set<Colaborador> colaboradors, Set<ProductoUsuario> productoUsuarios,
			Set<ComponenteUsuario> componenteUsuarios, Set<UsuarioPermiso> usuarioPermisos,
			Set<ProyectoUsuario> proyectoUsuarios, Set<SubproductoUsuario> subproductoUsuarios) {
		this.usuario = usuario;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.sistemaUsuario = sistemaUsuario;
		this.colaboradors = colaboradors;
		this.productoUsuarios = productoUsuarios;
		this.componenteUsuarios = componenteUsuarios;
		this.usuarioPermisos = usuarioPermisos;
		this.proyectoUsuarios = proyectoUsuarios;
		this.subproductoUsuarios = subproductoUsuarios;
	}

	@Id

	@Column(name = "usuario", unique = true, nullable = false, length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", nullable = false)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "usuario_creo", length = 30)
	public String getUsuarioCreo() {
		return this.usuarioCreo;
	}

	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	@Column(name = "usuario_actualizo", length = 30)
	public String getUsuarioActualizo() {
		return this.usuarioActualizo;
	}

	public void setUsuarioActualizo(String usuarioActualizo) {
		this.usuarioActualizo = usuarioActualizo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", length = 19)
	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "sistema_usuario", nullable = false)
	public int getSistemaUsuario() {
		return this.sistemaUsuario;
	}

	public void setSistemaUsuario(int sistemaUsuario) {
		this.sistemaUsuario = sistemaUsuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(Set<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<ProductoUsuario> getProductoUsuarios() {
		return this.productoUsuarios;
	}

	public void setProductoUsuarios(Set<ProductoUsuario> productoUsuarios) {
		this.productoUsuarios = productoUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<ComponenteUsuario> getComponenteUsuarios() {
		return this.componenteUsuarios;
	}

	public void setComponenteUsuarios(Set<ComponenteUsuario> componenteUsuarios) {
		this.componenteUsuarios = componenteUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UsuarioPermiso> getUsuarioPermisos() {
		return this.usuarioPermisos;
	}

	public void setUsuarioPermisos(Set<UsuarioPermiso> usuarioPermisos) {
		this.usuarioPermisos = usuarioPermisos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<ProyectoUsuario> getProyectoUsuarios() {
		return this.proyectoUsuarios;
	}

	public void setProyectoUsuarios(Set<ProyectoUsuario> proyectoUsuarios) {
		this.proyectoUsuarios = proyectoUsuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<SubproductoUsuario> getSubproductoUsuarios() {
		return this.subproductoUsuarios;
	}

	public void setSubproductoUsuarios(Set<SubproductoUsuario> subproductoUsuarios) {
		this.subproductoUsuarios = subproductoUsuarios;
	}

}
