package dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import pojo.Actividad;
import pojo.Componente;
import pojo.Producto;
import pojo.Proyecto;
import pojo.Subcomponente;
import pojo.Subproducto;
import utilities.CHibernateSession;
import utilities.CLogger;

public class EstructuraProyectoDAO {
		
	
	
	public static List<?> getEstructuraProyecto(Integer idProyecto){
		List<?> ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		
		try{

			String query =
					"select * from ( "+
					"select p.id, p.nombre, 0 objeto_tipo,  p.treePath, p.fecha_inicio, "+
					"p.fecha_fin, p.duracion, p.duracion_dimension,p.costo,0, p.acumulacion_costoid,  "+
					"p.programa, p.subprograma, p.proyecto, p.actividad, p.obra "+
					"from proyecto p "+
					"where p.id= ?1 and p.estado=1  "+
					"union "+
					"select c.id, c.nombre, 1 objeto_tipo,  c.treePath, c.fecha_inicio, "+
					"c.fecha_fin , c.duracion, c.duracion_dimension,c.costo,0,c.acumulacion_costoid, "+
					"c.programa, c.subprograma, c.proyecto, c.actividad, c.obra "+
					"from componente c "+
					"where c.proyectoid=?1 and c.estado=1  "+
					"union "+
					"select s.id, s.nombre, 2 objeto_tipo,  s.treePath, s.fecha_inicio, "+
					"s.fecha_fin , s.duracion, s.duracion_dimension,s.costo,0,s.acumulacion_costoid, "+
					"s.programa, s.subprograma, s.proyecto, s.actividad, s.obra "+
					"from subcomponente s "+
					"left outer join componente c on c.id=s.componenteid "+
					"where c.proyectoid=?1 and s.estado=1 and c.estado=1  "+
					"union "+
					"select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
					"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid, "+
					"pr.programa, pr.subprograma, pr.proyecto, pr.actividad, pr.obra "+
					"from producto pr "+
					"left outer join componente c on c.id=pr.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1   "+
					"union "+
					"select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
					"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid, "+
					"pr.programa, pr.subprograma, pr.proyecto, pr.actividad, pr.obra "+
					"from producto pr "+
					"left outer join subcomponente sc on sc.id=pr.subcomponenteid   "+  
					"left outer join componente c on c.id = sc.componenteid   "+
					"left outer join proyecto p on p.id=c.proyectoid   "+  
					"where p.id= ?1 and p.estado=1 and c.estado=1 and sc.estado=1 and pr.estado=1   "+
					"union   "+
					"select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
					"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid, "+
					"sp.programa, sp.subprograma, sp.proyecto, sp.actividad, sp.obra "+
					"from subproducto sp "+
					"left outer join producto pr on pr.id=sp.productoid "+
					"left outer join componente c on c.id=pr.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1 and sp.estado=1 and sp.id  "+
					"union   "+
					"select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
					"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid, "+
					"sp.programa, sp.subprograma, sp.proyecto, sp.actividad, sp.obra "+
					"from subproducto sp "+
					"left outer join producto pr on pr.id=sp.productoid "+
					"left outer join subcomponente sc on sc.id=pr.subcomponenteid "+
					"left outer join componente c on c.id=sc.subcomponenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and sc.estado=1 and pr.estado=1 and sp.estado=1 and sp.id  "+
					"union "+
					"select a.id, a.nombre, 5 objeto_tipo,  a.treePath, a.fecha_inicio, "+
					"a.fecha_fin , a.duracion, a.duracion_dimension,a.costo,a.pred_objeto_id,a.acumulacion_costo acumulacion_costoid, "+
					"a.programa, a.subprograma, a.proyecto, a.actividad, a.obra "+
					"from actividad a "+
					"where a.estado=1 and  a.treepath like '"+(10000000+idProyecto)+"%'"+
					") arbol "+
					"order by treePath ";			
				
			Query<?> criteria = session.createNativeQuery(query);
			criteria.setParameter("1", idProyecto);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("1", EstructuraProyectoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static List<?> getEstructuraProyecto(Integer idProyecto, String usuario){
		List<?> ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		
		try{
			String query =
				"select * from ( "+
				"select p.id, p.nombre, 0 objeto_tipo,  p.treePath, p.fecha_inicio, "+
				"p.fecha_fin, p.duracion, p.duracion_dimension,p.costo,0, p.acumulacion_costoid  "+
				"from proyecto p "+
				"where p.id= ?1 and p.estado=1 and p.id in ( select proyectoid from proyecto_usuario where usuario = ?2 ) "+
				"union "+
				"select c.id, c.nombre, 1 objeto_tipo,  c.treePath, c.fecha_inicio, "+
				"c.fecha_fin , c.duracion, c.duracion_dimension,c.costo,0,c.acumulacion_costoid "+
				"from componente c "+
				"where c.proyectoid=?1 and c.estado=1 and c.id in (select componenteid from componente_usuario where usuario = ?2 ) "+
				"union "+
				"select s.id, s.nombre, 2 objeto_tipo,  s.treePath, s.fecha_inicio, "+
				"s.fecha_fin , s.duracion, s.duracion_dimension,s.costo,0,s.acumulacion_costoid "+
				"from subcomponente s "+
				"left outer join componente c on c.id=s.componenteid "+
				"where c.proyectoid=?1 and s.estado=1 and c.estado=1 and s.id in (select subcomponenteid from subcomponente_usuario where usuario = ?2 ) "+
				"union "+
				"select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
				"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid "+
				"from producto pr "+
				"left outer join componente c on c.id=pr.componenteid "+
				"left outer join proyecto p on p.id=c.proyectoid "+
				"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1 and pr.id in ( select productoid from producto_usuario where usuario = ?2 )  "+
				"union "+
				"select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
				"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid "+
				"from producto pr "+
				"left outer join subcomponente s on s.id=pr.subcomponenteid "+
				"left outer join componente c on c.id=s.componenteid "+
				"left outer join proyecto p on p.id=c.proyectoid "+
				"where p.id= ?1 and p.estado=1 and c.estado=1 and s.estado=1 and pr.estado=1 and pr.id in ( select productoid from producto_usuario where usuario = ?2 )  "+
				"union "+
				"select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
				"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid "+
				"from subproducto sp "+
				"left outer join producto pr on pr.id=sp.productoid "+
				"left outer join componente c on c.id=pr.componenteid "+
				"left outer join proyecto p on p.id=c.proyectoid "+
				"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1 and sp.estado=1 and sp.id and pr.id in ( select productoid from producto_usuario where usuario = ?2 ) "+
				"union "+
				"select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
				"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid "+
				"from subproducto sp "+
				"left outer join producto pr on pr.id=sp.productoid "+
				"left outer join subcomponente sc on sc.id=pr.subcomponenteid "+
				"left outer join componente c on c.id=sc.componenteid "+
				"left outer join proyecto p on p.id=c.proyectoid "+
				"where p.id= ?1 and p.estado=1 and c.estado=1 and sc.estado=1 and pr.estado=1 and sp.estado=1 and sp.id and pr.id in ( select productoid from producto_usuario where usuario = ?2 ) "+
				"union "+
				"select a.id, a.nombre, 5 objeto_tipo,  a.treePath, a.fecha_inicio, "+
				"a.fecha_fin , a.duracion, a.duracion_dimension,a.costo,a.pred_objeto_id,a.acumulacion_costo acumulacion_costoid "+
				"from actividad a "+
				"where a.estado=1 and  a.treepath like '"+(10000000+idProyecto)+"%'"+
				") arbol "+
				"order by treePath ";			
			
			Query<?> criteria = session.createNativeQuery(query);
			criteria.setParameter("1", idProyecto);
			criteria.setParameter("2", usuario);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("1", EstructuraProyectoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static Nodo getEstructuraProyectoArbol(int id, String usuario){
		Nodo root = null;
		List<?> estructuras = EstructuraProyectoDAO.getEstructuraProyecto(id, usuario);
		if(estructuras.size()>0){
			try{
				Object[] dato = (Object[]) estructuras.get(0);
				int id_ = dato[0]!=null ? (Integer)dato[0] : 0;
				int objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
				String nombre = dato[1]!=null ? (String)dato[1] : null;
				int nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
				root = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false);
				Nodo nivel_actual_estructura = root;
				for(int i=1; i<estructuras.size(); i++){
					dato = (Object[]) estructuras.get(i);
					id_ = dato[0]!=null ? (Integer)dato[0] : 0;
					objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
					nombre = dato[1]!=null ? (String)dato[1] : null;
					nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
					Nodo nodo = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false);
					if(nodo.nivel!=nivel_actual_estructura.nivel+1){
						if(nodo.nivel>nivel_actual_estructura.nivel){
							nivel_actual_estructura = nivel_actual_estructura.children.get(nivel_actual_estructura.children.size()-1);
						}
						else{
							int retornar = nivel_actual_estructura.nivel-nodo.nivel+1;
							for(int j=0; j<retornar; j++)
								nivel_actual_estructura=nivel_actual_estructura.parent;
						}
					}
					nodo.parent = nivel_actual_estructura;
					nivel_actual_estructura.children.add(nodo);
				}
			}
			catch(Throwable e){
				root = null;
				CLogger.write("2", EstructuraProyectoDAO.class, e);
			}
		}
		return root;
	}
	
	public static Nodo getEstructuraProyectoArbolProyectosComponentesProductos(int id,String usuario){
		Nodo root = null;
		List<?> estructuras = EstructuraProyectoDAO.getEstructuraProyecto(id);
		if(estructuras.size()>0){
			try{
				Object[] dato = (Object[]) estructuras.get(0);
				int id_ = dato[0]!=null ? (Integer)dato[0] : 0;
				int objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
				String nombre = dato[1]!=null ? (String)dato[1] : null;
				int nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
				boolean estado = checkPermiso(id,objeto_tipo,usuario);
				root = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, estado);
				Nodo nivel_actual_estructura = root;
				for(int i=1; i<estructuras.size(); i++){
					dato = (Object[]) estructuras.get(i);
					id_ = dato[0]!=null ? (Integer)dato[0] : 0;
					objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
					nombre = dato[1]!=null ? (String)dato[1] : null;
					nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
					estado = checkPermiso(id_,objeto_tipo,usuario);
					if(objeto_tipo<4){
						Nodo nodo = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, estado);
						if(nodo.nivel!=nivel_actual_estructura.nivel+1){
							if(nodo.nivel>nivel_actual_estructura.nivel){
								nivel_actual_estructura = nivel_actual_estructura.children.get(nivel_actual_estructura.children.size()-1);
							}
							else{
								int retornar = nivel_actual_estructura.nivel-nodo.nivel+1;
								for(int j=0; j<(retornar); j++)
									nivel_actual_estructura=nivel_actual_estructura.parent;
							}
						}
						nodo.parent = nivel_actual_estructura;
						nivel_actual_estructura.children.add(nodo);
					}
				}
			}
			catch(Throwable e){
				root = null;
				CLogger.write("3", EstructuraProyectoDAO.class, e);
			}
		}
		return root;
	}
	
	public static List<?> getActividadesProyecto(Integer prestamoId){
		List<?> ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String str_Query = String.join(" ", "select a.id, a.nombre, 5 objeto_tipo,  a.treePath, a.nivel, a.fecha_inicio,", 
					"a.fecha_fin , a.duracion, a.duracion_dimension,a.costo,a.pred_objeto_id,a.acumulacion_costo acumulacion_costoid,",
					"a.porcentaje_avance", 
					"from actividad a", 
					"where a.estado=1 and a.treepath like '"+(10000000+prestamoId)+"%'");
			
			Query<?> criteria = session.createNativeQuery(str_Query);			
			ret = criteria.getResultList();
		}catch(Exception e){
			CLogger.write("4", EstructuraProyectoDAO.class, e);
		}finally{
			session.close();
		}
		
		return ret;
	}
	
	public static List<?> getActividadesByTreePath(String treePath, Integer idPrestamo){
		List<Object[]> ret = new ArrayList<Object[]>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			List<?> lstActividadesPrestamo = getActividadesProyecto(idPrestamo);
			Object[] temp = new Object[5];
			for(Object objeto : lstActividadesPrestamo){
				Object[] obj = (Object[])objeto;
				String treePathObj = (String)obj[3];
				if(treePathObj != null && treePath != null && treePathObj.length() >= treePath.length()){
					if(treePathObj.substring(0, treePath.length()).equals(treePath)){
						temp = new Object[]{(Integer)obj[0], (String)obj[1], (Date)obj[5], (Date)obj[6], (Integer)obj[12]};
						ret.add(temp);
					}
				}
			}
		}catch(Exception e){
			CLogger.write("5", EstructuraProyectoDAO.class, e);
		}finally{
			session.close();
		}
		
		return ret;
	}

