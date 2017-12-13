package pojo;
// Generated Dec 13, 2017 9:28:15 AM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InformePresupuesto generated by hbm2java
 */
@Entity
@Table(name = "informe_presupuesto", catalog = "sipro")
public class InformePresupuesto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059106346886531225L;
	private Integer id;
	private EstadoInforme estadoInforme;
	private int idPrestamo;
	private int objetoTipoId;
	private int objetoTipo;
	private Integer posicionArbol;
	private String objetoNombre;
	private int idPredecesor;
	private int objetoTipoPredecesor;
	private BigDecimal mes1;
	private BigDecimal mes2;
	private BigDecimal mes3;
	private BigDecimal mes4;
	private BigDecimal mes5;
	private BigDecimal mes6;
	private BigDecimal mes7;
	private BigDecimal mes8;
	private BigDecimal mes9;
	private BigDecimal mes10;
	private BigDecimal mes11;
	private BigDecimal mes12;
	private BigDecimal total;
	private Date anio;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public InformePresupuesto() {
	}

	public InformePresupuesto(int idPrestamo, int objetoTipoId, int objetoTipo, int idPredecesor,
			int objetoTipoPredecesor) {
		this.idPrestamo = idPrestamo;
		this.objetoTipoId = objetoTipoId;
		this.objetoTipo = objetoTipo;
		this.idPredecesor = idPredecesor;
		this.objetoTipoPredecesor = objetoTipoPredecesor;
	}

	public InformePresupuesto(EstadoInforme estadoInforme, int idPrestamo, int objetoTipoId, int objetoTipo,
			Integer posicionArbol, String objetoNombre, int idPredecesor, int objetoTipoPredecesor, BigDecimal mes1,
			BigDecimal mes2, BigDecimal mes3, BigDecimal mes4, BigDecimal mes5, BigDecimal mes6, BigDecimal mes7,
			BigDecimal mes8, BigDecimal mes9, BigDecimal mes10, BigDecimal mes11, BigDecimal mes12, BigDecimal total,
			Date anio, String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion,
			Integer estado) {
		this.estadoInforme = estadoInforme;
		this.idPrestamo = idPrestamo;
		this.objetoTipoId = objetoTipoId;
		this.objetoTipo = objetoTipo;
		this.posicionArbol = posicionArbol;
		this.objetoNombre = objetoNombre;
		this.idPredecesor = idPredecesor;
		this.objetoTipoPredecesor = objetoTipoPredecesor;
		this.mes1 = mes1;
		this.mes2 = mes2;
		this.mes3 = mes3;
		this.mes4 = mes4;
		this.mes5 = mes5;
		this.mes6 = mes6;
		this.mes7 = mes7;
		this.mes8 = mes8;
		this.mes9 = mes9;
		this.mes10 = mes10;
		this.mes11 = mes11;
		this.mes12 = mes12;
		this.total = total;
		this.anio = anio;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
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
	@JoinColumn(name = "tipo_presupuesto")
	public EstadoInforme getEstadoInforme() {
		return this.estadoInforme;
	}

	public void setEstadoInforme(EstadoInforme estadoInforme) {
		this.estadoInforme = estadoInforme;
	}

	@Column(name = "id_prestamo", nullable = false)
	public int getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	@Column(name = "objeto_tipo_id", nullable = false)
	public int getObjetoTipoId() {
		return this.objetoTipoId;
	}

	public void setObjetoTipoId(int objetoTipoId) {
		this.objetoTipoId = objetoTipoId;
	}

	@Column(name = "objeto_tipo", nullable = false)
	public int getObjetoTipo() {
		return this.objetoTipo;
	}

	public void setObjetoTipo(int objetoTipo) {
		this.objetoTipo = objetoTipo;
	}

	@Column(name = "posicion_arbol")
	public Integer getPosicionArbol() {
		return this.posicionArbol;
	}

	public void setPosicionArbol(Integer posicionArbol) {
		this.posicionArbol = posicionArbol;
	}

	@Column(name = "objeto_nombre", length = 1000)
	public String getObjetoNombre() {
		return this.objetoNombre;
	}

	public void setObjetoNombre(String objetoNombre) {
		this.objetoNombre = objetoNombre;
	}

	@Column(name = "id_predecesor", nullable = false)
	public int getIdPredecesor() {
		return this.idPredecesor;
	}

	public void setIdPredecesor(int idPredecesor) {
		this.idPredecesor = idPredecesor;
	}

	@Column(name = "objeto_tipo_predecesor", nullable = false)
	public int getObjetoTipoPredecesor() {
		return this.objetoTipoPredecesor;
	}

	public void setObjetoTipoPredecesor(int objetoTipoPredecesor) {
		this.objetoTipoPredecesor = objetoTipoPredecesor;
	}

	@Column(name = "mes1", precision = 11)
	public BigDecimal getMes1() {
		return this.mes1;
	}

	public void setMes1(BigDecimal mes1) {
		this.mes1 = mes1;
	}

	@Column(name = "mes2", precision = 11)
	public BigDecimal getMes2() {
		return this.mes2;
	}

	public void setMes2(BigDecimal mes2) {
		this.mes2 = mes2;
	}

	@Column(name = "mes3", precision = 11)
	public BigDecimal getMes3() {
		return this.mes3;
	}

	public void setMes3(BigDecimal mes3) {
		this.mes3 = mes3;
	}

	@Column(name = "mes4", precision = 11)
	public BigDecimal getMes4() {
		return this.mes4;
	}

	public void setMes4(BigDecimal mes4) {
		this.mes4 = mes4;
	}

	@Column(name = "mes5", precision = 11)
	public BigDecimal getMes5() {
		return this.mes5;
	}

	public void setMes5(BigDecimal mes5) {
		this.mes5 = mes5;
	}

	@Column(name = "mes6", precision = 11)
	public BigDecimal getMes6() {
		return this.mes6;
	}

	public void setMes6(BigDecimal mes6) {
		this.mes6 = mes6;
	}

	@Column(name = "mes7", precision = 11)
	public BigDecimal getMes7() {
		return this.mes7;
	}

	public void setMes7(BigDecimal mes7) {
		this.mes7 = mes7;
	}

	@Column(name = "mes8", precision = 11)
	public BigDecimal getMes8() {
		return this.mes8;
	}

	public void setMes8(BigDecimal mes8) {
		this.mes8 = mes8;
	}

	@Column(name = "mes9", precision = 11)
	public BigDecimal getMes9() {
		return this.mes9;
	}

	public void setMes9(BigDecimal mes9) {
		this.mes9 = mes9;
	}

	@Column(name = "mes10", precision = 11)
	public BigDecimal getMes10() {
		return this.mes10;
	}

	public void setMes10(BigDecimal mes10) {
		this.mes10 = mes10;
	}

	@Column(name = "mes11", precision = 11)
	public BigDecimal getMes11() {
		return this.mes11;
	}

	public void setMes11(BigDecimal mes11) {
		this.mes11 = mes11;
	}

	@Column(name = "mes12", precision = 11)
	public BigDecimal getMes12() {
		return this.mes12;
	}

	public void setMes12(BigDecimal mes12) {
		this.mes12 = mes12;
	}

	@Column(name = "total", precision = 11)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "anio", length = 19)
	public Date getAnio() {
		return this.anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	@Column(name = "usuario_creo", length = 30)
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
	@Column(name = "fecha_creacion", length = 19)
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
