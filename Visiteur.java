package projetjavaAmalCyrine2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Visiteur extends Utilisateur {
    public Visiteur(String nom) {
        super(nom);
    }

    // Méthodes pour les fonctionnalités du Visiteur
    //Publier un avis
    public List<Avis> publierAvis( List<Avis> listeAvis) {
        Scanner scanner = new Scanner(System.in);
        String commentaire ="";
        int   nombreEtoiles;
        int choixTypeObjet;
        String nom;
        
        do {
        System.out.println("Entrez votre nom : ");
        nom =  scanner.nextLine().trim();
        } while(nom.isEmpty());
        
        do {
            System.out.println("Entrez votre commentaire : ");
            commentaire = scanner.nextLine().trim(); // trim() pour supprimer les espaces au début et à la fin
        } while (commentaire.isEmpty());
        do {
        System.out.println("Entrez le nombre d'étoiles (de 1 à 5) : ");
         nombreEtoiles = scanner.nextInt();
         scanner.nextLine(); 
        }while(  nombreEtoiles<1 ||   nombreEtoiles>5);
        // Demander le type d'objet à évaluer
        
        System.out.println("Choisissez le type d'objet à évaluer (1 pour produit, 2 pour site de loisir) : ");
        choixTypeObjet = scanner.nextInt();
     
        scanner.nextLine(); 

        Avis nouvelAvis =new Avis(getNom(), commentaire, nombreEtoiles, null);
        String categorieProduit;
        String nomProduit;
        String typeSite;
        String marqueProduit;
        if (choixTypeObjet == 1) {
            // Entrer les détails du produit
            do {
            System.out.println("Entrez la catégorie du produit : 1.alimentation 2.électroménager 3.Téléphonie 4.Informatique ");
            categorieProduit = scanner.nextLine();
            }while(categorieProduit.contains("alimentation Informatique Téléphonie électroménager"));
            do {
            System.out.println("Entrez le nom du produit : ");
            nomProduit = scanner.nextLine().trim();
            } while (nomProduit.isEmpty());
            
            do {
            System.out.println("Entrez la marque du produit : ");
            marqueProduit = scanner.nextLine().trim();
            }while(marqueProduit.isEmpty());
            nouvelAvis = new Avis(nom, commentaire, nombreEtoiles,  new produits(categorieProduit, nomProduit, marqueProduit) );
             
             
        } else if (choixTypeObjet == 2) {
            // Entrer les détails du site de loisir
        	String nomCompletSite;
            String villeSite;
            String PaysSite; 
            
            System.out.println("Entrez le nom complet du site de loisir : ");
            nomCompletSite = scanner.nextLine();
            System.out.println("Entrez la ville du site de loisir : ");
            villeSite = scanner.nextLine();
            System.out.println("Entrez le pays du site de loisir : ");
            PaysSite = scanner.nextLine();
            do {
            System.out.println("Entrez le type du site de loisir : 1.Restaurant 2.café 3.hôtel 4.maison d’hôte");
            typeSite = scanner.nextLine();
            }while(typeSite.contains("Restaurant café hôtel maison d’hôte"));
            nouvelAvis = new Avis(nom, commentaire, nombreEtoiles, new SITES_DE_LOISIR(nomCompletSite,villeSite,PaysSite, typeSite) );
        }

        // Créer et publier l'avis
    
        listeAvis.add(nouvelAvis);
        System.out.println("Avis publié avec succès !");
       ///////
        return listeAvis;
    }



    //Consulter les avis par catégorie 
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

        System.out.println("Avis publiés sur la catégorie (PRODUIT) :");
        for (Avis avis : avisProduits) {
            avis.afficherAvis();
        }

        System.out.println("Avis publiés sur la catégorie (SITE DE LOISIR) :");
        for (Avis avis : avisSitesLoisir) {
            avis.afficherAvis();
        }

       
    }
      
	//METHODE rechercherObjets
	public List<Avis> rechercherObjets(List<Avis> listeAvis, String nomObjet) {
	    List<Avis> resultats = new ArrayList<>();
	
	    // Recherche de l'objet spécifique dans la liste d'avis
	    for (Avis avis : listeAvis) {
	        if (avis.getObjetEvalue() instanceof produits) {
	            produits produit = (produits) avis.getObjetEvalue();
	            if (produit.getNom().equalsIgnoreCase(nomObjet) || produit.getCategorie().equalsIgnoreCase(nomObjet)) {
	                // Objet trouvé, on ajoute l'avis à la liste des résultats
	                resultats.add(avis);
	            }
	        } else if (avis.getObjetEvalue() instanceof SITES_DE_LOISIR) {
	            SITES_DE_LOISIR site = (SITES_DE_LOISIR) avis.getObjetEvalue();
	            if (site.getNomComplet().equalsIgnoreCase(nomObjet) || site.getType().equalsIgnoreCase(nomObjet)) {
	                // Objet trouvé, on ajoute l'avis à la liste des résultats
	                resultats.add(avis);
	            }
	        }
	    }
	
	    // Consultation des avis publiés sur l'objet spécifique
	    if (!resultats.isEmpty()) {
	        System.out.println("Avis publiés sur l'objet " + nomObjet + " :");
	        for (Avis avis : resultats) {
	            avis.afficherAvis();
	        }
	    } else {
	        System.out.println("Aucun avis trouvé sur l'objet " + nomObjet);
	    }
	
	    return resultats;
	}}
