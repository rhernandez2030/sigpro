package pojo;
// Generated Mar 1, 2017 5:54:17 PM by Hibernate Tools 5.2.1.Final

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
 * Subproducto generated by hbm2java
 */
@Entity
@Table(name = "subproducto", catalog = "sipro")
public class Subproducto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2065394514208110107L;
	private Integer id;
	private Producto producto;
	private SubproductoTipo subproductoTipo;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Integer snip;
	private Integer programa;
	private Integer subprograma;
	private Integer proyecto;
	private Integer actividad;
	private Integer obra;
	private Integer fuente;
	private Set<SubproductoPropiedadValor> subproductoPropiedadValors = new HashSet<SubproductoPropiedadValor>(0);
	private Set<SubproductoUsuario> subproductoUsuarios = new HashSet<SubproductoUsuario>(0);

	public Subproducto() {
	}

	public Subproducto(Producto producto, SubproductoTipo subproductoTipo, String nombre, String usuarioCreo,
			Date fechaCreacion, int estado) {
		this.producto = producto;
		this.subproductoTipo = subproductoTipo;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Subproducto(Producto producto, SubproductoTipo subproductoTipo, String nombre, String descripcion,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado,
			Integer snip, Integer programa, Integer subprograma, Integer proyecto, Integer actividad, Integer obra,
			Integer fuente, Set<SubproductoPropiedadValor> subproductoPropiedadValors,
			Set<SubproductoUsuario> subproductoUsuarios) {
		this.producto = producto;
		this.subproductoTipo = subproductoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.snip = snip;
		this.programa = programa;
		this.subprograma = subprograma;
		this.proyecto = proyecto;
		this.actividad = actividad;
		this.obra = obra;
		this.fuente = fuente;
		this.subproductoPropiedadValors = subproductoPropiedadValors;
		this.subproductoUsuarios = subproductoUsuarios;
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
	@JoinColumn(name = "productoid", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproducto_tipoid", nullable = false)
	public SubproductoTipo getSubproductoTipo() {
		return this.subproductoTipo;
	}

	public void setSubproductoTipo(SubproductoTipo subproductoTipo) {
		this.subproductoTipo = subproductoTipo;
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

	@Column(name = "snip")
	public Integer getSnip() {
		return this.snip;
	}

	public void setSnip(Integer snip) {
		this.snip = snip;
	}

	@Column(name = "programa")
	public Integer getPrograma() {
		return this.programa;
	}

	public void setPrograma(Integer programa) {
		this.programa = programa;
	}

	@Column(name = "subprograma")
	public Integer getSubprograma() {
		return this.subprograma;
	}

	public void setSubprograma(Integer subprograma) {
		this.subprograma = subprograma;
	}

	@Column(name = "proyecto")
	public Integer getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Integer proyecto) {
		this.proyecto = proyecto;
	}

	@Column(name = "actividad")
	public Integer getActividad() {
		return this.actividad;
	}

	public void setActividad(Integer actividad) {
		this.actividad = actividad;
	}

	@Column(name = "obra")
	public Integer getObra() {
		return this.obra;
	}

	public void setObra(Integer obra) {
		this.obra = obra;
	}

	@Column(name = "fuente")
	public Integer getFuente() {
		return this.fuente;
	}

	public void setFuente(Integer fuente) {
		this.fuente = fuente;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subproducto")
	public Set<SubproductoPropiedadValor> getSubproductoPropiedadValors() {
		return this.subproductoPropiedadValors;
	}

	public void setSubproductoPropiedadValors(Set<SubproductoPropiedadValor> subproductoPropiedadValors) {
		this.subproductoPropiedadValors = subproductoPropiedadValors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subproducto")
	public Set<SubproductoUsuario> getSubproductoUsuarios() {
		return this.subproductoUsuarios;
	}

	public void setSubproductoUsuarios(Set<SubproductoUsuario> subproductoUsuarios) {
		this.subproductoUsuarios = subproductoUsuarios;
	}

}