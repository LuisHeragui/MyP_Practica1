import java.util.ArrayList;

public class Simulacion{

  public static void main(String[] args){

    int dia = 1;

    Plataforma spotify = new Spotify();
    Plataforma netflix = new Netflix();
    Plataforma amazon = new Amazon();
    Plataforma youtube = new Youtube();

    Usuario ana = new Usuario("Ana", 500);
    ana.suscribirse(spotify);
    ana.suscribirse(netflix);
    ana.suscribirse(amazon);
    ana.suscribirse(youtube);

    Usuario bob = new Usuario("Bob", 50);
    bob.suscribirse(spotify);

    while(dia <= 5){
      System.out.println("DIA " + dia + "\n");
      for(Plataforma p : ana.getSuscripciones())
        ana.getRecomendacion(p, dia);
      for(Plataforma p : ana.getSuscripciones())
        ana.pagar(dia, p);
      ana.update(dia);
      ana.getNotificaciones().clear();
      System.out.println("\n");
      dia++;
    }
  }
}
