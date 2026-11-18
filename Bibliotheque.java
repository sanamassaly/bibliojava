import java.util.List;
import java.util.ArrayList;

public class Bibliotheque {
    public static final int MAX_EMPRUNT = 3;
    private List<Livre> livres = new ArrayList<>();
    private List<Etudiant> etudiants = new ArrayList<>();
    private List<Emprunt> emprunts = new ArrayList<>();

    // Partie Livre

    public boolean ajouterLivre(Livre livre) {
        if (rechercheLivreParISBN(livre.getIsbn()) != null) {
            System.out.println("livre existe");
            return false;
        }
        livres.add(livre);
        System.out.println("livre ajoute");
        return true;

    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliotheque");
        } else {
            for (Livre livre : livres) {
                livre.afficherInformations();
            }
        }
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                return livre;
            }
        }
        return null;
    }

    public Livre rechercheLivreParISBN(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equalsIgnoreCase(isbn)) {
                return livre;
            }
        }
        return null;
    }
    // Partie etudiant

    public boolean inscrireEtudiant(Etudiant etudiant) {
        if (rechercheEtudiant(etudiant.getNumero()) != null) {
            System.out.println("Le numero" + etudiant.getNumero() + "existe deja");
            return false;
        }
        etudiants.add(etudiant);
        System.out.println("etudiant ajoute");
        return true;

    }

    public Etudiant rechercheEtudiant(String numero) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNumero().equalsIgnoreCase(numero)) {
                return etudiant;
            }
        }
        return null;
    }

    public void afficherEtudiants() {
        if (etudiants.isEmpty()) {
            System.out.println("Aucun etudiant inscrit");
        } else {
            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant);
            }
        }

    }
    // partie Emprunt

    private int compterEmpruntsEncours(Etudiant etudiant) {
        int total = 0;
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getEtudiant().equals(etudiant) && !emprunt.estTermine()) {
                total++;
            }

        }
        return total;
    }

    public boolean emprunterLivre(String numeroEtudiant, String titre) {
        Etudiant etudiant = rechercheEtudiant(numeroEtudiant);
        if (etudiant == null) {
            System.out.println("Etudiant introuvable");
            return false;
        }
        Livre livre = rechercherLivreParTitre(titre);
        if (livre == null) {
            System.out.println("Livre introuvable");
            return false;
        }
        if (compterEmpruntsEncours(etudiant) >= MAX_EMPRUNT) {
            System.out.println("Le nombre d'emprunts depasse la limite autorise");
            return false;
        }
        emprunts.add(new Emprunt(etudiant, livre));
        livre.emprunter();
        System.out.println("Emprunt Enregistrer");
        return true;

    }

    public boolean retournerLivre(String titre) {
        Livre livre = rechercherLivreParTitre(titre);
        if (livre == null) {
            System.out.println("Livre introuvable");
            return false;
        }
        if (livre.estDisponible()) {
            System.out.println("Le livre n'est pas emprunte");
            return false;
        }
        for (Emprunt emprunt : emprunts) {
            if (emprunt.getLivre() == livre && !emprunt.estTermine()) {
                emprunt.enregistrerRetour();
                System.out.println("Retour du livre enregistre");
                return true;
            }
        }
        System.out.println("Emprunt introuvable");
        return false;

    }

    public void afficherEmprunts() {
        if (emprunts.isEmpty()) {
            System.out.println("Aucun emprunt");
        } else {
            for (Emprunt emprunt : emprunts) {
                emprunt.afficherInformations();
                System.out.println("-----------------------");
            }
        }
    }

}
