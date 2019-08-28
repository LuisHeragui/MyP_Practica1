import java.util.ArrayList;

/**
 * Interfaz que define el comportamiento que las plataformas tiene en común.
 */
public interface InterfazPlataforma{

  /**
   * Cobra el monto diario de la plataforma al usuario.
   */
  public void cobrar();

  /**
   * Registra al usuario en la base de datos de la plataforma.
   * @param usuario el usuario a registrar.
   */
  public void registrar(Usuario usuario);

  /**
   * Remueve al usuario de la base de datos de la plataforma.
   * @param usuario el usuario a remover.
   */
  public void remover(Usuario usuario);

  /**
   * Les da una recomendacion de contenido a los usuarios en la base de datos
   * de la plataforma.
   */
  public void recomendar();

  /**
   * Le notifica al usuario que ocurrió un evento. Ya sea que se efectuó un pago,
   * o que el usuario fue removido de la plataforma por falta de dinero, etc.
   */
  public void notificar();

  /**
   * Crea las recomendaciones de contenido de la plataforma en su versión básica.
   */
  public ArrayList<String> recomendacionBasico();

  /**
   * Crea las recomendaciones de contenido de la plataforma en su versión premium.
   */
  public ArrayList<String> recomendacionPremium();

}
