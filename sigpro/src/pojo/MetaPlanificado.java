package pojo;
// Generated Oct 20, 2017 7:34:40 PM by Hibernate Tools 5.2.3.Final

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
 * MetaPlanificado generated by hbm2java
 */
@Entity
@Table(name = "meta_planificado", catalog = "sipro")
public class MetaPlanificado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7188695219643137480L;
	private MetaPlanificadoId id;
	private Meta meta;
	private Integer eneroEntero;
	private String eneroString;
	private BigDecimal eneroDecimal;
	private Date eneroTiempo;
	private Integer febreroEntero;
	private String febreroString;
	private BigDecimal febreroDecimal;
	private Date febreroTiempo;
	private Integer marzoEntero;
	private String marzoString;
	private BigDecimal marzoDecimal;
	private Date marzoTiempo;
	private Integer abrilEntero;
	private String abrilString;
	private BigDecimal abrilDecimal;
	private Date abrilTiempo;
	private Integer mayoEntero;
	private String mayoString;
	private BigDecimal mayoDecimal;
	private Date mayoTiempo;
	private Integer junioEntero;
	private String junioString;
	private BigDecimal junioDecimal;
	private Date junioTiempo;
	private Integer julioEntero;
	private String julioString;
	private BigDecimal julioDecimal;
	private Date julioTiempo;
	private Integer agostoEntero;
	private String agostoString;
	private BigDecimal agostoDecimal;
	private Date agostoTiempo;
	private Integer septiembreEntero;
	private String septiembreString;
	private BigDecimal septiembreDecimal;
	private Date septiembreTiempo;
	private Integer octubreEntero;
	private String octubreString;
	private BigDecimal octubreDecimal;
	private Date octubreTiempo;
	private Integer noviembreEntero;
	private String noviembreString;
	private BigDecimal noviembreDecimal;
	private Date noviembreTiempo;
	private Integer diciembreEntero;
	private String diciembreString;
	private BigDecimal diciembreDecimal;
	private Date diciembreTiempo;
	private int estado;
	private String usuario;
	private Date fechaIngreso;

	public MetaPlanificado() {
	}

	public MetaPlanificado(MetaPlanificadoId id, Meta meta, int estado, String usuario, Date fechaIngreso) {
		this.id = id;
		this.meta = meta;
		this.estado = estado;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
	}

	public MetaPlanificado(MetaPlanificadoId id, Meta meta, Integer eneroEntero, String eneroString,
			BigDecimal eneroDecimal, Date eneroTiempo, Integer febreroEntero, String febreroString,
			BigDecimal febreroDecimal, Date febreroTiempo, Integer marzoEntero, String marzoString,
			BigDecimal marzoDecimal, Date marzoTiempo, Integer abrilEntero, String abrilString, BigDecimal abrilDecimal,
			Date abrilTiempo, Integer mayoEntero, String mayoString, BigDecimal mayoDecimal, Date mayoTiempo,
			Integer junioEntero, String junioString, BigDecimal junioDecimal, Date junioTiempo, Integer julioEntero,
			String julioString, BigDecimal julioDecimal, Date julioTiempo, Integer agostoEntero, String agostoString,
			BigDecimal agostoDecimal, Date agostoTiempo, Integer septiembreEntero, String septiembreString,
			BigDecimal septiembreDecimal, Date septiembreTiempo, Integer octubreEntero, String octubreString,
			BigDecimal octubreDecimal, Date octubreTiempo, Integer noviembreEntero, String noviembreString,
			BigDecimal noviembreDecimal, Date noviembreTiempo, Integer diciembreEntero, String diciembreString,
			BigDecimal diciembreDecimal, Date diciembreTiempo, int estado, String usuario, Date fechaIngreso) {
		this.id = id;
		this.meta = meta;
		this.eneroEntero = eneroEntero;
		this.eneroString = eneroString;
		this.eneroDecimal = eneroDecimal;
		this.eneroTiempo = eneroTiempo;
		this.febreroEntero = febreroEntero;
		this.febreroString = febreroString;
		this.febreroDecimal = febreroDecimal;
		this.febreroTiempo = febreroTiempo;
		this.marzoEntero = marzoEntero;
		this.marzoString = marzoString;
		this.marzoDecimal = marzoDecimal;
		this.marzoTiempo = marzoTiempo;
		this.abrilEntero = abrilEntero;
		this.abrilString = abrilString;
		this.abrilDecimal = abrilDecimal;
		this.abrilTiempo = abrilTiempo;
		this.mayoEntero = mayoEntero;
		this.mayoString = mayoString;
		this.mayoDecimal = mayoDecimal;
		this.mayoTiempo = mayoTiempo;
		this.junioEntero = junioEntero;
		this.junioString = junioString;
		this.junioDecimal = junioDecimal;
		this.junioTiempo = junioTiempo;
		this.julioEntero = julioEntero;
		this.julioString = julioString;
		this.julioDecimal = julioDecimal;
		this.julioTiempo = julioTiempo;
		this.agostoEntero = agostoEntero;
		this.agostoString = agostoString;
		this.agostoDecimal = agostoDecimal;
		this.agostoTiempo = agostoTiempo;
		this.septiembreEntero = septiembreEntero;
		this.septiembreString = septiembreString;
		this.septiembreDecimal = septiembreDecimal;
		this.septiembreTiempo = septiembreTiempo;
		this.octubreEntero = octubreEntero;
		this.octubreString = octubreString;
		this.octubreDecimal = octubreDecimal;
		this.octubreTiempo = octubreTiempo;
		this.noviembreEntero = noviembreEntero;
		this.noviembreString = noviembreString;
		this.noviembreDecimal = noviembreDecimal;
		this.noviembreTiempo = noviembreTiempo;
		this.diciembreEntero = diciembreEntero;
		this.diciembreString = diciembreString;
		this.diciembreDecimal = diciembreDecimal;
		this.diciembreTiempo = diciembreTiempo;
		this.estado = estado;
		this.usuario = usuario;
		this.fechaIngreso = fechaIngreso;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "metaid", column = @Column(name = "metaid", nullable = false)),
			@AttributeOverride(name = "ejercicio", column = @Column(name = "ejercicio", nullable = false)) })
	public MetaPlanificadoId getId() {
		return this.id;
	}

	public void setId(MetaPlanificadoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "metaid", nullable = false, insertable = false, updatable = false)
	public Meta getMeta() {
		return this.meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@Column(name = "enero_entero")
	public Integer getEneroEntero() {
		return this.eneroEntero;
	}

	public void setEneroEntero(Integer eneroEntero) {
		this.eneroEntero = eneroEntero;
	}

	@Column(name = "enero_string", length = 65535)
	public String getEneroString() {
		return this.eneroString;
	}

	public void setEneroString(String eneroString) {
		this.eneroString = eneroString;
	}

	@Column(name = "enero_decimal", precision = 15)
	public BigDecimal getEneroDecimal() {
		return this.eneroDecimal;
	}

	public void setEneroDecimal(BigDecimal eneroDecimal) {
		this.eneroDecimal = eneroDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enero_tiempo", length = 19)
	public Date getEneroTiempo() {
		return this.eneroTiempo;
	}

	public void setEneroTiempo(Date eneroTiempo) {
		this.eneroTiempo = eneroTiempo;
	}

	@Column(name = "febrero_entero")
	public Integer getFebreroEntero() {
		return this.febreroEntero;
	}

	public void setFebreroEntero(Integer febreroEntero) {
		this.febreroEntero = febreroEntero;
	}

	@Column(name = "febrero_string", length = 65535)
	public String getFebreroString() {
		return this.febreroString;
	}

	public void setFebreroString(String febreroString) {
		this.febreroString = febreroString;
	}

	@Column(name = "febrero_decimal", precision = 15)
	public BigDecimal getFebreroDecimal() {
		return this.febreroDecimal;
	}

	public void setFebreroDecimal(BigDecimal febreroDecimal) {
		this.febreroDecimal = febreroDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "febrero_tiempo", length = 19)
	public Date getFebreroTiempo() {
		return this.febreroTiempo;
	}

	public void setFebreroTiempo(Date febreroTiempo) {
		this.febreroTiempo = febreroTiempo;
	}

	@Column(name = "marzo_entero")
	public Integer getMarzoEntero() {
		return this.marzoEntero;
	}

	public void setMarzoEntero(Integer marzoEntero) {
		this.marzoEntero = marzoEntero;
	}

	@Column(name = "marzo_string", length = 65535)
	public String getMarzoString() {
		return this.marzoString;
	}

	public void setMarzoString(String marzoString) {
		this.marzoString = marzoString;
	}

	@Column(name = "marzo_decimal", precision = 15)
	public BigDecimal getMarzoDecimal() {
		return this.marzoDecimal;
	}

	public void setMarzoDecimal(BigDecimal marzoDecimal) {
		this.marzoDecimal = marzoDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "marzo_tiempo", length = 19)
	public Date getMarzoTiempo() {
		return this.marzoTiempo;
	}

	public void setMarzoTiempo(Date marzoTiempo) {
		this.marzoTiempo = marzoTiempo;
	}

	@Column(name = "abril_entero")
	public Integer getAbrilEntero() {
		return this.abrilEntero;
	}

	public void setAbrilEntero(Integer abrilEntero) {
		this.abrilEntero = abrilEntero;
	}

	@Column(name = "abril_string", length = 65535)
	public String getAbrilString() {
		return this.abrilString;
	}

	public void setAbrilString(String abrilString) {
		this.abrilString = abrilString;
	}

	@Column(name = "abril_decimal", precision = 15)
	public BigDecimal getAbrilDecimal() {
		return this.abrilDecimal;
	}

	public void setAbrilDecimal(BigDecimal abrilDecimal) {
		this.abrilDecimal = abrilDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "abril_tiempo", length = 19)
	public Date getAbrilTiempo() {
		return this.abrilTiempo;
	}

	public void setAbrilTiempo(Date abrilTiempo) {
		this.abrilTiempo = abrilTiempo;
	}

	@Column(name = "mayo_entero")
	public Integer getMayoEntero() {
		return this.mayoEntero;
	}

	public void setMayoEntero(Integer mayoEntero) {
		this.mayoEntero = mayoEntero;
	}

	@Column(name = "mayo_string", length = 65535)
	public String getMayoString() {
		return this.mayoString;
	}

	public void setMayoString(String mayoString) {
		this.mayoString = mayoString;
	}

	@Column(name = "mayo_decimal", precision = 15)
	public BigDecimal getMayoDecimal() {
		return this.mayoDecimal;
	}

	public void setMayoDecimal(BigDecimal mayoDecimal) {
		this.mayoDecimal = mayoDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mayo_tiempo", length = 19)
	public Date getMayoTiempo() {
		return this.mayoTiempo;
	}

	public void setMayoTiempo(Date mayoTiempo) {
		this.mayoTiempo = mayoTiempo;
	}

	@Column(name = "junio_entero")
	public Integer getJunioEntero() {
		return this.junioEntero;
	}

	public void setJunioEntero(Integer junioEntero) {
		this.junioEntero = junioEntero;
	}

	@Column(name = "junio_string", length = 65535)
	public String getJunioString() {
		return this.junioString;
	}

	public void setJunioString(String junioString) {
		this.junioString = junioString;
	}

	@Column(name = "junio_decimal", precision = 15)
	public BigDecimal getJunioDecimal() {
		return this.junioDecimal;
	}

	public void setJunioDecimal(BigDecimal junioDecimal) {
		this.junioDecimal = junioDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "junio_tiempo", length = 19)
	public Date getJunioTiempo() {
		return this.junioTiempo;
	}

	public void setJunioTiempo(Date junioTiempo) {
		this.junioTiempo = junioTiempo;
	}

	@Column(name = "julio_entero")
	public Integer getJulioEntero() {
		return this.julioEntero;
	}

	public void setJulioEntero(Integer julioEntero) {
		this.julioEntero = julioEntero;
	}

	@Column(name = "julio_string", length = 65535)
	public String getJulioString() {
		return this.julioString;
	}

	public void setJulioString(String julioString) {
		this.julioString = julioString;
	}

	@Column(name = "julio_decimal", precision = 15)
	public BigDecimal getJulioDecimal() {
		return this.julioDecimal;
	}

	public void setJulioDecimal(BigDecimal julioDecimal) {
		this.julioDecimal = julioDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "julio_tiempo", length = 19)
	public Date getJulioTiempo() {
		return this.julioTiempo;
	}

	public void setJulioTiempo(Date julioTiempo) {
		this.julioTiempo = julioTiempo;
	}

	@Column(name = "agosto_entero")
	public Integer getAgostoEntero() {
		return this.agostoEntero;
	}

	public void setAgostoEntero(Integer agostoEntero) {
		this.agostoEntero = agostoEntero;
	}

	@Column(name = "agosto_string", length = 65535)
	public String getAgostoString() {
		return this.agostoString;
	}

	public void setAgostoString(String agostoString) {
		this.agostoString = agostoString;
	}

	@Column(name = "agosto_decimal", precision = 15)
	public BigDecimal getAgostoDecimal() {
		return this.agostoDecimal;
	}

	public void setAgostoDecimal(BigDecimal agostoDecimal) {
		this.agostoDecimal = agostoDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "agosto_tiempo", length = 19)
	public Date getAgostoTiempo() {
		return this.agostoTiempo;
	}

	public void setAgostoTiempo(Date agostoTiempo) {
		this.agostoTiempo = agostoTiempo;
	}

	@Column(name = "septiembre_entero")
	public Integer getSeptiembreEntero() {
		return this.septiembreEntero;
	}

	public void setSeptiembreEntero(Integer septiembreEntero) {
		this.septiembreEntero = septiembreEntero;
	}

	@Column(name = "septiembre_string", length = 65535)
	public String getSeptiembreString() {
		return this.septiembreString;
	}

	public void setSeptiembreString(String septiembreString) {
		this.septiembreString = septiembreString;
	}

	@Column(name = "septiembre_decimal", precision = 15)
	public BigDecimal getSeptiembreDecimal() {
		return this.septiembreDecimal;
	}

	public void setSeptiembreDecimal(BigDecimal septiembreDecimal) {
		this.septiembreDecimal = septiembreDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "septiembre_tiempo", length = 19)
	public Date getSeptiembreTiempo() {
		return this.septiembreTiempo;
	}

	public void setSeptiembreTiempo(Date septiembreTiempo) {
		this.septiembreTiempo = septiembreTiempo;
	}

	@Column(name = "octubre_entero")
	public Integer getOctubreEntero() {
		return this.octubreEntero;
	}

	public void setOctubreEntero(Integer octubreEntero) {
		this.octubreEntero = octubreEntero;
	}

	@Column(name = "octubre_string", length = 65535)
	public String getOctubreString() {
		return this.octubreString;
	}

	public void setOctubreString(String octubreString) {
		this.octubreString = octubreString;
	}

	@Column(name = "octubre_decimal", precision = 15)
	public BigDecimal getOctubreDecimal() {
		return this.octubreDecimal;
	}

	public void setOctubreDecimal(BigDecimal octubreDecimal) {
		this.octubreDecimal = octubreDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "octubre_tiempo", length = 19)
	public Date getOctubreTiempo() {
		return this.octubreTiempo;
	}

	public void setOctubreTiempo(Date octubreTiempo) {
		this.octubreTiempo = octubreTiempo;
	}

	@Column(name = "noviembre_entero")
	public Integer getNoviembreEntero() {
		return this.noviembreEntero;
	}

	public void setNoviembreEntero(Integer noviembreEntero) {
		this.noviembreEntero = noviembreEntero;
	}

	@Column(name = "noviembre_string", length = 65535)
	public String getNoviembreString() {
		return this.noviembreString;
	}

	public void setNoviembreString(String noviembreString) {
		this.noviembreString = noviembreString;
	}

	@Column(name = "noviembre_decimal", precision = 15)
	public BigDecimal getNoviembreDecimal() {
		return this.noviembreDecimal;
	}

	public void setNoviembreDecimal(BigDecimal noviembreDecimal) {
		this.noviembreDecimal = noviembreDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "noviembre_tiempo", length = 19)
	public Date getNoviembreTiempo() {
		return this.noviembreTiempo;
	}

	public void setNoviembreTiempo(Date noviembreTiempo) {
		this.noviembreTiempo = noviembreTiempo;
	}

	@Column(name = "diciembre_entero")
	public Integer getDiciembreEntero() {
		return this.diciembreEntero;
	}

	public void setDiciembreEntero(Integer diciembreEntero) {
		this.diciembreEntero = diciembreEntero;
	}

	@Column(name = "diciembre_string", length = 65535)
	public String getDiciembreString() {
		return this.diciembreString;
	}

	public void setDiciembreString(String diciembreString) {
		this.diciembreString = diciembreString;
	}

	@Column(name = "diciembre_decimal", precision = 15)
	public BigDecimal getDiciembreDecimal() {
		return this.diciembreDecimal;
	}

	public void setDiciembreDecimal(BigDecimal diciembreDecimal) {
		this.diciembreDecimal = diciembreDecimal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "diciembre_tiempo", length = 19)
	public Date getDiciembreTiempo() {
		return this.diciembreTiempo;
	}

	public void setDiciembreTiempo(Date diciembreTiempo) {
		this.diciembreTiempo = diciembreTiempo;
	}

	@Column(name = "estado", nullable = false)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "usuario", nullable = false, length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso", nullable = false, length = 19)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}
