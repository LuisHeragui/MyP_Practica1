import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Spotify.
 * Extiende de Plataforma.
 */
public class Spotify extends Plataforma{

  /**
   * Inicializa las variables de la clase padre Plataforma de acuerdo a las
   * especificaciones de Spotify.
   */
  public Spotify(){
    this.setNombre("Spotify");
    this.setPrecio(0);
    this.setPrecioPremium(4);
    this.setUsuarios(new ArrayList<Usuario>());
    this.setRecomBasico(recomBasico());
    this.setRecomPremium(recomPremium());
  }

  /**
   * Le notifica al usuario que ocurrió un evento. Ya sea que se efectuó un pago,
   * o que el usuario fue removido de la plataforma por falta de dinero, etc.
   */
  @Override public void notificar(){

  }

  /**
   * Crea las recomendaciones de contenido de Spotify en su versión básica.
   */
  @Override public ArrayList<String> recomBasico(){
    ArrayList<String> recomBasico = new ArrayList<String>();
    recomBasico.add("La salvación de la música pop ha llegado. Contrata Spotify" +
    " Premium para disfrutar de lo más nuevo de Charli XCX, 'No Angel', sin anuncios.");
    recomBasico.add("¿sabias que 'No Angel' de Charli XCX es la mejor canción pop del mundo?" +
    " Disfrútala sin anuncios contratando Spotify Premium.");
    recomBasico.add("¿qué esperas para contratar Spotify Premium y poder disfrutar de" +
    " 'No Angel' de Charli XCX en cualquier lugar?");
    recomBasico.add("NO ANGEL!!! CHARLI XCX!!!!! Escúchala offline y sin anuncios" +
    " contratando Spotify Premium");
    recomBasico.add("¿eres una de las personas que ya está disfrutando de 'No Angel' de" +
    " Charli XCX sin anuncios? Contrata Spotify Premium para ser parte de ellos!");
    return recomBasico;
  }

  /**
   * Crea las recomendaciones de contenido de Spotify en su versión premium.
   */
  @Override public ArrayList<String> recomPremium(){
    ArrayList<String> recomPremium = new ArrayList<String>();
    recomPremium.add("Charli XCX acaba de salvar al pop con su nuevo single 'No Angel'." +
    " Escúchalo ahora en Spotify Premium.");
    recomPremium.add("¿ya estás escuchando 'No Angel' de Charli XCX?, ¡¿Qué esperas?!" +
    " Escúchala ahora en Spotify Premium.");
    recomPremium.add("#StreamNoAngelByCharliXCXForClearSkin en Spotify Premium.");
    recomPremium.add("Escucha 'No Angel' de Charli XCX en Spotify Premium y di" +
    " no a la homofobia.");
    recomPremium.add("Solo las personas con mal gusto no han escuchado 'No Angel' de" +
    " Charli XCX, ¿tú ya lo hiciste? Disfrútala ahora en Spotify Premium.");
    return recomPremium;
  }

}
