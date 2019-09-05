import java.util.ArrayList;

/**
 * Clase que define a los usuarios de la simulacion.
 * Implementa la interfaz Observador.
 */
public class Usuario implements Observador{

  /* El nombre del usuario. */
  private String nombre;
  /* La cantidad de dinero del usuario. */
  private int dinero;
  /* La lista de suscripciones del usuario. */
  private ArrayList<Plataforma> suscripciones;
  /* La lista de notificaciones que recibe el usuario. */
  private ArrayList<String> notificaciones;

  private ArrayList<Integer> tipoDePlan;

  /**
   * Define el estado inicial de un usuario con los valores recibidos.
   * @param nombre el nombre del usuario.
   * @param dinero el dinero inicial del usuario.
   */
  public Usuario(String nombre, int dinero){
    this.nombre = nombre;
    this.dinero = dinero;
    this.suscripciones = new ArrayList<Plataforma>();
    this.notificaciones = new ArrayList<String>();
    this.tipoDePlan = new ArrayList<Integer>();
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
   * Regresa las suscripciones del usuario.
   * @return las suscripciones del usuario.
   */
  public ArrayList<Plataforma> getSuscripciones(){
    return this.suscripciones;
  }

  public ArrayList<String> getNotificaciones(){
    return this.notificaciones;
  }

  public ArrayList<Integer> getTipoDePlan(){
    return this.tipoDePlan;
  }

  /**
   * Suscribe al usuario a la plataforma.
   * @param plataforma la plataforma a la que se suscribe el usuario.
   */
  public void suscribirse(Plataforma plataforma, int tipoDePlan){
    this.getSuscripciones().add(plataforma);
    this.getTipoDePlan().add(tipoDePlan);
    plataforma.registrar(this);
    this.getNotificaciones().add(String.format("Hola, %s. Te damos la bienvenida "
    + "al servicio de %s%s.", this.getNombre(), plataforma.getNombre(),
    this.getNombreTipoDePlan(plataforma)));
  }

  /**
   * Desuscribe al usuario de la plataforma.
   * @param plataforma la plataforma de la que se desuscribe el usuario.
   */
  public void desuscribirse(Plataforma plataforma){
    int plan = this.getSuscripciones().indexOf(plataforma);
    this.getSuscripciones().remove(plataforma);
    this.getTipoDePlan().remove(plan);
    plataforma.remover(this);
    this.getNotificaciones().add(String.format("%s, te has desuscrito del servicio de %s.",
                                 this.getNombre(), plataforma.getNombre()));
  }

  /**
   * Hace que el usuario pague el costo diario de la plataforma.
   * @param plataforma la plataforma a la que el usuario paga.
   */
  public void pagar(int dia, Plataforma plataforma){
    if(plataforma.getUsuarios().contains(this))
      plataforma.cobrar(this, dia);
  }

  /**
   * Suscribe al usuario a la version premium de la plataforma.
   * @param plataforma la plataforma de la que se quiere el servicio premium.
   */
  public void upgradeSuscripcion(Plataforma plataforma, int plan){
    int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
    this.getTipoDePlan().set(indicePlataforma, plan);
    this.getNotificaciones().add(String.format("%s, has mejorado tu cuenta de %s." +
    " Bienvenido al servicio de %s%s", this.getNombre(), plataforma.getNombre(),
    plataforma.getNombre(), this.getNombreTipoDePlan(plataforma)));
  }

  /**
   * Cambia al usuario a la versión básica de la plataforma.
   * @param plataforma la plataforma de la que se quiere el servicio básico.
   */
  public void downgradeSuscripcion(Plataforma plataforma, int plan){
    String tipoDePlanViejo = this.getNombreTipoDePlan(plataforma);
    int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
    this.getTipoDePlan().set(indicePlataforma, plan);
    this.getNotificaciones().add(String.format("%s, has cambiado la configuración"+
    " de tu cuenta de %s%s a %s%s.", this.getNombre(), plataforma.getNombre(),
    tipoDePlanViejo, plataforma.getNombre(), this.getNombreTipoDePlan(plataforma)));
  }

  public void getRecomendacion(Plataforma plataforma, int dia){
    plataforma.recomendar(this, dia);
  }

  /**
   * Actualiza el estado del usuario cuando el observable al que está asociado
   * tiene una modificación o emite una notificación.
   */
  @Override public void update(){
    for(String notificacion : this.getNotificaciones())
      System.out.println(notificacion);
  }

  public ArrayList<Plataforma> creaCopiaSuscripciones(){
    ArrayList<Plataforma> copia = new ArrayList<Plataforma>();
    for(Plataforma p: this.getSuscripciones())
      copia.add(p);
    return copia;
  }

  public String getNombreTipoDePlan(Plataforma plataforma){
    int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
    int tipoDePlan = this.getTipoDePlan().get(indicePlataforma);
    switch(tipoDePlan){
      case 0:
        return "";
      case 9:
        return " Premium";
      case 1:
        return " para 1 dispositivo";
      case 2:
        return " para 2 dispositivos";
      case 4:
        return " para 4 dispositivos";
      default:
        return "";
    }
  }

  public void simula(int dia){
    ArrayList<Plataforma> copiaSuscripciones = this.creaCopiaSuscripciones();
    for(Plataforma p : copiaSuscripciones)
      this.pagar(dia, p);
    for(Plataforma p : this.getSuscripciones())
      this.getRecomendacion(p, dia);
    this.update();
    this.getNotificaciones().clear();
  }
}
