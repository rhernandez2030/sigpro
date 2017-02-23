var app = angular.module('proyectopropiedadController', []);

app.controller('proyectopropiedadController',['$scope','$http','$interval','i18nService','Utilidades','$routeParams','$window','$location','$route','uiGridConstants','$mdDialog',
	function($scope, $http, $interval,i18nService,$utilidades,$routeParams,$window,$location,$route,uiGridConstants,$mdDialog) {
		var mi=this;
		
		$window.document.title = $utilidades.sistema_nombre+' - Propiedad Proyecto';
		i18nService.setCurrentLang('es');
		mi.mostrarcargando=true;
		mi.proyectopropiedades = [];
		mi.proyectopropiedad;
		mi.mostraringreso=false;
		mi.esnuevo = false;
		mi.totalProyectoPropiedades = 0;
		mi.paginaActual = 1;
		mi.numeroMaximoPaginas = $utilidades.numeroMaximoPaginas;
		mi.elementosPorPagina = $utilidades.elementosPorPagina;
		mi.tipodatos = [];
		mi.redireccionSinPermisos=function(){
			$window.location.href = '/main.jsp';
			$utilidades.mensaje('primary','No tienes permiso de acceder a esta área');			
		}
		mi.filtros=[];
		mi.columnaOrdenada=null;
		mi.ordenDireccion = null;
		
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
						filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" style="width: 90%;" ng-model="grid.appScope.proyectopropiedadc.filtros[\'nombre\']" ng-keypress="grid.appScope.proyectopropiedadc.filtrar($event)"></input></div>'
				    },
				    { name: 'descripcion', displayName: 'Descripción', cellClass: 'grid-align-left', enableFiltering: false},
				    { name: 'datotiponombre', displayName: 'Tipo dato', cellClass: 'grid-align-left', enableFiltering: false},
				    { name: 'usuarioCreo', displayName: 'Usuario Creación',
				    	filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" style="width: 90%;" ng-model="grid.appScope.proyectopropiedadc.filtros[\'usuario_creo\']" ng-keypress="grid.appScope.proyectopropiedadc.filtrar($event)"></input></div>'
				    },
				    { name: 'fechaCreacion', displayName: 'Fecha Creación', cellClass: 'grid-align-right', type: 'date', cellFilter: 'date:\'dd/MM/yyyy\'',
				    	filterHeaderTemplate: '<div class="ui-grid-filter-container"><input type="text" style="width: 90%;" ng-model="grid.appScope.proyectopropiedadc.filtros[\'fecha_creacion\']" ng-keypress="grid.appScope.proyectopropiedadc.filtrar($event)"></input></div>'
				    }
				],
				onRegisterApi: function(gridApi) {
					mi.gridApi = gridApi;
					gridApi.selection.on.rowSelectionChanged($scope,function(row) {
						mi.proyectopropiedad = row.entity;
					});
					
					gridApi.core.on.sortChanged( $scope, function ( grid, sortColumns ) {
						if(sortColumns.length==1){
							grid.appScope.proyectopropiedadc.columnaOrdenada=sortColumns[0].field;
							grid.appScope.proyectopropiedadc.ordenDireccion = sortColumns[0].sort.direction;

							grid.appScope.proyectopropiedadc.cargarTabla(grid.appScope.proyectopropiedadc.paginaActual);
						}
						else if(sortColumns.length>1){
							sortColumns[0].unsort();
						}
						else{
							if(grid.appScope.proyectopropiedadc.columnaOrdenada!=null){
								grid.appScope.proyectopropiedadc.columnaOrdenada=null;
								grid.appScope.proyectopropiedadc.ordenDireccion=null;
							}
						}
					} );
					
					if($routeParams.reiniciar_vista=='rv'){
						mi.guardarEstado();
						mi.obtenerTotalProyectoPropiedades();
				    }
				    else{
				    	  $http.post('/SEstadoTabla', { action: 'getEstado', grid:'proyctopropiedades', t: (new Date()).getTime()}).then(function(response){
				    		  if(response.data.success && response.data.estado!='')
				    			  mi.gridApi.saveState.restore( $scope, response.data.estado);
					    	  mi.gridApi.colMovable.on.columnPositionChanged($scope, mi.guardarEstado);
						      mi.gridApi.colResizable.on.columnSizeChanged($scope, mi.guardarEstado);
						      mi.gridApi.core.on.columnVisibilityChanged($scope, mi.guardarEstado);
						      mi.obtenerTotalProyectoPropiedades();
						  });
				    }
				}
			};
		
		mi.cargarTabla = function(pagina){
			mi.mostrarcargando=true;
			$http.post('/SProyectoPropiedad', { accion: 'getProyectoPropiedadPagina', pagina: pagina, numeroriesgopropiedades: $utilidades.elementosPorPagina,
			filtro_nombre: mi.filtros['nombre'], 
			filtro_usuario_creo: mi.filtros['usuario_creo'],
		    filtro_fecha_creacion: mi.filtros['fecha_creacion'],
		    columna_ordenada: mi.columnaOrdenada, orden_direccion: mi.ordenDireccion }).success(
					function(response) {
						mi.proyectopropiedades = response.proyectopropiedades;
						mi.gridOptions.data = mi.proyectopropiedades;
						mi.mostrarcargando = false;
					});
		}
		
		mi.guardar=function(){
			if(mi.proyectopropiedad!=null && mi.proyectopropiedad.datotipoid!=null){
				$http.post('/SProyectoPropiedad', {
					accion: 'guardarProyectoPropiedad',
					esnuevo: mi.esnuevo,
					id: mi.proyectopropiedad.id,
					nombre: mi.proyectopropiedad.nombre,
					descripcion: mi.proyectopropiedad.descripcion,
					datoTipoId: mi.proyectopropiedad.datotipoid.id
				}).success(function(response){
					if(response.success){
						$utilidades.mensaje('success','Propiedad Proyecto '+(mi.esnuevo ? 'creado' : 'guardado')+' con éxito');
						mi.proyectopropiedad.id = response.id;
						mi.esnuevo = false;
						mi.obtenerTotalProyectoPropiedades();
					}
					else
						$utilidades.mensaje('danger','Error al '+(mi.esnuevo ? 'creado' : 'guardado')+' la Propiedad Proyecto');
				});
			}
			else
				$utilidades.mensaje('warning','Debe de llenar todos los campos obligatorios');
		};
	
		mi.borrar = function(ev) {
			if(mi.proyectopropiedad!=null && mi.proyectopropiedad.id!=null){
				var confirm = $mdDialog.confirm()
			          .title('Confirmación de borrado')
			          .textContent('¿Desea borrar la Propiedad Proyecto "'+mi.proyectopropiedad.nombre+'"?')
			          .ariaLabel('Confirmación de borrado')
			          .targetEvent(ev)
			          .ok('Borrar')
			          .cancel('Cancelar');
	
			    $mdDialog.show(confirm).then(function() {
			    	$http.post('/SProyectoPropiedad', {
						accion: 'borrarProyectoPropiedad',
						id: mi.proyectopropiedad.id
					}).success(function(response){
						if(response.success){
							$utilidades.mensaje('success','Propiedad Proyecto borrado con éxito');
							mi.obtenerTotalProyectoPropiedades();
						}
						else
							$utilidades.mensaje('danger','Error al borrar la Propiedad Proyecto');
					});
			    }, function() {
			    
			    });
			}
			else
				$utilidades.mensaje('warning','Debe seleccionar la Propiedad Proyecto que desea borrar');
		};
	
		mi.nuevo = function() {
			mi.mostraringreso=true;
			mi.esnuevo = true;
			mi.proyectopropiedad = {};
			mi.gridApi.selection.clearSelectedRows();
		};
	
		mi.editar = function() {
			if(mi.proyectopropiedad!=null && mi.prouyectopropiedad.id!=null){
				mi.mostraringreso = true;
				mi.esnuevo = false;
				mi.proyectopropiedad.datotipoid = {
						"id" : mi.proyectopropiedad.datotipoid,
						"nombre" : mi.proyectopropiedad.datotiponombre
				}

			}
			else
				$utilidades.mensaje('warning','Debe seleccionar la Propiedad Proyecto que desea editar');
		}
	
		mi.irATabla = function() {
			mi.mostraringreso=false;
		}
		
		mi.guardarEstado=function(){
			var estado = mi.gridApi.saveState.save();
			var tabla_data = { action: 'guardaEstado', grid:'proyctopropiedades', estado: JSON.stringify(estado), t: (new Date()).getTime() }; 
			$http.post('/SEstadoTabla', tabla_data).then(function(response){
				
			});
		}
		
		mi.cambioPagina=function(){
			mi.cargarTabla(mi.paginaActual);
		}
		
		mi.reiniciarVista=function(){
			if($location.path()=='/proyectopropiedad/rv')
				$route.reload();
			else
				$location.path('/proyectopropiedad/rv');
		}
		
		mi.obtenerTotalProyectoPropiedades = function() { 
			$http.post('/SProyectoPropiedad', { accion: 'numeroProyectoPropiedades',filtro_nombre: mi.filtros['nombre'], 
				filtro_usuario_creo: mi.filtros['usuario_creo'],
			    filtro_fecha_creacion: mi.filtros['fecha_creacion'] }).success(
					function(response) {
						mi.totalProyectoPropiedades = response.totalproyectopropiedades;
						mi.cargarTabla(1);
			});
		}
		
		mi.filtrar = function(evt){
			if(evt.keyCode==13){
				mi.obtenerTotalProyectoPropiedades();
			}
		}
		
		$http.post('/SDatoTipo', { accion: 'cargarCombo' }).success(
				function(response) {
					mi.tipodatos = response.datoTipos;
		});
		
	} 
]);