package pojo;
// Generated Dec 20, 2017 3:43:57 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * UnidadEjecutora generated by hbm2java
 */
@Entity
@Table(name = "unidad_ejecutora", catalog = "sipro")
public class UnidadEjecutora implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7892088800518473517L;
	private UnidadEjecutoraId id;
	private Entidad entidad;
	private String nombre;
	private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);
	private Set<Colaborador> colaboradors = new HashSet<Colaborador>(0);
	private Set<Subproducto> subproductos = new HashSet<Subproducto>(0);
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<Prestamo> prestamos = new HashSet<Prestamo>(0);
	private Set<Subcomponente> subcomponentes = new HashSet<Subcomponente>(0);
	private Set<Componente> componentes = new HashSet<Componente>(0);

	public UnidadEjecutora() {
	}

	public UnidadEjecutora(UnidadEjecutoraId id, Entidad entidad, String nombre) {
		this.id = id;
		this.entidad = entidad;
		this.nombre = nombre;
	}

	public UnidadEjecutora(UnidadEjecutoraId id, Entidad entidad, String nombre, Set<Proyecto> proyectos,
			Set<Colaborador> colaboradors, Set<Subproducto> subproductos, Set<Producto> productos,
			Set<Prestamo> prestamos, Set<Subcomponente> subcomponentes, Set<Componente> componentes) {
		this.id = id;
		this.entidad = entidad;
		this.nombre = nombre;
		this.proyectos = proyectos;
		this.colaboradors = colaboradors;
		this.subproductos = subproductos;
		this.productos = productos;
		this.prestamos = prestamos;
		this.subcomponentes = subcomponentes;
		this.componentes = componentes;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "unidadEjecutora", column = @Column(name = "unidad_ejecutora", nullable = false)),
			@AttributeOverride(name = "entidadentidad", column = @Column(name = "entidadentidad", nullable = false)),
			@AttributeOverride(name = "ejercicio", column = @Column(name = "ejercicio", nullable = false)) })
	public UnidadEjecutoraId getId() {
		return this.id;
	}

	public void setId(UnidadEjecutoraId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "entidadentidad", referencedColumnName = "entidad", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ejercicio", referencedColumnName = "ejercicio", nullable = false, insertable = false, updatable = false) })
	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	@Column(name = "nombre", nullable = false, length = 1000)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(Set<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Subproducto> getSubproductos() {
		return this.subproductos;
	}

	public void setSubproductos(Set<Subproducto> subproductos) {
		this.subproductos = subproductos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Subcomponente> getSubcomponentes() {
		return this.subcomponentes;
	}

	public void setSubcomponentes(Set<Subcomponente> subcomponentes) {
		this.subcomponentes = subcomponentes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadEjecutora")
	public Set<Componente> getComponentes() {
		return this.componentes;
	}

	public void setComponentes(Set<Componente> componentes) {
		this.componentes = componentes;
	}

}
