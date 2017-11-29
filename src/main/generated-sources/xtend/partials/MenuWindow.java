package partials;

import domain.Articulo;
import domain.Receta;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import partials.CrearRecetaWindow;
import partials.EditarRecetaWindow;
import partials.MensajeWindow;
import viewModel.MenuModel;

@SuppressWarnings("all")
public class MenuWindow extends SimpleWindow<MenuModel> {
  public MenuWindow(final WindowOwner parent) {
    super(parent, new MenuModel());
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Heladera");
    final NotNullObservable deshabilitador = new NotNullObservable("receta");
    final Panel recetasPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    recetasPanel.setLayout(_horizontalLayout);
    final Panel listaRecetasPanel = new Panel(recetasPanel);
    final Panel botonesRecetasPanel = new Panel(recetasPanel);
    Label _label = new Label(listaRecetasPanel);
    _label.setText("Recetas");
    List<Receta> _list = new List<Receta>(listaRecetasPanel);
    final Procedure1<List<Receta>> _function = new Procedure1<List<Receta>>() {
      public void apply(final List<Receta> it) {
        ObservableItems<Selector<Receta>, Receta, ListBuilder<Receta>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "recetas");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "receta");
        ObservableItems<Selector<Receta>, Receta, ListBuilder<Receta>> _items_1 = it.items();
        final Binding bindingRecetas = ArenaXtendExtensions.operator_spaceship(_items_1, "recetas");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Receta.class, "nombre");
        bindingRecetas.setAdapter(_propertyAdapter);
        it.setWidth(150);
      }
    };
    ObjectExtensions.<List<Receta>>operator_doubleArrow(_list, _function);
    Button _button = new Button(listaRecetasPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Almacenar Receta");
        final Action _function = new Action() {
          public void execute() {
            MenuWindow.this.getModelObject().almacenar();
            boolean _isAlmacenadoSatisfactorio = MenuWindow.this.getModelObject().isAlmacenadoSatisfactorio();
            if (_isAlmacenadoSatisfactorio) {
              MensajeWindow _mensajeWindow = new MensajeWindow(MenuWindow.this, "Se ha almacenado correctamente");
              MenuWindow.this.openDialog(_mensajeWindow);
              MenuModel _modelObject = MenuWindow.this.getModelObject();
              _modelObject.setAlmacenadoSatisfactorio(false);
            }
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(deshabilitador);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    new Label(botonesRecetasPanel);
    Button _button_1 = new Button(botonesRecetasPanel);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Crear Receta");
        final Action _function = new Action() {
          public void execute() {
            CrearRecetaWindow _crearRecetaWindow = new CrearRecetaWindow(MenuWindow.this);
            MenuWindow.this.openDialog(_crearRecetaWindow);
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
    Button _button_2 = new Button(botonesRecetasPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar Receta");
        final Action _function = new Action() {
          public void execute() {
            Receta _receta = MenuWindow.this.getModelObject().getReceta();
            EditarRecetaWindow _editarRecetaWindow = new EditarRecetaWindow(MenuWindow.this, _receta);
            MenuWindow.this.openDialog(_editarRecetaWindow);
          }
        };
        it.onClick(_function);
        it.<Object, ControlBuilder>bindEnabled(deshabilitador);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_3);
    Button _button_3 = new Button(botonesRecetasPanel);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Obtener Articulos");
        final Action _function = new Action() {
          public void execute() {
            MenuWindow.this.getModelObject().obtenerArticulos();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_4);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Articulos");
    List<Articulo> _list_1 = new List<Articulo>(mainPanel);
    final Procedure1<List<Articulo>> _function_5 = new Procedure1<List<Articulo>>() {
      public void apply(final List<Articulo> it) {
        ObservableItems<Selector<Articulo>, Articulo, ListBuilder<Articulo>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "articulos");
        ObservableItems<Selector<Articulo>, Articulo, ListBuilder<Articulo>> _items_1 = it.items();
        final Binding bindingArticulos = ArenaXtendExtensions.operator_spaceship(_items_1, "articulos");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Articulo.class, "nombre");
        bindingArticulos.setAdapter(_propertyAdapter);
        it.setWidth(150);
      }
    };
    ObjectExtensions.<List<Articulo>>operator_doubleArrow(_list_1, _function_5);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        MenuWindow.this.getModelObject().refreshAll();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
