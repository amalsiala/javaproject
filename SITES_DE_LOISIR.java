package projetjavaAmalCyrine2023;



public class SITES_DE_LOISIR {
    private String nomComplet;
    private String ville;
    private String pays;
    private String type;

 // Constructeur
    public SITES_DE_LOISIR(String nomComplet, String ville, String pays, String type) {
        this.nomComplet = nomComplet;
        this.ville = ville;
        this.pays = pays;
        this.type = type;
    }

    // Méthodes Getter et Setter pour le nomComplet
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    // Méthodes Getter et Setter pour la ville
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    // Méthodes Getter et Setter pour le pays
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    // Méthodes Getter et Setter pour le type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}