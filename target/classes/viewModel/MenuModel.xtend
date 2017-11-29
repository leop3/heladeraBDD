package viewModel

import BDDConnection.Conexion
import Repositorio.RepositorioReceta
import domain.Articulo
import domain.Receta
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class MenuModel {
	RepositorioReceta repo
	Receta receta
	List<Receta> recetas = newArrayList
	List<Articulo> articulos = newArrayList
	boolean almacenadoSatisfactorio = false
	Conexion conexion = new Conexion()

	new() {
		repo = RepositorioReceta.instance
		conexion.obtenerRecetas
		this.refreshAll
	}

	def refreshAll() {
		this.refreshRecetas
	}

	def refreshRecetas() {
		val recetasTemp = newArrayList
		repo.listaRepo.forEach[rec|recetasTemp.add(rec)]
		recetas = recetasTemp

	}

	
	def almacenar(){
		almacenadoSatisfactorio = true
		conexion.insertarReceta(receta)
	}
	
	def obtenerArticulos(){
		conexion.obtenerArticulos()
		articulos = conexion.articulos
	}
}
