package pojo;
// Generated Jan 27, 2017 10:39:58 AM by Hibernate Tools 5.2.0.CR1

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
 * FormularioItemOpcion generated by hbm2java
 */
@Entity
@Table(name = "formulario_item_opcion", catalog = "sigpro")
public class FormularioItemOpcion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2610028273412130513L;
	private Integer id;
	private FormularioItem formularioItem;
	private String etiqueta;
	private Integer valorEntero;
	private String valorString;
	private Date valorTiempo;
	private BigDecimal valorDecimal;
	private Integer estado;
	private String usuarioCreo;
	private Integer usuarioActualizacion;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public FormularioItemOpcion() {
	}

	public FormularioItemOpcion(FormularioItem formularioItem) {
		this.formularioItem = formularioItem;
	}

	public FormularioItemOpcion(FormularioItem formularioItem, String etiqueta, Integer valorEntero, String valorString,
			Date valorTiempo, BigDecimal valorDecimal, Integer estado, String usuarioCreo, Integer usuarioActualizacion,
			Date fechaCreacion, Date fechaActualizacion) {
		this.formularioItem = formularioItem;
		this.etiqueta = etiqueta;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorTiempo = valorTiempo;
		this.valorDecimal = valorDecimal;
		this.estado = estado;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizacion = usuarioActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
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
	@JoinColumn(name = "formulario_itemid", nullable = false)
	public FormularioItem getFormularioItem() {
		return this.formularioItem;
	}

	public void setFormularioItem(FormularioItem formularioItem) {
		this.formularioItem = formularioItem;
	}

	@Column(name = "etiqueta", length = 4000)
	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "valor_tiempo", length = 19)
	public Date getValorTiempo() {
		return this.valorTiempo;
	}

	public void setValorTiempo(Date valorTiempo) {
		this.valorTiempo = valorTiempo;
	}

	@Column(name = "valor_decimal", precision = 15)
	public BigDecimal getValorDecimal() {
		return this.valorDecimal;
	}

	public void setValorDecimal(BigDecimal valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	@Column(name = "estado")
	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Column(name = "usuario_creo", length = 30)
	public String getUsuarioCreo() {
		return this.usuarioCreo;
	}

	public void setUsuarioCreo(String usuarioCreo) {
		this.usuarioCreo = usuarioCreo;
	}

	@Column(name = "usuario_actualizacion")
	public Integer getUsuarioActualizacion() {
		return this.usuarioActualizacion;
	}

	public void setUsuarioActualizacion(Integer usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
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

}
