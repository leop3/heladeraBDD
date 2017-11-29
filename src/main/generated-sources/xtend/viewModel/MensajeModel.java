package viewModel;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class MensajeModel {
  private String msj;
  
  public MensajeModel(final String _msj) {
    this.msj = _msj;
  }
  
  @Pure
  public String getMsj() {
    return this.msj;
  }
  
  public void setMsj(final String msj) {
    this.msj = msj;
  }
}
