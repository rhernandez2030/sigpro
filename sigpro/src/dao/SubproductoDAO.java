package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pojo.Actividad;
import pojo.Proyecto;
import pojo.Subproducto;
import pojo.SubproductoUsuario;
import pojo.SubproductoUsuarioId;
import pojo.Usuario;
import utilities.CHibernateSession;
import utilities.CLogger;
import utilities.Utils;

public class SubproductoDAO {

	
	static class EstructuraPojo {
		Integer id;
		String nombre;
		String descripcion;
		Integer idProducto;
		String producto;
		Integer idSubproductoTipo;
		String subproductoTipo;
		Integer unidadEjectuora;
		String nombreUnidadEjecutora;
		String entidadnombre;
		Integer entidadentidad;
		Integer ejercicio;
		Long snip;
		Integer programa;
		Integer subprograma;
		Integer proyecto_;
		Integer actividad;
		Integer obra;
		Integer renglon;
		Integer ubicacionGeografica;
		Integer duracion;
		String duracionDimension;
		String fechaInicio;
		String fechaFin;
		Integer estado;
		String fechaCreacion;
		String usuarioCreo;
		String fechaactualizacion;
		String usuarioactualizo;
		String latitud;
		String longitud;
		BigDecimal costo;
		Integer acumulacionCosto;
		String acumulacionCostoNombre;
	}

