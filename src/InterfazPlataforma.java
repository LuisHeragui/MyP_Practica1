/**
 * Interfaz que define el comportamiento que las plataformas tiene en común.
 */
public interface InterfazPlataforma {

    /**
     * Cobra el monto diario de la plataforma al usuario.
     * @param usuario el usuario al que se le realiza el cobro.
     * @param dia el día en que se realiza el cobro.
     */
    public void cobrar(Usuario usuario, int dia);

    /**
     * Emite una recomendación de contenido de la plataforma hacia el usuario.
     * @param usuario el usuario a quién se le hará la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String daRecomendacion(Usuario usuario, int dia);

    /**
     * Le notifica al usuario que ocurrió un evento. Ya sea que se efectuó un
     * pago, o que el usuario fue removido de la plataforma por falta de dinero,
     * etc.
     */
    public void notificar(Usuario usuario, String notificacion);

    /**
     * Les da una recomendacion de contenido a los usuarios en la base de datos
     * de la plataforma.
     * @param usuario el usuario al que se le hace la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     */
    public void recomendar(Usuario usuario, int dia);

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

}
