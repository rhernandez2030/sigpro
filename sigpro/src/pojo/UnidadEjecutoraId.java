package pojo;
// Generated Nov 21, 2017 3:28:39 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UnidadEjecutoraId generated by hbm2java
 */
@Embeddable
public class UnidadEjecutoraId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1978726439712042734L;
	private int unidadEjecutora;
	private int entidadentidad;
	private int ejercicio;

	public UnidadEjecutoraId() {
	}

	public UnidadEjecutoraId(int unidadEjecutora, int entidadentidad, int ejercicio) {
		this.unidadEjecutora = unidadEjecutora;
		this.entidadentidad = entidadentidad;
		this.ejercicio = ejercicio;
	}

	@Column(name = "unidad_ejecutora", nullable = false)
	public int getUnidadEjecutora() {
		return this.unidadEjecutora;
	}

	public void setUnidadEjecutora(int unidadEjecutora) {
		this.unidadEjecutora = unidadEjecutora;
	}

	@Column(name = "entidadentidad", nullable = false)
	public int getEntidadentidad() {
		return this.entidadentidad;
	}

	public void setEntidadentidad(int entidadentidad) {
		this.entidadentidad = entidadentidad;
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
		if (!(other instanceof UnidadEjecutoraId))
			return false;
		UnidadEjecutoraId castOther = (UnidadEjecutoraId) other;

		return (this.getUnidadEjecutora() == castOther.getUnidadEjecutora())
				&& (this.getEntidadentidad() == castOther.getEntidadentidad())
				&& (this.getEjercicio() == castOther.getEjercicio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getUnidadEjecutora();
		result = 37 * result + this.getEntidadentidad();
		result = 37 * result + this.getEjercicio();
		return result;
	}

}
