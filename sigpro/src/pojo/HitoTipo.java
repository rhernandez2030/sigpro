package pojo;
// Generated Jan 24, 2017 3:13:19 PM by Hibernate Tools 5.2.0.CR1

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

/**
 * HitoTipo generated by hbm2java
 */
@Entity
@Table(name = "hito_tipo", catalog = "sigpro")
public class HitoTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4100089454630677181L;
	private Integer id;
	private DatoTipo datoTipo;
	private String nombre;
	private String descripcion;
	private int estado;
	private Set<Hito> hitos = new HashSet<Hito>(0);

	public HitoTipo() {
	}

	public HitoTipo(DatoTipo datoTipo, int estado) {
		this.datoTipo = datoTipo;
		this.estado = estado;
	}

	public HitoTipo(DatoTipo datoTipo, String nombre, String descripcion, int estado, Set<Hito> hitos) {
		this.datoTipo = datoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.hitos = hitos;
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

	@Column(name = "nombre", length = 1000)
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

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hitoTipo")
	public Set<Hito> getHitos() {
		return this.hitos;
	}

	public void setHitos(Set<Hito> hitos) {
		this.hitos = hitos;
	}

}
