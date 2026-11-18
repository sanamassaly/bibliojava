public class Etudiant {
    private String numero;
    private String nom;
    private String prenom;

    public Etudiant(String numero, String nom, String prenom) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNumero() { return numero; }
    public String getNomComplet() { return prenom + " " + nom; }

    public void afficherInformations() {
        System.out.println("Numéro : " + numero);
        System.out.println("Étudiant : " + getNomComplet());
    }
}
