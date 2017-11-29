package viewModel;

import BDDConnection.Conexion;
import Repositorio.RepositorioReceta;
import domain.Articulo;
import domain.Receta;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class MenuModel {
  private RepositorioReceta repo;
  
  private Receta receta;
  
  private List<Receta> recetas = CollectionLiterals.<Receta>newArrayList();
  
  private List<Articulo> articulos = CollectionLiterals.<Articulo>newArrayList();
  
  private boolean almacenadoSatisfactorio = false;
  
  private Conexion conexion = new Conexion();
  
  public MenuModel() {
    this.repo = RepositorioReceta.getInstance();
    this.conexion.obtenerRecetas();
    this.refreshAll();
  }
  
  public List<Receta> refreshAll() {
    return this.refreshRecetas();
  }
  
  public List<Receta> refreshRecetas() {
    List<Receta> _xblockexpression = null;
    {
      final ArrayList<Receta> recetasTemp = CollectionLiterals.<Receta>newArrayList();
      final Consumer<Receta> _function = new Consumer<Receta>() {
        public void accept(final Receta rec) {
          recetasTemp.add(rec);
        }
      };
      this.repo.getListaRepo().forEach(_function);
      _xblockexpression = this.recetas = recetasTemp;
    }
    return _xblockexpression;
  }
  
  public void almacenar() {
    this.almacenadoSatisfactorio = true;
    this.conexion.insertarReceta(this.receta);
  }
  
  public List<Articulo> obtenerArticulos() {
    List<Articulo> _xblockexpression = null;
    {
      this.conexion.obtenerArticulos();
      _xblockexpression = this.articulos = this.conexion.getArticulos();
    }
    return _xblockexpression;
  }
  
  @Pure
  public RepositorioReceta getRepo() {
    return this.repo;
  }
  
  public void setRepo(final RepositorioReceta repo) {
    this.repo = repo;
  }
  
  @Pure
  public Receta getReceta() {
    return this.receta;
  }
  
  public void setReceta(final Receta receta) {
    this.receta = receta;
  }
  
  @Pure
  public List<Receta> getRecetas() {
    return this.recetas;
  }
  
  public void setRecetas(final List<Receta> recetas) {
    this.recetas = recetas;
  }
  
  @Pure
  public List<Articulo> getArticulos() {
    return this.articulos;
  }
  
  public void setArticulos(final List<Articulo> articulos) {
    this.articulos = articulos;
  }
  
  @Pure
  public boolean isAlmacenadoSatisfactorio() {
    return this.almacenadoSatisfactorio;
  }
  
  public void setAlmacenadoSatisfactorio(final boolean almacenadoSatisfactorio) {
    this.almacenadoSatisfactorio = almacenadoSatisfactorio;
  }
  
  @Pure
  public Conexion getConexion() {
    return this.conexion;
  }
  
  public void setConexion(final Conexion conexion) {
    this.conexion = conexion;
  }
}
