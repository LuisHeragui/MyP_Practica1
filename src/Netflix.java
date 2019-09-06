import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Netflix.
 * Extiende a la clase abstracta Plataforma.
 */
public class Netflix extends Plataforma {

    /**
     * Inicializa las variables de la clase padre Plataforma de acuerdo a las
     * especificaciones de Netflix.
     */
    public Netflix() {
        this.setNombre("Netflix");
        this.setUsuarios(new ArrayList<Usuario>());
    }

    /**
     * Regresa el precio de la plataforma dependiendo del tipo de plan
     * contratado.
     * @param plan el tipo de plan contratado.
     * @return el precio de la plataforma.
     */
    @Override public int getPrecio(int plan) {
        if(plan == 1)
            return 7;
        else if(plan == 2)
            return 10;
        return 15;
    }

    /**
     * Emite una recomendación de contenido de Netflix hacia el usuario.
     * @param usuario el usuario a quién se le hará la recomendación.
     * @param dia el día para determinar la recomendación que se dará.
     * @return una recomendación de contenido para el usuario.
     */
    @Override public String daRecomendacion(Usuario usuario, int dia) {
        ArrayList<String> recomendaciones = new ArrayList<String>();
        recomendaciones.add("Ya esta disponible la nueva temporada de \"Dark\""
                            + ", no te la pierdas. Sólo en Netflix.");
        recomendaciones.add("Ya esta disponible la nueva temporada de " +
                            "\"Stranger Things\", no te la pierdas. Sólo en " +
                            "Netflix.");
        recomendaciones.add("Te recomendamos ver nuestro nuevo estreno de la " +
                            "película \"Invasor Zim y el poder del Florpus\"." +
                            " Sólo en Netflix.");
        recomendaciones.add("Te recomendamos ver nuestro nuevo estreno de la " +
                            "serie \"When They See Us\". Sólo en Netflix.");
        recomendaciones.add("Ya esta disponible la nueva temporada de \"La " +
                            "casa de papel\", no te la pierdas. Sólo en " +
                            "Netflix.");
        return recomendaciones.get(dia - 1);
    }

    /**
     * El método no es necesario, pues Netflix no tiene distintos tipos de
     * recomendaciones.
     */
    @Override public String recomendacionBasico(int dia) { return ""; }

    /**
     * El método no es necesario, pues Netflix no tiene distintos tipos de
     * recomendaciones.
     */
    @Override public String recomendacionPremium(int dia) { return ""; }

}
