package pojo;
// Generated Nov 20, 2017 4:56:36 PM by Hibernate Tools 5.2.3.Final

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
 * Riesgo generated by hbm2java
 */
@Entity
@Table(name = "riesgo", catalog = "sipro")
public class Riesgo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3267347443501897622L;
	private Integer id;
	private Colaborador colaborador;
	private RiesgoTipo riesgoTipo;
	private String nombre;
	private String descripcion;
	private BigDecimal impacto;
	private BigDecimal probabilidad;
	private BigDecimal impactoMonto;
	private BigDecimal impactoTiempo;
	private String gatillo;
	private String consecuencia;
	private String solucion;
	private String riesgosSegundarios;
	private int ejecutado;
	private Date fechaEjecucion;
	private String resultado;
	private String observaciones;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Set<ObjetoRiesgo> objetoRiesgos = new HashSet<ObjetoRiesgo>(0);
	private Set<RiesgoPropiedadValor> riesgoPropiedadValors = new HashSet<RiesgoPropiedadValor>(0);

	public Riesgo() {
	}

	public Riesgo(RiesgoTipo riesgoTipo, String nombre, BigDecimal impacto, BigDecimal probabilidad, int ejecutado,
			String usuarioCreo, Date fechaCreacion, int estado) {
		this.riesgoTipo = riesgoTipo;
		this.nombre = nombre;
		this.impacto = impacto;
		this.probabilidad = probabilidad;
		this.ejecutado = ejecutado;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public Riesgo(Colaborador colaborador, RiesgoTipo riesgoTipo, String nombre, String descripcion, BigDecimal impacto,
			BigDecimal probabilidad, BigDecimal impactoMonto, BigDecimal impactoTiempo, String gatillo,
			String consecuencia, String solucion, String riesgosSegundarios, int ejecutado, Date fechaEjecucion,
			String resultado, String observaciones, String usuarioCreo, String usuarioActualizo, Date fechaCreacion,
			Date fechaActualizacion, int estado, Set<ObjetoRiesgo> objetoRiesgos,
			Set<RiesgoPropiedadValor> riesgoPropiedadValors) {
		this.colaborador = colaborador;
		this.riesgoTipo = riesgoTipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.impacto = impacto;
		this.probabilidad = probabilidad;
		this.impactoMonto = impactoMonto;
		this.impactoTiempo = impactoTiempo;
		this.gatillo = gatillo;
		this.consecuencia = consecuencia;
		this.solucion = solucion;
		this.riesgosSegundarios = riesgosSegundarios;
		this.ejecutado = ejecutado;
		this.fechaEjecucion = fechaEjecucion;
		this.resultado = resultado;
		this.observaciones = observaciones;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.objetoRiesgos = objetoRiesgos;
		this.riesgoPropiedadValors = riesgoPropiedadValors;
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
	@JoinColumn(name = "colaboradorid")
	public Colaborador getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "riesgo_tipoid", nullable = false)
	public RiesgoTipo getRiesgoTipo() {
		return this.riesgoTipo;
	}

	public void setRiesgoTipo(RiesgoTipo riesgoTipo) {
		this.riesgoTipo = riesgoTipo;
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

	@Column(name = "impacto", nullable = false, precision = 3)
	public BigDecimal getImpacto() {
		return this.impacto;
	}

	public void setImpacto(BigDecimal impacto) {
		this.impacto = impacto;
	}

	@Column(name = "probabilidad", nullable = false, precision = 3)
	public BigDecimal getProbabilidad() {
		return this.probabilidad;
	}

	public void setProbabilidad(BigDecimal probabilidad) {
		this.probabilidad = probabilidad;
	}

	@Column(name = "impacto_monto", precision = 15)
	public BigDecimal getImpactoMonto() {
		return this.impactoMonto;
	}

	public void setImpactoMonto(BigDecimal impactoMonto) {
		this.impactoMonto = impactoMonto;
	}

	@Column(name = "impacto_tiempo", precision = 15)
	public BigDecimal getImpactoTiempo() {
		return this.impactoTiempo;
	}

	public void setImpactoTiempo(BigDecimal impactoTiempo) {
		this.impactoTiempo = impactoTiempo;
	}

	@Column(name = "gatillo", length = 1000)
	public String getGatillo() {
		return this.gatillo;
	}

	public void setGatillo(String gatillo) {
		this.gatillo = gatillo;
	}

	@Column(name = "consecuencia", length = 1000)
	public String getConsecuencia() {
		return this.consecuencia;
	}

	public void setConsecuencia(String consecuencia) {
		this.consecuencia = consecuencia;
	}

	@Column(name = "solucion", length = 1000)
	public String getSolucion() {
		return this.solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	@Column(name = "riesgos_segundarios", length = 1000)
	public String getRiesgosSegundarios() {
		return this.riesgosSegundarios;
	}

	public void setRiesgosSegundarios(String riesgosSegundarios) {
		this.riesgosSegundarios = riesgosSegundarios;
	}

	@Column(name = "ejecutado", nullable = false)
	public int getEjecutado() {
		return this.ejecutado;
	}

	public void setEjecutado(int ejecutado) {
		this.ejecutado = ejecutado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ejecucion", length = 19)
	public Date getFechaEjecucion() {
		return this.fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	@Column(name = "resultado", length = 1000)
	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Column(name = "observaciones", length = 1000)
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "riesgo")
	public Set<ObjetoRiesgo> getObjetoRiesgos() {
		return this.objetoRiesgos;
	}

	public void setObjetoRiesgos(Set<ObjetoRiesgo> objetoRiesgos) {
		this.objetoRiesgos = objetoRiesgos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "riesgo")
	public Set<RiesgoPropiedadValor> getRiesgoPropiedadValors() {
		return this.riesgoPropiedadValors;
	}

	public void setRiesgoPropiedadValors(Set<RiesgoPropiedadValor> riesgoPropiedadValors) {
		this.riesgoPropiedadValors = riesgoPropiedadValors;
	}

}
