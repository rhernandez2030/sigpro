package pojo;
// Generated Dec 27, 2016 7:02:33 PM by Hibernate Tools 5.2.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RiesgoPropiedad generated by hbm2java
 */
@Entity
@Table(name = "riesgo_propiedad", catalog = "sigpro")
public class RiesgoPropiedad implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7990409942326264041L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<RiesgoPropiedadValor> riesgoPropiedadValors = new HashSet<RiesgoPropiedadValor>(0);
	private Set<RtipoPropiedad> rtipoPropiedads = new HashSet<RtipoPropiedad>(0);

	public RiesgoPropiedad() {
	}

	public RiesgoPropiedad(String nombre, String usuarioCreo, Date fechaCreacion, int estado) {
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public RiesgoPropiedad(String nombre, String descripcion, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion, int estado, Set<RiesgoPropiedadValor> riesgoPropiedadValors,
			Set<RtipoPropiedad> rtipoPropiedads) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.riesgoPropiedadValors = riesgoPropiedadValors;
		this.rtipoPropiedads = rtipoPropiedads;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 1000)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 4000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "riesgoPropiedad")
	public Set<RiesgoPropiedadValor> getRiesgoPropiedadValors() {
		return this.riesgoPropiedadValors;
	}

	public void setRiesgoPropiedadValors(Set<RiesgoPropiedadValor> riesgoPropiedadValors) {
		this.riesgoPropiedadValors = riesgoPropiedadValors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "riesgoPropiedad")
	public Set<RtipoPropiedad> getRtipoPropiedads() {
		return this.rtipoPropiedads;
	}

	public void setRtipoPropiedads(Set<RtipoPropiedad> rtipoPropiedads) {
		this.rtipoPropiedads = rtipoPropiedads;
	}

}
