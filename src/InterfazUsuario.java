/**
 * Interfaz que define el método update(). Nos permite seguir el patrón de
 * diseño Observer.
 */
public interface InterfazUsuario{

  /**
   * Método que nos permite modificar los objetos vinculados a un sujeto
   * observable una vez que este tiene algún cambio.
   */
   public void update();
}
