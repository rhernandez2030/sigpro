<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="metaunidadmedidaController as metaunidadc" class="maincontainer all_page" id="title">
		<h3>Unidades de Medida de Metas</h3><br/>
		<div class="row" align="center" ng-hide="metaunidadc.mostraringreso">
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group">
			       <shiro:hasPermission name="crearCooperante">
			       		<label class="btn btn-primary" ng-click="metaunidadc.nueva()">Nueva</label>
			       </shiro:hasPermission> 
			       <shiro:hasPermission name="editarCooperante"><label class="btn btn-primary" ng-click="metaunidadc.editar()">Editar</label></shiro:hasPermission>
			       <shiro:hasPermission name="eliminarCooperante">
			       		<label class="btn btn-primary" ng-click="metaunidadc.borrar()">Borrar</label>
			       </shiro:hasPermission>
			        
			        
    			</div>				
    		</div>
    		<shiro:hasPermission name="verCooperante">
    		<div class="col-sm-12" align="center">
    			<div style="height: 35px;">
					<div style="text-align: right;"><div class="btn-group" role="group" aria-label="">
						<a class="btn btn-default" href ng-click="metaunidadc.reiniciarVista()" role="button" uib-tooltip="Reiniciar la vista de la tabla" tooltip-placement="left"><span class="glyphicon glyphicon-repeat" aria-hidden="true"></span></a>
					</div>
					</div>
				</div>
				<br/>
				<div id="maingrid" ui-grid="metaunidadc.gridOptions" ui-grid-save-state 
						ui-grid-move-columns ui-grid-resize-columns ui-grid-selection ui-grid-pinning ui-grid-pagination class="grid">
					<div class="grid_loading" ng-hide="!metaunidadc.mostrarcargando">
				  	<div class="msg">
				      <span><i class="fa fa-spinner fa-spin fa-4x"></i>
						  <br /><br />
						  <b>Cargando, por favor espere...</b>
					  </span>
					</div>
				  </div>
				</div>
				<ul uib-pagination total-items="metaunidadc.totalmedidas" 
						ng-model="metaunidadc.paginaActual" 
						max-size="metaunidadc.numeroMaximoPaginas" 
						items-per-page="metaunidadc.elementosPorPagina"
						first-text="Primero"
						last-text="Último"
						next-text="Siguiente"
						previous-text="Anterior"
						class="pagination-sm" boundary-links="true" force-ellipses="true"
						ng-change="metaunidadc.cambioPagina()"
				></ul>
			</div>
    		</shiro:hasPermission>
    		
		</div>
		<div class="row" ng-show="metaunidadc.mostraringreso">
			<h4 ng-hide="!metaunidadc.esnueva">Nueva Unidad de Medidad</h4>
			<h4 ng-hide="metaunidadc.esnueva">Edición de Unidad de Medida</h4>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="btn-group">
			        <label class="btn btn-success"  ng-click="form.$valid ? metaunidadc.guardar() : ''" ng-disabled="form.$invalid">Guardar</label>
			        <label class="btn btn-primary" ng-click="metaunidadc.irATabla()">Ir a Tabla</label>
    			</div>
    		</div>
			
			<div class="col-sm-12">
				<form name="form">
						<div class="form-group" ng-show="!metaunidadc.esnueva">
							<label for="id">ID</label>
    						<p class="form-control-static"  id="id">{{ metaunidadc.medida.id }} </p>
						</div>
						<div class="form-group">
							<label for="nombre">* Nombre</label>
    						<input type="text" class="form-control" id="nombre" placeholder="Nombre" ng-model="metaunidadc.medida.nombre" ng-required="true">
						</div>
						<div class="form-group">
							<label for="descripcion">Descripción</label>
    						<input type="text" class="form-control" id="descripcion" placeholder="Descripción" ng-model="metaunidadc.medida.descripcion">
						</div>
						<div class="form-group">
							<label for="simbolo">Símbolo</label>
    						<input type="text" class="form-control" id="simbolo" placeholder="Símbolo" ng-model="metaunidadc.medida.simbolo">
						</div>
						<div class="form-group" ng-show="!metaunidadc.esnueva">
							<label for="usuarioCreo">Usuario que creo</label>
    						<p class="form-control-static" id="usuarioCreo">{{ metaunidadc.medida.usuarioCreo }} </p>
						</div>
						<div class="form-group" ng-show="!metaunidadc.esnueva">
							<label for="fechaCreacion">Fecha de creación</label>
    						<p class="form-control-static" id="fechaCreacion">{{ metaunidadc.medida.fechaCreacion }} </p>
						</div>
						<div class="form-group" ng-show="!metaunidadc.esnueva">
							<label for="usuarioActualizo">Usuario que actualizo</label>
    						<p class="form-control-static" id="usuarioCreo">{{ metaunidadc.medida.usuarioActualizo }} </p>
						</div>
						<div class="form-group" ng-show="!metaunidadc.esnueva">
							<label for="fechaActualizacion">Fecha de actualizacion</label>
    						<p class="form-control-static" id="usuarioCreo">{{ metaunidadc.medida.fechaActualizacion }} </p>
						</div>
				</form>
			</div>
			<div align="center">Los campos marcados con * son obligatorios</div>
			<div class="col-sm-12 operation_buttons" align="right">
				<div class="col-sm-12 operation_buttons" align="right">
					<div class="btn-group">
				        <label class="btn btn-success" ng-click="form.$valid ? metaunidadc.guardar() : ''" ng-disabled="form.$invalid">Guardar</label>
				        <label class="btn btn-primary" ng-click="metaunidadc.irATabla()">Ir a Tabla</label>
	    			</div>
	    		</div>
    		</div>
		</div>
	</div>
