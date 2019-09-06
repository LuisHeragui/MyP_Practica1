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
     * Regresa el precio de la plataforma dependiendo del tipo de plan
     * contratado.
     * @param plan el tipo de plan contratado.
     * @return el precio de la plataforma.
     */
    public abstract int getPrecio(int plan);

    /**
     * Cobra el monto diario de la plataforma al usuario.
     * @param usuario el usuario al que se le realiza el cobro.
     * @param dia el día en que se realiza el cobro.
     */
    @Override public void cobrar(Usuario usuario, int dia) {
        if(dia == 1)
            return;
        int indicePlataforma = usuario.getSuscripciones().indexOf(this);
        int plan = usuario.getPlanes().get(indicePlataforma);
        String mensaje;
        if (usuario.getDinero() < this.getPrecio(plan)) {
            mensaje = String.format("%s, te informamos que tu suscripción a " +
                                    "%s%s ha sido cancelada por " +
                                    "incumplimiento con el pago.",
                                    usuario.getNombre(), nombre,
                                    usuario.getNombrePlan(this));
            usuario.getNotificaciones().add(mensaje);
            usuario.getPlanes().remove(usuario.getSuscripciones().
                                           indexOf(this));
            usuario.getSuscripciones().remove(this);
            usuarios.remove(usuario);
        } else {
            mensaje = String.format("%s, se te han cobrado $%d del servicio " +
                                    "de %s%s.", usuario.getNombre(),
                                    this.getPrecio(plan), nombre,
                                    usuario.getNombrePlan(this));
            usuario.setDinero(usuario.getDinero() - this.getPrecio(plan));
            usuario.getNotificaciones().add(mensaje);
        }

    }

    /**
     * Emite una recomendación de contenido de la plataforma hacia el usuario.
     * @param usuario el usuario a quién se le hará la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public abstract String daRecomendacion(Usuario usuario, int dia);

    /**
     * Le notifica al usuario que ocurrió un evento. Ya sea que se efectuó un
     * pago, o que el usuario fue removido de la plataforma por falta de dinero,
     * etc.
     */
    @Override public void notificar() {
        for (Usuario usuario : usuarios)
        usuario.update();
    }

    /**
     * Les da una recomendacion de contenido a los usuarios en la base de datos
     * de la plataforma.
     * @param usuario el usuario al que se le hace la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     */
    @Override public void recomendar(Usuario usuario, int dia) {
        String mensaje = String.format("¡Hey %s! %s", usuario.getNombre(),
                                       this.daRecomendacion(usuario, dia));
    }

    ///**
    // * Crea las recomendaciones de contenido de la plataforma en su versión
    // * básica.
    // * @param dia el día para determinar la recomendación que se dará.
    // * @return una recomendación de contenido para el usuario.
    // */
    //public abstract String recomendacionBasico(int dia);


    ///**
    // * Crea las recomendaciones de contenido de la plataforma en su versión
    // * premium.
    // * @param dia el día para determinar la recomendación que se dará.
    // * @return una recomendación de contenido para el usuario.
    // */
    //public abstract String recomendacionPremium(int dia);

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
}
