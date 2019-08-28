import java.util.ArrayList;

/**
 * Clase que define las variables y el comportamiento de las distintas plataformas.
 * Implementa la interfaz InterfazPlataforma.
 * Es abstracta pues la no implementa todos los métodos de InterfazPlataforma.
 */
public abstract class Plataforma implements InterfazPlataforma{

  /* El nombre de la plataforma. */
  private String nombre;
  /* El costo de la versión normal de la plataforma. */
  private double precio;
  /* El costo de la versión premium de la plataforma. */
  private double precioPremium;
  /* La lista de usuarios de la plataforma. */
  private ArrayList<Usuario> usuarios;
  /* Las recomendaciones que se dan cuando se tiene el servicio normal. */
  private ArrayList<String> recomendacionPremium;
  /* Las recomendaciones que se dan cuando se tiene el servicio premium. */
  private ArrayList<String> recomendacionBasico;

  /**
   * Define el nombre de la plataforma.
   * @param nombre el nuevo nombre de la plataforma.
   */
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /**
   * Regresa el nombre de la plataforma.
   * @return el nombre de la plataforma.
   */
  public String getNombre(){
    return this.nombre;
  }

  /**
   * Define el precio de la plataforma.
   * @param precio el nuevo precio de la plataforma.
   */
  public void setPrecio(int precio){
    this.precio = precio;
  }

  /**
   * Regresa el precio de la plataforma.
   * @return el precio de la plataforma.
   */
  public double getPrecio(){
    return this.precio;
  }

  /**
   * Define el precio de la plataforma en su versión premium.
   * @param precioPremium el nuevo precio de la plataforma en su versión premium.
   */
  public void setPrecioPremium(double precioPremium){
    this.precioPremium = precioPremium;
  }

  /**
   * Regresa el precio de la plataforma en su versión premium.
   * @return el precio de la plataforma en su versión premium.
   */
  public double getPrecioPremium(){
    return this.precioPremium;
  }

  /**
   * Define la lista de usuarios de la plataforma.
   * @param usuarios los nuevos usuarios de la plataforma.
   */
  public void setUsuarios(ArrayList<Usuario> usuarios){
    this.usuarios = usuarios;
  }

  /**
   * Regresa la lista de usuarios de la plataforma.
   * @return la lista de usuarios de la plataforma.
   */
  public ArrayList<Usuario> getUsuarios(){
    return this.usuarios;
  }

  /**
   * Define las recomendaciones que da la plataforma cuando el servicio es premium.
   * @param recomPremium las nuevas recomendaciones de la plataforma.
   */
  public void setRecomPremium(ArrayList<String> recomPremium){
    this.recomendacionPremium = recomPremium;
  }

  /**
   * Regresa las recomendaciones de la plataforma en modo premium.
   * @return las recomendaciones de la plataforma en modo premium.
   */
  public ArrayList<String> getRecomPremium(){
    return this.recomendacionPremium;
  }

  /**
   * Define las recomendaciones que da la plataforma cuando el servicio es básico.
   * @param recomBasico las nuevas recomendaciones de la plataforma.
   */
  public void setRecomBasico(ArrayList<String> recomBasico){
    this.recomendacionBasico = recomBasico;
  }

  /**
   * Regresa las recomendaciones de la plataforma en modo básico.
   * @return las recomendaciones de la plataforma en modo básico.
   */
  public ArrayList<String> getRecomBasico(){
    return this.recomendacionBasico;
  }

  /**
   * Cobra el monto diario de la plataforma al usuario.
   */
  @Override public void cobrar(){

  }

  /**
   * Registra al usuario en la base de datos de la plataforma.
   * @param usuario el usuario a registrar.
   */
  @Override public void registrar(Usuario usuario){

  }

  /**
   * Remueve al usuario de la base de datos de la plataforma.
   * @param usuario el usuario a remover.
   */
  @Override public void remover(Usuario usuario){

  }

  /**
   * Les da una recomendacion de contenido a los usuarios en la base de datos
   * de la plataforma.
   */
  @Override public void recomendar(){

  }
}
