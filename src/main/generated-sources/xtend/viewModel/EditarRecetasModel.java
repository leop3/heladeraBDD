package viewModel;

import domain.Articulo;
import domain.Receta;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import viewModel.CrearRecetasModel;

@SuppressWarnings("all")
public class EditarRecetasModel extends CrearRecetasModel {
  private int idTemp;
  
  public EditarRecetasModel(final Receta receta) {
    final Consumer<Articulo> _function = new Consumer<Articulo>() {
      public void accept(final Articulo art) {
        EditarRecetasModel.this.getArticulosAgregados().add(art);
      }
    };
    receta.getArticulos().forEach(_function);
    this.idTemp = receta.getIdReceta();
    this.setDescripcionTemp(receta.getDescripcion());
    this.setNombreTemp(receta.getNombre());
  }
  
  public void crearReceta() {
    List<Articulo> _articulosAgregados = this.getArticulosAgregados();
    String _nombreTemp = this.getNombreTemp();
    String _descripcionTemp = this.getDescripcionTemp();
    Receta _receta = new Receta(_articulosAgregados, _nombreTemp, _descripcionTemp);
    final Procedure1<Receta> _function = new Procedure1<Receta>() {
      public void apply(final Receta it) {
        it.setIdReceta(EditarRecetasModel.this.idTemp);
      }
    };
    final Receta recetaTemp = ObjectExtensions.<Receta>operator_doubleArrow(_receta, _function);
    this.getRepo().update(recetaTemp);
  }
}
