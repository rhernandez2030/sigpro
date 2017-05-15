package pojo;
// Generated May 15, 2017 4:04:46 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductoUsuarioId generated by hbm2java
 */
@Embeddable
public class ProductoUsuarioId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391639895218102545L;
	private int productoid;
	private String usuario;

	public ProductoUsuarioId() {
	}

	public ProductoUsuarioId(int productoid, String usuario) {
		this.productoid = productoid;
		this.usuario = usuario;
	}

	@Column(name = "productoid", nullable = false)
	public int getProductoid() {
		return this.productoid;
	}

	public void setProductoid(int productoid) {
		this.productoid = productoid;
	}

	@Column(name = "usuario", nullable = false, length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductoUsuarioId))
			return false;
		ProductoUsuarioId castOther = (ProductoUsuarioId) other;

		return (this.getProductoid() == castOther.getProductoid())
				&& ((this.getUsuario() == castOther.getUsuario()) || (this.getUsuario() != null
						&& castOther.getUsuario() != null && this.getUsuario().equals(castOther.getUsuario())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProductoid();
		result = 37 * result + (getUsuario() == null ? 0 : this.getUsuario().hashCode());
		return result;
	}

}
