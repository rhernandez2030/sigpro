package pojo;
// Generated Dec 1, 2017 6:08:23 PM by Hibernate Tools 5.2.3.Final

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
 * PlanAdquisicionPago generated by hbm2java
 */
@Entity
@Table(name = "plan_adquisicion_pago", catalog = "sipro")
public class PlanAdquisicionPago implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5880536820710783807L;
	private Integer id;
	private PlanAdquisicion planAdquisicion;
	private Date fechaPago;
	private BigDecimal pago;
	private String descripcion;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private Integer estado;

	public PlanAdquisicionPago() {
	}

	public PlanAdquisicionPago(PlanAdquisicion planAdquisicion, Date fechaPago, String descripcion, String usuarioCreo,
			Date fechaCreacion) {
		this.planAdquisicion = planAdquisicion;
		this.fechaPago = fechaPago;
		this.descripcion = descripcion;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public PlanAdquisicionPago(PlanAdquisicion planAdquisicion, Date fechaPago, BigDecimal pago, String descripcion,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, Integer estado) {
		this.planAdquisicion = planAdquisicion;
		this.fechaPago = fechaPago;
		this.pago = pago;
		this.descripcion = descripcion;
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
	@JoinColumn(name = "plan_adquisicionid", nullable = false)
	public PlanAdquisicion getPlanAdquisicion() {
		return this.planAdquisicion;
	}

	public void setPlanAdquisicion(PlanAdquisicion planAdquisicion) {
		this.planAdquisicion = planAdquisicion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_pago", nullable = false, length = 19)
	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Column(name = "pago", precision = 15)
	public BigDecimal getPago() {
		return this.pago;
	}

	public void setPago(BigDecimal pago) {
		this.pago = pago;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
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

}
