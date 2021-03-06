package pojo;
// Generated Dec 20, 2017 3:43:57 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PtipoPropiedadId generated by hbm2java
 */
@Embeddable
public class PtipoPropiedadId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2394013481771907512L;
	private int proyectoTipoid;
	private int proyectoPropiedadid;

	public PtipoPropiedadId() {
	}

	public PtipoPropiedadId(int proyectoTipoid, int proyectoPropiedadid) {
		this.proyectoTipoid = proyectoTipoid;
		this.proyectoPropiedadid = proyectoPropiedadid;
	}

	@Column(name = "proyecto_tipoid", nullable = false)
	public int getProyectoTipoid() {
		return this.proyectoTipoid;
	}

	public void setProyectoTipoid(int proyectoTipoid) {
		this.proyectoTipoid = proyectoTipoid;
	}

	@Column(name = "proyecto_propiedadid", nullable = false)
	public int getProyectoPropiedadid() {
		return this.proyectoPropiedadid;
	}

	public void setProyectoPropiedadid(int proyectoPropiedadid) {
		this.proyectoPropiedadid = proyectoPropiedadid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PtipoPropiedadId))
			return false;
		PtipoPropiedadId castOther = (PtipoPropiedadId) other;

		return (this.getProyectoTipoid() == castOther.getProyectoTipoid())
				&& (this.getProyectoPropiedadid() == castOther.getProyectoPropiedadid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getProyectoTipoid();
		result = 37 * result + this.getProyectoPropiedadid();
		return result;
	}

}
