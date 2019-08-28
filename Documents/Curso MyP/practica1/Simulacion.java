import java.util.ArrayList;

public class Simulacion{

  public static void main(String[] args){
    Plataforma spo = new Spotify();
    System.out.println(spo.getNombre());
    System.out.println(spo.getRecomPremium().get(2));
  }
}
