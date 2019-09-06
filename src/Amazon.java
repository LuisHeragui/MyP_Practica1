import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Amazon Prime Video.
 * Extiende a la clase abstracta Plataforma.
 */
public class Amazon extends Plataforma {

    /**
     * Inicializa las variables de la clase padre Plataforma de acuerdo a las
     * especificaciones de Amazon Prime Video.
     */
    public Amazon() {
        this.setNombre("Amazon Prime Video");
        this.setUsuarios(new ArrayList<Usuario>());
    }

    /**
     * Regresa el precio de la plataforma dependiendo del tipo de plan
     * contratado.
     * @param plan el tipo de plan contratado.
     * @return el precio de la plataforma.
     */
    @Override public int getPrecio(int plan) {
        if(plan == 0)
            return 7;
        return 13;
    }

    /**
     * Emite una recomendación de contenido de la plataforma hacia el usuario.
     * @param usuario el usuario a quién se le hará la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    @Override public String daRecomendacion(Usuario usuario, int dia) {
        int indicePlataforma = usuario.getSuscripciones().indexOf(this);
        int plan = usuario.getPlanes().get(indicePlataforma);
        if (plan == 0)
            return this.recomendacionBasico(dia);
        return this.recomendacionPremium(dia);
    }

    /**
     * Crea las recomendaciones de contenido de Amazon en su versión básica.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionBasico(int dia) {
        ArrayList<String> recomBasico = new ArrayList<String>();
        recomBasico.add("cacacacaca");
        recomBasico.add("");
        recomBasico.add("");
        recomBasico.add("");
        recomBasico.add("");
        return recomBasico.get(dia - 1);
    }

    /**
     * Crea las recomendaciones de contenido de Amazon en su versión premium.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionPremium(int dia) {
        ArrayList<String> recomPremium = new ArrayList<String>();
        recomPremium.add("");
        recomPremium.add("");
        recomPremium.add("");
        recomPremium.add("");
        recomPremium.add("");
        return recomPremium.get(dia - 1);
  }

}
