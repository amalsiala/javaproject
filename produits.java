package projetjavaAmalCyrine2023;

	public class produits  {
	    private String categorie;
	    private String nom;
	    private String marque;
	//Constructeur  
	public produits(String categorie,String nom,String marque){
		this.categorie = categorie;
		this.nom= nom;
		this.marque= marque; }
	//getter et setter pour la catégorie
	public String getCategorie() {
	return categorie; }
	public void setCategorie(String categorie) {
		this.categorie = categorie; }
	//getter et setter pour le nom
	public String getNom() {
	return nom ;}
	public void setNom(String nom) {
	this.nom= nom; }
	//getter et setter pour la marque
	public String getMarque() {
       return marque;
	    }
	public void setMarque(String marque) {
	    this.marque = marque;
	    } 
	}
