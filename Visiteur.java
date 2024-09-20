package projetjavaAmalCyrine2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Visiteur extends Utilisateur {
    public Visiteur(String nom) {
        super(nom);
    }

    // M�thodes pour les fonctionnalit�s du Visiteur
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
            commentaire = scanner.nextLine().trim(); // trim() pour supprimer les espaces au d�but et � la fin
        } while (commentaire.isEmpty());
        do {
        System.out.println("Entrez le nombre d'�toiles (de 1 � 5) : ");
         nombreEtoiles = scanner.nextInt();
         scanner.nextLine(); 
        }while(  nombreEtoiles<1 ||   nombreEtoiles>5);
        // Demander le type d'objet � �valuer
        
        System.out.println("Choisissez le type d'objet � �valuer (1 pour produit, 2 pour site de loisir) : ");
        choixTypeObjet = scanner.nextInt();
     
        scanner.nextLine(); 

        Avis nouvelAvis =new Avis(getNom(), commentaire, nombreEtoiles, null);
        String categorieProduit;
        String nomProduit;
        String typeSite;
        String marqueProduit;
        if (choixTypeObjet == 1) {
            // Entrer les d�tails du produit
            do {
            System.out.println("Entrez la cat�gorie du produit : 1.alimentation 2.�lectrom�nager 3.T�l�phonie 4.Informatique ");
            categorieProduit = scanner.nextLine();
            }while(categorieProduit.contains("alimentation Informatique T�l�phonie �lectrom�nager"));
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
            // Entrer les d�tails du site de loisir
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
            System.out.println("Entrez le type du site de loisir : 1.Restaurant 2.caf� 3.h�tel 4.maison d�h�te");
            typeSite = scanner.nextLine();
            }while(typeSite.contains("Restaurant caf� h�tel maison d�h�te"));
            nouvelAvis = new Avis(nom, commentaire, nombreEtoiles, new SITES_DE_LOISIR(nomCompletSite,villeSite,PaysSite, typeSite) );
        }

        // Cr�er et publier l'avis
    
        listeAvis.add(nouvelAvis);
        System.out.println("Avis publi� avec succ�s !");
       ///////
        return listeAvis;
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
      
	//METHODE rechercherObjets
	public List<Avis> rechercherObjets(List<Avis> listeAvis, String nomObjet) {
	    List<Avis> resultats = new ArrayList<>();
	
	    // Recherche de l'objet sp�cifique dans la liste d'avis
	    for (Avis avis : listeAvis) {
	        if (avis.getObjetEvalue() instanceof produits) {
	            produits produit = (produits) avis.getObjetEvalue();
	            if (produit.getNom().equalsIgnoreCase(nomObjet) || produit.getCategorie().equalsIgnoreCase(nomObjet)) {
	                // Objet trouv�, on ajoute l'avis � la liste des r�sultats
	                resultats.add(avis);
	            }
	        } else if (avis.getObjetEvalue() instanceof SITES_DE_LOISIR) {
	            SITES_DE_LOISIR site = (SITES_DE_LOISIR) avis.getObjetEvalue();
	            if (site.getNomComplet().equalsIgnoreCase(nomObjet) || site.getType().equalsIgnoreCase(nomObjet)) {
	                // Objet trouv�, on ajoute l'avis � la liste des r�sultats
	                resultats.add(avis);
	            }
	        }
	    }
	
	    // Consultation des avis publi�s sur l'objet sp�cifique
	    if (!resultats.isEmpty()) {
	        System.out.println("Avis publi�s sur l'objet " + nomObjet + " :");
	        for (Avis avis : resultats) {
	            avis.afficherAvis();
	        }
	    } else {
	        System.out.println("Aucun avis trouv� sur l'objet " + nomObjet);
	    }
	
	    return resultats;
	}}
