package pojo;
// Generated Nov 2, 2017 8:47:48 AM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ComponenteUsuario generated by hbm2java
 */
@Entity
@Table(name = "componente_usuario", catalog = "sipro")
public class ComponenteUsuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3789926856541419540L;
	private ComponenteUsuarioId id;
	private Componente componente;
	private Usuario usuario;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public ComponenteUsuario() {
	}

	public ComponenteUsuario(ComponenteUsuarioId id, Componente componente, Usuario usuario) {
		this.id = id;
		this.componente = componente;
		this.usuario = usuario;
	}

	public ComponenteUsuario(ComponenteUsuarioId id, Componente componente, Usuario usuario, String usuarioCreo,
			String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion) {
		this.id = id;
		this.componente = componente;
		this.usuario = usuario;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "componenteid", column = @Column(name = "componenteid", nullable = false)),
			@AttributeOverride(name = "usuario", column = @Column(name = "usuario", nullable = false, length = 30)) })
	public ComponenteUsuarioId getId() {
		return this.id;
	}

	public void setId(ComponenteUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "componenteid", nullable = false, insertable = false, updatable = false)
	public Componente getComponente() {
		return this.componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	@Column(name = "fecha_creacion", length = 19)
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

}
