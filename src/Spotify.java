import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Spotify.
 * Extiende a la clase abstracta Plataforma.
 */
public class Spotify extends Plataforma {

    /**
     * Inicializa las variables de la clase padre Plataforma de acuerdo a las
     * especificaciones de Spotify.
     */
    public Spotify(){
        this.setNombre("Spotify");
        this.setUsuarios(new ArrayList<Usuario>());
    }

    /**
     * Regresa el precio de la plataforma dependiendo del tipo de plan
     * contratado.
     * @param plan el tipo de plan contratado.
     * @return el precio de la plataforma.
     */
    @Override public int getPrecio(int plan) {
        if (plan == 0)
            return 0;
        return 4;
    }

    /**
     * Crea las recomendaciones de contenido de Spotify en su versión básica.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionBasico(int dia) {
        ArrayList<String> recomBasico = new ArrayList<String>();
        recomBasico.add("La salvación de la música pop ha llegado. Contrata " +
                        "Spotify Premium para disfrutar de lo más nuevo de " +
                        "Charli XCX, \"No Angel\", sin anuncios.");
        recomBasico.add("¿Sabías que \"No Angel\" de Charli XCX es la mejor " +
                        "canción pop del mundo? Disfrútala sin anuncios " +
                        "contratando Spotify Premium.");
        recomBasico.add("¿Qué esperas para contratar Spotify Premium y poder " +
                        "disfrutar \"No Angel\" de Charli XCX en cualquier " +
                        "lugar?");
        recomBasico.add("¡¡NO ANGEL!! ¡¡CHARLI XCX!! Escúchala offline y sin " +
                        "anuncios contratando Spotify Premium.");
        recomBasico.add("¿Eres una de las personas que ya está disfrutando " +
                        "\"No Angel\" de Charli XCX sin anuncios? ¡Contrata " +
                        "Spotify Premium para ser parte de ellos!");
        return recomBasico.get(dia - 1);
    }

    /**
     * Crea las recomendaciones de contenido de Spotify en su versión premium.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    public String recomendacionPremium(int dia) {
        ArrayList<String> recomPremium = new ArrayList<String>();
        recomPremium.add("Charli XCX acaba de salvar al pop con su nuevo " +
                         "single \"No Angel\". Escúchalo ahora en Spotify " +
                         "Premium.");
        recomPremium.add("¿Ya estás escuchando \"No Angel\" de Charli XCX? " +
                         "¡¿Qué esperas?! Escúchala ahora en Spotify Premium.");
        recomPremium.add("#StreamNoAngelByCharliXCXForClearSkin en Spotify " +
                         "Premium.");
        recomPremium.add("Escucha \"No Angel\" de Charli XCX en Spotify " +
                         "Premium y di no a la homofobia.");
        recomPremium.add("Sólo las personas con mal gusto no han escuchado " +
                         "\"No Angel\" de Charli XCX, ¿tú ya lo hiciste? " +
                         "Disfrútala ahora en Spotify Premium.");
        return recomPremium.get(dia - 1);
  }
}
