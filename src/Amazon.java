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
     * Crea las recomendaciones de contenido de Amazon en su versión básica.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionBasico(int dia) {
        ArrayList<String> recomBasico = new ArrayList<String>();
        recomBasico.add("Te sugerimos ver \"The Boys\", sólo en Amazon Prime " +
                        "Video.");
        recomBasico.add("Adquiere el plan Premium para poder tener 100 " +
                        "dispositivos conectados a la vez.");
        recomBasico.add("Te sugerimos ver \"Good Omens\", sólo en Amazon " +
                        "Prime Video.");
        recomBasico.add("Actualiza tu plan a Premium para mejor cálidad de " +
                        "video.");
        recomBasico.add("Te sugerimos ver \"Jack Ryan\", sólo en Amazon Prime" +
                        " Video.");
        return recomBasico.get(dia - 1);
    }

    /**
     * Crea las recomendaciones de contenido de Amazon en su versión premium.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionPremium(int dia) {
        ArrayList<String> recomPremium = new ArrayList<String>();
        recomPremium.add("Te sugerimos ver \"Jack Ryan\", sólo en Amazon " +
                         "Prime Video.");
        recomPremium.add("Te sugerimos ver \"Good Omens\", sólo en Amazon " +
                         "Prime Video.");
        recomPremium.add("Te sugerimos ver \"Bosch\", sólo en Amazon " +
                         "Prime Video.");
        recomPremium.add("Te sugerimos ver \"The Grand Tour\", sólo en " +
                         "Amazon Prime Video.");
        recomPremium.add("Te sugerimos ver \"The Boys\", sólo en Amazon Prime" +
                         " Video.");
        return recomPremium.get(dia - 1);
  }

}
