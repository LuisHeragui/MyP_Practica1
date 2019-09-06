import java.util.ArrayList;

/**
 * Clase que define a los usuarios de la simulacion.
 * Implementa la interfaz Observador.
 */
public class Usuario implements Observador {

    /* El nombre del usuario. */
    private String nombre;
    /* La cantidad de dinero del usuario. */
    private int dinero;
    /* La lista de suscripciones del usuario. */
    private ArrayList<Plataforma> suscripciones;
    /* La lista de notificaciones que recibe el usuario. */
    private ArrayList<String> notificaciones;
    /* La lista de planes contratados por el usuario. */
    private ArrayList<Integer> planes;

    /**
     * Define el estado inicial de un usuario con los valores recibidos.
     * @param nombre el nombre del usuario.
     * @param dinero el dinero inicial del usuario.
     */
    public Usuario(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.suscripciones = new ArrayList<Plataforma>();
        this.notificaciones = new ArrayList<String>();
        this.planes = new ArrayList<Integer>();
    }

    /**
     * Regresa el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Define la cantidad de dinero del usuario.
     * @param dinero el dinero del usuario.
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Regresa el dinero del usuario.
     * @return el dinero del usuario.
     */
    public int getDinero() {
        return this.dinero;
    }

    /**
     * Regresa las suscripciones del usuario.
     * @return las suscripciones del usuario.
     */
    public ArrayList<Plataforma> getSuscripciones() {
        return this.suscripciones;
    }

    /**
     * Regresa las notificaciones del usuario.
     * @return las notificaciones del usuario.
     */
    public ArrayList<String> getNotificaciones() {
        return this.notificaciones;
    }

    /**
     * Regresa los planes contratados del usuario.
     * @return los planes contratados del usuario.
     */
    public ArrayList<Integer> getPlanes() {
        return this.planes;
    }

    /**
     * Crea una copia de la lista de suscripciones del usuario.
     * @return la copia de la lista de suscripciones del usuario.
     */
    public ArrayList<Plataforma> creaCopiaSuscripciones() {
        ArrayList<Plataforma> copia = new ArrayList<Plataforma>();
        for (Plataforma p: this.getSuscripciones())
            copia.add(p);
        return copia;
    }

    /**
     * Desuscribe al usuario de la plataforma.
     * @param plataforma la plataforma de la que se desuscribe el usuario.
     */
    public void desuscribirse(Plataforma plataforma) {
        int plan = this.getSuscripciones().indexOf(plataforma);
        this.getSuscripciones().remove(plataforma);
        this.getPlanes().remove(plan);
        plataforma.remover(this);
        String mensaje = String.format("%s, te has desuscrito del servicio " +
                                       "de %s.", this.getNombre(),
                                       plataforma.getNombre());
        this.getNotificaciones().add(mensaje);
    }

    /**
     * Cambia al usuario a la versión básica de la plataforma.
     * @param plataforma la plataforma de la que se quiere el servicio básico.
     * @param plan el nuevo plan de la suscripción.
     */
    public void downgradeSuscripcion(Plataforma plataforma, int plan) {
        String planViejo = this.getNombrePlan(plataforma);
        int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
        this.getPlanes().set(indicePlataforma, plan);
        String mensaje = String.format("%s, has cambiado la configuración " +
                                       "de tu cuenta de %s%s a %s%s.",
                                       this.getNombre(), plataforma.getNombre(),
                                       planViejo, plataforma.getNombre(),
                                       this.getNombrePlan(plataforma));
        this.getNotificaciones().add(mensaje);
    }

    /**
     * Regresa el nombre del plan contratado.
     * @param plataforma la plataforma de la que queremos obtener el plan.
     * @return el nombre del plan contratado.
     */
    public String getNombrePlan(Plataforma plataforma) {
        int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
        int plan = this.getPlanes().get(indicePlataforma);
        switch(plan) {
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

    /**
     * Solicita a la plataforma que brinde una recomendación.
     * @param plataforma la plataforma de la que queremos la recomendación.
     * @param dia el día que determina la recomendación que nos darán.
     */
    public void getRecomendacion(Plataforma plataforma, int dia) {
        plataforma.recomendar(this, dia);
    }

    /**
     * Hace que el usuario pague el costo diario de la plataforma.
     * @param plataforma la plataforma a la que el usuario paga.
     */
    public void pagar(int dia, Plataforma plataforma) {
        if (plataforma.getUsuarios().contains(this))
            plataforma.cobrar(this, dia);
    }

    /**
     * Realiza la simulación del día de un usuario.
     * @param dia el día que se simulará.
     */
    public void simula(int dia) {
        ArrayList<Plataforma> copiaSuscripciones = this.creaCopiaSuscripciones();
        for (Plataforma p : copiaSuscripciones)
            this.pagar(dia, p);
        for (Plataforma p : this.getSuscripciones())
            this.getRecomendacion(p, dia);
        this.update();
        this.getNotificaciones().clear();
    }

    /**
     * Suscribe al usuario a la plataforma.
     * @param plataforma la plataforma a la que se suscribe el usuario.
     */
    public void suscribirse(Plataforma plataforma, int plan) {
        this.getSuscripciones().add(plataforma);
        this.getPlanes().add(plan);
        plataforma.registrar(this);
        String mensaje = String.format("Hola, %s. Te damos la bienvenida al " +
                                       "servicio de %s%s.", this.getNombre(),
                                       plataforma.getNombre(),
                                       this.getNombrePlan(plataforma));
        this.getNotificaciones().add(mensaje);
    }

    /**
     * Actualiza el estado del usuario cuando el observable al que está asociado
     * tiene una modificación o emite una notificación.
     */
    @Override public void update() {
        for(String notificacion : this.getNotificaciones())
            System.out.println(notificacion);
    }

    /**
     * Suscribe al usuario a la version premium de la plataforma.
     * @param plataforma la plataforma de la que se quiere el servicio premium.
     */
    public void upgradeSuscripcion(Plataforma plataforma, int plan) {
        int indicePlataforma = this.getSuscripciones().indexOf(plataforma);
        this.getPlanes().set(indicePlataforma, plan);
        String mensaje = String.format("%s, has mejorado tu cuenta de %s. " +
                                       "Bienvenido al servicio de %s%s",
                                       this.getNombre(),
                                       plataforma.getNombre(),
                                       plataforma.getNombre(),
                                       this.getNombrePlan(plataforma));
        this.getNotificaciones().add(mensaje);
    }

}
