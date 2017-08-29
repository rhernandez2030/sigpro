package pojo;
// Generated Aug 29, 2017 4:40:10 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductoUsuario generated by hbm2java
 */
@Entity
@Table(name = "producto_usuario", catalog = "sipro")
public class ProductoUsuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8137482262666214807L;
	private ProductoUsuarioId id;
	private Producto producto;
	private String usuarioCreo;
	private String usuarioActualizo;
	private Date fechaCreacion;
	private Date fechaActualizacion;

	public ProductoUsuario() {
	}

	public ProductoUsuario(ProductoUsuarioId id, Producto producto) {
		this.id = id;
		this.producto = producto;
	}

	public ProductoUsuario(ProductoUsuarioId id, Producto producto, String usuarioCreo, String usuarioActualizo,
			Date fechaCreacion, Date fechaActualizacion) {
		this.id = id;
		this.producto = producto;
		this.usuarioCreo = usuarioCreo;
		this.usuarioActualizo = usuarioActualizo;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productoid", column = @Column(name = "productoid", nullable = false)),
			@AttributeOverride(name = "usuario", column = @Column(name = "usuario", nullable = false, length = 30)) })
	public ProductoUsuarioId getId() {
		return this.id;
	}

	public void setId(ProductoUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productoid", nullable = false, insertable = false, updatable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "usuario_creo", length = 30)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", length = 19)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", length = 19)
	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
