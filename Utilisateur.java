package projetjavaAmalCyrine2023;
import java.util.Scanner;

public class Utilisateur {
    private String nom;
    Scanner s = new Scanner(System.in);

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    public String saisirNom() {
        System.out.println("Donnez votre nom svp !");
        nom = s.next();
        return nom;
    }

    // Getter et Setter pour Nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}