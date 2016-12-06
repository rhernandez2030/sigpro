package pojo;
// Generated Dec 5, 2016 7:40:54 PM by Hibernate Tools 5.2.0.Beta1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RiesgoPropiedadValor generated by hbm2java
 */
@Entity
@Table(name = "riesgo_propiedad_valor", catalog = "sigpro")
public class RiesgoPropiedadValor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5915920762898323341L;
	private RiesgoPropiedadValorId id;
	private Riesgo riesgo;
	private RiesgoPropiedad riesgoPropiedad;
	private Integer valorEntero;
	private String valorString;
	private BigDecimal valorDecimal;
	private Date valorTiempo;
	private int estado;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public RiesgoPropiedadValor() {
	}

	public RiesgoPropiedadValor(RiesgoPropiedadValorId id, Riesgo riesgo, RiesgoPropiedad riesgoPropiedad, int estado,
			String usuarioCreo, Date fechaCreacion) {
		this.id = id;
		this.riesgo = riesgo;
		this.riesgoPropiedad = riesgoPropiedad;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public RiesgoPropiedadValor(RiesgoPropiedadValorId id, Riesgo riesgo, RiesgoPropiedad riesgoPropiedad,
			Integer valorEntero, String valorString, BigDecimal valorDecimal, Date valorTiempo, int estado,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion) {
		this.id = id;
		this.riesgo = riesgo;
		this.riesgoPropiedad = riesgoPropiedad;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorDecimal = valorDecimal;
		this.valorTiempo = valorTiempo;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "riesgoid", column = @Column(name = "riesgoid", nullable = false)),
			@AttributeOverride(name = "riesgoPropiedadid", column = @Column(name = "riesgo_propiedadid", nullable = false)) })
	public RiesgoPropiedadValorId getId() {
		return this.id;
	}

	public void setId(RiesgoPropiedadValorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "riesgoid", nullable = false, insertable = false, updatable = false)
	public Riesgo getRiesgo() {
		return this.riesgo;
	}

	public void setRiesgo(Riesgo riesgo) {
		this.riesgo = riesgo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "riesgo_propiedadid", nullable = false, insertable = false, updatable = false)
	public RiesgoPropiedad getRiesgoPropiedad() {
		return this.riesgoPropiedad;
	}

	public void setRiesgoPropiedad(RiesgoPropiedad riesgoPropiedad) {
		this.riesgoPropiedad = riesgoPropiedad;
	}

	@Column(name = "valor_entero")
	public Integer getValorEntero() {
		return this.valorEntero;
	}

	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}

	@Column(name = "valor_string", length = 4000)
	public String getValorString() {
		return this.valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	@Column(name = "valor_decimal", precision = 15)
	public BigDecimal getValorDecimal() {
		return this.valorDecimal;
	}

	public void setValorDecimal(BigDecimal valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valor_tiempo", length = 19)
	public Date getValorTiempo() {
		return this.valorTiempo;
	}

	public void setValorTiempo(Date valorTiempo) {
		this.valorTiempo = valorTiempo;
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

}
