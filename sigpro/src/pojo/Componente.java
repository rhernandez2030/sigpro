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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Componente generated by hbm2java
 */
@Entity
@Table(name = "componente", catalog = "sigpro")
public class Componente implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8367809323144567515L;
	private Integer id;
	private ComponenteTipo componenteTipo;
	private Proyecto proyecto;
	private String nombre;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<Meta> metas = new HashSet<Meta>(0);
	private Set<ObjetoFormulario> objetoFormularios = new HashSet<ObjetoFormulario>(0);
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<Riesgo> riesgos = new HashSet<Riesgo>(0);
	private Set<ComponentePropiedadValor> componentePropiedadValors = new HashSet<ComponentePropiedadValor>(0);
	private Set<FormularioItemValor> formularioItemValors = new HashSet<FormularioItemValor>(0);
	private Set<ObjetoRecurso> objetoRecursos = new HashSet<ObjetoRecurso>(0);

	public Componente() {
	}

	public Componente(ComponenteTipo componenteTipo, Proyecto proyecto, String nombre, String usuarioCreo,
			Date fechaCreacion, int estado) {
		this.componenteTipo = componenteTipo;
		this.proyecto = proyecto;
		this.nombre = nombre;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Componente(ComponenteTipo componenteTipo, Proyecto proyecto, String nombre, String descripcion,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado,
			Set<Meta> metas, Set<ObjetoFormulario> objetoFormularios, Set<Producto> productos, Set<Riesgo> riesgos,
			Set<ComponentePropiedadValor> componentePropiedadValors, Set<FormularioItemValor> formularioItemValors,
			Set<ObjetoRecurso> objetoRecursos) {
		this.componenteTipo = componenteTipo;
		this.proyecto = proyecto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.metas = metas;
		this.objetoFormularios = objetoFormularios;
		this.productos = productos;
		this.riesgos = riesgos;
		this.componentePropiedadValors = componentePropiedadValors;
		this.formularioItemValors = formularioItemValors;
		this.objetoRecursos = objetoRecursos;
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
	@JoinColumn(name = "componente_tipoid", nullable = false)
	public ComponenteTipo getComponenteTipo() {
		return this.componenteTipo;
	}

	public void setComponenteTipo(ComponenteTipo componenteTipo) {
		this.componenteTipo = componenteTipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyectoid", nullable = false)
	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<Meta> getMetas() {
		return this.metas;
	}

	public void setMetas(Set<Meta> metas) {
		this.metas = metas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<ObjetoFormulario> getObjetoFormularios() {
		return this.objetoFormularios;
	}

	public void setObjetoFormularios(Set<ObjetoFormulario> objetoFormularios) {
		this.objetoFormularios = objetoFormularios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<Riesgo> getRiesgos() {
		return this.riesgos;
	}

	public void setRiesgos(Set<Riesgo> riesgos) {
		this.riesgos = riesgos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<ComponentePropiedadValor> getComponentePropiedadValors() {
		return this.componentePropiedadValors;
	}

	public void setComponentePropiedadValors(Set<ComponentePropiedadValor> componentePropiedadValors) {
		this.componentePropiedadValors = componentePropiedadValors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<FormularioItemValor> getFormularioItemValors() {
		return this.formularioItemValors;
	}

	public void setFormularioItemValors(Set<FormularioItemValor> formularioItemValors) {
		this.formularioItemValors = formularioItemValors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "componente")
	public Set<ObjetoRecurso> getObjetoRecursos() {
		return this.objetoRecursos;
	}

	public void setObjetoRecursos(Set<ObjetoRecurso> objetoRecursos) {
		this.objetoRecursos = objetoRecursos;
	}

}
