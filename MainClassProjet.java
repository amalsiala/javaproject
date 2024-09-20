package projetjavaAmalCyrine2023;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MainClassProjet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Liste d'avis pour les tests
        List<Avis> listeAvis = new ArrayList<Avis>();

        // Simulation de quelques avis pour les tests
        // Création d'avis pour les produits
        listeAvis.add(new Avis("Alice", "Très satisfait du four LG, fonctionne parfaitement !", 5, new produits("Électroménager", "Four", "LG")));
        listeAvis.add(new Avis("Bob", "J'aime beaucoup ce produit, il est vraiment pratique.", 4, new produits("Alimentation", "Pâtes", "Barilla")));
        listeAvis.add(new Avis("Charlie", "Je ne recommande pas ce produit, il a des problèmes de qualité.", 2, new produits("Électroménager", "Réfrigérateur", "Samsung")));

        // Création d'avis pour les sites de loisir
        listeAvis.add(new Avis("David", "Excellent restaurant, plats délicieux et service impeccable !", 5, new SITES_DE_LOISIR("Restaurant", "Chez Pierre", "Paris", "France")));
        listeAvis.add(new Avis("Eva", "Super hôtel avec une vue magnifique, séjour très agréable.", 4, new SITES_DE_LOISIR("Hôtel", "Grand Hôtel", "New York", "États-Unis")));
        listeAvis.add(new Avis("Frank", "Maison d'hôte charmante, personnel accueillant.", 5, new SITES_DE_LOISIR("Maison d'hôte", "La Petite Maison", "Provence", "France")));
        listeAvis.add(new Avis("Fikt", "personnel vulgaire.", 1, new SITES_DE_LOISIR("hotel", "La goulette", "tunis", "Tunisie")));
        
        // Menu principal
        System.out.println("********************************************");
        System.out.println("  Bienvenue dans l'application de gestion d'avis !");
        System.out.println("********************************************");
        
       
        int choixRole;
        do {
            System.out.println("1. Se connecter en tant qu'Administrateur");
            System.out.println("2. Se connecter en tant que Visiteur");
            System.out.println("3. Quitter");
            System.out.print("Choisissez votre rôle (1, 2 ou 3) : ");
            choixRole = scanner.nextInt();

            switch (choixRole) {
                case 1:
                    // Connexion en tant qu'Administrateur
                    Administrateur administrateur = new Administrateur("Admin");
                 // Affichage du menu pour les actions de l'administrateur
                    int choixActionAdmin , p=1;
                    
                    do {
                    	System.out.println("\n***************************************************");
                    	System.out.println("*                  Menu Administrateur            *");
                    	System.out.println("***************************************************");
                    	System.out.println("*  1. Consulter les avis par catégorie             *");
                    	System.out.println("*  2. Supprimer les commentaires inappropriés      *");
                    	System.out.println("*  3. Afficher le nombre total d'avis postés        *");
                    	System.out.println("*  4. Afficher le nombre d'avis par catégorie d'objets  *");
                    	System.out.println("*     (Produit / sites de loisirs)                  *");
                    	System.out.println("*  5. Afficher le nombre et la liste des visiteurs  *");
                    	System.out.println("*     différents utilisant le site                *");
                    	System.out.println("*  6. Quitter                                      *");
                    	System.out.println("***************************************************");
                    	System.out.print("Choisissez votre action (1, 2, 3, 4, 5 ou 6) : ");
                    choixActionAdmin = scanner.nextInt();

                    

                    // Exécution de l'action choisie par l'administrateur
                    switch (choixActionAdmin) {
                    	case 1:
                    		//Consulter les avis par catégorie
                    		administrateur.consulterAvisParCategorie(listeAvis);
                    		System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                    		break;
                        case 2:
                            // Supprimer les commentaires inapropriés :
                            administrateur.modererAvis(listeAvis);
                            System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                            break;
                        case 3:
                        	//Afficher le nombre total d'avis postés
                        	administrateur.afficherNombreTotalAvis(listeAvis);
                        	System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                        	break;
                        case 4:
                        	//Afficher le nombre d'avis par catégorie d'objets (Produit / sites de loisirs)
                        	administrateur.afficherNombreAvisParCategorie(listeAvis);
                        	System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                        	break;
                        case 5:
                        	//Afficher Le nombre et la liste des visiteurs différents utilisant le site
                        	administrateur.afficherNombreEtListeVisiteurs(listeAvis);
                        	System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                        	break;
                        case 6:
                        	System.out.println("vous quittez le menu administrateur");
                        	System.out.println("Voulez vous continuer 1:oui 0:non");
                    		p = scanner.nextInt();
                        	break;
                        default:
                            System.out.println("Choix invalide.");
                          
                    }
                    } while((choixActionAdmin != 6)&&(p==1));
                    break;
                case 2:
                    // Connexion en tant que Visiteur
                    Visiteur visiteur = new Visiteur("Visiteur");
                 // Affichage du menu pour les actions du visiteur
                    int choixActionVisiteur , k=1 ;
                    do {
                    	System.out.println("\n***************************************");
                    	System.out.println("*          Menu Visiteur             *");
                    	System.out.println("***************************************");
                    	System.out.println("*  1. Publier un avis                 *");
                    	System.out.println("*  2. Consulter les avis par catégorie *");
                    	System.out.println("*     (Produits / sites de loisir)     *");
                    	System.out.println("*  3. Rechercher des objets           *");
                    	System.out.println("*  4. Quitter           *");
                    	System.out.println("***************************************");
                    	System.out.println("Choisissez votre action (1, 2 ou 3) : ");
                    	    
                    	    choixActionVisiteur = scanner.nextInt();
                    
                    // Exécution de l'action choisie par le visiteur
                    switch (choixActionVisiteur) {
                        case 1:
                            // Publier un avis
                        	visiteur.publierAvis(listeAvis);
                        	System.out.println("Voulez vous continuer 1:oui 0:non");
                    		k = scanner.nextInt();
                            break;
                        case 2:
                            // Consulter les avis par catégorie (Produits /site de loisir
                           visiteur.consulterAvisParCategorie(listeAvis);
                           System.out.println("Voulez vous continuer 1:oui 0:non");
                   		   k = scanner.nextInt();
                            break;
                        case 3:
                            // Rechercher des objets
                            System.out.println("Entrez le nom de l'objet à rechercher : ");
                            String objetRecherche = scanner.next();
                            List<Avis> resultatRecherche = visiteur.rechercherObjets(listeAvis, objetRecherche);
                            System.out.println("Résultats de la recherche :");
                            for (Avis a : resultatRecherche) {
                                System.out.println(a);
                            }
                            System.out.println("Voulez vous continuer 1:oui 0:non");
                    		k = scanner.nextInt();
                            break;
                       case 4:
                    	   // Quitter le menu visiteur
                    	   System.out.println("vous quittez le menu visiteur");
                    	   System.out.println("Voulez vous continuer 1:oui 0:non");
                   		   k = scanner.nextInt();
                    	   break;
                       default:
                            System.out.println("Choix invalide.");
                    
                    }
                    } while((choixActionVisiteur !=4)&&(k==1));
                    break;
                case 3:
                    System.out.println("Vous avez quitté l'application.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir 1, 2 ou 3.");
            }
            
        } while (choixRole != 3);

        // Fermer le scanner
        scanner.close();
    }
}
    
