package pojo;
// Generated Dec 5, 2016 7:40:54 PM by Hibernate Tools 5.2.0.Beta1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObjetoRecursoId generated by hbm2java
 */
@Embeddable
public class ObjetoRecursoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7206435289003491916L;
	private int recursoid;
	private int recursoPropiedadid;
	private int proyectoid;
	private int componenteid;
	private int productoid;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	private int estado;
	private Integer valorEntero;
	private String valorString;
	private BigDecimal valorDecimal;
	private Date valorTiempo;

	public ObjetoRecursoId() {
	}

	public ObjetoRecursoId(int recursoid, int recursoPropiedadid, int proyectoid, int componenteid, int productoid,
			String usuarioCreo, Date fechaCreacion, int estado) {
		this.recursoid = recursoid;
		this.recursoPropiedadid = recursoPropiedadid;
		this.proyectoid = proyectoid;
		this.componenteid = componenteid;
		this.productoid = productoid;
		this.usuarioCreo = usuarioCreo;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public ObjetoRecursoId(int recursoid, int recursoPropiedadid, int proyectoid, int componenteid, int productoid,
			String usuarioCreo, String usuarioActualizo, Date fechaCreacion, Date fechaActualizacion, int estado,
			Integer valorEntero, String valorString, BigDecimal valorDecimal, Date valorTiempo) {
		this.recursoid = recursoid;
		this.recursoPropiedadid = recursoPropiedadid;
		this.proyectoid = proyectoid;
		this.componenteid = componenteid;
		this.productoid = productoid;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
		this.valorEntero = valorEntero;
		this.valorString = valorString;
		this.valorDecimal = valorDecimal;
		this.valorTiempo = valorTiempo;
	}

	@Column(name = "recursoid", nullable = false)
	public int getRecursoid() {
		return this.recursoid;
	}

	public void setRecursoid(int recursoid) {
		this.recursoid = recursoid;
	}

	@Column(name = "recurso_propiedadid", nullable = false)
	public int getRecursoPropiedadid() {
		return this.recursoPropiedadid;
	}

	public void setRecursoPropiedadid(int recursoPropiedadid) {
		this.recursoPropiedadid = recursoPropiedadid;
	}

	@Column(name = "proyectoid", nullable = false)
	public int getProyectoid() {
		return this.proyectoid;
	}

	public void setProyectoid(int proyectoid) {
		this.proyectoid = proyectoid;
	}

	@Column(name = "componenteid", nullable = false)
	public int getComponenteid() {
		return this.componenteid;
	}

	public void setComponenteid(int componenteid) {
		this.componenteid = componenteid;
	}

	@Column(name = "productoid", nullable = false)
	public int getProductoid() {
		return this.productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
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

	@Column(name = "fecha_creacion", nullable = false, length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

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

	@Column(name = "valor_tiempo", length = 19)
	public Date getValorTiempo() {
		return this.valorTiempo;
	}

	public void setValorTiempo(Date valorTiempo) {
		this.valorTiempo = valorTiempo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ObjetoRecursoId))
			return false;
		ObjetoRecursoId castOther = (ObjetoRecursoId) other;

		return (this.getRecursoid() == castOther.getRecursoid())
				&& (this.getRecursoPropiedadid() == castOther.getRecursoPropiedadid())
				&& (this.getProyectoid() == castOther.getProyectoid())
				&& (this.getComponenteid() == castOther.getComponenteid())
				&& (this.getProductoid() == castOther.getProductoid())
				&& ((this.getUsuarioCreo() == castOther.getUsuarioCreo())
						|| (this.getUsuarioCreo() != null && castOther.getUsuarioCreo() != null
								&& this.getUsuarioCreo().equals(castOther.getUsuarioCreo())))
				&& ((this.getUsuarioActualizo() == castOther.getUsuarioActualizo())
						|| (this.getUsuarioActualizo() != null && castOther.getUsuarioActualizo() != null
								&& this.getUsuarioActualizo().equals(castOther.getUsuarioActualizo())))
				&& ((this.getFechaCreacion() == castOther.getFechaCreacion())
						|| (this.getFechaCreacion() != null && castOther.getFechaCreacion() != null
								&& this.getFechaCreacion().equals(castOther.getFechaCreacion())))
				&& ((this.getFechaActualizacion() == castOther.getFechaActualizacion())
						|| (this.getFechaActualizacion() != null && castOther.getFechaActualizacion() != null
								&& this.getFechaActualizacion().equals(castOther.getFechaActualizacion())))
				&& (this.getEstado() == castOther.getEstado())
				&& ((this.getValorEntero() == castOther.getValorEntero())
						|| (this.getValorEntero() != null && castOther.getValorEntero() != null
								&& this.getValorEntero().equals(castOther.getValorEntero())))
				&& ((this.getValorString() == castOther.getValorString())
						|| (this.getValorString() != null && castOther.getValorString() != null
								&& this.getValorString().equals(castOther.getValorString())))
				&& ((this.getValorDecimal() == castOther.getValorDecimal())
						|| (this.getValorDecimal() != null && castOther.getValorDecimal() != null
								&& this.getValorDecimal().equals(castOther.getValorDecimal())))
				&& ((this.getValorTiempo() == castOther.getValorTiempo())
						|| (this.getValorTiempo() != null && castOther.getValorTiempo() != null
								&& this.getValorTiempo().equals(castOther.getValorTiempo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRecursoid();
		result = 37 * result + this.getRecursoPropiedadid();
		result = 37 * result + this.getProyectoid();
		result = 37 * result + this.getComponenteid();
		result = 37 * result + this.getProductoid();
		result = 37 * result + (getUsuarioCreo() == null ? 0 : this.getUsuarioCreo().hashCode());
		result = 37 * result + (getUsuarioActualizo() == null ? 0 : this.getUsuarioActualizo().hashCode());
		result = 37 * result + (getFechaCreacion() == null ? 0 : this.getFechaCreacion().hashCode());
		result = 37 * result + (getFechaActualizacion() == null ? 0 : this.getFechaActualizacion().hashCode());
		result = 37 * result + this.getEstado();
		result = 37 * result + (getValorEntero() == null ? 0 : this.getValorEntero().hashCode());
		result = 37 * result + (getValorString() == null ? 0 : this.getValorString().hashCode());
		result = 37 * result + (getValorDecimal() == null ? 0 : this.getValorDecimal().hashCode());
		result = 37 * result + (getValorTiempo() == null ? 0 : this.getValorTiempo().hashCode());
		return result;
	}

}
