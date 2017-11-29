package Repositorio;

import Repositorio.Repositorio;
import com.google.common.base.Objects;
import domain.Receta;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RepositorioReceta extends Repositorio<Receta> {
  private static RepositorioReceta instance;
  
  private RepositorioReceta() {
  }
  
  public static RepositorioReceta getInstance() {
    boolean _equals = Objects.equal(RepositorioReceta.instance, null);
    if (_equals) {
      RepositorioReceta _repositorioReceta = new RepositorioReceta();
      RepositorioReceta.instance = _repositorioReceta;
    }
    return RepositorioReceta.instance;
  }
  
  public void crear(final Receta objeto) {
    int _size = this.getListaRepo().size();
    boolean _equals = (_size == 0);
    if (_equals) {
      objeto.setIdReceta(0);
      this.getListaRepo().add(objeto);
    } else {
      final int idMaximo = this.maxId();
      objeto.setIdReceta((idMaximo + 1));
      this.getListaRepo().add(objeto);
    }
  }
  
  public int maxId() {
    int _xblockexpression = (int) 0;
    {
      int idMax = 0;
      final Function1<Receta, Integer> _function = new Function1<Receta, Integer>() {
        public Integer apply(final Receta receta) {
          return Integer.valueOf(receta.getIdReceta());
        }
      };
      final Receta objetoTemp = IterableExtensions.<Receta, Integer>maxBy(this.getListaRepo(), _function);
      idMax = objetoTemp.getIdReceta();
      _xblockexpression = idMax;
    }
    return _xblockexpression;
  }
  
  public void eliminar(final Receta objeto) {
    final Receta recetaTemp = this.searchById(objeto.getIdReceta());
    boolean _notEquals = (!Objects.equal(recetaTemp, null));
    if (_notEquals) {
      this.getListaRepo().remove(recetaTemp);
    }
  }
  
  public Receta searchById(final int _id) {
    final Function1<Receta, Boolean> _function = new Function1<Receta, Boolean>() {
      public Boolean apply(final Receta receta) {
        int _idReceta = receta.getIdReceta();
        return Boolean.valueOf((_idReceta == _id));
      }
    };
    return IterableExtensions.<Receta>findFirst(this.getListaRepo(), _function);
  }
  
  public void update(final Receta objeto) {
    int _idReceta = objeto.getIdReceta();
    boolean _lessThan = (_idReceta < 0);
    if (_lessThan) {
      this.crear(objeto);
    } else {
      Receta _searchById = this.searchById(objeto.getIdReceta());
      boolean _notEquals = (!Objects.equal(_searchById, null));
      if (_notEquals) {
        this.getListaRepo().set(this.getListaRepo().indexOf(this.searchById(objeto.getIdReceta())), objeto);
      } else {
        this.getListaRepo().add(objeto);
      }
    }
  }
}
