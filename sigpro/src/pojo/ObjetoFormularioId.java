package pojo;
// Generated Dec 20, 2017 3:43:57 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObjetoFormularioId generated by hbm2java
 */
@Embeddable
public class ObjetoFormularioId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788297290599764323L;
	private int formularioid;
	private int objetoTipo;
	private int objetoId;

	public ObjetoFormularioId() {
	}

	public ObjetoFormularioId(int formularioid, int objetoTipo, int objetoId) {
		this.formularioid = formularioid;
		this.objetoTipo = objetoTipo;
		this.objetoId = objetoId;
	}

	@Column(name = "formularioid", nullable = false)
	public int getFormularioid() {
		return this.formularioid;
	}

	public void setFormularioid(int formularioid) {
		this.formularioid = formularioid;
	}

	@Column(name = "objeto_tipo", nullable = false)
	public int getObjetoTipo() {
		return this.objetoTipo;
	}

	public void setObjetoTipo(int objetoTipo) {
		this.objetoTipo = objetoTipo;
	}

	@Column(name = "objeto_id", nullable = false)
	public int getObjetoId() {
		return this.objetoId;
	}

	public void setObjetoId(int objetoId) {
		this.objetoId = objetoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ObjetoFormularioId))
			return false;
		ObjetoFormularioId castOther = (ObjetoFormularioId) other;

		return (this.getFormularioid() == castOther.getFormularioid())
				&& (this.getObjetoTipo() == castOther.getObjetoTipo())
				&& (this.getObjetoId() == castOther.getObjetoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFormularioid();
		result = 37 * result + this.getObjetoTipo();
		result = 37 * result + this.getObjetoId();
		return result;
	}

}