	public static ArrayList<Nodo> getEstructuraProyectosArbol(String usuario) {
		ArrayList<Nodo> ret = new ArrayList<Nodo>();
		List<Proyecto> proyectos = ProyectoDAO.getTodosProyectos();
		if(proyectos!=null){
			for(int i=0; i<proyectos.size(); i++){
				Nodo proyecto = getEstructuraProyectoArbolProyectosComponentesProductos(proyectos.get(i).getId(),usuario);
				if(proyecto!=null)
					ret.add(proyecto);
			}
		}
		return (ret.size()>0 ? ret : null);
	}
	
	public static boolean checkPermiso(int id, int objeto_tipo, String usuario){
		boolean ret = false;
		switch(objeto_tipo){
			case 0: ret = UsuarioDAO.checkUsuarioProyecto(usuario,id); break;
			case 1: ret = UsuarioDAO.checkUsuarioComponente(usuario,id); break;
			case 2: ret = UsuarioDAO.checkUsuarioSubComponente(usuario,id); break;
			case 3: ret = UsuarioDAO.checkUsuarioProducto(usuario,id); break;
		}
		return ret;
	}
	
	public static List<ObjetoCosto> getHijosCompleto(String treePathPadre, List<ObjetoCosto> estruturaProyecto){
		ArrayList<ObjetoCosto> ret = new ArrayList<ObjetoCosto>();
		for(ObjetoCosto objeto : estruturaProyecto){
			String treePath = objeto.getTreePath();
			if(treePath != null){
				if(treePath.length() >= treePathPadre.length()+6){
					String path = treePath.substring(0, treePathPadre.length()); 
					if(path.equals(treePathPadre)){
						ret.add(objeto);
					}	
				}	
			}
		}
		
		return ret;
	}
	
