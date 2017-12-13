package pojo;
// Generated Dec 13, 2017 9:28:15 AM by Hibernate Tools 5.2.3.Final

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
 * RolUnidadEjecutora generated by hbm2java
 */
@Entity
@Table(name = "rol_unidad_ejecutora", catalog = "sipro")
public class RolUnidadEjecutora implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8622941537041496076L;
	private Integer id;
	private String nombre;
	private int estado;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer rolPredeterminado;
	private Set<ProyectoRolColaborador> proyectoRolColaboradors = new HashSet<ProyectoRolColaborador>(0);

	public RolUnidadEjecutora() {
	}

	public RolUnidadEjecutora(String nombre, int estado, String usuarioCreo, Date fechaCreacion) {
		this.nombre = nombre;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public RolUnidadEjecutora(String nombre, int estado, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion, Integer rolPredeterminado,
			Set<ProyectoRolColaborador> proyectoRolColaboradors) {
		this.nombre = nombre;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.rolPredeterminado = rolPredeterminado;
		this.proyectoRolColaboradors = proyectoRolColaboradors;
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

	@Column(name = "nombre", nullable = false, length = 500)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	@Column(name = "rol_predeterminado")
	public Integer getRolPredeterminado() {
		return this.rolPredeterminado;
	}

	public void setRolPredeterminado(Integer rolPredeterminado) {
		this.rolPredeterminado = rolPredeterminado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rolUnidadEjecutora")
	public Set<ProyectoRolColaborador> getProyectoRolColaboradors() {
		return this.proyectoRolColaboradors;
	}

	public void setProyectoRolColaboradors(Set<ProyectoRolColaborador> proyectoRolColaboradors) {
		this.proyectoRolColaboradors = proyectoRolColaboradors;
	}

}
