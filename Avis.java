package projetjavaAmalCyrine2023;

public class Avis {
    private String nomUtilisateur;
    private String commentaire;
    private int nombreEtoiles; // Note en nombre d'étoiles (0 à 5 étoiles)
    private Object objetEvalue;
 

    public Avis(String nomUtilisateur, String commentaire, int nombreEtoiles, Object objetEvalue) {
        this.nomUtilisateur=nomUtilisateur;
        this.commentaire = commentaire;
        this.nombreEtoiles = nombreEtoiles;
        this.objetEvalue = objetEvalue;
    }
	//Getters et setters pour nomUtilisateur
	public String getNomUtilisateur() {
	return nomUtilisateur ;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur=nomUtilisateur; }


    // Getters et Setters pour Commentaire
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    // Getters et Setters pour Nombre d'étoiles
    public int getNombreEtoiles() {
        return nombreEtoiles;
    }

    public void setNombreEtoiles(int nombreEtoiles) {
        // Assurez-vous que la note est dans la plage valide (0 à 5 étoiles)
        if (nombreEtoiles >= 0 && nombreEtoiles <= 5) {
            this.nombreEtoiles = nombreEtoiles;
        } else {
            System.out.println("La note doit être comprise entre 0 et 5 étoiles.");
        }
    }

    // Getters et Setters pour ObjetEvalue
    public Object getObjetEvalue() {
        return objetEvalue;
    }

    public void setObjetEvalue(Object objetEvalue) {
        this.objetEvalue = objetEvalue;
    }


    // Méthode pour afficher l'avis
    public void afficherAvis() {
    	produits prd = new produits("","","");
    	SITES_DE_LOISIR ste = new SITES_DE_LOISIR("","","","");
    	System.out.println("Nom d'utlisateur : " + nomUtilisateur);
        System.out.println("Commentaire : " + commentaire);
        System.out.println("Note : " + nombreEtoiles + " étoiles");
        if (objetEvalue instanceof produits){
        	prd= (produits) objetEvalue;
        	 System.out.println("Nom:"+ prd.getNom());
        	 System.out.println("Nom Categorie:"+ prd.getCategorie());
        	 System.out.println("Nom marque:"+ prd.getMarque());
        	 
        }
        else if (objetEvalue instanceof SITES_DE_LOISIR) {
        	ste= (SITES_DE_LOISIR) objetEvalue;
		   	 System.out.println("Nom:"+ ste.getNomComplet());
			 System.out.println("Nom ville:"+ ste.getVille());
			 System.out.println("Nom pays:"+ ste.getPays());
			 System.out.println("Nom type:"+ ste.getType()); }
    }
 
}
