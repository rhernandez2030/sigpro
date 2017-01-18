package pojo;
// Generated Jan 18, 2017 10:47:45 AM by Hibernate Tools 5.2.0.CR1

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
 * PtipoPropiedad generated by hbm2java
 */
@Entity
@Table(name = "ptipo_propiedad", catalog = "sigpro")
public class PtipoPropiedad implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8204782662649910436L;
	private PtipoPropiedadId id;
	private ProyectoPropiedad proyectoPropiedad;
	private ProyectoTipo proyectoTipo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public PtipoPropiedad() {
	}

	public PtipoPropiedad(PtipoPropiedadId id, ProyectoPropiedad proyectoPropiedad, ProyectoTipo proyectoTipo,
			String usuarioCreo, Date fechaCreacion) {
		this.id = id;
		this.proyectoPropiedad = proyectoPropiedad;
		this.proyectoTipo = proyectoTipo;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public PtipoPropiedad(PtipoPropiedadId id, ProyectoPropiedad proyectoPropiedad, ProyectoTipo proyectoTipo,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, Integer estado) {
		this.id = id;
		this.proyectoPropiedad = proyectoPropiedad;
		this.proyectoTipo = proyectoTipo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "proyectoTipoid", column = @Column(name = "proyecto_tipoid", nullable = false)),
			@AttributeOverride(name = "proyectoPropiedadid", column = @Column(name = "proyecto_propiedadid", nullable = false)) })
	public PtipoPropiedadId getId() {
		return this.id;
	}

	public void setId(PtipoPropiedadId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto_propiedadid", nullable = false, insertable = false, updatable = false)
	public ProyectoPropiedad getProyectoPropiedad() {
		return this.proyectoPropiedad;
	}

	public void setProyectoPropiedad(ProyectoPropiedad proyectoPropiedad) {
		this.proyectoPropiedad = proyectoPropiedad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto_tipoid", nullable = false, insertable = false, updatable = false)
	public ProyectoTipo getProyectoTipo() {
		return this.proyectoTipo;
	}

	public void setProyectoTipo(ProyectoTipo proyectoTipo) {
		this.proyectoTipo = proyectoTipo;
	}

	@Column(name = "usuario_creo", nullable = false, length = 30)
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

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
