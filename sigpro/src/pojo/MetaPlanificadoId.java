package pojo;
// Generated Nov 1, 2017 10:04:00 AM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MetaPlanificadoId generated by hbm2java
 */
@Embeddable
public class MetaPlanificadoId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841532910343893111L;
	private int metaid;
	private int ejercicio;

	public MetaPlanificadoId() {
	}

	public MetaPlanificadoId(int metaid, int ejercicio) {
		this.metaid = metaid;
		this.ejercicio = ejercicio;
	}

	@Column(name = "metaid", nullable = false)
	public int getMetaid() {
		return this.metaid;
	}

	public void setMetaid(int metaid) {
		this.metaid = metaid;
	}

	@Column(name = "ejercicio", nullable = false)
	public int getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(int ejercicio) {
		this.ejercicio = ejercicio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MetaPlanificadoId))
			return false;
		MetaPlanificadoId castOther = (MetaPlanificadoId) other;

		return (this.getMetaid() == castOther.getMetaid()) && (this.getEjercicio() == castOther.getEjercicio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMetaid();
		result = 37 * result + this.getEjercicio();
		return result;
	}

}
