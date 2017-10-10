package pojo;
// Generated Oct 9, 2017 6:11:54 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
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

	private Integer id;
	private DatoTipo datoTipo;
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
	private Integer metaFinalEntero;
	private String metaFinalString;
	private BigDecimal metaFinalDecimal;
	private Date metaFinalFecha;
	private Set<MetaAvance> metaAvances = new HashSet<MetaAvance>(0);
	private Set<MetaPlanificado> metaPlanificados = new HashSet<MetaPlanificado>(0);

	public Meta() {
	}

	public Meta(DatoTipo datoTipo, MetaUnidadMedida metaUnidadMedida, String nombre, String usuarioCreo,
			Date fechaCreacion) {
		this.datoTipo = datoTipo;
		this.metaUnidadMedida = metaUnidadMedida;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public Meta(DatoTipo datoTipo, MetaUnidadMedida metaUnidadMedida, String nombre, String descripcion,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, Integer estado,
			Integer objetoId, Integer objetoTipo, Integer metaFinalEntero, String metaFinalString,
			BigDecimal metaFinalDecimal, Date metaFinalFecha, Set<MetaAvance> metaAvances,
			Set<MetaPlanificado> metaPlanificados) {
		this.datoTipo = datoTipo;
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
		this.metaFinalEntero = metaFinalEntero;
		this.metaFinalString = metaFinalString;
		this.metaFinalDecimal = metaFinalDecimal;
		this.metaFinalFecha = metaFinalFecha;
		this.metaAvances = metaAvances;
		this.metaPlanificados = metaPlanificados;
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

	@Column(name = "meta_final_entero")
	public Integer getMetaFinalEntero() {
		return this.metaFinalEntero;
	}

	public void setMetaFinalEntero(Integer metaFinalEntero) {
		this.metaFinalEntero = metaFinalEntero;
	}

	@Column(name = "meta_final_string", length = 65535)
	public String getMetaFinalString() {
		return this.metaFinalString;
	}

	public void setMetaFinalString(String metaFinalString) {
		this.metaFinalString = metaFinalString;
	}

	@Column(name = "meta_final_decimal", precision = 15)
	public BigDecimal getMetaFinalDecimal() {
		return this.metaFinalDecimal;
	}

	public void setMetaFinalDecimal(BigDecimal metaFinalDecimal) {
		this.metaFinalDecimal = metaFinalDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "meta_final_fecha", length = 19)
	public Date getMetaFinalFecha() {
		return this.metaFinalFecha;
	}

	public void setMetaFinalFecha(Date metaFinalFecha) {
		this.metaFinalFecha = metaFinalFecha;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meta")
	public Set<MetaAvance> getMetaAvances() {
		return this.metaAvances;
	}

	public void setMetaAvances(Set<MetaAvance> metaAvances) {
		this.metaAvances = metaAvances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "meta")
	public Set<MetaPlanificado> getMetaPlanificados() {
		return this.metaPlanificados;
	}

	public void setMetaPlanificados(Set<MetaPlanificado> metaPlanificados) {
		this.metaPlanificados = metaPlanificados;
	}

}
