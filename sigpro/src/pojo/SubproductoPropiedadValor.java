package pojo;
// Generated Jul 13, 2017 10:05:07 AM by Hibernate Tools 5.2.3.Final

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
 * SubproductoPropiedadValor generated by hbm2java
 */
@Entity
@Table(name = "subproducto_propiedad_valor", catalog = "sipro")
public class SubproductoPropiedadValor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7661492997868961192L;
	private SubproductoPropiedadValorId id;
	private Subproducto subproducto;
	private SubproductoPropiedad subproductoPropiedad;
	private Integer valorEntero;
	private String valorString;
	private BigDecimal valorDecimal;
	private Date valorTiempo;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;

	public SubproductoPropiedadValor() {
	}

	public SubproductoPropiedadValor(SubproductoPropiedadValorId id, Subproducto subproducto,
			SubproductoPropiedad subproductoPropiedad, String usuarioCreo, Date fechaCreacion, int estado) {
		this.id = id;
		this.subproducto = subproducto;
		this.subproductoPropiedad = subproductoPropiedad;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public SubproductoPropiedadValor(SubproductoPropiedadValorId id, Subproducto subproducto,
			SubproductoPropiedad subproductoPropiedad, Integer valorEntero, String valorString, BigDecimal valorDecimal,
			Date valorTiempo, String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion,
			int estado) {
		this.id = id;
		this.subproducto = subproducto;
		this.subproductoPropiedad = subproductoPropiedad;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorDecimal = valorDecimal;
		this.valorTiempo = valorTiempo;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "subproductoid", column = @Column(name = "subproductoid", nullable = false)),
			@AttributeOverride(name = "subproductoPropiedadid", column = @Column(name = "subproducto_propiedadid", nullable = false)) })
	public SubproductoPropiedadValorId getId() {
		return this.id;
	}

	public void setId(SubproductoPropiedadValorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproductoid", nullable = false, insertable = false, updatable = false)
	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproducto_propiedadid", nullable = false, insertable = false, updatable = false)
	public SubproductoPropiedad getSubproductoPropiedad() {
		return this.subproductoPropiedad;
	}

	public void setSubproductoPropiedad(SubproductoPropiedad subproductoPropiedad) {
		this.subproductoPropiedad = subproductoPropiedad;
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

}
