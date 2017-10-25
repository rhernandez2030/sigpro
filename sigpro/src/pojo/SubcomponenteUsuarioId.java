package pojo;
// Generated Oct 24, 2017 11:46:58 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubcomponenteUsuarioId generated by hbm2java
 */
@Embeddable
public class SubcomponenteUsuarioId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -875099956640835042L;
	private int subcomponenteid;
	private String usuario;

	public SubcomponenteUsuarioId() {
	}

	public SubcomponenteUsuarioId(int subcomponenteid, String usuario) {
		this.subcomponenteid = subcomponenteid;
		this.usuario = usuario;
	}

	@Column(name = "subcomponenteid", nullable = false)
	public int getSubcomponenteid() {
		return this.subcomponenteid;
	}

	public void setSubcomponenteid(int subcomponenteid) {
		this.subcomponenteid = subcomponenteid;
	}

	@Column(name = "usuario", nullable = false, length = 30)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubcomponenteUsuarioId))
			return false;
		SubcomponenteUsuarioId castOther = (SubcomponenteUsuarioId) other;

		return (this.getSubcomponenteid() == castOther.getSubcomponenteid())
				&& ((this.getUsuario() == castOther.getUsuario()) || (this.getUsuario() != null
						&& castOther.getUsuario() != null && this.getUsuario().equals(castOther.getUsuario())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getSubcomponenteid();
		result = 37 * result + (getUsuario() == null ? 0 : this.getUsuario().hashCode());
		return result;
	}

}
