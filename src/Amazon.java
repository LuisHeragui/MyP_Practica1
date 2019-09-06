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
    this.setUsuarios(new ArrayList<Usuario>());
  }

  @Override public int getPrecio(int plan){
    if(plan == 0)
      return 7;
    return 13;
  }

  /**
   * Emite una recomendación de contenido de Amazon Prime Video hacia el usuario.
   */
  @Override public String daRecomendacion(int dia){
    return "te recomiendo que te vayas a la verga. :)";
  }
}
