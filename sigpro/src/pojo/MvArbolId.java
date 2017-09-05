package pojo;
// Generated Aug 29, 2017 4:40:10 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MvArbolId generated by hbm2java
 */
@Embeddable
public class MvArbolId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1280058044354171831L;
	private byte prestamo;
	private byte componente;
	private byte producto;
	private byte subproducto;
	private byte level;
	private byte actividad;
	private byte treelevel;
	private byte treepath;
	private byte fechaInicio;

	public MvArbolId() {
	}

	public MvArbolId(byte prestamo, byte componente, byte producto, byte subproducto, byte level, byte actividad,
			byte treelevel, byte treepath, byte fechaInicio) {
		this.prestamo = prestamo;
		this.componente = componente;
		this.producto = producto;
		this.subproducto = subproducto;
		this.level = level;
		this.actividad = actividad;
		this.treelevel = treelevel;
		this.treepath = treepath;
		this.fechaInicio = fechaInicio;
	}

	@Column(name = "prestamo", nullable = false)
	public byte getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(byte prestamo) {
		this.prestamo = prestamo;
	}

	@Column(name = "componente", nullable = false)
	public byte getComponente() {
		return this.componente;
	}

	public void setComponente(byte componente) {
		this.componente = componente;
	}

	@Column(name = "producto", nullable = false)
	public byte getProducto() {
		return this.producto;
	}

	public void setProducto(byte producto) {
		this.producto = producto;
	}

	@Column(name = "subproducto", nullable = false)
	public byte getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(byte subproducto) {
		this.subproducto = subproducto;
	}

	@Column(name = "level", nullable = false)
	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	@Column(name = "actividad", nullable = false)
	public byte getActividad() {
		return this.actividad;
	}

	public void setActividad(byte actividad) {
		this.actividad = actividad;
	}

	@Column(name = "treelevel", nullable = false)
	public byte getTreelevel() {
		return this.treelevel;
	}

	public void setTreelevel(byte treelevel) {
		this.treelevel = treelevel;
	}

	@Column(name = "treepath", nullable = false)
	public byte getTreepath() {
		return this.treepath;
	}

	public void setTreepath(byte treepath) {
		this.treepath = treepath;
	}

	@Column(name = "fecha_inicio", nullable = false)
	public byte getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(byte fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MvArbolId))
			return false;
		MvArbolId castOther = (MvArbolId) other;

		return (this.getPrestamo() == castOther.getPrestamo()) && (this.getComponente() == castOther.getComponente())
				&& (this.getProducto() == castOther.getProducto())
				&& (this.getSubproducto() == castOther.getSubproducto()) && (this.getLevel() == castOther.getLevel())
				&& (this.getActividad() == castOther.getActividad())
				&& (this.getTreelevel() == castOther.getTreelevel()) && (this.getTreepath() == castOther.getTreepath())
				&& (this.getFechaInicio() == castOther.getFechaInicio());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPrestamo();
		result = 37 * result + this.getComponente();
		result = 37 * result + this.getProducto();
		result = 37 * result + this.getSubproducto();
		result = 37 * result + this.getLevel();
		result = 37 * result + this.getActividad();
		result = 37 * result + this.getTreelevel();
		result = 37 * result + this.getTreepath();
		result = 37 * result + this.getFechaInicio();
		return result;
	}

}