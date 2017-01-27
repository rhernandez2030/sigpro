package pojo;
// Generated Jan 27, 2017 10:39:58 AM by Hibernate Tools 5.2.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProdtipoPropiedadId generated by hbm2java
 */
@Embeddable
public class ProdtipoPropiedadId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8098692967518533528L;
	private int productoTipoid;
	private int productoPropiedadid;

	public ProdtipoPropiedadId() {
	}

	public ProdtipoPropiedadId(int productoTipoid, int productoPropiedadid) {
		this.productoTipoid = productoTipoid;
		this.productoPropiedadid = productoPropiedadid;
	}

	@Column(name = "producto_tipoid", nullable = false)
	public int getProductoTipoid() {
		return this.productoTipoid;
	}

	public void setProductoTipoid(int productoTipoid) {
		this.productoTipoid = productoTipoid;
	}

	@Column(name = "producto_propiedadid", nullable = false)
	public int getProductoPropiedadid() {
		return this.productoPropiedadid;
	}

	public void setProductoPropiedadid(int productoPropiedadid) {
		this.productoPropiedadid = productoPropiedadid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdtipoPropiedadId))
			return false;
		ProdtipoPropiedadId castOther = (ProdtipoPropiedadId) other;

		return (this.getProductoTipoid() == castOther.getProductoTipoid())
				&& (this.getProductoPropiedadid() == castOther.getProductoPropiedadid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductoTipoid();
		result = 37 * result + this.getProductoPropiedadid();
		return result;
	}

}
