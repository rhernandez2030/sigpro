<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="metaController as metac" class="all_page" id="title">
		<div align="center">
			<div class="operation_buttons" align="right">
				<br/>
				<div class="btn-group btn-group-sm">
			       <shiro:hasPermission name="17040">
			       		<label class="btn btn-default" ng-click="producto.nuevaMeta()" uib-tooltip="Nueva">
						<span class="glyphicon glyphicon-plus"></span></label>
			       </shiro:hasPermission> 
			       <shiro:hasPermission name="17030">
			       		<label class="btn btn-default" ng-click="producto.borrarMeta()" uib-tooltip="Borrar">
						<span class="glyphicon glyphicon-trash"></span></label>
			       </shiro:hasPermission>
			   	</div>				
    		</div>
    		<shiro:hasPermission name="17010">
    		<div align="center">
				<table st-table="cmetas" class="table">
				<thead>
				<tr>
					<th st-sort="id">ID</th>
					<th st-sort="nombre">Nombre</th>
					<th>Descripción</th>
					<th st-sort="meta_unidad_medidadid">U. Medida</th>
					<th st-sort="dato_tipoid">Tipo de Dato</th>
					<th st-sort="meta_final">Meta Final</th>
				</tr>
				</thead>
				<tbody>
				<tr st-select-row="row" ng-repeat="row in cmetas">
					<td>{{row.id | uppercase}}</td>
					<td>{{row.nombre}}</td>
					<td>{{row.descripcion}}</td>
					<td>{{row.dato_tipoid}}</td>
					<td>{{row.meta_final}}</td>
				</tr>
				</tbody>
				</table>
			</div>
			<div style="margin-top: 10px;">
				<div class="panel panel-default">
					<div class="panel-heading label-form" style="text-align: center;">Valores</div>
					<div class="panel-body">
					<div class="form-group col-sm-2" style="text-align: left;">
						<select class="inputText" 
							ng-model="producto.anio" 
							ng-options="opcion for opcion in producto.anios" 
							ng-readonly="true" ng-required="true" >
							<option value="">Seleccione un año</option>
						</select>
						<label for="nombre" class="floating-label">* Año</label>
					</div>
					<div align="center">
						<br>
		    			<table class="table table-striped"  style="height: 100%">
							<thead >
								<tr>
									<th style="text-align: center;" class="label-form"></th>
			         				<th style="text-align: center;" class="label-form">Ene</th>
			         				<th style="text-align: center;" class="label-form">Feb</th>
			         				<th style="text-align: center;" class="label-form">Mar</th>
			         				<th style="text-align: center;" class="label-form">Abr</th>
			         				<th style="text-align: center;" class="label-form">May</th>
			         				<th style="text-align: center;" class="label-form">Jun</th>
			         				<th style="text-align: center;" class="label-form">Jul</th>
			         				<th style="text-align: center;" class="label-form">Ago</th>
			         				<th style="text-align: center;" class="label-form">Sep</th>
			         				<th style="text-align: center;" class="label-form">Oct</th>
			         				<th style="text-align: center;" class="label-form">Nov</th>
									<th style="text-align: center;" class="label-form">Dic</th>
			         				<th style="text-align: center;" class="label-form">Total</th>
			         			</tr>
							</thead>
							<tbody >
								<tr>
						      		<td>Planificado</td>
						      		<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">12</td>
						      	</tr>
						      	<tr>
						      		<td>Real</td>
						      		<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">1</td>
									<td style="text-align: right;">12</td>
						      	</tr>
							</tbody>
						</table>
					</div>
					</div>
				</div>
			</div>
			
    		</shiro:hasPermission>
    		
		</div>
	</div>