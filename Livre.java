public class Livre {
    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;

    public Livre(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.disponible = true;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void afficherInformations() {
        System.out.println("Titre : " + titre);
        System.out.println("Auteur : " + auteur);
        System.out.println("ISBN : " + isbn);
        System.out.println("Disponible : " + (disponible ? "Oui" : "Non"));
    }

    public boolean emprunter() {
        if (!disponible) {
            return false;
        }
        this.disponible = false;
        return true;
    }

    public void retourner() {
        disponible = true;
    }
}