	public static List<Subproducto> getSubproductos(String usuario) {
		List<Subproducto> ret = new ArrayList<Subproducto>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			Query<Subproducto> criteria = session.createQuery("FROM Subproducto p where p.id in (SELECT u.id.subproductoid from SubproductoUsuario u where u.id.usuario=:usuario )", Subproducto.class);
			criteria.setParameter("usuario", usuario);
			ret =   (List<Subproducto>)criteria.getResultList();
		} catch (Throwable e) {
			CLogger.write("1", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static Subproducto getSubproductoPorId(int id, String usuario) {
		Session session = CHibernateSession.getSessionFactory().openSession();
		Subproducto ret = null;
		try {
			List<Subproducto> listRet = null;
			String Str_query = String.join(" ","Select sp FROM Subproducto sp",
					"where id=:id");
			String Str_usuario = "";
			if(usuario != null){
				Str_usuario = String.join(" ", "AND id in (SELECT u.id.subproductoid from SubproductoUsuario u where u.id.usuario=:usuario )");
			}
			
			Str_query = String.join(" ", Str_query, Str_usuario);
			Query<Subproducto> criteria = session.createQuery(Str_query, Subproducto.class);
			criteria.setParameter("id", id);
			if(usuario != null){
				criteria.setParameter("usuario", usuario);
			}
			listRet=criteria.getResultList();
			 ret =!listRet.isEmpty() ? listRet.get(0) : null;
		} catch (Throwable e) {
			CLogger.write("2", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static boolean guardarSubproducto(Subproducto subproducto, boolean calcular_valores_agregados) {
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if(subproducto.getId()==null || subproducto.getId()<1){
				session.saveOrUpdate(subproducto);
				session.flush();
				subproducto.setTreePath(subproducto.getProducto().getTreePath()+""+
				(10000000+subproducto.getId()));
			}
			session.saveOrUpdate(subproducto);
			Usuario usu = UsuarioDAO.getUsuario(subproducto.getUsuarioCreo());
			SubproductoUsuario su = new SubproductoUsuario(new SubproductoUsuarioId(subproducto.getId(),subproducto.getUsuarioCreo())
					, subproducto, usu, subproducto.getUsuarioCreo(), subproducto.getFechaCreacion());
			session.saveOrUpdate(su);
			if(!subproducto.getUsuarioCreo().equals("admin")){
				SubproductoUsuario su_admin = new SubproductoUsuario(new SubproductoUsuarioId(subproducto.getId(),"admin")
						, subproducto, usu, subproducto.getUsuarioCreo(), subproducto.getFechaCreacion());
				session.saveOrUpdate(su_admin);
			}
<<<<<<< HEAD
			if(calcular_valores_agregados){
				subproducto.setCosto(calcularCosto(subproducto));
				Date fechaMinima = calcularFechaMinima(subproducto);
				Date fechaMaxima = calcularFechaMaxima(subproducto);
				Integer duracion = Utils.getWorkingDays(fechaMinima, fechaMaxima);
				
				subproducto.setDuracion(duracion.intValue());
				subproducto.setFechaInicio(fechaMinima);
				subproducto.setFechaFin(fechaMaxima);
				session.saveOrUpdate(subproducto);
				session.getTransaction().commit();
				session.close();
				ProductoDAO.guardarProducto(subproducto.getProducto(), true);
			}
			else{
				session.getTransaction().commit();
				session.close();
			}
=======
			
			subproducto.setCosto(calcularCosto(subproducto));
			Date fechaMinima = calcularFechaMinima(subproducto);
			Date fechaMaxima = calcularFechaMaxima(subproducto);
			Integer duracion = Utils.getWorkingDays(fechaMinima, fechaMaxima);
			
			subproducto.setDuracion(duracion.intValue());
			subproducto.setFechaInicio(fechaMinima);
			subproducto.setFechaFin(fechaMaxima);
			session.saveOrUpdate(subproducto);
			session.getTransaction().commit();
			session.close();
			
			ProductoDAO.guardarProducto(subproducto.getProducto());
>>>>>>> branch 'master' of https://github.com/MINFIN-GT/sigpro.git
			ret = true;
		} catch (Throwable e) {
			CLogger.write("3", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static boolean eliminarSubproducto(Subproducto subproducto) {
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			subproducto.setEstado(0);
			session.beginTransaction();
			session.update(subproducto);
			session.getTransaction().commit();
			ret = true;
		} catch (Throwable e) {
			CLogger.write("4", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static boolean eliminarTotalSubproducto(Subproducto Subproducto) {
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(Subproducto);
			session.getTransaction().commit();
			ret = true;
		} catch (Throwable e) {
			CLogger.write("5", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static List<Subproducto> getSubproductosPagina(int pagina, int numeroProductos,Integer productoid, 
			String filtro_nombre, String filtro_usuario_creo, String filtro_fecha_creacion, String columna_ordenada, 
			String orden_direccion,String usuario) {
		List<Subproducto> ret = new ArrayList<Subproducto>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			
			String query = "SELECT p FROM Subproducto p WHERE p.estado = 1 "
					+ (productoid!=null && productoid > 0 ? "AND p.producto.id = :idProducto " : "");
			String query_a="";
			if(filtro_nombre!=null && filtro_nombre.trim().length()>0)
				query_a = String.join("",query_a, " p.nombre LIKE '%",filtro_nombre,"%' ");
			if(filtro_usuario_creo!=null && filtro_usuario_creo.trim().length()>0)
				query_a = String.join("",query_a,(query_a.length()>0 ? " OR " :""), " p.usuarioCreo LIKE '%", filtro_usuario_creo,"%' ");
			if(filtro_fecha_creacion!=null && filtro_fecha_creacion.trim().length()>0)
				query_a = String.join("",query_a,(query_a.length()>0 ? " OR " :""), " str(date_format(p.fechaCreacion,'%d/%m/%YYYY')) LIKE '%", filtro_fecha_creacion,"%' ");
			query = String.join(" ", query, (query_a.length()>0 ? String.join("","AND (",query_a,")") : ""));
			if(usuario!=null)
				query = String.join("", query, " AND p.id in (SELECT u.id.subproductoid from SubproductoUsuario u where u.id.usuario=:usuario )");
			query = columna_ordenada!=null && columna_ordenada.trim().length()>0 ? String.join(" ",query,"ORDER BY",columna_ordenada,orden_direccion ) : query;
			
			Query<Subproducto> criteria = session.createQuery(query,Subproducto.class);
			criteria.setParameter("usuario", usuario);
			if (productoid!=null && productoid>0){
				criteria.setParameter("idProducto", productoid);
			}
			criteria.setFirstResult(((pagina - 1) * (numeroProductos)));
			criteria.setMaxResults(numeroProductos);
			
			ret = criteria.getResultList();
		} catch (Throwable e) {
			CLogger.write("6", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static Long getTotalSubproductos(Integer productoid, String filtro_nombre, String filtro_usuario_creo, 
			String filtro_fecha_creacion, String usuario) {
		Long ret = 0L;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try {
			
			String query = "SELECT count(p.id) FROM Subproducto p WHERE p.estado = 1 "
					+ (productoid!=null && productoid > 0 ? "AND p.producto.id = :idProducto " : "");
			String query_a="";
			if(filtro_nombre!=null && filtro_nombre.trim().length()>0)
				query_a = String.join("",query_a, " p.nombre LIKE '%",filtro_nombre,"%' ");
			if(filtro_usuario_creo!=null && filtro_usuario_creo.trim().length()>0)
				query_a = String.join("",query_a,(query_a.length()>0 ? " OR " :""), " p.usuarioCreo LIKE '%", filtro_usuario_creo,"%' ");
			if(filtro_fecha_creacion!=null && filtro_fecha_creacion.trim().length()>0)
				query_a = String.join("",query_a,(query_a.length()>0 ? " OR " :""), " str(date_format(p.fechaCreacion,'%d/%m/%YYYY')) LIKE '%", filtro_fecha_creacion,"%' ");
			query = String.join(" ", query, (query_a.length()>0 ? String.join("","AND (",query_a,")") : ""));
			if(usuario!=null)
				query = String.join("", query, " AND p.id in (SELECT u.id.subproductoid from SubproductoUsuario u where u.id.usuario=:usuario )");
			
			
			Query<Long> conteo = session.createQuery(query,Long.class);
			conteo.setParameter("usuario", usuario);
			if (productoid!=null && productoid > 0){
				conteo.setParameter("idProducto", productoid);
			}
			ret = conteo.getSingleResult();
		} catch (Throwable e) {
			CLogger.write("7", SubproductoDAO.class, e);
		} finally {
			session.close();
		}
		return ret;
	}

	public static String getJson(int pagina, int registros,Integer componenteid, String usuario
			,String filtro_nombre, String filtro_usuario_creo,
			String filtro_fecha_creacion, String columna_ordenada, String orden_direccion) {
		String jsonEntidades = "";

		List<Subproducto> pojos = getSubproductosPagina(pagina, registros,componenteid
				,filtro_nombre, filtro_usuario_creo,filtro_fecha_creacion
				,columna_ordenada,orden_direccion,usuario);

		List<EstructuraPojo> listaEstructuraPojos = new ArrayList<EstructuraPojo>();

		for (Subproducto pojo : pojos) {
			EstructuraPojo estructuraPojo = new EstructuraPojo();
			estructuraPojo.id = pojo.getId();
			estructuraPojo.nombre = pojo.getNombre();
			estructuraPojo.descripcion = pojo.getDescripcion();
			estructuraPojo.programa = pojo.getPrograma();
			estructuraPojo.subprograma = pojo.getSubprograma();
			estructuraPojo.proyecto_ = pojo.getProyecto();
			estructuraPojo.obra = pojo.getObra();
			estructuraPojo.actividad = pojo.getActividad();
			estructuraPojo.renglon = pojo.getRenglon();
			estructuraPojo.ubicacionGeografica = pojo.getUbicacionGeografica();
			estructuraPojo.duracion = pojo.getDuracion();
			estructuraPojo.duracionDimension = pojo.getDuracionDimension();
			estructuraPojo.fechaInicio = Utils.formatDate(pojo.getFechaInicio());
			estructuraPojo.fechaFin = Utils.formatDate(pojo.getFechaFin());
			estructuraPojo.snip = pojo.getSnip();
			estructuraPojo.estado = pojo.getEstado();
			estructuraPojo.usuarioCreo = pojo.getUsuarioCreo();
			estructuraPojo.usuarioactualizo = pojo.getUsuarioActualizo();
			estructuraPojo.fechaCreacion = Utils.formatDateHour(pojo.getFechaCreacion());
			estructuraPojo.fechaactualizacion = Utils.formatDateHour(pojo.getFechaActualizacion());
			estructuraPojo.latitud = pojo.getLatitud();
			estructuraPojo.longitud = pojo.getLongitud();
			estructuraPojo.costo = pojo.getCosto();
			estructuraPojo.acumulacionCosto = pojo.getAcumulacionCosto() != null ? pojo.getAcumulacionCosto().getId() : null;
			estructuraPojo.acumulacionCostoNombre = pojo.getAcumulacionCosto() != null ? pojo.getAcumulacionCosto().getNombre() : null;
			
			if (pojo.getProducto() != null) {
				estructuraPojo.idProducto = pojo.getProducto().getId();
				estructuraPojo.producto = pojo.getProducto().getNombre();
			}

			if (pojo.getSubproductoTipo() != null) {
				estructuraPojo.idSubproductoTipo = pojo.getSubproductoTipo().getId();
				estructuraPojo.subproductoTipo = pojo.getSubproductoTipo().getNombre();
			}
			
			if (pojo.getUnidadEjecutora() != null){
				estructuraPojo.unidadEjectuora = pojo.getUnidadEjecutora().getId().getUnidadEjecutora();
				estructuraPojo.nombreUnidadEjecutora = pojo.getUnidadEjecutora().getNombre();
				estructuraPojo.entidadentidad = pojo.getUnidadEjecutora().getId().getEntidadentidad();
				estructuraPojo.ejercicio = pojo.getUnidadEjecutora().getId().getEjercicio();
				estructuraPojo.entidadnombre = pojo.getUnidadEjecutora().getEntidad().getNombre();
			}
			else if(pojo.getProducto().getUnidadEjecutora()!=null){
				estructuraPojo.unidadEjectuora = pojo.getProducto().getUnidadEjecutora().getId().getUnidadEjecutora();
				estructuraPojo.nombreUnidadEjecutora = pojo.getProducto().getUnidadEjecutora().getNombre();
				estructuraPojo.entidadentidad = pojo.getProducto().getUnidadEjecutora().getId().getEntidadentidad();
				estructuraPojo.ejercicio = pojo.getProducto().getUnidadEjecutora().getId().getEjercicio();
				estructuraPojo.entidadnombre = pojo.getProducto().getUnidadEjecutora().getEntidad().getNombre();
			}
			
			listaEstructuraPojos.add(estructuraPojo);
		}

		jsonEntidades = Utils.getJSonString("subproductos", listaEstructuraPojos);

		return jsonEntidades;
	}

		public static boolean eliminar(Integer productoId, String usuario) {
		boolean ret = false;

		Subproducto pojo = getSubproductoPorId(productoId,usuario);

		if (pojo != null) {
			pojo.setEstado(0);
			pojo.setOrden(null);
			Session session = CHibernateSession.getSessionFactory().openSession();

			try {
				session.beginTransaction();
				session.update(pojo);
				session.getTransaction().commit();

				ret = true;

			} catch (Throwable e) {
				CLogger.write("10", SubproductoDAO.class, e);
			} finally {
				session.close();
			}
		}
		return ret;
	}
	
	public static Subproducto getSubproductoPorId(int id) {
		Session session = CHibernateSession.getSessionFactory().openSession();
		Subproducto ret = null;
		try{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			List<Subproducto> listRet = null;
			CriteriaQuery<Subproducto> criteria = builder.createQuery(Subproducto.class);
			Root<Subproducto> root = criteria.from(Subproducto.class);
			criteria.select( root );
			criteria.where( builder.and(builder.equal( root.get("id"), id )));
			listRet= session.createQuery( criteria ).getResultList();
			ret = !listRet.isEmpty() ? listRet.get(0) : null;
		}
		catch(Throwable e){
			CLogger.write("2", SubproductoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public String getSubproductoJson(int id){
		
		Subproducto pojo = getSubproductoPorId(id);
		EstructuraPojo estructuraPojo = new EstructuraPojo();
		estructuraPojo.id = pojo.getId();
		estructuraPojo.nombre = pojo.getNombre();
		
		String subproducto =   Utils.getJSonString("subproducto", estructuraPojo);
		return subproducto;
		
	}
	
	public static Subproducto getSubproductoInicial(Integer productoId, String usuario){
		Subproducto ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = "FROM Subproducto sp where sp.estado=1 and sp.orden=1 and sp.producto.id=:productoId and sp.usuarioCreo=:usuario";
			Query<Subproducto> criteria = session.createQuery(query, Subproducto.class);
			criteria.setParameter("productoId", productoId);
			criteria.setParameter("usuario", usuario);
			List<Subproducto> listRet = null;
			listRet = criteria.getResultList();
			ret = !listRet.isEmpty() ? listRet.get(0) : null;
		}catch(Throwable e){
			CLogger.write("11", SubproductoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static Subproducto getSubproductoFechaMaxima(Integer productoId, String usuario){
		Subproducto ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = "FROM Subproducto sp where sp.estado=1 and sp.producto.id=:productoId and sp.usuarioCreo=:usuario order by sp.fechaFin desc";
			Query<Subproducto> criteria = session.createQuery(query, Subproducto.class);
			criteria.setMaxResults(1);
			criteria.setParameter("productoId", productoId);
			criteria.setParameter("usuario", usuario);
			List<Subproducto> listRet = null;
			listRet = criteria.getResultList();
			 ret = !listRet.isEmpty() ? listRet.get(0) : null;
		}catch(Throwable e){
			CLogger.write("12", SubproductoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static boolean guardarSubproductoOrden(Subproducto subproducto, Session session) {
		boolean ret = false;
		try {
			session.saveOrUpdate(subproducto);
			session.flush();
			session.clear();
			ret = true;
		} catch (Throwable e) {
			CLogger.write("13", SubproductoDAO.class, e);
			session.getTransaction().rollback();
			session.close();
		}
		return ret;
	}
	
	public static BigDecimal calcularCosto(Subproducto subproducto){
		BigDecimal costo = new BigDecimal(0);
		try{
			List<Actividad> actividades = ActividadDAO.getActividadesPorObjeto(subproducto.getId(), 4);
			if(actividades != null && actividades.size() > 0){
				for(Actividad actividad : actividades){
					costo = costo.add(actividad.getCosto() != null ? actividad.getCosto() : new BigDecimal(0));
				}
			}else{				
				costo = subproducto.getCosto() != null ? subproducto.getCosto() : new BigDecimal(0);
			}
		}catch(Exception e){
			CLogger.write("14", Proyecto.class, e);
		}
		
		return costo;
	}
	
	public static Date calcularFechaMinima(Subproducto subproducto){
		Date ret = null;
		try{
			List<Actividad> actividades = ActividadDAO.getActividadesPorObjeto(subproducto.getId(), 4);
			if(actividades != null && actividades.size() > 0){
				Date fechaMinima = new Date();
				for(Actividad actividad : actividades){
					if(ret == null)
						ret = actividad.getFechaInicio();
					else{
						fechaMinima = actividad.getFechaInicio();
						
						if(ret.after(fechaMinima))
							ret = fechaMinima;
					}
				}
			}else
				ret = subproducto.getFechaInicio();
		}catch(Exception e){
			CLogger.write("15", Proyecto.class, e);
		}
		
		return ret;
	}
	
	public static Date calcularFechaMaxima(Subproducto subproducto){
		Date ret = null;
		try{
			List<Actividad> actividades = ActividadDAO.getActividadesPorObjeto(subproducto.getId(), 4);			
			if(actividades != null && actividades.size() > 0){
				Date fechaMaxima = new Date();
				for(Actividad actividad : actividades){
					if(ret == null)
						ret = actividad.getFechaFin();
					else{
						fechaMaxima = actividad.getFechaInicio();
						
						if(ret.before(fechaMaxima))
							ret = fechaMaxima;
					}
				}
			}else
				ret = subproducto.getFechaFin();
		}catch(Exception e){
			CLogger.write("16", Proyecto.class, e);
		}
		
		return ret;
	}
}
