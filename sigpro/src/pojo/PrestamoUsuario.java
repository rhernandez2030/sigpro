package pojo;
// Generated Nov 2, 2017 6:40:52 PM by Hibernate Tools 5.2.3.Final

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
 * PrestamoUsuario generated by hbm2java
 */
@Entity
@Table(name = "prestamo_usuario", catalog = "sipro")
public class PrestamoUsuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2197213712057589121L;
	private PrestamoUsuarioId id;
	private Prestamo prestamo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public PrestamoUsuario() {
	}

	public PrestamoUsuario(PrestamoUsuarioId id, Prestamo prestamo) {
		this.id = id;
		this.prestamo = prestamo;
	}

	public PrestamoUsuario(PrestamoUsuarioId id, Prestamo prestamo, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion) {
		this.id = id;
		this.prestamo = prestamo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "prestamoid", column = @Column(name = "prestamoid", nullable = false)),
			@AttributeOverride(name = "usuario", column = @Column(name = "usuario", nullable = false, length = 30)) })
	public PrestamoUsuarioId getId() {
		return this.id;
	}

	public void setId(PrestamoUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prestamoid", nullable = false, insertable = false, updatable = false)
	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
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
