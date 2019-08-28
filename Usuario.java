import java.util.ArrayList;

/**
 * Clase que define a los usuarios de la simulacion.
 * Implementa la interfaz InterfazUsuario.
 */
public class Usuario implements InterfazUsuario{

  /* El nombre del usuario. */
  private String nombre;
  /* La cantidad de dinero del usuario. */
  private int dinero;
  /* La lista de suscripciones del usuario. */
  private ArrayList<Plataforma> suscripciones;

  /**
   * Define el estado incial de un usuario con los valores default.
   */
  public Usuario(){
    this.nombre = "";
    this.dinero = 0;
    this.suscripciones = new ArrayList<Plataforma>();
  }

  /**
   * Define el estado inicial de un usuario con los valores recibidos.
   * @param nombre el nombre del usuario.
   * @param dinero el dinero del usuario.
   * @param suscribirse la lista de suscripciones del usuario.
   */
  public Usuario(String nombre, int dinero, ArrayList<Plataforma> suscripciones){
    this.nombre = nombre;
    this.dinero = dinero;
    this.suscripciones = suscripciones;
  }

  /**
   * Define el nombre del usuario.
   * @param nombre el nuevo nombre del usuario.
   */
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /**
   * Regresa el nombre del usuario.
   * @return el nombre del usuario.
   */
  public String getNombre(){
    return this.nombre;
  }

  /**
   * Define la cantidad de dinero del usuario.
   * @param dinero el dinero del usuario.
   */
  public void setDinero(int dinero){
    this.dinero = dinero;
  }

  /**
   * Regresa el dinero del usuario.
   * @return el dinero del usuario.
   */
  public int getDinero(){
    return this.dinero;
  }

  /**
   * Define las suscripciones del usuario.
   * @param suscripciones las nuevas suscripciones del usuario.
   */
  public void setSuscripciones(ArrayList<Plataforma> suscripciones){
    this.suscripciones = suscripciones;
  }

  /**
   * Regresa las suscripciones del usuario.
   * @return las suscripciones del usuario.
   */
  public ArrayList<Plataforma> getSuscripciones(){
    return this.suscripciones;
  }

  /**
   * Suscribe al usuario a la plataforma.
   * @param plataforma la plataforma a la que se suscribe el usuario.
   */
  public void suscribirse(Plataforma plataforma){

  }

  /**
   * Desuscribe al usuario de la plataforma.
   * @param plataforma la plataforma de la que se desuscribe el usuario.
   */
  public void desuscribirse(Plataforma plataforma){

  }

  /**
   * Hace que el usuario pague el costo diario de la plataforma.
   * @param plataforma la plataforma a la que el usuario paga.
   */
  public void pagar(int dia, Plataforma plataforma){

  }

  /**
   * Suscribe al usuario a la version premium de la plataforma.
   * @param plataforma la plataforma de la que se quiere el servicio premium.
   */
  public void upgradeSuscripcion(Plataforma plataforma){

  }

  /**
   * Cambia al usuario a la versión básica de la plataforma.
   * @param plataforma la plataforma de la que se quiere el servicio básico.
   */
  public void downgradeSuscripcion(Plataforma plataforma){

  }

  /**
   * Actualiza el estado del usuario cuando el observable al que está asociado
   * tiene una modificación o emite una notificación.
   */
  @Override public void update(){

  }
}
