import java.util.ArrayList;

public class Simulacion {

    public static void main(String[] args) {

        int dia = 1;

        Plataforma spotify = new Spotify();
        Plataforma netflix = new Netflix();
        Plataforma amazon = new Amazon();
        Plataforma youtube = new Youtube();

        Usuario alicia = new Usuario("Alicia", 500);
        alicia.suscribirse(spotify, 9);
        alicia.suscribirse(netflix, 4);
        alicia.suscribirse(amazon, 9);
        alicia.suscribirse(youtube, 9);

        Usuario bob = new Usuario("Bob", 40);
        bob.suscribirse(spotify, 9);
        bob.suscribirse(netflix, 4);
        bob.suscribirse(amazon, 9);
        bob.suscribirse(youtube, 9);

        Usuario cesar = new Usuario("César", 40);
        cesar.suscribirse(spotify, 9);
        cesar.suscribirse(youtube, 0);

        Usuario diego = new Usuario("Diego", 80);
        diego.suscribirse(netflix, 2);
        diego.suscribirse(amazon, 9);

        Usuario erika = new Usuario("Erika", 300);
        erika.suscribirse(spotify, 0);
        erika.suscribirse(netflix, 4);
        erika.suscribirse(youtube, 0);

        while(dia <= 5) {
            System.out.println("");
            if(dia == 2) {
                erika.upgradeSuscripcion(youtube, 9);
                erika.upgradeSuscripcion(spotify, 9);
            }
            if(dia == 3) {
                diego.suscribirse(spotify, 0);
                erika.desuscribirse(netflix);
                erika.suscribirse(amazon, 9);
            }
            System.out.println("DIA " + dia + "\n");
            alicia.simula(dia);
            System.out.println("");
            bob.simula(dia);
            System.out.println("");
            cesar.simula(dia);
            System.out.println("");
            diego.simula(dia);
            System.out.println("");
            erika.simula(dia);
            System.out.println("____________");
            dia++;
        }
    }
}
