var app = angular.module('metatipoController', []);

app.controller('metatipoController',['$scope','$http','$interval','i18nService','Utilidades','$routeParams','$window','$location','$route','uiGridConstants','$mdDialog',
		function($scope, $http, $interval,i18nService,$utilidades,$routeParams,$window,$location,$route,uiGridConstants,$mdDialog) {
			var mi=this;
			
			$window.document.title = 'SIGPRO - Tipos de Meta';
			i18nService.setCurrentLang('es');
			mi.mostrarcargando=true;
			mi.tipos = [];
			mi.tipo;
			mi.mostraringreso=false;
			mi.esnueva = false;
			mi.totaltipos = 0;
			mi.paginaActual = 1;
			mi.numeroMaximoPaginas = $utilidades.numeroMaximoPaginas;
			mi.elementosPorPagina = $utilidades.elementosPorPagina;
			
			mi.columnaOrdenada=null;
			mi.ordenDireccion = null;
			
			mi.filtros = [];
			
			mi.gridOptions = {
					enableRowSelection : true,
					enableRowHeaderSelection : false,
					multiSelect: false,
					modifierKeysToMultiSelect: false,
					noUnselect: true,
					enableFiltering: true,
					enablePaginationControls: false,
				    paginationPageSize: $utilidades.elementosPorPagina,
				    useExternalFiltering: true,
				    useExternalSorting: true,
					columnDefs : [ 
						{ name: 'id', width: 100, displayName: 'ID', cellClass: 'grid-align-right', type: 'number', enableFiltering: false },
						{ name: 'nombre', width: 200, displayName: 'Nombre',cellClass: 'grid-align-left',
							filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" ng-keypress="grid.appScope.recursoc.filtrar($event,1)"></input></div>'
						},
					    { name: 'descripcion', displayName: 'Descripción', cellClass: 'grid-align-left', enableFiltering: false},
					    { name: 'usuarioCreo', displayName: 'Usuario Creación',
					    	filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" ng-keypress="grid.appScope.recursoc.filtrar($event,2)"></input></div>'
					    },
					    { name: 'fechaCreacion', displayName: 'Fecha Creación', cellClass: 'grid-align-right', type: 'date', cellFilter: 'date:\'dd/MM/yyyy\'',
					    	filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" ng-keypress="grid.appScope.recursoc.filtrar($event,3)"></input></div>'
					    }
					],
					onRegisterApi: function(gridApi) {
						mi.gridApi = gridApi;
						gridApi.selection.on.rowSelectionChanged($scope,function(row) {
							mi.tipo = row.entity;
						});
						
						gridApi.core.on.sortChanged( $scope, function ( grid, sortColumns ) {
							if(sortColumns.length==1){
								grid.appScope.metatipoc.columnaOrdenada=sortColumns[0].field;
								grid.appScope.metatipoc.ordenDireccion = sortColumns[0].sort.direction;
								for(var i = 0; i<sortColumns.length-1; i++)
									sortColumns[i].unsort();
								grid.appScope.metatipoc.cargarTabla(grid.appScope.metatipoc.paginaActual);
							}
							else if(sortColumns.length>1){
								sortColumns[0].unsort();
							}
							else{
								if(grid.appScope.metatipoc.columnaOrdenada!=null){
									grid.appScope.metatipoc.columnaOrdenada=null;
									grid.appScope.metatipoc.ordenDireccion=null;
								}
							}
								
						} );
						
						if($routeParams.reiniciar_vista=='rv'){
							mi.guardarEstado();
					    }
					    else{
					    	  $http.post('/SEstadoTabla', { action: 'getEstado', grid:'metatipos', t: (new Date()).getTime()}).then(function(response){
						      if(response.data.success && response.data.estado!='')
						    	  mi.gridApi.saveState.restore( $scope, response.data.estado);
						    	  mi.gridApi.colMovable.on.columnPositionChanged($scope, mi.guardarEstado);
							      mi.gridApi.colResizable.on.columnSizeChanged($scope, mi.guardarEstado);
							      mi.gridApi.core.on.columnVisibilityChanged($scope, mi.guardarEstado);
							      mi.gridApi.core.on.sortChanged($scope, mi.guardarEstado);
							  });
					    }
					}
				};
			
			mi.cargarTabla = function(pagina){
				mi.mostrarcargando=true;
				$http.post('/SMetaTipo', { accion: 'getMetaTiposPagina', pagina: pagina, numerometaunidadtipos: $utilidades.elementosPorPagina,
					filtro_nombre: mi.filtros['nombre'], 
					filtro_usuario_creo: mi.filtros['usuario_creo'], filtro_fecha_creacion: mi.filtros['fecha_creacion'],
					columna_ordenada: mi.columnaOrdenada, orden_direccion: mi.ordenDireccion 
				}).success(
				
						function(response) {
							mi.tipos = response.MetaTipos;
							for(var i=0; i<mi.tipos.length; i++){
								mi.tipos[i].fechaCreacion = moment(mi.tipos[i].fechaCreacion, 'MMM D, YYYY H:m:s a').format('DD/MM/YYYY');
							}
							mi.gridOptions.data = mi.tipos;
							mi.mostrarcargando = false;
						});
			}
			
			mi.guardar=function(){
				if(mi.tipo!=null && mi.tipo.nombre!=''){
					$http.post('/SMetaTipo', {
						accion: 'guardarMetaTipo',
						esnueva: mi.esnueva,
						id: mi.tipo.id,
						codigo: mi.tipo.codigo,
						nombre: mi.tipo.nombre,
						descripcion: mi.tipo.descripcion
					}).success(function(response){
						if(response.success){
							$utilidades.mensaje('success','Tipo meta  '+(mi.esnueva ? 'creado' : 'guardado')+' con éxito');
							mi.cargarTabla();
						}
						else
							$utilidades.mensaje('danger','Error al '+(mi.esnueva ? 'crear' : 'guardar')+' el tipo de meta');
					});
				}
				else
					$utilidades.mensaje('warning','Debe de llenar todos los campos obligatorios');
			};

			mi.borrar = function(ev) {
				if(mi.tipo!=null){
					var confirm = $mdDialog.confirm()
				          .title('Confirmación de borrado')
				          .textContent('¿Desea borrar el tipo de meta "'+mi.tipo.nombre+'"?')
				          .ariaLabel('Confirmación de borrado')
				          .targetEvent(ev)
				          .ok('Borrar')
				          .cancel('Cancelar');
	
				    $mdDialog.show(confirm).then(function() {
				    	$http.post('/SMetaTipo', {
							accion: 'borrarMetaTipo',
							id: mi.tipo.id
						}).success(function(response){
							if(response.success){
								$utilidades.mensaje('success','Tipo de meta borrado con éxito');
								mi.cargarTabla();
							}
							else
								$utilidades.mensaje('danger','Error al borrar el tipo de meta');
						});
				    }, function() {
				    
				    });
				}
				else
					$utilidades.mensaje('warning','Debe seleccionar el tipo de meta que desea borrar');
			};

			mi.nueva = function() {
				mi.mostraringreso=true;
				mi.esnueva = true;
				mi.tipo = null;
				mi.gridApi.selection.clearSelectedRows();
			};

			mi.editar = function() {
				if(mi.tipo!=null){
					mi.mostraringreso = true;
					mi.esnueva = false;
				}
				else
					$utilidades.mensaje('warning','Debe seleccionar el tipo de meta que desea editar');
			}

			mi.irATabla = function() {
				mi.mostraringreso=false;
			}
			
			mi.guardarEstado=function(){
				var estado = mi.gridApi.saveState.save();
				var tabla_data = { action: 'guardaEstado', grid:'metatipos', estado: JSON.stringify(estado), t: (new Date()).getTime() }; 
				$http.post('/SEstadoTabla', tabla_data).then(function(response){
					
				});
			}
			
			mi.cambioPagina=function(){
				mi.cargarTabla(mi.paginaActual);
			}
			
			mi.reiniciarVista=function(){
				if($location.path()=='/metatipos/rv')
					$route.reload();
				else
					$location.path('/metatipos/rv');
			}
			
			mi.filtrar = function(evt,tipo){
				if(evt.keyCode==13){
					switch(tipo){
						case 1: mi.filtros['nombre'] = evt.currentTarget.value; break;
						case 2: mi.filtros['usuario_creo'] = evt.currentTarget.value; break;
						case 3: mi.filtros['fecha_creacion'] = evt.currentTarget.value; break;
							
					}
					mi.cargarTabla(mi.paginaActual);
				}
			}
			
			$http.post('/SMetaTipo', { accion: 'numeroMetaTipos' }).success(
					function(response) {
						mi.totaltipos = response.totaltipos;
						mi.cargarTabla(1);
					});
			
		} ]);