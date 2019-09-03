import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Amazon Prime Video.
 * Extiende de Plataforma.
 */
public class Amazon extends Plataforma{

  /**
   * Inicializa las variables de la clase padre Plataforma de acuerdo a las
   * especificaciones de Amazon Prime Video.
   */
  public Amazon(){
    this.setNombre("Amazon Prime Video");
    this.setPrecio(9);
    this.setUsuarios(new ArrayList<Usuario>());
  }

  /**
   * Emite una recomendación de contenido de Amazon Prime Video hacia el usuario.
   */
  @Override public String daRecomendacion(int dia){
    return "te recomiendo que te vayas a la verga. :)";
  }
}
