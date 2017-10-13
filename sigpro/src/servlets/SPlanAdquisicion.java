package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import dao.CategoriaAdquisicionDAO;
import dao.PlanAdquisicionDAO;
import dao.PlanAdquisicionPagoDAO;
import dao.TipoAdquisicionDAO;
import pojo.PlanAdquisicion;
import pojo.PlanAdquisicionPago;
import utilities.CLogger;
import utilities.Utils;

@WebServlet("/SPlanAdquisicion")
public class SPlanAdquisicion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public class stpago{
		String fechaPago;
		BigDecimal pago;
	}
	
	public class stadquisicion{
		Integer id;
		String tipoNombre;
		Integer tipoId;
		String categoriaNombre;
		Integer categoriaId;
		String medidaNombre;
		Integer cantidad;
		BigDecimal precioUnitario;
		BigDecimal total;
		Long nog;
		String numeroContrato;
		BigDecimal montoContrato;
		String preparacionDocumentoPlanificada;
		String preparacionDocumentoReal;
		String lanzamientoEventoPlanificada;
		String lanzamientoEventoReal;
		String recepcionOfertasPlanificada;
		String recepcionOfertasReal;
		String adjudicacionPlanificada;
		String adjudicacionReal;
		String firmaContratoPlanificada;
		String firmaContratoReal;
		stpago pagos[];
	}
		
    public SPlanAdquisicion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
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
			Map<String, String> map = gson.fromJson(sb.toString(), type);
			String accion = map.get("accion")!=null ? map.get("accion") : "";
			String response_text = "";
			
			if(accion.equals("guardarAdquisicion")){
				Integer objetoId = map.get("objetoId")!=null ? Utils.String2Int(map.get("objetoId")) : null;
				Integer objetoTipo = map.get("objetoTipo")!=null ? Utils.String2Int(map.get("objetoTipo")) : null;
				
				Date adjudicacionPlanificado = map.get("adjudicacionPlanificada")!=null ? Utils.stringToDateZ(map.get("adjudicacionPlanificada").toString()) : null;
				Date adjudicacionReal = map.get("adjudicacionReal")!=null ? Utils.stringToDateZ(map.get("adjudicacionReal").toString()) : null;
					Integer cantidad = map.get("cantidad")!=null ? Utils.String2Int(map.get("cantidad").toString()) : null;
					Integer categoriaId = map.get("categoriaId")!=null ? Utils.String2Int(map.get("categoriaId").toString()) : null;
					Date firmaContratoPlanificado = map.get("firmaContratoPlanificada")!=null ? Utils.stringToDateZ(map.get("firmaContratoPlanificada").toString()) : null;
					Date firmaContratoReal = map.get("firmaContratoReal")!=null ? Utils.stringToDateZ(map.get("firmaContratoReal").toString()) : null;
					Integer id = map.get("id")!=null ? Utils.String2Int(map.get("id").toString()) : null;
					Date lanzamientoEventoPlanificado = map.get("lanzamientoEventoPlanificada")!=null ? Utils.stringToDateZ(map.get("lanzamientoEventoPlanificada").toString()) : null;
					Date lanzamientoEventoReal = map.get("lanzamientoEventoReal")!=null ? Utils.stringToDateZ(map.get("lanzamientoEventoReal").toString()) : null;
					BigDecimal montoContrato = map.get("montoContrato")!=null ? Utils.String2BigDecimal(map.get("montoContrato").toString(),null) : null;
					Long nog = map.get("nog")!=null ? Utils.String2Long(map.get("nog").toString()) : null;
					String numeroContrato =  map.get("numeroContrato")!=null ? map.get("numeroContrato").toString() : null;
					BigDecimal precioUnitario =  map.get("precioUnitario")!=null ? Utils.String2BigDecimal(map.get("precioUnitario").toString(),null) : null;
					Date preparacionDocPlanificado = map.get("preparacionDocumentosPlanificada")!=null ? Utils.stringToDateZ(map.get("preparacionDocumentosPlanificada").toString()) : null;
					Date preparacionDocReal = map.get("preparacionDocumentosReal")!=null ? Utils.stringToDateZ(map.get("preparacionDocumentosReal").toString()) : null;
					Date recepcionOfertasPlanificado = map.get("recepcionOfertasPlanificada")!=null ? Utils.stringToDateZ(map.get("recepcionOfertasPlanificada").toString()) : null;
					Date recepcionOfertasReal = map.get("recepcionOfertasReal")!=null ? Utils.stringToDateZ(map.get("recepcionOfertasReal").toString()) : null;
					Integer tipoId = map.get("tipoId")!=null ? Utils.String2Int(map.get("tipoId").toString()) : null;
					BigDecimal total = map.get("total")!=null ? Utils.String2BigDecimal(map.get("total").toString(),null) : null;
					String unidadMedida =  map.get("medidaNombre")!=null ? map.get("medidaNombre").toString() : null;
					PlanAdquisicion pa;
					if(id==null || id == -1)
						pa = new PlanAdquisicion(CategoriaAdquisicionDAO.getCategoriaPorId(categoriaId), 
							TipoAdquisicionDAO.getTipoAdquisicionPorId(tipoId), unidadMedida, cantidad, total, precioUnitario, 
							preparacionDocPlanificado, preparacionDocReal, lanzamientoEventoPlanificado, lanzamientoEventoReal, 
							recepcionOfertasPlanificado, recepcionOfertasReal, adjudicacionPlanificado, adjudicacionReal, 
							firmaContratoPlanificado, firmaContratoReal, objetoId, objetoTipo,usuario, null, 
							new DateTime().toDate(), null, 1, 0, numeroContrato, montoContrato, nog, null);
					else{
						pa = PlanAdquisicionDAO.getPlanAdquisicionById(id);
						pa.setCategoriaAdquisicion(CategoriaAdquisicionDAO.getCategoriaPorId(categoriaId));
						pa.setTipoAdquisicion(TipoAdquisicionDAO.getTipoAdquisicionPorId(tipoId));
						pa.setUnidadMedida(unidadMedida);
						pa.setCantidad(cantidad);
						pa.setTotal(total);
						pa.setPrecioUnitario(precioUnitario);
						pa.setPreparacionDocPlanificado(preparacionDocPlanificado);
						pa.setPreparacionDocReal(preparacionDocReal);
						pa.setLanzamientoEventoPlanificado(lanzamientoEventoPlanificado);
						pa.setLanzamientoEventoReal(lanzamientoEventoReal);
						pa.setRecepcionOfertasPlanificado(recepcionOfertasPlanificado);
						pa.setRecepcionOfertasReal(recepcionOfertasReal);
						pa.setAdjudicacionPlanificado(adjudicacionPlanificado);
						pa.setAdjudicacionReal(adjudicacionReal);
						pa.setFirmaContratoPlanificado(firmaContratoPlanificado);
						pa.setFirmaContratoReal(firmaContratoReal);
						pa.setObjetoId(objetoId);
						pa.setObjetoTipo(objetoTipo);
						pa.setUsuarioActualizo(usuario);
						pa.setFechaActualizacion(new DateTime().toDate());
						pa.setEstado(1);
						pa.setBloqueado(0);
						pa.setNumeroContrato(numeroContrato);
						pa.setMontoContrato(montoContrato);
						pa.setNog(nog);
						PlanAdquisicionPagoDAO.eliminarPagos(new ArrayList<PlanAdquisicionPago>(pa.getPlanAdquisicionPagos()));
					}
					PlanAdquisicionDAO.guardarPlanAdquisicion(pa);
					if(map.get("pagos")!=null){
						JsonParser parser = new JsonParser();
						JsonArray pagos = parser.parse(map.get("pagos").toString()).getAsJsonArray();
						for(int j=0; j<pagos.size(); j++){
							JsonObject objeto_pago = pagos.get(j).getAsJsonObject();
							Date fechaPago = objeto_pago.get("fecha").isJsonNull() ? null : Utils.stringToDate(objeto_pago.get("fecha").getAsString());
							BigDecimal dpago = objeto_pago.get("pago").isJsonNull() ? null : objeto_pago.get("pago").getAsBigDecimal();
							PlanAdquisicionPago pago = new PlanAdquisicionPago(pa, fechaPago, dpago, "", usuario, null, new DateTime().toDate(), null, 1);
							PlanAdquisicionPagoDAO.guardarPago(pago);
						}
					}
				response_text = String.join("","{ \"success\": true, \"id\": "+pa.getId()+" }");
			}
			else if(accion.equals("getPlanAdquisicionPorObjeto")){
				Integer objetoId = Utils.String2Int(map.get("objetoId"));
				Integer objetoTipo = Utils.String2Int(map.get("objetoTipo"));
				PlanAdquisicion adquisicion=PlanAdquisicionDAO.getPlanAdquisicionByObjeto(objetoTipo, objetoId);
				if(adquisicion!=null){
						stadquisicion temp = new stadquisicion();
						temp.id = adquisicion.getId();
						temp.adjudicacionPlanificada = Utils.formatDate(adquisicion.getAdjudicacionPlanificado());
						temp.adjudicacionReal = Utils.formatDate(adquisicion.getAdjudicacionReal());
						temp.cantidad = adquisicion.getCantidad();
						temp.categoriaId = adquisicion.getCategoriaAdquisicion().getId();
						temp.categoriaNombre = adquisicion.getCategoriaAdquisicion().getNombre();
						temp.firmaContratoPlanificada = Utils.formatDate(adquisicion.getFirmaContratoPlanificado());
						temp.firmaContratoReal = Utils.formatDate(adquisicion.getFirmaContratoReal());
						temp.lanzamientoEventoPlanificada = Utils.formatDate(adquisicion.getLanzamientoEventoPlanificado());
						temp.lanzamientoEventoReal = Utils.formatDate(adquisicion.getLanzamientoEventoReal());
						temp.medidaNombre = adquisicion.getUnidadMedida();
						temp.montoContrato = adquisicion.getMontoContrato();
						temp.nog = adquisicion.getNog();
						temp.numeroContrato = adquisicion.getNumeroContrato();
						temp.precioUnitario = adquisicion.getPrecioUnitario();
						temp.preparacionDocumentoPlanificada = Utils.formatDate(adquisicion.getPreparacionDocPlanificado());
						temp.preparacionDocumentoReal = Utils.formatDate(adquisicion.getPreparacionDocReal());
						temp.recepcionOfertasPlanificada =  Utils.formatDate(adquisicion.getRecepcionOfertasPlanificado());
						temp.recepcionOfertasReal = Utils.formatDate(adquisicion.getRecepcionOfertasReal());
						temp.tipoId = adquisicion.getTipoAdquisicion().getId();
						temp.tipoNombre = adquisicion.getTipoAdquisicion().getNombre();
						temp.total = adquisicion.getTotal()!= null ? adquisicion.getTotal() : new BigDecimal(0);
						if(adquisicion.getPlanAdquisicionPagos()!=null && adquisicion.getPlanAdquisicionPagos().size()>0){
							ArrayList<stpago> pagos = new ArrayList<stpago>();
							stpago pago = null;

							ArrayList<PlanAdquisicionPago> apagos = new ArrayList<PlanAdquisicionPago>(adquisicion.getPlanAdquisicionPagos());
							for(int i=0; i<apagos.size();i++){
								if(apagos.get(i).getEstado() == 1){
									pago = new stpago();
									pago.fechaPago = Utils.formatDate(apagos.get(i).getFechaPago());
									pago.pago = apagos.get(i).getPago();
									pagos.add(pago);	
								}
							}
							temp.pagos = pagos.toArray(new stpago[pagos.size()]);
						}
						
						response_text = new GsonBuilder().serializeNulls().create().toJson(temp);
						response_text = String.join("", "\"adquisicion\":",response_text);
				        response_text = String.join("", "{\"success\":true,", response_text, "}");
					}
				else
					response_text = String.join("", "{\"success\":false }");
			}
			else if(accion.equals("borrarTodasAdquisiciones")){
				Integer objetoId = Utils.String2Int(map.get("objetoId"));
				Integer objetoTipo = Utils.String2Int(map.get("objetoTipo"));
				PlanAdquisicionDAO.borrarTodosPlan(objetoId, objetoTipo);
				response_text = String.join("", "{\"success\":true }");
			}
			
			response.setHeader("Content-Encoding", "gzip");
			response.setCharacterEncoding("UTF-8");

	        OutputStream output = response.getOutputStream();
			GZIPOutputStream gz = new GZIPOutputStream(output);
	        gz.write(response_text.getBytes("UTF-8"));
	        gz.close();
	        output.close();

		}catch(Exception e){
			CLogger.write("1", SPlanAdquisicion.class, e);
		}
	}
	
	
}
