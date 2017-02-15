<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="componenteController as componentec" class="maincontainer all_page" id="title">
	    <script type="text/ng-template" id="buscarPorComponente.jsp">
    		<%@ include file="/app/components/componente/buscarPorComponente.jsp"%>
  	    </script>
		<h3>Componentes</h3><br/>
		<h4>{{ componentec.proyectoNombre }}</h4><br/>
		<div class="row" align="center" ng-hide="componentec.mostraringreso">
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group">
			       <shiro:hasPermission name="5040">
			       		<label class="btn btn-primary" ng-click="componentec.nuevo()">Nuevo</label>
			       </shiro:hasPermission>
			       <shiro:hasPermission name="5020"><label class="btn btn-primary" ng-click="componentec.editar()">Editar</label></shiro:hasPermission>
			       <shiro:hasPermission name="5030">
			       		<label class="btn btn-primary" ng-click="componentec.borrar()">Borrar</label>
			       </shiro:hasPermission>


    			</div>
    		</div>
    		<shiro:hasPermission name="5010">
    		<div class="col-sm-12" align="center">
    			<div style="height: 35px;">
					<div style="text-align: right;"><div class="btn-group" role="group" aria-label="">
						<a class="btn btn-default" href ng-click="componentec.reiniciarVista()" role="button" uib-tooltip="Reiniciar la vista de la tabla" tooltip-placement="left"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
					</div>
					</div>
				</div>
				<br/>
				<div id="maingrid" ui-grid="componentec.gridOptions" ui-grid-save-state
						ui-grid-move-columns ui-grid-resize-columns ui-grid-selection ui-grid-pinning ui-grid-pagination class="grid">
					<div class="grid_loading" ng-hide="!componentec.mostrarcargando">
				  	<div class="msg">
				      <span><i class="fa fa-spinner fa-spin fa-4x"></i>
						  <br /><br />
						  <b>Cargando, por favor espere...</b>
					  </span>
					</div>
				  </div>
				</div>
				<br/>
			<div class="total-rows">Total de {{  componentec.totalComponentes + (componentec.totalComponentes == 1 ? " Componente" : " Componentes" ) }}</div>
				<ul uib-pagination total-items="componentec.totalComponentes"
						ng-model="componentec.paginaActual"
						max-size="componentec.numeroMaximoPaginas"
						items-per-page="componentec.elementosPorPagina"
						first-text="Primero"
						last-text="Último"
						next-text="Siguiente"
						previous-text="Anterior"
						class="pagination-sm" boundary-links="true" force-ellipses="true"
						ng-change="componentec.cambioPagina()"
				></ul>
			</div>
    		</shiro:hasPermission>

		</div>
		<div class="row main-form" ng-show="componentec.mostraringreso">
			<h4 ng-hide="!componentec.esnuevo">Nuevo componente</h4>
			<h4 ng-hide="componentec.esnuevo">Edición de componente</h4>
			<div class="col-sm-12 operation_buttons" align="left">
			<div class="btn-group" ng-hide="componentec.esnuevo">
				<label class="btn btn-default" ng-click="componentec.irAProductos(componentec.componente.id)">Productos</label>
			</div>
		</div>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group">
			        <label class="btn btn-success" ng-click="form.$valid ? componentec.guardar() : ''" ng-disabled="!form.$valid" >Guardar</label>
			        <label class="btn btn-primary" ng-click="componentec.irATabla()">Ir a Tabla</label>
    			</div>
    		</div>

			<div class="col-sm-12">
				<form name="form" id="form">
						<div class="form-group" ng-show="!componentec.esnuevo">
							<label for="id">ID</label>
    						<p class="form-control-static" id="id">{{ componentec.componente.id }}</p>
						</div>
						<div class="form-group">
							<label for="nombre">* Nombre</label>
    						<input type="text" class="form-control" id="nombre" placeholder="Nombre" ng-model="componentec.componente.nombre" ng-required="true">
						</div>
						
						<div class="form-group">
							<label >SNIP</label> 
							<input type="number" ng-model="componentec.componente.snip" class="form-control" id="n_snip" placeholder="SNIP">
						</div>
						<div class="form-grup row" >
							<div class="form-group col-sm-2"  >
							       <label>Programa</label> 
							       <input type="number" class="form-control"  placeholder="Programa" ng-model="componentec.componente.programa"  ng-maxlength="4" style="text-align: center"/>
							</div>
							<div class="form-group col-sm-2"  >
							  <label >Subprograma</label> 
							  <input type="number" class="form-control"  placeholder="Subprograma" ng-model="componentec.componente.subprograma" ng-maxlength="4" style="text-align: center"/>
							</div>
							<div class="form-group col-sm-2"  >
							  <label >Proyecto</label> 
							  <input type="number" class="form-control"  placeholder="Proyecto" ng-model="componentec.componente.proyecto_" ng-maxlength="4" style="text-align: center"/>
							</div>
							<div class="form-group col-sm-2" >
							  <label>Actividad</label> 
							  <input type="number" class="form-control" placeholder="Actividad" ng-model="componentec.componente.actividad" ng-maxlength="4" style="text-align: center"/>
							</div>					
							<div class="form-group col-sm-2" >
							  <label>Obra</label> 
							  <input type="number" class="form-control" placeholder="Obra" ng-model="componentec.componente.obra" ng-maxlength="4" style="text-align: center"/>
							</div>
							<div class="form-group col-sm-2" >
							  <label for="campo5">Fuente</label> 
							  <input type="number" class="form-control" placeholder="Fuente" ng-model="componentec.componente.fuente" ng-maxlength="4" style="text-align: center"/>
							</div>
						</div>
						
						<div class="form-group">
							<label>* Unidad Ejecturoa</label>
				          	<div class="input-group">
				            	<input type="text" class="form-control" id="iunejec" name="iunejec" placeholder="Nombre Unidad Ejecutora" ng-model="componentec.unidadejecutoranombre" ng-readonly="true" ng-required="true"/>
				            	<span class="input-group-addon" ng-click="componentec.buscarUnidadEjecutora()"><i class="glyphicon glyphicon-search"></i></span>
				          	</div>
						</div>

						<div class="form-group">
							<label>* Tipo Componente</label>
				          	<div class="input-group">
				            	<input type="text" class="form-control" id="icomptipo" name="icomptipo" placeholder="Nombre Tipo Componente" ng-model="componentec.componentetiponombre" ng-readonly="true" ng-required="true"/>
				            	<span class="input-group-addon" ng-click="componentec.buscarComponenteTipo()"><i class="glyphicon glyphicon-search"></i></span>
				          	</div>
						</div>


						<div class="form-group" ng-repeat="campo in componentec.camposdinamicos">
							<label for="campo.id">{{ campo.label }}</label>
							<div ng-switch="campo.tipo">
								<input ng-switch-when="texto" type="text" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" class="form-control" />
								<input ng-switch-when="entero" type="text" id="{{ 'campo_'+campo.id }}" numbers-only ng-model="campo.valor" class="form-control" />
								<input ng-switch-when="decimal" type="number" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" class="form-control" />
								<input ng-switch-when="booleano" type="checkbox" id="{{ 'campo_'+campo.id }}" ng-model="campo.valor" />
								<p ng-switch-when="fecha" class="input-group">
									<input type="text" id="{{ 'campo_'+campo.id }}" class="form-control" uib-datepicker-popup="{{componentec.formatofecha}}" ng-model="campo.valor" is-open="campo.isOpen"
														datepicker-options="mi.fechaOptions" close-text="Cerrar" current-text="Hoy" clear-text="Limpiar" />
													<span class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="componentec.abrirPopupFecha($index)">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
								</p>
								<select ng-switch-when="select" id="{{ 'field_'+campo.id }}" class="form-control" ng-model="x.value">
													<option value="">Seleccione una opción</option>
													<option ng-repeat="number in campo.opciones"
														value="{{number.valor}}">{{number.label}}</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="descripcion">Descripción</label>
    						<input type="text" class="form-control" id="descripcion" placeholder="Descripción" ng-model="componentec.componente.descripcion">
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" style="text-align: center;">Datos de auditoría</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-sm-6" >
										<div class="form-group" style="text-align: right">
											<label for="usuarioCreo">Usuario que creo</label>
				    						<p class="form-control-static">{{ componentec.componente.usuarioCreo }}</p>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label for="fechaCreacion">Fecha de creación</label>
				    						<p class="form-control-static">{{ componentec.componente.fechaCreacion }}</p>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group" style="text-align: right">
											<label for="usuarioActualizo">Usuario que actualizo</label>
				    						<p class="form-control-static">{{ componentec.componente.usuarioActualizo }}</p>
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<label for="fechaActualizacion">Fecha de actualizacion</label>
				    						<p class="form-control-static" >{{ componentec.componente.fechaActualizacion }}</p>
										</div>
									</div>
								</div>
							</div>
						</div>
				</form>
			</div>
			<div align="center">Los campos marcados con * son obligatorios</div>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="col-sm-12 operation_buttons" align="right">
					<div class="btn-group">
				        <label class="btn btn-success" ng-click="form.$valid ? componentec.guardar() : ''" ng-disabled="!form.$valid">Guardar</label>
				        <label class="btn btn-primary" ng-click="componentec.irATabla()">Ir a Tabla</label>
	    			</div>
	    		</div>
    		</div>
		</div>
	</div>
