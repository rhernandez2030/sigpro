package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import utilities.CHibernateSession;
import utilities.CLogger;
import pojo.AsignacionRaci;
import pojo.Colaborador;

public class AsignacionRaciDAO {
	public static List<AsignacionRaci> getAsignacionesRaci(Integer objetoId, int objetoTipo){
		List<AsignacionRaci> ret = new ArrayList<AsignacionRaci>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = String.join(" ", "select a ",
											"from AsignacionRaci a ",
											"where a.estado = 1 ",
											"and a.objetoId = :objId ",
											"and a.objetoTipo  = :objTipo " );
			
			Query<AsignacionRaci> criteria = session.createQuery(query, AsignacionRaci.class);
			criteria.setParameter("objId", objetoId);
			criteria.setParameter("objTipo", objetoTipo);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("1", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static List<Colaborador> getColaboradoresPorProyecto(Integer proyectoId){
		List<Colaborador> ret = new ArrayList<Colaborador>();
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = String.join(" ", "select distinct c", 
					"FROM AsignacionRaci ar",
					"inner join ar.colaborador c",
					"where ar.objetoTipo = 5",
					"and ar.estado = 1",
					"and ar.objetoId in (", 
						"select a.id",
						"from Actividad a",
						"where a.estado = 1",
						"and a.treePath like '"+(10000000+proyectoId)+"%'",
					")");
			
			Query<Colaborador> criteria = session.createQuery(query, Colaborador.class);
			
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("2", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static AsignacionRaci getAsignacionPorRolTarea(Integer objetoId, Integer objetoTipo , String rol){
		AsignacionRaci ret = null;
		List<AsignacionRaci> listRet = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = String.join(" ", "select a from AsignacionRaci a",
							"where a.objetoId = :objId",
							"and a.objetoTipo = :objTipo",
							"and lower(a.rolRaci) = :rol",
							"and a.estado = 1");
			
			Query<AsignacionRaci> criteria = session.createQuery(query, AsignacionRaci.class);
			criteria.setParameter("objId", objetoId);
			criteria.setParameter("objTipo", objetoTipo);
			criteria.setParameter("rol", rol.toLowerCase());
			
			listRet = criteria.getResultList();
			
			ret = !listRet.isEmpty() ? listRet.get(0) : null;
		}
		catch(Throwable e){
			CLogger.write("3", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	
	public static Colaborador getResponsablePorRol(Integer objetoId, int objetoTipo,String rol){
		Colaborador ret = null;
		List<Colaborador> listRet = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = String.join(" ", "select c ",
									"from AsignacionRaci a", 
									"inner join a.colaborador c",
									"where a.objetoId = :objId",
									"and a.objetoTipo = :objTipo",
									"and a.rolRaci = :rol ",
									"and a.estado = 1 " );
			
			Query<Colaborador> criteria = session.createQuery(query, Colaborador.class);
			criteria.setParameter("objId", objetoId);
			criteria.setParameter("objTipo", objetoTipo);
			criteria.setParameter("rol", rol);
			listRet = criteria.getResultList();
			
			ret = !listRet.isEmpty() ? listRet.get(0) : null;
		}
		catch(Throwable e){
			CLogger.write("4", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static boolean guardarAsignacion(AsignacionRaci asignacion){
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();
			session.saveOrUpdate(asignacion);
			session.getTransaction().commit();
			ret = true;
		}
		catch(Throwable e){
			CLogger.write("5", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	
	
	public static boolean eliminarTotalAsignacion(AsignacionRaci asignacion){
		boolean ret = false;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(asignacion);
			session.getTransaction().commit();
			ret = true;
		}
		catch(Throwable e){
			CLogger.write("7", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}
	
	public static List<AsignacionRaci> getAsignacionPorTarea(Integer objetoId, Integer objetoTipo){
		List<AsignacionRaci> ret = null;
		Session session = CHibernateSession.getSessionFactory().openSession();
		try{
			String query = String.join(" ", "select a from AsignacionRaci a",
							"where a.objetoId = :objId",
							"and a.objetoTipo = :objTipo",
							"and a.estado = 1");
			
			Query<AsignacionRaci> criteria = session.createQuery(query, AsignacionRaci.class);
			criteria.setParameter("objId", objetoId);
			criteria.setParameter("objTipo", objetoTipo);
			ret = criteria.getResultList();
		}
		catch(Throwable e){
			CLogger.write("8", AsignacionRaciDAO.class, e);
		}
		finally{
			session.close();
		}
		return ret;
	}

}
