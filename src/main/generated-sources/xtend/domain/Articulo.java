package domain;

import domain.UnidadDeMedida;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Articulo {
  private int idArticulo;
  
  private String descripcion;
  
  private String nombre;
  
  private UnidadDeMedida unidad;
  
  private int cantidad;
  
  @Pure
  public int getIdArticulo() {
    return this.idArticulo;
  }
  
  public void setIdArticulo(final int idArticulo) {
    this.idArticulo = idArticulo;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public UnidadDeMedida getUnidad() {
    return this.unidad;
  }
  
  public void setUnidad(final UnidadDeMedida unidad) {
    this.unidad = unidad;
  }
  
  @Pure
  public int getCantidad() {
    return this.cantidad;
  }
  
  public void setCantidad(final int cantidad) {
    this.cantidad = cantidad;
  }
}
