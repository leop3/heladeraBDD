package BDDConnection;

import Repositorio.RepositorioReceta;
import domain.Articulo;
import domain.Receta;
import domain.UnidadDeMedida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Conexion {
  private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  
  private final static String DB_URL = "jdbc:mysql://localhost:3306/mydb";
  
  private final static String USER = "root";
  
  private final static String PASS = "159159";
  
  private LocalDateTime fecha;
  
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
  
  private String formattedDateTime;
  
  private Connection conn;
  
  private Statement stment;
  
  private ResultSet rs;
  
  private RepositorioReceta repoReceta = RepositorioReceta.getInstance();
  
  private List<Articulo> articulos = CollectionLiterals.<Articulo>newArrayList();
  
  private List<UnidadDeMedida> medidas = CollectionLiterals.<UnidadDeMedida>newArrayList();
  
  public Conexion() {
    try {
      Class.forName(Conexion.JDBC_DRIVER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void obtenerArticulos() {
    try {
      final String sql = "select * from articulo;";
      final ResultSet rs = this.ejecutarQuery(sql);
      this.articulos = CollectionLiterals.<Articulo>newArrayList();
      while (rs.next()) {
        {
          final int unidadIDTemp = rs.getInt("unidadMedida_idUnidadMedida");
          final Function1<UnidadDeMedida, Boolean> _function = new Function1<UnidadDeMedida, Boolean>() {
            public Boolean apply(final UnidadDeMedida unit) {
              int _id = unit.getId();
              return Boolean.valueOf((_id == unidadIDTemp));
            }
          };
          final UnidadDeMedida unidadTemp = IterableExtensions.<UnidadDeMedida>findFirst(this.medidas, _function);
          Articulo _articulo = new Articulo();
          final Procedure1<Articulo> _function_1 = new Procedure1<Articulo>() {
            public void apply(final Articulo it) {
              try {
                it.setIdArticulo(rs.getInt("idArticulo"));
                it.setNombre(rs.getString("nombre"));
                it.setDescripcion(rs.getString("descripcion"));
                it.setCantidad(rs.getInt("stock"));
                it.setUnidad(unidadTemp);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          Articulo _doubleArrow = ObjectExtensions.<Articulo>operator_doubleArrow(_articulo, _function_1);
          this.articulos.add(_doubleArrow);
        }
      }
      rs.close();
      this.cerrarQuery();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void obtenerRecetas() {
    try {
      final String sql = "select * from receta;";
      final ResultSet rs = this.ejecutarQuery(sql);
      while (rs.next()) {
        Receta _receta = new Receta();
        final Procedure1<Receta> _function = new Procedure1<Receta>() {
          public void apply(final Receta it) {
            try {
              it.setNueva(false);
              it.setIdReceta(rs.getInt("idReceta"));
              it.setNombre(rs.getString("nombre"));
              it.setDescripcion(rs.getString("descripcion"));
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        Receta _doubleArrow = ObjectExtensions.<Receta>operator_doubleArrow(_receta, _function);
        this.repoReceta.update(_doubleArrow);
      }
      rs.close();
      this.cerrarQuery();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void obtenerUnidadDeMedida() {
    try {
      final String sql = "select * from unidadmedida;";
      final ResultSet rs = this.ejecutarQuery(sql);
      this.medidas = CollectionLiterals.<UnidadDeMedida>newArrayList();
      while (rs.next()) {
        String _string = rs.getString("descripcion");
        UnidadDeMedida _unidadDeMedida = new UnidadDeMedida(_string);
        final Procedure1<UnidadDeMedida> _function = new Procedure1<UnidadDeMedida>() {
          public void apply(final UnidadDeMedida it) {
            try {
              it.setId(rs.getInt("idUnidadMedida"));
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        UnidadDeMedida _doubleArrow = ObjectExtensions.<UnidadDeMedida>operator_doubleArrow(_unidadDeMedida, _function);
        this.medidas.add(_doubleArrow);
      }
      rs.close();
      this.cerrarQuery();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void insertarReceta(final Receta receta) {
    final StringBuilder sql = new StringBuilder();
    this.fecha = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    this.formattedDateTime = this.fecha.format(this.formatter);
    boolean _isNueva = receta.isNueva();
    if (_isNueva) {
      sql.append("insert into receta ");
      sql.append("values (");
      int _idReceta = receta.getIdReceta();
      String _plus = (Integer.valueOf(_idReceta) + ",");
      sql.append(_plus);
      String _descripcion = receta.getDescripcion();
      String _plus_1 = ("\'" + _descripcion);
      String _plus_2 = (_plus_1 + "\',\'");
      String _nombre = receta.getNombre();
      String _plus_3 = (_plus_2 + _nombre);
      String _plus_4 = (_plus_3 + "\' ); ");
      sql.append(_plus_4);
      this.ejecutarUpdate(sql.toString());
      final Consumer<Articulo> _function = new Consumer<Articulo>() {
        public void accept(final Articulo art) {
          String str = null;
          String _string = Integer.valueOf(art.getIdArticulo()).toString();
          String _plus = ("insert into compone values(" + _string);
          String _plus_1 = (_plus + ",");
          String _string_1 = Integer.valueOf(receta.getIdReceta()).toString();
          String _plus_2 = (_plus_1 + _string_1);
          String _plus_3 = (_plus_2 + "); ");
          str = _plus_3;
          Conexion.this.ejecutarUpdate(str);
        }
      };
      receta.getArticulos().forEach(_function);
    }
    this.cerrarQuery();
  }
  
  public void cerrarQuery() {
    try {
      this.conn.close();
      this.stment.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int ejecutarUpdate(final String sqlQuery) {
    try {
      int _xblockexpression = (int) 0;
      {
        this.conn = DriverManager.getConnection(Conexion.DB_URL, Conexion.USER, Conexion.PASS);
        this.stment = this.conn.createStatement();
        _xblockexpression = this.stment.executeUpdate(sqlQuery);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResultSet ejecutarQuery(final String sqlQuery) {
    try {
      ResultSet _xblockexpression = null;
      {
        this.conn = DriverManager.getConnection(Conexion.DB_URL, Conexion.USER, Conexion.PASS);
        this.stment = this.conn.createStatement();
        _xblockexpression = this.rs = this.stment.executeQuery(sqlQuery);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void start() {
    this.obtenerUnidadDeMedida();
    this.obtenerArticulos();
  }
  
  public List<UnidadDeMedida> getMedidas() {
    return this.medidas;
  }
  
  public List<Articulo> getArticulos() {
    return this.articulos;
  }
}
