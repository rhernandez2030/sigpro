package pojo;
// Generated Sep 12, 2017 3:58:47 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Meta generated by hbm2java
 */
@Entity
@Table(name = "meta", catalog = "sipro")
public class Meta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8025612996827494277L;
	private Integer id;
	private DatoTipo datoTipo;
	private MetaTipo metaTipo;
	private MetaUnidadMedida metaUnidadMedida;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;
	private Integer objetoId;
	private Integer objetoTipo;
	private Set<MetaValor> metaValors = new HashSet<MetaValor>(0);

	public Meta() {
	}

	public Meta(DatoTipo datoTipo, MetaTipo metaTipo, MetaUnidadMedida metaUnidadMedida, String nombre,
			String usuarioCreo, Date fechaCreacion) {
		this.datoTipo = datoTipo;
		this.metaTipo = metaTipo;
		this.metaUnidadMedida = metaUnidadMedida;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public Meta(DatoTipo datoTipo, MetaTipo metaTipo, MetaUnidadMedida metaUnidadMedida, String nombre,
			String descripcion, String usuarioCreo, String usuarioActualizo, Date fechaCreacion,
			Date fechaActualizacion, Integer estado, Integer objetoId, Integer objetoTipo, Set<MetaValor> metaValors) {
		this.datoTipo = datoTipo;
		this.metaTipo = metaTipo;
		this.metaUnidadMedida = metaUnidadMedida;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.objetoId = objetoId;
		this.objetoTipo = objetoTipo;
		this.metaValors = metaValors;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dato_tipoid", nullable = false)
	public DatoTipo getDatoTipo() {
		return this.datoTipo;
	}

	public void setDatoTipo(DatoTipo datoTipo) {
		this.datoTipo = datoTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meta_tipoid", nullable = false)
	public MetaTipo getMetaTipo() {
		return this.metaTipo;
	}

	public void setMetaTipo(MetaTipo metaTipo) {
		this.metaTipo = metaTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meta_unidad_medidaid", nullable = false)
	public MetaUnidadMedida getMetaUnidadMedida() {
		return this.metaUnidadMedida;
	}

	public void setMetaUnidadMedida(MetaUnidadMedida metaUnidadMedida) {
		this.metaUnidadMedida = metaUnidadMedida;
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

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Column(name = "objeto_id")
	public Integer getObjetoId() {
		return this.objetoId;
	}

	public void setObjetoId(Integer objetoId) {
		this.objetoId = objetoId;
	}

	@Column(name = "objeto_tipo")
	public Integer getObjetoTipo() {
		return this.objetoTipo;
	}

	public void setObjetoTipo(Integer objetoTipo) {
		this.objetoTipo = objetoTipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meta")
	public Set<MetaValor> getMetaValors() {
		return this.metaValors;
	}

	public void setMetaValors(Set<MetaValor> metaValors) {
		this.metaValors = metaValors;
	}

}
