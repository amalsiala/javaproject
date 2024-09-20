package projetjavaAmalCyrine2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Administrateur extends Utilisateur {



    public Administrateur(String nom) {
        super(nom);
    }
    
    //Consulter les avis par cat�gorie 
    public void consulterAvisParCategorie(List<Avis> listeAvis) {
        List<Avis> avisProduits = new ArrayList<>();
        List<Avis> avisSitesLoisir = new ArrayList<>();

        for (Avis avis : listeAvis) {
            if (avis.getObjetEvalue() instanceof produits) {
                avisProduits.add(avis);
                }
            else if (avis.getObjetEvalue() instanceof SITES_DE_LOISIR) {
                avisSitesLoisir.add(avis);
            }
        }

        System.out.println("Avis publi�s sur la cat�gorie (PRODUIT) :");
        for (Avis avis : avisProduits) {
            avis.afficherAvis();
        }

        System.out.println("Avis publi�s sur la cat�gorie (SITE DE LOISIR) :");
        for (Avis avis : avisSitesLoisir) {
            avis.afficherAvis();
        }

       
    }

    public void modererAvis(List<Avis> listeAvis) {
        // Mod�ration : Supprimer les avis contenant des mots-cl�s inappropri�s
        Iterator<Avis> iterator = listeAvis.iterator();
        while (iterator.hasNext()) {
            Avis avis = iterator.next();
            if ((avis.getCommentaire().contains("vulgaire"))||(avis.getCommentaire().contains("idiot"))||(avis.getCommentaire().contains("stupide")) ){
                iterator.remove();
                System.out.println("Avis mod�r� : Commentaire inappropri�.");
            }
            else 
                System.out.println("commentaire appropri�");
        }
    }

   
    // M�thode pour afficher le nombre total d�avis post�s
    public void afficherNombreTotalAvis(List<Avis> listeAvis) {
        int nombreTotalAvis = listeAvis.size();
        System.out.println("Le nombre total d'avis post�s : " + nombreTotalAvis);
    }

    public void afficherNombreAvisParCategorie(List<Avis> listeAvis) {
        int nombreAvisProduit = 0;
        int nombreAvisSiteLoisir = 0;

        for (Avis avis : listeAvis) {
            if (avis.getObjetEvalue() instanceof produits) {
                nombreAvisProduit++;
            } else if (avis.getObjetEvalue() instanceof SITES_DE_LOISIR) {
                nombreAvisSiteLoisir++;
            }
        }

        System.out.println("Le nombre d'avis pour la cat�gorie PRODUIT : " + nombreAvisProduit);
        System.out.println("Le nombre d'avis pour la cat�gorie SITE DE LOISIR : " + nombreAvisSiteLoisir);
    }
    // M�thode pour afficher le nombre et la liste des visiteurs diff�rents utilisant le site
    public void afficherNombreEtListeVisiteurs(List<Avis> listeAvis) {
        Set<String> visiteursDifferents = new HashSet<>();

        for (Avis avis : listeAvis) {
            visiteursDifferents.add(avis.getNomUtilisateur());
        }

        System.out.println("Le nombre de visiteurs diff�rents utilisant le site : " + visiteursDifferents.size());
        System.out.println("Liste des visiteurs : " + visiteursDifferents);
    }
}
