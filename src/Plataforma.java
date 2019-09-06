import java.util.ArrayList;

/**
 * Clase que define las variables y el comportamiento de las distintas
 * plataformas.
 * Implementa la interfaz InterfazPlataforma.
 * Es abstracta, pues no implementa todos los métodos de InterfazPlataforma.
 */
public abstract class Plataforma implements InterfazPlataforma {

    /* El nombre de la plataforma. */
    private String nombre;
    /* La lista de usuarios de la plataforma. */
    private ArrayList<Usuario> usuarios;

    /**
     * Define el nombre de la plataforma.
     * @param nombre el nuevo nombre de la plataforma.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el nombre de la plataforma.
     * @return el nombre de la plataforma.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Regresa el precio de la plataforma dependiendo del tipo de plan.
     * @return el precio de la plataforma.
     */
    public abstract int getPrecio(int plan);

    /**
     * Define la lista de usuarios de la plataforma.
     * @param usuarios los nuevos usuarios de la plataforma.
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Regresa la lista de usuarios de la plataforma.
     * @return la lista de usuarios de la plataforma.
     */
    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    /**
     * Cobra el monto diario de la plataforma al usuario.
     * @param usuario el usuario al que se le realiza el cobro.
     * @param dia el día en que se realiza el cobro.
     */
    @Override public void cobrar(Usuario usuario, int dia) {
        if(dia == 1)
            return;
        int indicePlataforma = usuario.getSuscripciones().indexOf(this);
        int tipoDePlan = usuario.getTipoDePlan().get(indicePlataforma);
        String mensaje;
        if (usuario.getDinero() < this.getPrecio(tipoDePlan)) {
            mensaje = String.format("%s, te informamos que tu suscripción a " +
                                    "%s%s ha sido cancelada por " +
                                    "incumplimiento con el pago.",
                                    usuario.getNombre(), nombre,
                                    usuario.getNombreTipoDePlan(this));
            usuario.getNotificaciones().add(mensaje);
            usuario.getTipoDePlan().remove(usuario.getSuscripciones().
                                           indexOf(this));
            usuario.getSuscripciones().remove(this);
            usuarios.remove(usuario);
        } else {
            mensaje = String.format("%s, se te han cobrado $%d del servicio " +
                                    "de %s%s.", usuario.getNombre(),
                                    this.getPrecio(tipoDePlan), nombre,
                                    usuario.getNombreTipoDePlan(this));
            usuario.setDinero(usuario.getDinero() - this.getPrecio(tipoDePlan));
            usuario.getNotificaciones().add(mensaje);
        }

    }

    /**
     * Registra al usuario en la base de datos de la plataforma.
     * @param usuario el usuario a registrar.
     */
    @Override public void registrar(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    /**
     * Remueve al usuario de la base de datos de la plataforma.
     * @param usuario el usuario a remover.
     */
    @Override public void remover(Usuario usuario) {
        this.getUsuarios().remove(usuario);
    }

    /**
     * Les da una recomendacion de contenido a los usuarios en la base de datos
     * de la plataforma.
     * @param usuario el usuario al que se le hace la recomendación.
     */
    @Override public void recomendar(Usuario usuario, int dia) {
        String mensaje = String.format("¡Hey %s! %s", usuario.getNombre(),
                                       this.daRecomendacion(dia));
    }

    @Override public void notificar() {
        for (Usuario usuario : usuarios)
            usuario.update();
    }
}
