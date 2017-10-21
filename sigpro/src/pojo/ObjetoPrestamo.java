package pojo;
// Generated Oct 20, 2017 4:18:11 PM by Hibernate Tools 5.2.3.Final

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
 * ObjetoPrestamo generated by hbm2java
 */
@Entity
@Table(name = "objeto_prestamo", catalog = "sipro")
public class ObjetoPrestamo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1542174108033277370L;
	private ObjetoPrestamoId id;
	private Prestamo prestamo;
	private String usuarioCreo;
	private Integer usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public ObjetoPrestamo() {
	}

	public ObjetoPrestamo(ObjetoPrestamoId id, Prestamo prestamo) {
		this.id = id;
		this.prestamo = prestamo;
	}

	public ObjetoPrestamo(ObjetoPrestamoId id, Prestamo prestamo, String usuarioCreo, Integer usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion, Integer estado) {
		this.id = id;
		this.prestamo = prestamo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "prestamoid", column = @Column(name = "prestamoid", nullable = false)),
			@AttributeOverride(name = "objetoId", column = @Column(name = "objeto_id", nullable = false)),
			@AttributeOverride(name = "objetoTipo", column = @Column(name = "objeto_tipo", nullable = false)) })
	public ObjetoPrestamoId getId() {
		return this.id;
	}

	public void setId(ObjetoPrestamoId id) {
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

	@Column(name = "usuario_actualizo")
	public Integer getUsuarioActualizo() {
		return this.usuarioActualizo;
	}

	public void setUsuarioActualizo(Integer usuarioActualizo) {
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

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
