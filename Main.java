import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();
        int choix;

        do {
            afficherMenu();
            choix = lireEntier("Votre choix : ");

            switch (choix) {
                case 1 -> {
                    String titre = lireTexte("Titre : ");
                    String auteur = lireTexte("Auteur : ");
                    String isbn = lireTexte("ISBN : ");
                    bibliotheque.ajouterLivre(new Livre(titre, auteur, isbn));
                }
                case 2 -> bibliotheque.afficherLivres();
                case 3 -> {
                    Livre livre = bibliotheque.rechercherLivreParTitre(lireTexte("Titre à rechercher : "));
                    if (livre == null) {
                        System.out.println("Livre introuvable.");
                    } else {
                        livre.afficherInformations();
                    }
                }
                case 4 -> {
                    String numero = lireTexte("Numéro étudiant : ");
                    String nom = lireTexte("Nom : ");
                    String prenom = lireTexte("Prénom : ");
                    bibliotheque.inscrireEtudiant(new Etudiant(numero, nom, prenom));
                }
                case 5 -> {
                    String numero = lireTexte("Numéro étudiant : ");
                    String titre = lireTexte("Titre du livre : ");
                    bibliotheque.emprunterLivre(numero, titre);
                }
                case 6 -> bibliotheque.retournerLivre(lireTexte("Titre du livre à retourner : "));
                case 7 -> bibliotheque.afficherEmprunts();
                case 8 -> bibliotheque.afficherEtudiants();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 0);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n===== BIBLIOTHEQUE UNIVERSITAIRE =====");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Afficher les livres");
        System.out.println("3. Rechercher un livre");
        System.out.println("4. Inscrire un étudiant");
        System.out.println("5. Emprunter un livre");
        System.out.println("6. Retourner un livre");
        System.out.println("7. Afficher les emprunts");
        System.out.println("8. Afficher les étudiants");
        System.out.println("0. Quitter");
    }

    /** Lit un nombre entier ; redemande tant que la saisie n'est pas un nombre. */
    private static int lireEntier(String message) {
        while (true) {
            System.out.print(message);
            String ligne = scanner.nextLine().trim();
            try {
                return Integer.parseInt(ligne);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre.");
            }
        }
    }

    /** Lit un texte non vide ; redemande tant que la saisie est vide. */
    private static String lireTexte(String message) {
        while (true) {
            System.out.print(message);
            String texte = scanner.nextLine().trim();
            if (!texte.isEmpty()) {
                return texte;
            }
            System.out.println("Ce champ est obligatoire.");
        }
    }
}