	public static List<String> getHijos(String treePathPadre, List<?> estruturaProyecto){
		ArrayList<String> ret = new ArrayList<String>();
		for(Object objeto : estruturaProyecto){
			Object[] obj = (Object[])objeto;
			String treePath = (String)obj[3];
			if(treePath != null){
				if(treePath.length() == treePathPadre.length()+6){
					String path = treePath.substring(0, treePathPadre.length()); 
					if(path.equals(treePathPadre)){
						ret.add((Integer)obj[0]+ "," + ((BigInteger) obj[2]).intValue());
					}	
				}	
			}
		}
		
		return ret;
	}
	
	public static ArrayList<ArrayList<Nodo>> getEstructuraProyectoArbolCalculos(int id){
		ArrayList<ArrayList<Nodo>> ret = new ArrayList<ArrayList<Nodo>>();
		Nodo root = null;
		List<?> estructuras = EstructuraProyectoDAO.getEstructuraProyecto(id);
		if(estructuras.size()>0){
			try{
				int nivel_maximo = 0;
				Object[] dato = (Object[]) estructuras.get(0);
				int id_ = dato[0]!=null ? (Integer)dato[0] : 0;
				int objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
				String nombre = dato[1]!=null ? (String)dato[1] : null;
				int nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
				Timestamp fecha_inicio = (dato[4]!=null) ? new Timestamp(((Date)dato[4]).getTime()) : null;
				Timestamp fecha_fin = (dato[5]!=null) ? new Timestamp(((Date)dato[5]).getTime()) : null;
				Double costo = (dato[8]!=null) ? ((BigDecimal)dato[8]).doubleValue() : 0;
				root = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false, fecha_inicio, fecha_fin, costo,0);
				Nodo nivel_actual_estructura = root;
				ret.add(new ArrayList<Nodo>());
				ret.get(0).add(root);
				for(int i=1; i<estructuras.size(); i++){
					dato = (Object[]) estructuras.get(i);
					id_ = dato[0]!=null ? (Integer)dato[0] : 0;
					objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
					nombre = dato[1]!=null ? (String)dato[1] : null;
					nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
					fecha_inicio = (dato[4]!=null) ? new Timestamp(((Date)dato[4]).getTime()) : null;
					fecha_fin = (dato[5]!=null) ? new Timestamp(((Date)dato[5]).getTime()) : null;
					costo = (dato[8]!=null) ? ((BigDecimal)dato[8]).doubleValue() : 0;
					nivel_maximo = nivel_maximo <  nivel ? nivel : nivel_maximo;
					Nodo nodo = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false, fecha_inicio, fecha_fin, costo,0);
					if(nodo.nivel!=nivel_actual_estructura.nivel+1){
						if(nodo.nivel>nivel_actual_estructura.nivel){
							nivel_actual_estructura = nivel_actual_estructura.children.get(nivel_actual_estructura.children.size()-1);
						}
						else{
							int retornar = nivel_actual_estructura.nivel-nodo.nivel+1;
							for(int j=0; j<retornar; j++)
								nivel_actual_estructura=nivel_actual_estructura.parent;
						}
					}
					nodo.parent = nivel_actual_estructura;
					nivel_actual_estructura.children.add(nodo);
					if(ret.size()<nivel){
						ret.add(new ArrayList<Nodo>());
						ret.get(ret.size()-1).add(nodo);
					}
					else{
						ret.get(nivel-1).add(nodo);
					}
				}
			}
			catch(Throwable e){
				root = null;
				CLogger.write("6", EstructuraProyectoDAO.class, e);
			}
		}
		return ret;
	}
	
	public static List<?> getEstructuraObjeto(Integer objetoId, Integer objetoTipo){
		List<?> ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		String treePath_inicio="";
		switch(objetoTipo){
			case 0: Proyecto proyecto = ProyectoDAO.getProyecto(objetoId); treePath_inicio = (proyecto!=null) ? proyecto.getTreePath() : null; break;
			case 1: Componente componente = ComponenteDAO.getComponente(objetoId); treePath_inicio = (componente!=null) ? componente.getTreePath() : null; break;
			case 2: Subcomponente subcomponente = SubComponenteDAO.getSubComponente(objetoId); treePath_inicio = (subcomponente!=null) ? subcomponente.getTreePath() : null; break;
			case 3: Producto producto = ProductoDAO.getProductoPorId(objetoId); treePath_inicio = (producto!=null) ? producto.getTreePath() : null; break;
			case 4: Subproducto subproducto = SubproductoDAO.getSubproductoPorId(objetoId); treePath_inicio = (subproducto!=null) ? subproducto.getTreePath() : null; break;
			case 5: Actividad actividad = ActividadDAO.getActividadPorId(objetoId); treePath_inicio = (actividad!=null) ? actividad.getTreePath() : null; break;
		}
		try{

			String query =
					"select * from ( "+
					( objetoTipo<=0 ? 
					"select p.id, p.nombre, 0 objeto_tipo,  p.treePath, p.fecha_inicio, "+
					"p.fecha_fin, p.duracion, p.duracion_dimension,p.costo,0, p.acumulacion_costoid,  "+
					"p.programa, p.subprograma, p.proyecto, p.actividad, p.obra "+
					"from proyecto p "+
					"where p.id= ?1 and p.estado=1  "+
					"union " : "" ) +
					( objetoTipo<=1 ? 
					"select c.id, c.nombre, 1 objeto_tipo,  c.treePath, c.fecha_inicio, "+
					"c.fecha_fin , c.duracion, c.duracion_dimension,c.costo,0,c.acumulacion_costoid, "+
					"c.programa, c.subprograma, c.proyecto, c.actividad, c.obra "+
					"from componente c "+
					"where c.proyectoid=?1 and c.estado=1  "+
					"union " : "" ) +
					( objetoTipo<=2 ? 
					"select s.id, s.nombre, 2 objeto_tipo,  s.treePath, s.fecha_inicio, "+
					"s.fecha_fin , s.duracion, s.duracion_dimension,s.costo,0,s.acumulacion_costoid, "+
					"s.programa, s.subprograma, s.proyecto, s.actividad, s.obra "+
					"from subcomponente s "+
					"left outer join componente c on c.id=s.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and s.estado=1 and pr.estado=1   "+
					"union " : "" ) +
					( objetoTipo<=3 ? "select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
					"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid, "+
					"pr.programa, pr.subprograma, pr.proyecto, pr.actividad, pr.obra "+
					"from producto pr "+
					"left outer join componente c on c.id=pr.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1   "+
					"union "+
					"select pr.id, pr.nombre, 3 objeto_tipo , pr.treePath, pr.fecha_inicio, "+
					"pr.fecha_fin, pr.duracion, pr.duracion_dimension,pr.costo,0,pr.acumulacion_costoid, "+
					"pr.programa, pr.subprograma, pr.proyecto, pr.actividad, pr.obra "+
					"from producto pr "+
					"left outer join subcomponente s on s.id=pr.subcomponenteid "+
					"left outer join componente c on c.id=s.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and s.estado=1 and pr.estado=1   "+
					"union " : "")+
					( objetoTipo<=4 ? "select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
					"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid, "+
					"sp.programa, sp.subprograma, sp.proyecto, sp.actividad, sp.obra "+
					"from subproducto sp "+
					"left outer join producto pr on pr.id=sp.productoid "+
					"left outer join componente c on c.id=pr.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and pr.estado=1 and sp.estado=1 and sp.id  "+
					"union "+
					"select sp.id, sp.nombre, 4 objeto_tipo,  sp.treePath, sp.fecha_inicio, "+
					"sp.fecha_fin , sp.duracion, sp.duracion_dimension,sp.costo,0,sp.acumulacion_costoid, "+
					"sp.programa, sp.subprograma, sp.proyecto, sp.actividad, sp.obra "+
					"from subproducto sp "+
					"left outer join producto pr on pr.id=sp.productoid "+
					"left outer join subcomponente sc on sc.id=pr.subcomponenteid "+
					"left outer join componente c on c.id=sc.componenteid "+
					"left outer join proyecto p on p.id=c.proyectoid "+
					"where p.id= ?1 and p.estado=1 and c.estado=1 and sc.estado=1 and pr.estado=1 and sp.estado=1 and sp.id  "+
					"union " : "") +
					"select a.id, a.nombre, 5 objeto_tipo,  a.treePath, a.fecha_inicio, "+
					"a.fecha_fin , a.duracion, a.duracion_dimension,a.costo,a.pred_objeto_id,a.acumulacion_costo acumulacion_costoid, "+
					"a.programa, a.subprograma, a.proyecto, a.actividad, a.obra "+
					"from actividad a "+
					"where a.estado=1 and  a.treepath like '"+treePath_inicio+"%'"+
					") arbol "+
					"order by treePath ";			
				
			Query<?> criteria = session.createNativeQuery(query);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("7", EstructuraProyectoDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static ArrayList<ArrayList<Nodo>> getEstructuraObjetoArbolCalculos(Integer objetoId,Integer objetoTipo){
		ArrayList<ArrayList<Nodo>> ret = new ArrayList<ArrayList<Nodo>>();
		Nodo root = null;
		List<?> estructuras = EstructuraProyectoDAO.getEstructuraObjeto(objetoId,objetoTipo);
		if(estructuras.size()>0){
			try{
				int nivel_maximo = 0;
				Object[] dato = (Object[]) estructuras.get(0);
				int id_ = dato[0]!=null ? (Integer)dato[0] : 0;
				int objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
				String nombre = dato[1]!=null ? (String)dato[1] : null;
				int nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
				Timestamp fecha_inicio = (dato[4]!=null) ? new Timestamp(((Date)dato[4]).getTime()) : null;
				Timestamp fecha_fin = (dato[5]!=null) ? new Timestamp(((Date)dato[5]).getTime()) : null;
				Double costo = (dato[8]!=null) ? ((BigDecimal)dato[8]).doubleValue() : 0;
				root = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false, fecha_inicio, fecha_fin, costo,0);
				Nodo nivel_actual_estructura = root;
				ret.add(new ArrayList<Nodo>());
				ret.get(0).add(root);
				for(int i=1; i<estructuras.size(); i++){
					dato = (Object[]) estructuras.get(i);
					id_ = dato[0]!=null ? (Integer)dato[0] : 0;
					objeto_tipo = dato[2]!=null ? ((BigInteger)dato[2]).intValue() : 0;
					nombre = dato[1]!=null ? (String)dato[1] : null;
					nivel = (dato[3]!=null) ? ((String)dato[3]).length()/8 : 0;
					fecha_inicio = (dato[4]!=null) ? new Timestamp(((Date)dato[4]).getTime()) : null;
					fecha_fin = (dato[5]!=null) ? new Timestamp(((Date)dato[5]).getTime()) : null;
					costo = (dato[8]!=null) ? ((BigDecimal)dato[8]).doubleValue() : 0;
					nivel_maximo = nivel_maximo <  nivel ? nivel : nivel_maximo;
					Nodo nodo = new Nodo(id_, objeto_tipo, nombre, nivel, new ArrayList<Nodo>(), null, false, fecha_inicio, fecha_fin, costo,0);
					if(nodo.nivel!=nivel_actual_estructura.nivel+1){
						if(nodo.nivel>nivel_actual_estructura.nivel){
							nivel_actual_estructura = nivel_actual_estructura.children.get(nivel_actual_estructura.children.size()-1);
						}
						else{
							int retornar = nivel_actual_estructura.nivel-nodo.nivel+1;
							for(int j=0; j<retornar; j++)
								nivel_actual_estructura=nivel_actual_estructura.parent;
						}
					}
					nodo.parent = nivel_actual_estructura;
					nivel_actual_estructura.children.add(nodo);
					if(ret.size()<nivel){
						ret.add(new ArrayList<Nodo>());
						ret.get(ret.size()-1).add(nodo);
					}
					else{
						ret.get(nivel-1).add(nodo);
					}
				}
			}
			catch(Throwable e){
				root = null;
				CLogger.write("8", EstructuraProyectoDAO.class, e);
			}
		}
		return ret;
	}
	
}
