package domain;

import domain.Articulo;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Receta {
  private int idReceta = (-1);
  
  private String nombre;
  
  private String descripcion;
  
  private List<Articulo> articulos = CollectionLiterals.<Articulo>newArrayList();
  
  private boolean nueva = true;
  
  public Receta(final List<Articulo> articles, final String name, final String description) {
    this.articulos = articles;
    this.descripcion = description;
    this.nombre = name;
  }
  
  public Receta() {
  }
  
  @Pure
  public int getIdReceta() {
    return this.idReceta;
  }
  
  public void setIdReceta(final int idReceta) {
    this.idReceta = idReceta;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Pure
  public List<Articulo> getArticulos() {
    return this.articulos;
  }
  
  public void setArticulos(final List<Articulo> articulos) {
    this.articulos = articulos;
  }
  
  @Pure
  public boolean isNueva() {
    return this.nueva;
  }
  
  public void setNueva(final boolean nueva) {
    this.nueva = nueva;
  }
}
