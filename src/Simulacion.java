import java.util.ArrayList;

public class Simulacion{

  public static void main(String[] args){

    int dia = 1;
    Simulacion s = new Simulacion();

    Plataforma spotify = new Spotify();
    Plataforma netflix = new Netflix();
    Plataforma amazon = new Amazon();
    Plataforma youtube = new Youtube();

    Usuario ana = new Usuario("Ana", 50);
    ana.suscribirse(spotify);
    ana.suscribirse(netflix);
    ana.suscribirse(amazon);
    ana.suscribirse(youtube);

    Usuario bob = new Usuario("Bob", 50);
    bob.suscribirse(spotify);
    ArrayList<Plataforma> copiaSuscripciones = ana.creaCopiaSuscripciones();
    ana.desuscribirse(youtube);

    while(dia <= 5){
      System.out.println("DIA " + dia + "\n");
      for(Plataforma p : ana.getSuscripciones())
        ana.getRecomendacion(p, dia);
      for(Plataforma p : copiaSuscripciones)
        ana.pagar(dia, p);
      ana.update();
      ana.getNotificaciones().clear();
      System.out.println("\n");
      dia++;
    }
  }
}
