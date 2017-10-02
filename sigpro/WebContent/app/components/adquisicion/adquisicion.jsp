<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="adquisicionController as adquisicionc" class="maincontainer_treeview all_page" id="title">
	    <script type="text/ng-template" id="buscarPorAdquisicion.jsp">
    		<%@ include file="/app/components/adquisicion/buscarPorAdquisicion.jsp"%>
  	    </script>
  	    <shiro:lacksPermission name="30010">
			<span ng-init="adquisicionc.redireccionSinPermisos()"></span>
		</shiro:lacksPermission>
		<br/>
		<div class="row" align="center" ng-show="!adquisicioncc.mostraringreso">
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group btn-group-sm">
			       <shiro:hasPermission name="30040">
			       		<label class="btn btn-default" ng-click="adquisicionc.nuevo()" uib-tooltip="Nueva Adquisicion" tooltip-placement="left">
						<span class="glyphicon glyphicon-plus"></span></label>
			       </shiro:hasPermission> 		        
    			</div>				
    		</div>
    		<shiro:hasPermission name="30010">
    		<div class="col-sm-12" align="center">
    			<table st-table="adquisicionc.display_riesgos" st-safe-src="adquisicionc.adquisiciones" class="table table-striped">
					<thead>
						<tr>
							<th st-sort="categoriaNombre">Categoría</th>
							<th st-sort="tipoNombre">Tipo</th>
							<th st-sort="medidaNombre">Medida</th>
							<th st-sort="cantidad">Cantidad</th>
							<shiro:hasPermission name="30030">
								<th width="1%"></th>
							</shiro:hasPermission>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="row in adquisicionc.display_adquisicionc">
							<td  ng-click="adquisicionc.editar(row)">{{ row.categoriaNombre }}</td>
							<td  ng-click="adquisicionc.editar(row)">{{ row.tipoNombre }}</td>
							<td  ng-click="adquisicionc.editar(row)">{{ row.medidaNombre }}</td>
							<td  ng-click="adquisicionc.editar(row)">{{ row.cantidad }}</td>
							<shiro:hasPermission name="30030">
							<td><label class="btn btn-default btn-xs" ng-click="adquisicionc.borrar(row)" uib-tooltip="Borrar" tooltip-placement="left">
								<span class="glyphicon glyphicon-trash"></span></label></td>
							</shiro:hasPermission>
						</tr>
					</tbody>
				</table>
			</div>
    		</shiro:hasPermission>
		</div>
		<div class="row second-main-form" ng-show="adquisicionc.mostraringreso">
			<div class="page-header">
				<h2 ng-if="adquisicionc.esnuevo"><small>Nueva adquisición</small></h2>
				<h2 ng-if="!adquisicionc.esnuevo"><small>Edición de adquisición</small></h2>
			</div>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group btn-group-sm">
					<label class="btn btn-default" ng-click="adquisicionc.irATabla()" uib-tooltip="Ir a Adquisiciones" tooltip-placement="bottom">
					<span class="glyphicon glyphicon-list-alt"></span></label>
    			</div>
    		</div>
			<div class="col-sm-12">
						<div class="form-group" ng-show="!adquisicionc.esnuevo">
							<label for="id" class="floating-label id_class">ID {{ adquisicionc.adquisicion.id }}</label>
    						<br/><br/>
						</div>
						<div class="form-group">
				            	<input type="text" class="inputText" ng-model="adquisicionc.adquisicion.tipoNombre" 
				            	ng-click="adquisicionc.buscarAdquisicionTipo()" ng-readonly="true" ng-required="adquisicionc.mostraringreso"/>
				            	<span class="label-icon" ng-click="adquisicionc.buscarAdquisicionTipo()"><i class="glyphicon glyphicon-search"></i></span>
								<label class="floating-label">* Tipo</label>
						</div>
						<div class="form-group">
				            	<input type="text" class="inputText" ng-model="adquisicionc.adquisicion.categoriaNombre" 
				            	ng-click="adquisicionc.buscarAdquisicionCategoria()" ng-readonly="true" ng-required="adquisicionc.mostraringreso"/>
				            	<span class="label-icon" ng-click="adquisicionc.buscarAdquisicionCategoria()"><i class="glyphicon glyphicon-search"></i></span>
								<label class="floating-label">* Categoría</label>
						</div>
						<div class="row">
							<div class="cols-sm-3">
								<div class="form-group">
										<input type="text" class="inputText" ng-model="adquisicionc.adquisicion.medidaNombre" 
						            	ng-click="adquisicionc.buscarAdquisicionMedida()" ng-readonly="true" ng-required="adquisicionc.mostraringreso"/>
						            	<span class="label-icon" ng-click="adquisicionc.buscarAdquisicionMedida()"><i class="glyphicon glyphicon-search"></i></span>
										<label class="floating-label">* Medida</label>
								</div>
							</div>
							<div class="cols-sm-3">
								<div class="form-group">
										<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.cantidad" ng-required="adquisicionc.mostraringreso" ui-number-mask="0" />
										<label class="floating-label" >* Cantidad</label>
								</div>
							</div>
							<div class="cols-sm-3">
								<div class="form-group">
										<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.precioUnitario" ui-number-mask="2" />
										<label class="floating-label" >Precio</label>
								</div>
							</div>
							<div class="cols-sm-3">
								<div class="form-group">
										<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.total" ng-required="adquisicionc.mostraringreso" ui-number-mask="2" />
										<label class="floating-label" >* Total</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.nog" ui-number-mask="0" />
										<label class="floating-label" >NOG (Número de Orden Guatecompra)</label>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.numeroContrato" />
										<label class="floating-label" >Número de contrato</label>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" class="inputText input-money" ng-model="adquisicionc.adquisicion.montoContrato" ui-number-mask="2" />
										<label class="floating-label" >Monto del contrato</label>
								</div>
							</div>
						</div>
							<div class="row">
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.preparacionDocumentoPlanificada" is-open="adquisicionc.popup_fechas[0]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(0)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Preparación de documentos (Planificada)</label>
									</div>
    							</div>
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.preparacionDocumentoReal" is-open="adquisicionc.popup_fechas[1]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(1)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Preparación de documentos (Real)</label>
									</div>
    							</div>
    						</div>
							<div class="row">
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.lanzamientoEventoPlanificada" is-open="adquisicionc.popup_fechas[2]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(2)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Lanzamiento de evento (Planificada)</label>
									</div>
    							</div>
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.lanzamientoEventoReal" is-open="adquisicionc.popup_fechas[3]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(3)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Lanzamiento de evento (Real)</label>
									</div>
    							</div>
    						</div>
							<div class="row">
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.recepcionOfertasPlanificada" is-open="adquisicionc.popup_fechas[4]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(4)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Recepción de ofertas (Planificada)</label>
									</div>
    							</div>
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.recepcionOfertasReal" is-open="adquisicionc.popup_fechas[5]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(5)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Recepción de ofertas (Real)</label>
									</div>
    							</div>
    						</div>
							<div class="row">
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.adjudicacionPlanificada" is-open="adquisicionc.popup_fechas[6]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(6)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Adjudicación (Planificada)</label>
									</div>
    							</div>
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.adjudicacionReal" is-open="adquisicionc.popup_fechas[7]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(7)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Adjudicación (Real)</label>
									</div>
    							</div>
    						</div>
							<div class="row">
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.firmaContratoPlanificada" is-open="adquisicionc.popup_fechas[8]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(8)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Firma contrato (Planificada)</label>
									</div>
    							</div>
    							<div class="col-sm-6">
    								<div class="form-group">
										<input type="text" class="inputText" uib-datepicker-popup="{{controller.formatofecha}}" ng-model="adquisicionc.adquisicion.firmaContratoReal" is-open="adquisicionc.popup_fechas[9]"
											datepicker-options="adquisicionc.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Borrar" ng-required="adquisicionc.mostraringreso"/>
											<span class="label-icon" ng-click="adquisicionc.abrirPopupFecha(9)">
												<i class="glyphicon glyphicon-calendar"></i>
											</span>
											<label class="floating-label">Firma contrato (Real)</label>
									</div>
    							</div>
    						</div>
						<input type="hidden" ng-model="adquisicionc.form_valid" name="form_valid" ng-required="adquisicionc.mostraringreso" />
			</div>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group btn-group-sm">
					<label class="btn btn-default" ng-click="adquisicionc.irATabla()" uib-tooltip="Ir a Riegos" tooltip-placement="left">
					<span class="glyphicon glyphicon-list-alt"></span></label>
    			</div>
    		</div>
		</div>
	</div>