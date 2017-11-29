package partials;

import domain.Articulo;
import domain.UnidadDeMedida;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;
import viewModel.CrearRecetasModel;

@SuppressWarnings("all")
public class CrearRecetaWindow extends TransactionalDialog<CrearRecetasModel> {
  public CrearRecetaWindow(final WindowOwner owner) {
    super(owner, new CrearRecetasModel());
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Crear Receta");
    final Panel nombreDescripcionPanel = new Panel(mainPanel);
    final Panel ingresosPanel = new Panel(mainPanel);
    final Panel tablePanel = new Panel(mainPanel);
    final Panel botonesPanel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    nombreDescripcionPanel.setLayout(_horizontalLayout);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    ingresosPanel.setLayout(_horizontalLayout_1);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    tablePanel.setLayout(_horizontalLayout_2);
    HorizontalLayout _horizontalLayout_3 = new HorizontalLayout();
    botonesPanel.setLayout(_horizontalLayout_3);
    Label _label = new Label(nombreDescripcionPanel);
    _label.setText("Nombre Receta");
    TextBox _textBox = new TextBox(nombreDescripcionPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "nombreTemp");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(nombreDescripcionPanel);
    _label_1.setText("Descripcion");
    TextBox _textBox_1 = new TextBox(nombreDescripcionPanel);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "descripcionTemp");
        it.setWidth(250);
        it.setHeight(150);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
    Label _label_2 = new Label(ingresosPanel);
    _label_2.setText("Articulos:");
    Selector<Articulo> _selector = new Selector<Articulo>(ingresosPanel);
    final Procedure1<Selector<Articulo>> _function_2 = new Procedure1<Selector<Articulo>>() {
      public void apply(final Selector<Articulo> it) {
        ObservableItems<Selector<Articulo>, Articulo, ListBuilder<Articulo>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "articulosAAgregar");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "articulo");
        it.setWidth(100);
        ObservableItems<Selector<Articulo>, Articulo, ListBuilder<Articulo>> _items_1 = it.items();
        final Binding bindingAcciones = ArenaXtendExtensions.operator_spaceship(_items_1, "articulosAAgregar");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Articulo.class, "nombre");
        bindingAcciones.setAdapter(_propertyAdapter);
      }
    };
    ObjectExtensions.<Selector<Articulo>>operator_doubleArrow(_selector, _function_2);
    Label _label_3 = new Label(ingresosPanel);
    _label_3.setText("Cantidad");
    NumericField _numericField = new NumericField(ingresosPanel);
    final Procedure1<NumericField> _function_3 = new Procedure1<NumericField>() {
      public void apply(final NumericField it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "cantidadTemp");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<NumericField>operator_doubleArrow(_numericField, _function_3);
    Label _label_4 = new Label(ingresosPanel);
    _label_4.setText("Unidad:");
    Selector<UnidadDeMedida> _selector_1 = new Selector<UnidadDeMedida>(ingresosPanel);
    final Procedure1<Selector<UnidadDeMedida>> _function_4 = new Procedure1<Selector<UnidadDeMedida>>() {
      public void apply(final Selector<UnidadDeMedida> it) {
        ObservableItems<Selector<UnidadDeMedida>, UnidadDeMedida, ListBuilder<UnidadDeMedida>> _items = it.items();
        ArenaXtendExtensions.operator_spaceship(_items, "medidas");
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, "medidaTemp");
        it.setWidth(100);
        ObservableItems<Selector<UnidadDeMedida>, UnidadDeMedida, ListBuilder<UnidadDeMedida>> _items_1 = it.items();
        final Binding bindingAcciones = ArenaXtendExtensions.operator_spaceship(_items_1, "medidas");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(UnidadDeMedida.class, "nombre");
        bindingAcciones.setAdapter(_propertyAdapter);
      }
    };
    ObjectExtensions.<Selector<UnidadDeMedida>>operator_doubleArrow(_selector_1, _function_4);
    this.loadTable(tablePanel);
    Button _button = new Button(botonesPanel);
    final Procedure1<Button> _function_5 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar");
        final Action _function = new Action() {
          public void execute() {
            CrearRecetaWindow.this.getModelObject().agregar();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_5);
    Button _button_1 = new Button(botonesPanel);
    final Procedure1<Button> _function_6 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Eliminar");
        final Action _function = new Action() {
          public void execute() {
            CrearRecetaWindow.this.getModelObject().eliminar();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_6);
  }
  
  public Column<Articulo> loadTable(final Panel panel) {
    Column<Articulo> _xblockexpression = null;
    {
      Table<Articulo> _table = new Table<Articulo>(panel, Articulo.class);
      final Procedure1<Table<Articulo>> _function = new Procedure1<Table<Articulo>>() {
        public void apply(final Table<Articulo> it) {
          ViewObservable<Table<Articulo>, TableBuilder<Articulo>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "articulosAgregados");
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "seleccionado");
          it.setNumberVisibleRows(3);
        }
      };
      final Table<Articulo> tablaDeProcesos = ObjectExtensions.<Table<Articulo>>operator_doubleArrow(_table, _function);
      Column<Articulo> _column = new Column<Articulo>(tablaDeProcesos);
      final Procedure1<Column<Articulo>> _function_1 = new Procedure1<Column<Articulo>>() {
        public void apply(final Column<Articulo> it) {
          it.setTitle("Articulo");
          it.setFixedSize(200);
          it.bindContentsToProperty("nombre");
        }
      };
      ObjectExtensions.<Column<Articulo>>operator_doubleArrow(_column, _function_1);
      Column<Articulo> _column_1 = new Column<Articulo>(tablaDeProcesos);
      final Procedure1<Column<Articulo>> _function_2 = new Procedure1<Column<Articulo>>() {
        public void apply(final Column<Articulo> it) {
          it.setTitle("cantidad");
          it.setFixedSize(150);
          it.bindContentsToProperty("cantidad");
        }
      };
      ObjectExtensions.<Column<Articulo>>operator_doubleArrow(_column_1, _function_2);
      Column<Articulo> _column_2 = new Column<Articulo>(tablaDeProcesos);
      final Procedure1<Column<Articulo>> _function_3 = new Procedure1<Column<Articulo>>() {
        public void apply(final Column<Articulo> it) {
          it.setTitle("unidad");
          it.setFixedSize(150);
          it.bindContentsToProperty("unidad.nombre");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Articulo>>operator_doubleArrow(_column_2, _function_3);
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Crear");
        final Action _function = new Action() {
          public void execute() {
            CrearRecetaWindow.this.accept();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public void executeTask() {
    this.getModelObject().crearReceta();
    super.executeTask();
  }
}
