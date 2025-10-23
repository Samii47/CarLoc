package ch.hearc.ig.carloc.service;

import ch.hearc.ig.carloc.business.Voiture;
import ch.hearc.ig.carloc.business.Statut;
import ch.hearc.ig.carloc.datastructure.ArrayList;
import ch.hearc.ig.carloc.datastructure.List;

public class VehiculeService implements VehiculeServiceInterface {

    private static List<Voiture> voitures = new ArrayList<>();

    public void ajouterVoiture(Voiture voiture) {
        // Vérification : voiture null
        if (voiture == null) {
            throw new IllegalArgumentException("Impossible d'ajouter une voiture nulle.");
        }

        // Vérification : voiture déjà existante (même immatriculation)
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getImmatriculation().equals(voiture.getImmatriculation())) {
                throw new IllegalArgumentException("Une voiture avec l'immatriculation " +
                        voiture.getImmatriculation() + " existe déjà dans le parc.");
            }
        }

        voitures.add(voiture);
        System.out.println("Voiture ajoutée : " + voiture.getImmatriculation() +
                " (" + voiture.getMarque() + ")");
    }

    public void supprimerVoiture(String immatriculation) {
        // Recherche de la voiture par immatriculation
        for (int i = 0; i < voitures.size(); i++) {
            if (voitures.get(i).getImmatriculation().equals(immatriculation)) {
                Voiture voitureSuppr = voitures.remove(i);
                System.out.println("\nVoiture supprimée : " + voitureSuppr.getImmatriculation() +
                        " (" + voitureSuppr.getMarque() + ")");
                return;  // Sortie de la méthode après suppression
            }
        }
        throw new IllegalArgumentException("\nAucune voiture avec l'immatriculation " +
                immatriculation + " n'a été trouvée dans le parc.");
    }

    public void afficherVoitures(Statut statut) {
        if (voitures.isEmpty()) {
            System.out.println("\nAucune voiture dans le parc.");
            return;
        }

        System.out.println("--- Parc de Voiture ---");

        int compteur = 0;

        for (int i = 0; i < voitures.size(); i++) {
            Voiture v = voitures.get(i);

            // Si pas de filtre OU si le statut correspond
            if (statut == null || v.getStatut() == statut) {
                System.out.println(v);
                compteur++;
            }
        }
        if (compteur == 0 && statut != null) {
            System.out.println("\nAucune voiture avec le statut : " + statut);
        }

        System.out.println("--------------");
    }

    public static List<Voiture> getToutesLesVoitures() {
        return voitures;
    }

}
