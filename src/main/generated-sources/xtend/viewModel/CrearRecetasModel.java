package viewModel;

import BDDConnection.Conexion;
import Repositorio.RepositorioReceta;
import domain.Articulo;
import domain.Receta;
import domain.UnidadDeMedida;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class CrearRecetasModel {
  private RepositorioReceta repo = RepositorioReceta.getInstance();
  
  private List<Articulo> articulosAgregados = CollectionLiterals.<Articulo>newArrayList();
  
  private Articulo articulo;
  
  private Articulo seleccionado;
  
  private String nombreTemp;
  
  private String descripcionTemp;
  
  private int cantidadTemp;
  
  private UnidadDeMedida medidaTemp;
  
  private Conexion conexion = new Conexion();
  
  public CrearRecetasModel() {
    this.conexion.start();
  }
  
  public List<Articulo> getArticulosAAgregar() {
    return this.conexion.getArticulos();
  }
  
  public List<UnidadDeMedida> getMedidas() {
    return this.conexion.getMedidas();
  }
  
  public boolean agregar() {
    boolean _xifexpression = false;
    boolean _contains = this.articulosAgregados.contains(this.articulo);
    boolean _not = (!_contains);
    if (_not) {
      boolean _xblockexpression = false;
      {
        this.articulo.setCantidad(this.cantidadTemp);
        this.articulo.setUnidad(this.medidaTemp);
        _xblockexpression = this.articulosAgregados.add(this.articulo);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public boolean eliminar() {
    return this.articulosAgregados.remove(this.seleccionado);
  }
  
  public void crearReceta() {
    Receta _receta = new Receta(this.articulosAgregados, this.nombreTemp, this.descripcionTemp);
    this.repo.update(_receta);
  }
  
  @Pure
  public RepositorioReceta getRepo() {
    return this.repo;
  }
  
  public void setRepo(final RepositorioReceta repo) {
    this.repo = repo;
  }
  
  @Pure
  public List<Articulo> getArticulosAgregados() {
    return this.articulosAgregados;
  }
  
  public void setArticulosAgregados(final List<Articulo> articulosAgregados) {
    this.articulosAgregados = articulosAgregados;
  }
  
  @Pure
  public Articulo getArticulo() {
    return this.articulo;
  }
  
  public void setArticulo(final Articulo articulo) {
    this.articulo = articulo;
  }
  
  @Pure
  public Articulo getSeleccionado() {
    return this.seleccionado;
  }
  
  public void setSeleccionado(final Articulo seleccionado) {
    this.seleccionado = seleccionado;
  }
  
  @Pure
  public String getNombreTemp() {
    return this.nombreTemp;
  }
  
  public void setNombreTemp(final String nombreTemp) {
    this.nombreTemp = nombreTemp;
  }
  
  @Pure
  public String getDescripcionTemp() {
    return this.descripcionTemp;
  }
  
  public void setDescripcionTemp(final String descripcionTemp) {
    this.descripcionTemp = descripcionTemp;
  }
  
  @Pure
  public int getCantidadTemp() {
    return this.cantidadTemp;
  }
  
  public void setCantidadTemp(final int cantidadTemp) {
    this.cantidadTemp = cantidadTemp;
  }
  
  @Pure
  public UnidadDeMedida getMedidaTemp() {
    return this.medidaTemp;
  }
  
  public void setMedidaTemp(final UnidadDeMedida medidaTemp) {
    this.medidaTemp = medidaTemp;
  }
  
  @Pure
  public Conexion getConexion() {
    return this.conexion;
  }
  
  public void setConexion(final Conexion conexion) {
    this.conexion = conexion;
  }
}
