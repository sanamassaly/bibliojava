import java.time.LocalDate;

public class Emprunt {
    private Etudiant etudiant;
    private Livre livre;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour; // null tant que le livre n'est pas rendu

    public Emprunt(Etudiant etudiant, Livre livre) {
        this.etudiant = etudiant;
        this.livre = livre;
        this.dateEmprunt = LocalDate.now();
        this.dateRetour = null;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Livre getLivre() {
        return livre;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public boolean estTermine() {
        return dateRetour != null;
    }

    public void enregistrerRetour() {
        if (dateRetour == null) {
            livre.retourner();
            dateRetour = LocalDate.now();
        }
    }

    public void afficherInformations() {
        System.out.println("Étudiant : " + etudiant.getNomComplet());
        System.out.println("Livre : " + livre.getTitre());
        System.out.println("Date d'emprunt : " + dateEmprunt);
        System.out.println("Date de retour : "
                + (dateRetour == null ? "Non rendu" : dateRetour));
    }
}
