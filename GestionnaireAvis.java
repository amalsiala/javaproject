package projetjavaAmalCyrine2023;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireAvis {
    private static List<Avis> listeAvis = new ArrayList<>();

    public static void ajouterAvis(Avis avis) {
        listeAvis.add(avis);
    }

    public static List<Avis> consulterTousLesAvis() {
        return new ArrayList<>(listeAvis);
    }
}
