package pojo;
// Generated Oct 24, 2017 11:46:58 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FormularioItemValorId generated by hbm2java
 */
@Embeddable
public class FormularioItemValorId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204275031896061268L;
	private int formularioItemid;
	private int objetoFormularioformularioid;
	private int objetoFormularioobjetoTipoid;
	private int objetoFormularioobjetoId;

	public FormularioItemValorId() {
	}

	public FormularioItemValorId(int formularioItemid, int objetoFormularioformularioid,
			int objetoFormularioobjetoTipoid, int objetoFormularioobjetoId) {
		this.formularioItemid = formularioItemid;
		this.objetoFormularioformularioid = objetoFormularioformularioid;
		this.objetoFormularioobjetoTipoid = objetoFormularioobjetoTipoid;
		this.objetoFormularioobjetoId = objetoFormularioobjetoId;
	}

	@Column(name = "formulario_itemid", nullable = false)
	public int getFormularioItemid() {
		return this.formularioItemid;
	}

	public void setFormularioItemid(int formularioItemid) {
		this.formularioItemid = formularioItemid;
	}

	@Column(name = "objeto_formularioformularioid", nullable = false)
	public int getObjetoFormularioformularioid() {
		return this.objetoFormularioformularioid;
	}

	public void setObjetoFormularioformularioid(int objetoFormularioformularioid) {
		this.objetoFormularioformularioid = objetoFormularioformularioid;
	}

	@Column(name = "objeto_formularioobjeto_tipoid", nullable = false)
	public int getObjetoFormularioobjetoTipoid() {
		return this.objetoFormularioobjetoTipoid;
	}

	public void setObjetoFormularioobjetoTipoid(int objetoFormularioobjetoTipoid) {
		this.objetoFormularioobjetoTipoid = objetoFormularioobjetoTipoid;
	}

	@Column(name = "objeto_formularioobjeto_id", nullable = false)
	public int getObjetoFormularioobjetoId() {
		return this.objetoFormularioobjetoId;
	}

	public void setObjetoFormularioobjetoId(int objetoFormularioobjetoId) {
		this.objetoFormularioobjetoId = objetoFormularioobjetoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FormularioItemValorId))
			return false;
		FormularioItemValorId castOther = (FormularioItemValorId) other;

		return (this.getFormularioItemid() == castOther.getFormularioItemid())
				&& (this.getObjetoFormularioformularioid() == castOther.getObjetoFormularioformularioid())
				&& (this.getObjetoFormularioobjetoTipoid() == castOther.getObjetoFormularioobjetoTipoid())
				&& (this.getObjetoFormularioobjetoId() == castOther.getObjetoFormularioobjetoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getFormularioItemid();
		result = 37 * result + this.getObjetoFormularioformularioid();
		result = 37 * result + this.getObjetoFormularioobjetoTipoid();
		result = 37 * result + this.getObjetoFormularioobjetoId();
		return result;
	}

}
