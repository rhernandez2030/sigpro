package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import dao.ComponenteDAO;
import dao.ComponentePropiedadDAO;
import dao.ComponentePropiedadValorDAO;
import pojo.Componente;
import pojo.ComponentePropiedad;
import pojo.ComponentePropiedadValor;
import pojo.ComponentePropiedadValorId;
import pojo.ComponenteTipo;
import pojo.Proyecto;
import pojo.UnidadEjecutora;
import utilities.Utils;

/**
 * Servlet implementation class SComponente
 */
@WebServlet("/SComponente")
public class SComponente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	class stcomponente{
		Integer id;
		String nombre;
		String descripcion;
		String usuarioCreo;
		String usuarioActualizo;
		String fechaCreacion;
		String fechaActualizacion;
		Integer componentetipoid;
		String componentetiponombre;
		int estado;
		Long snip;
		Integer programa;
		Integer subprograma;
		Integer proyecto_;
		Integer obra;
		Integer fuente;
		int unidadejecutoraid;
		String unidadejecutoranombre;
	}

	class stdatadinamico {
		String id;
		String tipo;
		String label;
		String valor;
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SComponente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String response_text = "{ \"success\": false }";

		response.setHeader("Content-Encoding", "gzip");
		response.setCharacterEncoding("UTF-8");

        OutputStream output = response.getOutputStream();
		GZIPOutputStream gz = new GZIPOutputStream(output);
        gz.write(response_text.getBytes("UTF-8"));
        gz.close();
        output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession sesionweb = request.getSession();
		String usuario = sesionweb.getAttribute("usuario")!= null ? sesionweb.getAttribute("usuario").toString() : null;
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, String>>(){}.getType();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		;
		Map<String, String> map = gson.fromJson(sb.toString(), type);
		String accion = map.get("accion");
		String response_text="";
		if(accion.equals("getComponentesPagina")){
			int pagina = map.get("pagina")!=null  ? Integer.parseInt(map.get("pagina")) : 0;
			int numeroCooperantes = map.get("numerocomponentes")!=null  ? Integer.parseInt(map.get("numerocomponentes")) : 0;
			List<Componente> componentes = ComponenteDAO.getComponentesPagina(pagina, numeroCooperantes,usuario);
			List<stcomponente> stcomponentes=new ArrayList<stcomponente>();
			for(Componente componente:componentes){
				stcomponente temp =new stcomponente();
				temp.descripcion = componente.getDescripcion();
				temp.estado = componente.getEstado();
				temp.fechaActualizacion = Utils.formatDate(componente.getFechaActualizacion());
				temp.fechaCreacion = Utils.formatDate(componente.getFechaCreacion());
				temp.id = componente.getId();
				temp.nombre = componente.getNombre();
				temp.usuarioActualizo = componente.getUsuarioActualizo();
				temp.usuarioCreo = componente.getUsuarioCreo();
				temp.componentetipoid = componente.getComponenteTipo().getId();
				temp.componentetiponombre = componente.getComponenteTipo().getNombre();
				temp.snip = componente.getSnip();
				temp.programa = componente.getPrograma();
				temp.subprograma = componente.getSubprograma();
				temp.proyecto_ = componente.getProyecto_1();
				temp.obra = componente.getActividadObra();
				temp.fuente = componente.getFuente();
				temp.unidadejecutoraid = componente.getUnidadEjecutora().getUnidadEjecutora();
				temp.unidadejecutoranombre = componente.getUnidadEjecutora().getNombre();
				stcomponentes.add(temp);
			}

			response_text=new GsonBuilder().serializeNulls().create().toJson(stcomponentes);
	        response_text = String.join("", "\"componentes\":",response_text);
	        response_text = String.join("", "{\"success\":true,", response_text,"}");
		}
		else if(accion.equals("getComponentes")){
			List<Componente> componentes = ComponenteDAO.getComponentes(usuario);
			List<stcomponente> stcomponentes=new ArrayList<stcomponente>();
			for(Componente componente:componentes){
				stcomponente temp =new stcomponente();

				temp.descripcion = componente.getDescripcion();
				temp.estado = componente.getEstado();
				temp.fechaActualizacion = Utils.formatDate(componente.getFechaActualizacion());
				temp.fechaCreacion = Utils.formatDate(componente.getFechaCreacion());
				temp.id = componente.getId();
				temp.nombre = componente.getNombre();
				temp.usuarioActualizo = componente.getUsuarioActualizo();
				temp.usuarioCreo = componente.getUsuarioCreo();
				temp.componentetipoid = componente.getComponenteTipo().getId();
				temp.componentetiponombre = componente.getComponenteTipo().getNombre();
				temp.snip = componente.getSnip();
				temp.programa = componente.getPrograma();
				temp.subprograma = componente.getSubprograma();
				temp.proyecto_ = componente.getProyecto_1();
				temp.obra = componente.getActividadObra();
				temp.fuente = componente.getFuente();
				temp.unidadejecutoraid = componente.getUnidadEjecutora().getUnidadEjecutora();
				temp.unidadejecutoranombre = componente.getUnidadEjecutora().getNombre();
				stcomponentes.add(temp);
			}

			response_text=new GsonBuilder().serializeNulls().create().toJson(stcomponentes);
	        response_text = String.join("", "\"componentes\":",response_text);
	        response_text = String.join("", "{\"success\":true,", response_text,"}");
		}
		else if(accion.equals("guardarComponente")){
			try{
				boolean result = false;
				boolean esnuevo = map.get("esnuevo").equals("true");
				int id = map.get("id")!=null ? Integer.parseInt(map.get("id")) : 0;
				if(id>0 || esnuevo){
					String nombre = map.get("nombre");
					String descripcion = map.get("descripcion");
					int componentetipoid = map.get("componentetipoid")!=null ? Integer.parseInt(map.get("componentetipoid")) : 0;
					int proyectoid= map.get("proyectoid")!=null ? Integer.parseInt(map.get("proyectoid")) : 0;
					int unidadEjecutoraId = map.get("unidadejecutoraid") !=null ? Integer.parseInt(map.get("unidadejecutoraid")) : 0;
					Long snip = map.get("snip")!=null ? Long.parseLong(map.get("snip")) : null;
					Integer programa = map.get("programa")!=null ? Integer.parseInt(map.get("programa")) : null;
					Integer subPrograma = map.get("subprograma")!=null ?  Integer.parseInt(map.get("subprograma")) : null;
					Integer proyecto_ = map.get("proyecto_")!=null ? Integer.parseInt(map.get("proyecto_")) : null;
					Integer obra = map.get("obra")!=null ? Integer.parseInt(map.get("obra")):null;
					Integer fuente = map.get("fuente")!=null ? Integer.parseInt(map.get("fuente")):null;
					ComponenteTipo componenteTipo= new ComponenteTipo();
					componenteTipo.setId(componentetipoid);

					UnidadEjecutora unidadEjecutora = new UnidadEjecutora();
					unidadEjecutora.setUnidadEjecutora(unidadEjecutoraId);


					Proyecto proyecto = new Proyecto();
					proyecto .setId(proyectoid);

					type = new TypeToken<List<stdatadinamico>>() {
					}.getType();

					List<stdatadinamico> datos = gson.fromJson(map.get("datadinamica"), type);

					Componente componente;
					if(esnuevo){
						componente = new Componente(componenteTipo, proyecto, unidadEjecutora, nombre,
								descripcion, usuario, null, new DateTime().toDate(), null, 1,
								snip, programa, subPrograma, proyecto_, obra, fuente, null, null, null);
					}
					else{
						componente = ComponenteDAO.getComponentePorId(id,usuario);
						componente.setNombre(nombre);
						componente.setDescripcion(descripcion);
						componente.setUsuarioActualizo(usuario);
						componente.setFechaActualizacion(new DateTime().toDate());
						componente.setSnip(snip);
						componente.setPrograma(programa);
						componente.setSubprograma(subPrograma);
						componente.setProyecto_1(proyecto_);
						componente.setActividadObra(obra);
						componente.getFuente();
					}
					result = ComponenteDAO.guardarComponente(componente);

					Set<ComponentePropiedadValor> valores_temp = componente.getComponentePropiedadValors();
					componente.setComponentePropiedadValors(null);
					if (valores_temp!=null){
						for (ComponentePropiedadValor valor : valores_temp){
							ComponentePropiedadValorDAO.eliminarTotalComponentePropiedadValor(valor);
						}
					}

					for (stdatadinamico data : datos) {
						ComponentePropiedad componentePropiedad = ComponentePropiedadDAO.getComponentePropiedadPorId(Integer.parseInt(data.id));
						ComponentePropiedadValorId idValor = new ComponentePropiedadValorId(componente.getId(),Integer.parseInt(data.id));
						ComponentePropiedadValor valor = new ComponentePropiedadValor(idValor, componente, componentePropiedad, usuario, new DateTime().toDate());

						switch (componentePropiedad.getDatoTipo().getId()){
							case 1:
								valor.setValorString(data.valor);
								break;
							case 2:
								valor.setValorEntero(Integer.parseInt(data.valor));
								break;
							case 3:
								valor.setValorDecimal(new BigDecimal(data.valor));
								break;
							case 4:

								break;
							case 5:
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								valor.setValorTiempo(sdf.parse(data.valor));
								break;
						}
						result = (result && ComponentePropiedadValorDAO.guardarComponentePropiedadValor(valor));
					}
					response_text = String.join("","{ \"success\": ",(result ? "true" : "false"),", "
							+ "\"id\": " + componente.getId() +" }");
				}
				else
					response_text = "{ \"success\": false }";
			}
			catch (Throwable e){
				response_text = "{ \"success\": false }";
			}
		}
		else if(accion.equals("borrarComponente")){
			int id = map.get("id")!=null ? Integer.parseInt(map.get("id")) : 0;
			if(id>0){
				Componente componente = ComponenteDAO.getComponentePorId(id,usuario);
				componente.setUsuarioActualizo(usuario);
				response_text = String.join("","{ \"success\": ",(ComponenteDAO.eliminarComponente(componente) ? "true" : "false")," }");
			}
			else
				response_text = "{ \"success\": false }";
		}
		else if(accion.equals("numeroComponentes")){
			response_text = String.join("","{ \"success\": true, \"totalcomponentes\":",ComponenteDAO.getTotalComponentes(usuario).toString()," }");
		}
		else if(accion.equals("numeroComponentesPorProyecto")){
			String filtro_nombre = map.get("filtro_nombre");
			String filtro_usuario_creo = map.get("filtro_usuario_creo");
			String filtro_fecha_creacion = map.get("filtro_fecha_creacion");
			int proyectoId = map.get("proyectoid")!=null  ? Integer.parseInt(map.get("proyectoid")) : 0;
			response_text = String.join("","{ \"success\": true, \"totalcomponentes\":",ComponenteDAO.getTotalComponentesPorProyecto(proyectoId, filtro_nombre, filtro_usuario_creo, filtro_fecha_creacion,usuario).toString()," }");
		}
		else if(accion.equals("getComponentesPaginaPorProyecto")){
			int pagina = map.get("pagina")!=null  ? Integer.parseInt(map.get("pagina")) : 0;
			int proyectoId = map.get("proyectoid")!=null  ? Integer.parseInt(map.get("proyectoid")) : 0;
			int numeroCooperantes = map.get("numerocomponentes")!=null  ? Integer.parseInt(map.get("numerocomponentes")) : 0;
			String filtro_nombre = map.get("filtro_nombre");
			String filtro_usuario_creo = map.get("filtro_usuario_creo");
			String filtro_fecha_creacion = map.get("filtro_fecha_creacion");
			String columna_ordenada = map.get("columna_ordenada");
			String orden_direccion = map.get("orden_direccion");

			List<Componente> componentes = ComponenteDAO.getComponentesPaginaPorProyecto(pagina, numeroCooperantes,proyectoId
					,filtro_nombre,filtro_usuario_creo,filtro_fecha_creacion,columna_ordenada,orden_direccion,usuario);
			List<stcomponente> stcomponentes=new ArrayList<stcomponente>();
			for(Componente componente:componentes){
				stcomponente temp =new stcomponente();
				temp.descripcion = componente.getDescripcion();
				temp.estado = componente.getEstado();
				temp.fechaActualizacion = Utils.formatDate(componente.getFechaActualizacion());
				temp.fechaCreacion = Utils.formatDate(componente.getFechaCreacion());
				temp.id = componente.getId();
				temp.nombre = componente.getNombre();
				temp.usuarioActualizo = componente.getUsuarioActualizo();
				temp.usuarioCreo = componente.getUsuarioCreo();
				temp.componentetipoid = componente.getComponenteTipo().getId();
				temp.componentetiponombre = componente.getComponenteTipo().getNombre();
				temp.snip = componente.getSnip();
				temp.programa = componente.getPrograma();
				temp.subprograma = componente.getSubprograma();
				temp.proyecto_ = componente.getProyecto_1();
				temp.obra = componente.getActividadObra();
				temp.fuente = componente.getFuente();
				temp.unidadejecutoraid = componente.getUnidadEjecutora().getUnidadEjecutora();
				temp.unidadejecutoranombre = componente.getUnidadEjecutora().getNombre();
				stcomponentes.add(temp);
			}

			response_text=new GsonBuilder().serializeNulls().create().toJson(stcomponentes);
	        response_text = String.join("", "\"componentes\":",response_text);
	        response_text = String.join("", "{\"success\":true,", response_text,"}");
		}
		else if(accion.equals("obtenerComponentePorId")){
			Integer id = map.get("id")!=null ? Integer.parseInt(map.get("id")) : 0;
			Componente componente = ComponenteDAO.getComponentePorId(id,usuario);

			response_text = String.join("","{ \"success\": ",(componente!=null && componente.getId()!=null ? "true" : "false"),", "
				+ "\"id\": " + (componente!=null ? componente.getId():"0") +", "
				+ "\"nombre\": \"" + (componente!=null ? componente.getNombre():"Indefinido") +"\" }");



		}
		else{
			response_text = "{ \"success\": false }";
		}

		response.setHeader("Content-Encoding", "gzip");
		response.setCharacterEncoding("UTF-8");


        OutputStream output = response.getOutputStream();
		GZIPOutputStream gz = new GZIPOutputStream(output);
        gz.write(response_text.getBytes("UTF-8"));
        gz.close();
        output.close();
	}
}