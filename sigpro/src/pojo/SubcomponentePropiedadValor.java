package pojo;
// Generated Oct 31, 2017 11:02:39 AM by Hibernate Tools 5.2.3.Final

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
 * SubcomponentePropiedadValor generated by hbm2java
 */
@Entity
@Table(name = "subcomponente_propiedad_valor", catalog = "sipro")
public class SubcomponentePropiedadValor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8886487794905853658L;
	private SubcomponentePropiedadValorId id;
	private Subcomponente subcomponente;
	private SubcomponentePropiedad subcomponentePropiedad;
	private String valorString;
	private Integer valorEntero;
	private BigDecimal valorDecimal;
	private Date valorTiempo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public SubcomponentePropiedadValor() {
	}

	public SubcomponentePropiedadValor(SubcomponentePropiedadValorId id, Subcomponente subcomponente,
			SubcomponentePropiedad subcomponentePropiedad, String usuarioCreo, Date fechaCreacion) {
		this.id = id;
		this.subcomponente = subcomponente;
		this.subcomponentePropiedad = subcomponentePropiedad;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
	}

	public SubcomponentePropiedadValor(SubcomponentePropiedadValorId id, Subcomponente subcomponente,
			SubcomponentePropiedad subcomponentePropiedad, String valorString, Integer valorEntero,
			BigDecimal valorDecimal, Date valorTiempo, String usuarioCreo, String usuarioActualizo, Date fechaCreacion,
			Date fechaActualizacion) {
		this.id = id;
		this.subcomponente = subcomponente;
		this.subcomponentePropiedad = subcomponentePropiedad;
		this.valorString = valorString;
		this.valorEntero = valorEntero;
		this.valorDecimal = valorDecimal;
		this.valorTiempo = valorTiempo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "subcomponenteid", column = @Column(name = "subcomponenteid", nullable = false)),
			@AttributeOverride(name = "subcomponentePropiedadid", column = @Column(name = "subcomponente_propiedadid", nullable = false)) })
	public SubcomponentePropiedadValorId getId() {
		return this.id;
	}

	public void setId(SubcomponentePropiedadValorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcomponenteid", nullable = false, insertable = false, updatable = false)
	public Subcomponente getSubcomponente() {
		return this.subcomponente;
	}

	public void setSubcomponente(Subcomponente subcomponente) {
		this.subcomponente = subcomponente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subcomponente_propiedadid", nullable = false, insertable = false, updatable = false)
	public SubcomponentePropiedad getSubcomponentePropiedad() {
		return this.subcomponentePropiedad;
	}

	public void setSubcomponentePropiedad(SubcomponentePropiedad subcomponentePropiedad) {
		this.subcomponentePropiedad = subcomponentePropiedad;
	}

	@Column(name = "valor_string", length = 4000)
	public String getValorString() {
		return this.valorString;
	}

	public void setValorString(String valorString) {
		this.valorString = valorString;
	}

	@Column(name = "valor_entero")
	public Integer getValorEntero() {
		return this.valorEntero;
	}

	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
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
