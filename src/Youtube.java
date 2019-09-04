import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma YouTube.
 * Extiende de Plataforma.
 */
public class Youtube extends Plataforma{

  /**
   * Inicializa las variables de la clase padre Plataforma de acuerdo a las
   * especificaciones de YouTube.
   */
  public Youtube(){
    this.setNombre("YouTube");
    this.setPrecio(0);
    this.setUsuarios(new ArrayList<Usuario>());
  }

  /**
   * Emite una recomendación de contenido de Spotify hacia el usuario.
   */
  @Override public String daRecomendacion(int dia){
    return recomendacionPremium(dia-1);
  }

  /**
   * Crea las recomendaciones de contenido de Spotify en su versión básica.
   * @param dia el día determina que recomendación se emite.
   */
  public String recomendacionBasico(int dia){
    ArrayList<String> recomBasico = new ArrayList<String>();
    recomBasico.add("¿ya conoces todo el contenido que YouTube Red tiene para ti?"+
    " Conócelo ahora contratando YouTube Premium.");
    recomBasico.add("Contrata YouTube Premium y reproduce tus videos favoritos con" +
    " tu telefono bloqueado!!!!");
    recomBasico.add("Toda la música de tus artistas favoritos está en YouTube Music."+
    " Escúchala sin anuncios y con el telefono bloqueado contratando YouTube Premium.");
    recomBasico.add("Contrata YouTube Premium y descubre todos los beneficios que tiene para ti.");
    recomBasico.add("contrata YouTube Premium y descarga tus videos favoritos para"+
    " verlos donde sea!");
    return recomBasico.get(dia);
  }

  /**
   * Crea las recomendaciones de contenido de Spotify en su versión premium.
   * @param dia el día determina que recomendacion se emite.
   */
  public String recomendacionPremium(int dia){
    ArrayList<String> recomPremium = new ArrayList<String>();
    recomPremium.add("'Norman Fucking Rockwell!' de Lana Del Rey ha llegado a"+
    " YouTube Music!!!!!!!! Escúchalo ahora ysin anuncios.");
    recomPremium.add("Descarga 'Fuck it i love you/The greatest', el más reciente"+
    " video de Lana Del Rey, y disfruta de él donde sea!");
    recomPremium.add("¿Ya estas viendo 'I'm Poppy'? Disfruta de está película original de" +
    " YouTube Red ahora.");
    recomPremium.add("#WatchImPoppyByPoppyForSalvation en YouTube Premium.");
    recomPremium.add("Mira el video de 'Doin Time' y disfruta de una Lana Del Rey" +
    " de 20 metros y sin anuncios en YouTube Premium.");
    return recomPremium.get(dia);
  }
}
