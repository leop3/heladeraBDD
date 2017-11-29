package Repositorio;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public abstract class Repositorio<Tipo extends Object> {
  private List<Tipo> listaRepo = CollectionLiterals.<Tipo>newArrayList();
  
  public abstract void crear(final Tipo objeto);
  
  public abstract void eliminar(final Tipo objeto);
  
  public abstract Tipo searchById(final int _id);
  
  public abstract void update(final Tipo objeto);
  
  public List<Tipo> getListaRepo() {
    return this.listaRepo;
  }
}
