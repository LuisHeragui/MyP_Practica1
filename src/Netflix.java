import java.util.ArrayList;

/**
 * Clase que define el comportamiento de la plataforma Netflix.
 * Extiende de Plataforma.
 */
public class Netflix extends Plataforma{

  /**
   * Inicializa las variables de la clase padre Plataforma de acuerdo a las
   * especificaciones de Netflix.
   */
  public Netflix(){
    this.setNombre("Netflix");
    this.setPrecio(12);
    this.setUsuarios(new ArrayList<Usuario>());
  }

  /**
   * Emite una recomendación de contenido de Netflix hacia el usuario.
   */
  @Override public String daRecomendacion(int dia){
    return "te recomiendo que me descontrates, porque mis series son pura basura. xdxd";
  }
}
