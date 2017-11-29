package Runnable;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import partials.MenuWindow;

@SuppressWarnings("all")
public class HeladeraApp extends Application {
  public HeladeraApp() {
    super();
  }
  
  public static void main(final String[] args) {
    new HeladeraApp().start();
  }
  
  protected Window<?> createMainWindow() {
    return new MenuWindow(this);
  }
}
